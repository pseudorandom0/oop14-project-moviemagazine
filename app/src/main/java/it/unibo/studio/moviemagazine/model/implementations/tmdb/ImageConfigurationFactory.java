package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Backdrop;
import it.unibo.studio.moviemagazine.model.interfaces.Image;
import it.unibo.studio.moviemagazine.model.interfaces.Logo;
import it.unibo.studio.moviemagazine.model.interfaces.Poster;
import it.unibo.studio.moviemagazine.model.interfaces.Profile;

/**
 * This class is a flyweight factory for images base url and it's sizes. The data in this class should be initialized
 * on application startup. All the images types must be mapped to it's specific list of sizes and it's an example of
 * power type, because all the images have sizes but they depend on the type of the image.
 */

public final class ImageConfigurationFactory {


    private static String base_url;
    private static String secure_base_url;
    private static final int IMAGE_TYPES = 4;
    private static Map<Class<? extends Image>, List<String>> powerType;

    private ImageConfigurationFactory() {
        powerType = new HashMap<>(IMAGE_TYPES);
    }

    public static List<String> getSizes(Class<? extends Image> image){
        if(image.isAssignableFrom(Image.class)){
            throw new IllegalArgumentException("Image class should not be used!");
        }
        return powerType.get(image);
    }
    public static String getBaseUrl(){
        return base_url;
    }

    private void mapImageToSize(Class<? extends Image> image, List<String> sizes){
        powerType.put(image,sizes);
    }

    private void setBaseUrls(String url, String secure){
        base_url = url;
        secure_base_url = secure;
    }

    public static JsonDeserializer<ImageConfigurationFactory> createDeserializer(){
        return new ImageConfigurationDeserializer();
    }


    private static class ImageConfigurationDeserializer implements JsonDeserializer<ImageConfigurationFactory>{

        private ImageConfigurationDeserializer() {

        }

        /**
         * {@link ImageConfigurationFactory} requires a custom deserializer because the static fields should be initialized
         * @param json
         * @param typeOfT
         * @param context
         * @return
         * @throws JsonParseException
         */
        @Override
        public ImageConfigurationFactory deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            ImageConfigurationFactory factory = new ImageConfigurationFactory();
            JsonObject images = json.getAsJsonObject().getAsJsonObject(Constants.Parsing.IMAGES_CONFIGURATION_MEMBER_NAME);
            factory.setBaseUrls(images.get(Constants.Parsing.BASE_URL_MEMBER_NAME).getAsString(),images.get(Constants.Parsing.SECURE_BASE_URL_MEMBER_NAME).getAsString());
            Type listType = new TypeToken<List<String>>(){}.getType();
            factory.mapImageToSize(Poster.class, (List<String>)(context.deserialize(images.getAsJsonArray(Constants.Parsing.POSTER_SIZES_MEMBER_NAME), listType)));
            factory.mapImageToSize(Backdrop.class, (List<String>)(context.deserialize(images.getAsJsonArray(Constants.Parsing.BACKDROP_SIZES_MEMBER_NAME), listType)));
            factory.mapImageToSize(Profile.class, (List<String>)(context.deserialize(images.getAsJsonArray(Constants.Parsing.PROFILE_SIZES_MEMBER_NAME), listType)));
            factory.mapImageToSize(Logo.class, (List<String>)(context.deserialize(images.getAsJsonArray(Constants.Parsing.LOGO_SIZES_MEMBER_NAME), listType)));

            return factory;
        }

    }

}


