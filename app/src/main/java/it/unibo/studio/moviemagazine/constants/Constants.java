package it.unibo.studio.moviemagazine.constants;

/**
 * This class holds the constants used in the application
 */
public final class Constants {

    public static final String API_BASE_URL = "https://api.themoviedb.org/3/";
    public static final String DATE_STYLE_PATTERN = "yyyy-MM-dd";

    public static final class Parsing{
        public static final String IMAGES_CONFIGURATION_MEMBER_NAME = "images";
        public static final String BASE_URL_MEMBER_NAME = "base_url";
        public static final String SECURE_BASE_URL_MEMBER_NAME = "secure_base_url";
        public static final String POSTER_SIZES_MEMBER_NAME = "poster_sizes";
        public static final String BACKDROP_SIZES_MEMBER_NAME = "backdrop_sizes";
        public static final String PROFILE_SIZES_MEMBER_NAME = "profile_sizes";
        public static final String LOGO_SIZES_MEMBER_NAME = "logo_sizes";
        public static final String GENRES_MEMBER_NAME = "genres";
        public static final String CAST_MEMBER_NAME = "cast";
        public static final String CREW_MEMBER_NAME = "crew";
        public static final String COUNTRY_CODE_MEMBER_NAME = "iso_3166_1";
        public static final String GENRE_MEMBER_NAME = "name";
        public static final String IMAGE_PATH_MEMBER_NAME = "file_path";
        public static final String BACKDROP_PATH_MEMBER_NAME = "backdrop_path";
        public static final String POSTER_PATH_MEMBER_NAME = "poster_path";
        public static final String PROFILE_PATH_MEMBER_NAME = "profile_path";
        public static final String LOGO_PATH_MEMBER_NAME = "logo_path";
        public static final String POSTERS_ARRAY_MEMBER_NAME = "posters";
        public static final String BACKDROPS_ARRAY_MEMBER_NAME = "backdrops";
        public static final String CURRENT_PAGE_MEMBER_NAME = APIParameters.PAGE;
        public static final String TOTAL_PAGES_MEMBER_NAME = "total_pages";
        public static final String TOTAL_RESULTS_MEMBER_NAME = "total_results";
        public static final String ITEM_COUNT_MEMBER_NAME = "item_count";
        public static final String MOVIE_LIST_NAME_MEMBER_NAME = GENRE_MEMBER_NAME;
        public static final String MOVIE_LIST_ITEMS_MEMBER_NAME = "items";
        public static final String MOVIE_LIST_RESULTS_MEMBER_NAME = "results";
        public static final String REVIEW_LIST_RESULTS_MEMBER_NAME = MOVIE_LIST_RESULTS_MEMBER_NAME;
        public static final String LANGUAGE_CODE_MEMBER_NAME = "iso_639_1";
        public static final String PERSON_LIST_RESULTS_MEMBER_NAME = MOVIE_LIST_RESULTS_MEMBER_NAME;
        public static final String LISTS_RESUTS_MEMBER_NAME = MOVIE_LIST_RESULTS_MEMBER_NAME;
        public static final String COLLECTION_RESULTS_MEMBER_NAME = MOVIE_LIST_RESULTS_MEMBER_NAME;
        public static final String CREDIT_ID_MEMBER_NAME = "credit_id";
        public static final String CAST_ORDER_MEMBER_NAME = "order";
        public static final String CAST_ID_MEMBER_NAME = "cast_id";
        public static final String CHARACTER_MEMBER_NAME = "character";
        public static final String DEPARTMENT_MEMBER_NAME = "department";
        public static final String JOB_MEMBER_NAME = "job";
    }

