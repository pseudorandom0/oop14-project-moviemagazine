package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Credit;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.Person;

/**
 * Represents a generic credit
 */

public abstract class TMDBCredit implements Credit{

    protected String credit_id;
    protected TMDBPerson person;
    protected TMDBMovie movie;

    @Override
    public String getId() {
        return this.credit_id;
    }


    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public Movie getMovie() {
        return this.movie;
    }


    public static JsonDeserializer createDeserializer(boolean ofMovie){
        return new CreditDeserializer(ofMovie);
    }


    /**
     * Deserializer for cast and crew credits
     * @param <T> will be either {@link TMDBCastCredit} or {@link TMDBCrewCredit}
     */
    private static final class CreditDeserializer<T extends TMDBCredit> implements JsonDeserializer<T>{

        private final DeserializationStrategy strategy;


        private CreditDeserializer(boolean ofMovie){
            this.strategy = ofMovie? new OfMovie() : new OfPerson();
        }

        @SuppressWarnings("unchecked") //safe cast
        @Override
        public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return (T) (typeOfT == TMDBCastCredit.class? strategy.parseCastCredit(json, context) : strategy.parseCrewCredit(json, context));
        }


        /**
         * The deserialization strategy is used to parse the credits of a movie or a person
         */
        private interface DeserializationStrategy{
            TMDBCastCredit parseCastCredit(JsonElement castCredit, JsonDeserializationContext context);
            TMDBCrewCredit parseCrewCredit(JsonElement crewCredit, JsonDeserializationContext context);
        }

        private class OfPerson implements DeserializationStrategy{
            @Override
            public TMDBCastCredit parseCastCredit(JsonElement castCredit, JsonDeserializationContext context) {
                TMDBCastCredit credit = new TMDBCastCredit();
                JsonObject creditObject = castCredit.getAsJsonObject();
                credit.movie = context.deserialize(castCredit, TMDBMovie.class);
                credit.credit_id = creditObject.getAsJsonPrimitive(Constants.Parsing.CREDIT_ID_MEMBER_NAME).getAsString();
                credit.character = creditObject.getAsJsonPrimitive(Constants.Parsing.CHARACTER_MEMBER_NAME).getAsString();
                return credit;
            }

            @Override
            public TMDBCrewCredit parseCrewCredit(JsonElement crewCredit, JsonDeserializationContext context) {
                TMDBCrewCredit credit = new TMDBCrewCredit();
                JsonObject creditObject = crewCredit.getAsJsonObject();
                credit.movie = context.deserialize(crewCredit, TMDBMovie.class);
                credit.credit_id = creditObject.getAsJsonPrimitive(Constants.Parsing.CREDIT_ID_MEMBER_NAME).getAsString();
                credit.department = creditObject.getAsJsonPrimitive(Constants.Parsing.DEPARTMENT_MEMBER_NAME).getAsString();
                credit.job = creditObject.getAsJsonPrimitive(Constants.Parsing.JOB_MEMBER_NAME).getAsString();
                return credit;
            }
        }

        private class OfMovie implements DeserializationStrategy{
            @Override
            public TMDBCastCredit parseCastCredit(JsonElement castCredit, JsonDeserializationContext context) {
                TMDBCastCredit credit = new TMDBCastCredit();
                JsonObject creditObject = castCredit.getAsJsonObject();
                credit.person = context.deserialize(castCredit, TMDBPerson.class);
                credit.credit_id = creditObject.getAsJsonPrimitive(Constants.Parsing.CREDIT_ID_MEMBER_NAME).getAsString();
                credit.order = creditObject.getAsJsonPrimitive(Constants.Parsing.CAST_ORDER_MEMBER_NAME).getAsInt();
                credit.castId = creditObject.getAsJsonPrimitive(Constants.Parsing.CAST_ID_MEMBER_NAME).getAsInt();
                credit.character = creditObject.getAsJsonPrimitive(Constants.Parsing.CHARACTER_MEMBER_NAME).getAsString();
                return credit;
            }

            @Override
            public TMDBCrewCredit parseCrewCredit(JsonElement crewCredit, JsonDeserializationContext context) {
                TMDBCrewCredit credit = new TMDBCrewCredit();
                JsonObject creditObject = crewCredit.getAsJsonObject();
                credit.person = context.deserialize(crewCredit, TMDBPerson.class);
                credit.credit_id = creditObject.getAsJsonPrimitive(Constants.Parsing.CREDIT_ID_MEMBER_NAME).getAsString();
                credit.department = creditObject.getAsJsonPrimitive(Constants.Parsing.DEPARTMENT_MEMBER_NAME).getAsString();
                credit.job = creditObject.getAsJsonPrimitive(Constants.Parsing.JOB_MEMBER_NAME).getAsString();
                return credit;
            }
        }

    }
}


