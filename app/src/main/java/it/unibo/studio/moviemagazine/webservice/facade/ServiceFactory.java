package it.unibo.studio.moviemagazine.webservice.facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Locale;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.ImageConfigurationFactory;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBCredit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Factory that creates the service interfaces with retrofit and configures all parameters that cannot and should not be controlled by clients like
 * adding language parameters, appending methods, setting up the JSON converters needed for deserialization.
 */

public class ServiceFactory{

    static {
        restoreBaseBuilders();
    }

    private static OkHttpClient.Builder httpClient;
    private static Retrofit.Builder serviceFactoryBuilder;


    public static <T> T createService(Class<T> serviceClass){

        if(serviceClass == Discover.class || serviceClass == Movies.class){

            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient.addInterceptor(new LanguageAdder()).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        } else if(serviceClass == Movie.class){

            Gson gson = new GsonBuilder()
                    .registerTypeHierarchyAdapter(TMDBCredit.class, TMDBCredit.createDeserializer(true))
                    .create();

            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient
                            .addInterceptor(new LanguageAdder())
                            .addInterceptor(new ParameterAppender(new AppendingCondition() {
                                @Override
                                public boolean requiresAppend(final HttpUrl url) {
                                    //TODO qua ci vuole una regex perche MOVIE_BY_ID è movie/{id} e quindi mi appende sempre la roba
                                    return url.encodedPath().contains(Constants.APIMethods.MOVIE_BY_ID);
                                }
                            }, new MovieParametersAppender()))
                            .build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        } else if(serviceClass == Lists.class){

            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        } else if (serviceClass == MovieCollections.class){

            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient
                            .addInterceptor(new LanguageAdder())
                            .addInterceptor(new ParameterAppender(new AppendingCondition() {
                                @Override
                                public boolean requiresAppend(final HttpUrl url) {
                                    return true;
                                }
                            }, new MovieParametersAppender())).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        } else if (serviceClass == People.class){

            Gson gson = new GsonBuilder()
                    .registerTypeHierarchyAdapter(TMDBCredit.class, TMDBCredit.createDeserializer(false))
                    .create();
            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient
                            .addInterceptor(new ParameterAppender(new AppendingCondition() {
                                @Override
                                public boolean requiresAppend(final HttpUrl url) {
                                    return true;
                                }
                            }, new MovieParametersAppender()))
                            .build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        } else if(serviceClass == Search.class){

            Retrofit retrofit = serviceFactoryBuilder
                    .client(httpClient
                            .addInterceptor(new ParameterAppender(new AppendingCondition() {
                                @Override
                                public boolean requiresAppend(final HttpUrl url) {
                                    //here contains is ok because there are no path ids that will be put in the url
                                    return url.encodedPath().contains(Constants.APIMethods.SEARCH_COLLECTION)
                                            || url.encodedPath().contains(Constants.APIMethods.SEARCH_MOVIE);
                                }
                            }, new AppendingStrategy() {
                                @Override
                                public HttpUrl appendParameters(HttpUrl original) {
                                    HttpUrl url = original.newBuilder()
                                            .addQueryParameter(Constants.APIParameters.LANGUAGE, Locale.getDefault().getLanguage())
                                            .build();
                                    return url;
                                }
                            }))
                            .build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            restoreBaseBuilders();
            return retrofit.create(serviceClass);
        }
        return null;
    }

    /**
     * The base builders are modified every time a service is created so we need to recreate the builders
     * with only the basic parameters that need to be appended to each request
     */
    private static void restoreBaseBuilders(){


        serviceFactoryBuilder =  new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL);


        httpClient = new OkHttpClient.Builder()
                .addInterceptor(new APIKeyAdder())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));
    }

    static Configuration createImageConfigurationService(){

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ImageConfigurationFactory.class, ImageConfigurationFactory.createDeserializer())
                .create();

        Retrofit retrofit = serviceFactoryBuilder
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restoreBaseBuilders();
        return retrofit.create(Configuration.class);
    }

    static Genres createGenresLoaderService(){

        Retrofit retrofit = serviceFactoryBuilder
                .client(httpClient
                        .addInterceptor(new LanguageAdder())
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restoreBaseBuilders();
        return retrofit.create(Genres.class);
    }

    /**
     * Interceptor that appends parameters to requests
     */
    private static class ParameterAppender implements Interceptor{

        private final AppendingCondition condition;
        private final AppendingStrategy strategy;

        /**
         * Creates an interceptor that appends parameters to requests based on the condition predicate and if needed appends parameters with the strategy
         * @param condition when true appends parameters to the request
         * @param strategy the strategy to append parameters
         */
        private ParameterAppender(AppendingCondition condition, AppendingStrategy strategy){
            this.condition = condition;
            this.strategy = strategy;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl url = original.url();
            if(condition.requiresAppend(url)){
                url = strategy.appendParameters(url);
                original = original.newBuilder().url(url).build();
            }
            return chain.proceed(original);
        }
    }

    /**
     * Interface that represents the strategy of appending parameters to url
     */
    private interface AppendingStrategy{
        HttpUrl appendParameters(HttpUrl original);
    }

    /**
     * Strategy for using append_to_response feature of TMDB API and append images to the request being made
     */
    private static class MovieParametersAppender implements AppendingStrategy{
        @Override
        public HttpUrl appendParameters(HttpUrl original) {
            StringBuilder imageLanguages = new StringBuilder();
            imageLanguages.append(Locale.getDefault().getISO3Language())
                    .append(Constants.APIParameters.AND_PARAMETER_SEPARATOR)
                    .append(Constants.APIParameters.NULL_LOCALE);

            StringBuilder methodsAppender = new StringBuilder();
            methodsAppender.append(Constants.APIMethods.APPEND_IMAGES)
                            .append(Constants.APIParameters.AND_PARAMETER_SEPARATOR)
                            .append(Constants.APIMethods.APPEND_KEYWORDS);

            original = original.newBuilder()
                    .addQueryParameter(Constants.APIParameters.INCLUDE_IMAGE_LANGUAGE, imageLanguages.toString())
                    .addQueryParameter(Constants.APIMethods.APPEND_TO_RESPONSE, methodsAppender.toString())
                    .build();
            return original;
        }
    }

    /*private static class MethodAppender implements Interceptor{

        private List<String> methods;

        private MethodAppender(List<String> methods) {
            this.methods = methods;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            StringBuilder methodAppender = new StringBuilder();
            for (int i = 0; i < methods.size(); i++ ){
                methodAppender.append(methods.get(i));
                if(i != methods.size()){
                    methodAppender.append(Constants.APIParameters.AND_PARAMETER_SEPARATOR);
                }
            }
            HttpUrl newUrl = original.url().newBuilder()
                    .addQueryParameter(Constants.APIMethods.APPEND_TO_RESPONSE, methodAppender.toString())
                    .build();
            original = original.newBuilder().url(newUrl).build();

            return chain.proceed(original);
        }
    }*/



    /**
     * Predicate interface like in java 8
     */
    private interface AppendingCondition{
        boolean requiresAppend(final HttpUrl url);
    }


    /**
     * Interceptor for adding the API key to requests and is used for every request
     */
    private static class APIKeyAdder implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(Constants.APIParameters.API_KEY, Constants.APIParameters.Values.API_KEY)
                    .build();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }

    /**
     * Interceptor for adding user localized language parameter
     */
    private static class LanguageAdder implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(Constants.APIParameters.LANGUAGE, Locale.getDefault().getLanguage())
                    .build();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }
}