    public static final class APIMethods{
        //Configuration
        public static final String CONFIGURATION = "configuration";
        //Movie methods
        public static final String MOVIE_BY_ID = "movie/{id}";
        public static final String MOVIE_CREDITS = "movie/{id}/credits";
        public static final String MOVIE_IMAGES = "movie/{id}/images";
        public static final String MOVIE_KEYWORDS = "movie/{id}keywords";
        public static final String MOVIE_REVIEWS = "movie/{id}/reviews";
        public static final String MOVIES_NOW_PLAYING = "movie/now_playing";
        public static final String MOVIES_POPULAR = "movie/popular";
        public static final String MOVIES_UPCOMING = "movie/upcoming";
        public static final String MOVIES_TOP_RATED = "movie/top_rated";
        public static final String MOVIE_LISTS = "movie/{id}/lists";
        //Discover
        public static final String DISCOVER_MOVIES = "discover/movie";
        //Genres
        public static final String MOVIES_BY_GENRE = "genre/{id}/movies";
        public static final String LOAD_MOVIE_GENRES = "genre/movie/list";
        //Lists
        public static final String LIST_BY_ID = "list/{id}";
        //People
        public static final String PERSON_BY_ID = "person/{id}";
        public static final String PERSON_MOVIE_CREDITS = "person/{id}/credits";
        public static final String PERSON_IMAGES = "person/{id}/images";
        //Search
        public static final String SEARCH_MULTI = "search/multi";
        public static final String SEARCH_MOVIE = "search/movie";
        public static final String SEARCH_PERSON = "search/person";
        public static final String SEARCH_LIST = "search/list";
        public static final String SEARCH_COLLECTION = "search/collection";
        //Collections
        public static final String COLLECTION_BY_ID = "collection/{id}";
        public static final String COLLECTION_IMAGES = "collection/{id}/images";
        //Append to response
        public static final String APPEND_TO_RESPONSE = "append_to_response";
        public static final String APPEND_IMAGES = "images";
        public static final String APPEND_KEYWORDS = "keywords";
    }

    public static final class APIParameters{
        public static final String AND_PARAMETER_SEPARATOR = ",";
        public static final String OR_PARAMETER_SEPARATOR = "|";
        public static final String NULL_LOCALE = "null";
        public static final String LANGUAGE = "language";
        public static final String API_KEY = "api_key";
        public static final String ID = "id";
        public static final String PAGE = "page";
        public static final String QUERY = "query";
        //People search
        public static final String SEARCH_TYPE = "search_type";
        //Collection
        public static final String INCLUDE_IMAGE_LANGUAGE = "include_image_language";
        //Discover
        public static final String SORT_BY = "sort_by";
        public static final String PRIMARY_RELEASE_YEAR = "primary_release_year";
        public static final String PRIMARY_RELEASE_DATE_GTE = "primary_release_date.gte";
        public static final String PRIMARY_RELEASE_DATE_LTE = "primary_release_date.lte";
        public static final String RELEASE_DATE_LTE = "release_date.lte";
        public static final String RELEASE_DATE_GTE = "release_date.gte";
        public static final String VOTE_COUNT_LTE = "vote_count.lte";
        public static final String VOTE_COUNT_GTE = "vote_count.gte";
        public static final String VOTE_AVERAGE_LTE = "vote_average.lte";
        public static final String VOTE_AVERAGE_GTE = "vote_average.gte";
        public static final String WITH_CAST = "with_cast";
        public static final String WITH_CREW = "with_crew";
        public static final String WITH_PEOPLE = "with_people";
        public static final String WITH_GENRES = "with_genres";
        public static final String RELEASE_YEAR = "year";
        public static final String INCLUDE_ALL_MOVIES = "include_all_movies";


        public static final class Values{
            public static final String API_KEY = "b980b0183f6bf4cbe7f88f6a60494af9";

            public static final class PersonSearch{
                public static final String NGRAM = "ngram";
                public static final String PHRASE = "phrase";
            }

            public static final class Popularity{
                public static final String ASC = "popularity.asc";
                public static final String DESC = "popularity.desc";
            }
            public static final class PrimaryReleaseDate{
                public static final String ASC = "primary_release_date.asc";
                public static final String DESC = "primary_release_date.desc";
            }
            public static final class OriginalTitle{
                public static final String ASC = "original_title.asc";
                public static final String DESC = "original_title.desc";
            }
            public static final class VoteAverage{
                public static final String ASC = "vote_average.asc";
                public static final String DESC = "vote_average.desc";
            }
            public static final class VoteCount{
                public static final String ASC = "vote_count.asc";
                public static final String DESC = "vote_count.desc";
            }
            public static final class Revenue{
                public static final String ASC = "revenue.asc";
                public static final String DESC = "revenue.desc";
            }

            public static final class ReleaseDate{
                public static final String ASC = "release_date.asc";
                public static final String DESC = "release_date.desc";
            }

        }
    }

}
