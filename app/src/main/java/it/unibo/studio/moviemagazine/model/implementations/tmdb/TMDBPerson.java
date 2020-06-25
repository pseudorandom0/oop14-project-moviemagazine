package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.model.interfaces.Profile;

/**
 * A person
 */
public class TMDBPerson implements Person {

    private int id;
    private String biography;
    private Date birthday;
    /**
     * The deathday is saved as a string because if the person is alive, the json will have an empty string and Gson will throw an exception when tries to deserialize it
     */
    private String deathday;
    private Date deathDayConcrete;
    private String homepage;
    private String name;
    private String place_of_birth;
    private String profile_path;
    private List<String> also_known_as;
    private TMDBProfile profile;
    private List<TMDBProfile> allProfiles;
    private ImagesWrapper images;


    TMDBPerson(){
    }

    @Override
    public List<String> getNicknames() {
        return new ArrayList<>(also_known_as);
    }

    @Override
    public String getBiography() {
        return biography;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public Date getDeathday() {
        if(isAlive()){
            return null;
        } else {
            SimpleDateFormat parser = new SimpleDateFormat(Constants.DATE_STYLE_PATTERN);
            try {
                deathDayConcrete = parser.parse(deathday);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return deathDayConcrete;
    }

    @Override
    public boolean isAlive() {
        return deathday == null || deathday.isEmpty();
    }

    @Override
    public String getHomepage() {
        return homepage;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPlaceOfBirth() {
        return place_of_birth;
    }

    @Override
    public Profile getProfileImage() {
        if(profile == null){
            profile = new TMDBProfile();
            profile.path = profile_path;
        }
        return profile;
    }

    @Override
    public List<Profile> getAllProfileImages() {
        if(allProfiles == null){
            allProfiles = images.profiles;
        }
        return new ArrayList<Profile>(allProfiles);
    }

    private class ImagesWrapper {
        List<TMDBProfile> profiles;
    }
}




