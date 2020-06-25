package it.unibo.studio.moviemagazine;


import android.text.Html;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CollectionListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CreditsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieReviewsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.PersonListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBBackdrop;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBCastCredit;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBCredit;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBCrewCredit;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBGenre;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBImage;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovie;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovieList;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBPerson;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBPoster;
import it.unibo.studio.moviemagazine.webservice.facade.Movie;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {



    @Test
    public void testMovieListResultsWrapper(){
        String json = "{\n" +
                "  \"created_by\": \"Travis Bell\",\n" +
                "  \"description\": \"Here's my list of best picture winners for the Oscars. Thought it would be neat to see them all together. There's a lot of movies here I have never even heard of.\",\n" +
                "  \"favorite_count\": 18,\n" +
                "  \"id\": \"509ec17b19c2950a0600050d\",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/7MGIEdu0Mokqt8i7snflYRLbooI.jpg\",\n" +
                "      \"id\": 68734,\n" +
                "      \"original_title\": \"Argo\",\n" +
                "      \"release_date\": \"2012-10-12\",\n" +
                "      \"poster_path\": \"/oai3xLBQHpIh18VJdRCcL7D0Yg0.jpg\",\n" +
                "      \"popularity\": 8.87774381845068,\n" +
                "      \"title\": \"Argo\",\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 1379\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/tr6OExnBfjLADi9OyZoW308mPAp.jpg\",\n" +
                "      \"id\": 74643,\n" +
                "      \"original_title\": \"The Artist\",\n" +
                "      \"release_date\": \"2011-10-11\",\n" +
                "      \"poster_path\": \"/i0mpvMIIjyubXsVKug9vX0lYpnd.jpg\",\n" +
                "      \"popularity\": 2.74829074958879,\n" +
                "      \"title\": \"The Artist\",\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 203\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/hAQKDTVKk04LWn82OYWLBPpsaVa.jpg\",\n" +
                "      \"id\": 45269,\n" +
                "      \"original_title\": \"The King's Speech\",\n" +
                "      \"release_date\": \"2010-09-06\",\n" +
                "      \"poster_path\": \"/v8M5Sytbut7vBXyZ1HDy8lUVVcB.jpg\",\n" +
                "      \"popularity\": 3.45469925426767,\n" +
                "      \"title\": \"The King's Speech\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 633\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/heYHgkaxA1z7IJG0pLitaXmd2Pm.jpg\",\n" +
                "      \"id\": 12405,\n" +
                "      \"original_title\": \"Slumdog Millionaire\",\n" +
                "      \"release_date\": \"2008-11-12\",\n" +
                "      \"poster_path\": \"/ojgf8iJpS4VX6jJfWGLpuEx0wm.jpg\",\n" +
                "      \"popularity\": 5.56008500729782,\n" +
                "      \"title\": \"Slumdog Millionaire\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 468\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/3iPnZOXR9mpcK8RwvAW7b7Axr8v.jpg\",\n" +
                "      \"id\": 12162,\n" +
                "      \"original_title\": \"The Hurt Locker\",\n" +
                "      \"release_date\": \"2009-06-25\",\n" +
                "      \"poster_path\": \"/3ZEqU9Ykmn8zGDUwWnmTfHaaWRB.jpg\",\n" +
                "      \"popularity\": 4.15219918317637,\n" +
                "      \"title\": \"The Hurt Locker\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 365\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/7hx7ANh11TbbvHLDXUuywYkg5rK.jpg\",\n" +
                "      \"id\": 6977,\n" +
                "      \"original_title\": \"No Country for Old Men\",\n" +
                "      \"release_date\": \"2007-11-08\",\n" +
                "      \"poster_path\": \"/6o0UWX2naW7HK45PDNYmoMIk5qs.jpg\",\n" +
                "      \"popularity\": 5.10706403201925,\n" +
                "      \"title\": \"No Country for Old Men\",\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 444\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/8Od5zV7Q7zNOX0y9tyNgpTmoiGA.jpg\",\n" +
                "      \"id\": 1422,\n" +
                "      \"original_title\": \"The Departed\",\n" +
                "      \"release_date\": \"2006-10-05\",\n" +
                "      \"poster_path\": \"/tGLO9zw5ZtCeyyEWgbYGgsFxC6i.jpg\",\n" +
                "      \"popularity\": 9.02263067356166,\n" +
                "      \"title\": \"The Departed\",\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 1018\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/o4OSztAvDYNDXkn9PJGbaQAO8VG.jpg\",\n" +
                "      \"id\": 70,\n" +
                "      \"original_title\": \"Million Dollar Baby\",\n" +
                "      \"release_date\": \"2004-12-14\",\n" +
                "      \"poster_path\": \"/h4VZKi2Jt4VoBYJmtC4c3bO8KqM.jpg\",\n" +
                "      \"popularity\": 3.78805660450045,\n" +
                "      \"title\": \"Million Dollar Baby\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 328\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/nvDo8teZGqlDeHxjWkM4RBf4YMO.jpg\",\n" +
                "      \"id\": 1640,\n" +
                "      \"original_title\": \"Crash\",\n" +
                "      \"release_date\": \"2004-09-10\",\n" +
                "      \"poster_path\": \"/lmozwVOTY7sa9KlrSbKMqKMuKUM.jpg\",\n" +
                "      \"popularity\": 3.00932841502733,\n" +
                "      \"title\": \"Crash\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 266\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/8BPZO0Bf8TeAy8znF43z8soK3ys.jpg\",\n" +
                "      \"id\": 122,\n" +
                "      \"original_title\": \"The Lord of the Rings: The Return of the King\",\n" +
                "      \"release_date\": \"2003-12-17\",\n" +
                "      \"poster_path\": \"/50LoR9gJhbWZ5PpoHgi8MNTYgzd.jpg\",\n" +
                "      \"popularity\": 10.9536005909551,\n" +
                "      \"title\": \"The Lord of the Rings: The Return of the King\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 3162\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qXLXEvYSycdllvdKvmhFXLUcFhM.jpg\",\n" +
                "      \"id\": 1574,\n" +
                "      \"original_title\": \"Chicago\",\n" +
                "      \"release_date\": \"2002-12-27\",\n" +
                "      \"poster_path\": \"/18pCc2XZ5MO7wsywOYEbhoeuxNw.jpg\",\n" +
                "      \"popularity\": 1.62073245663158,\n" +
                "      \"title\": \"Chicago\",\n" +
                "      \"vote_average\": 5.9,\n" +
                "      \"vote_count\": 105\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/5YF6MwuuKBRKLUE2dz3wetkgxAE.jpg\",\n" +
                "      \"id\": 453,\n" +
                "      \"original_title\": \"A Beautiful Mind\",\n" +
                "      \"release_date\": \"2001-12-12\",\n" +
                "      \"poster_path\": \"/4SFqHDZ1NvWdysucWbgnYlobdxC.jpg\",\n" +
                "      \"popularity\": 35.4165683476143,\n" +
                "      \"title\": \"A Beautiful Mind\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 550\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sHg0lJLtfTuGQxUz3Yie5AGW4v0.jpg\",\n" +
                "      \"id\": 98,\n" +
                "      \"original_title\": \"Gladiator\",\n" +
                "      \"release_date\": \"2000-05-01\",\n" +
                "      \"poster_path\": \"/6WBIzCgmDCYrqh64yDREGeDk9d3.jpg\",\n" +
                "      \"popularity\": 6.73772199351565,\n" +
                "      \"title\": \"Gladiator\",\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 1884\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/mAwd34SAC8KqBKRm2MwHPLhLDU5.jpg\",\n" +
                "      \"id\": 14,\n" +
                "      \"original_title\": \"American Beauty\",\n" +
                "      \"release_date\": \"1999-09-15\",\n" +
                "      \"poster_path\": \"/3UBQGKS8c1dxRnDiu5kUK6ej3pP.jpg\",\n" +
                "      \"popularity\": 4.095987790479,\n" +
                "      \"title\": \"American Beauty\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 497\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qvhpBNfb53wLnEbVnmC5GNGFRHO.jpg\",\n" +
                "      \"id\": 1934,\n" +
                "      \"original_title\": \"Shakespeare in Love\",\n" +
                "      \"release_date\": \"1998-12-11\",\n" +
                "      \"poster_path\": \"/sAN5jedynbs3pa3ww0UXQ1k0lRF.jpg\",\n" +
                "      \"popularity\": 3.25405271007016,\n" +
                "      \"title\": \"Shakespeare in Love\",\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"vote_count\": 88\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/fVcZErSWa7gyENuj8IWp8eAfCnL.jpg\",\n" +
                "      \"id\": 597,\n" +
                "      \"original_title\": \"Titanic\",\n" +
                "      \"release_date\": \"1997-11-01\",\n" +
                "      \"poster_path\": \"/f9iH7Javzxokvnkiz2yHD1dcmUy.jpg\",\n" +
                "      \"popularity\": 7.40796003893298,\n" +
                "      \"title\": \"Titanic\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 2306\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/cD7lPdjFyf5dQIlc6ToehqFrIZU.jpg\",\n" +
                "      \"id\": 409,\n" +
                "      \"original_title\": \"The English Patient\",\n" +
                "      \"release_date\": \"1996-11-14\",\n" +
                "      \"poster_path\": \"/niqc0v3Lclh99Mmmxm49qZTIo2e.jpg\",\n" +
                "      \"popularity\": 1.08769436121621,\n" +
                "      \"title\": \"The English Patient\",\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 52\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qUa7vuqh3lkVBw5IJ4nfhfoOykQ.jpg\",\n" +
                "      \"id\": 197,\n" +
                "      \"original_title\": \"Braveheart\",\n" +
                "      \"release_date\": \"1995-05-24\",\n" +
                "      \"poster_path\": \"/2qAgGeYdLjelOEqjW9FYvPHpplC.jpg\",\n" +
                "      \"popularity\": 3.85144239936905,\n" +
                "      \"title\": \"Braveheart\",\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 1189\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/wMgbnUVS9wbRGAdki8fqxKU1O0N.jpg\",\n" +
                "      \"id\": 13,\n" +
                "      \"original_title\": \"Forrest Gump\",\n" +
                "      \"release_date\": \"1994-06-22\",\n" +
                "      \"poster_path\": \"/z4ROnCrL77ZMzT0MsNXY5j25wS2.jpg\",\n" +
                "      \"popularity\": 10.0820028516641,\n" +
                "      \"title\": \"Forrest Gump\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 1987\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/af98P1bc7lJsFjhHOVWXQgNNgSQ.jpg\",\n" +
                "      \"id\": 424,\n" +
                "      \"original_title\": \"Schindler's List\",\n" +
                "      \"release_date\": \"1993-11-29\",\n" +
                "      \"poster_path\": \"/tvOvW7Qjj63zbQW5TZ8CjPThAUd.jpg\",\n" +
                "      \"popularity\": 4.82655908578256,\n" +
                "      \"title\": \"Schindler's List\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 1062\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/A9YUJXy0wLwYMvnUmPnyPOriTHp.jpg\",\n" +
                "      \"id\": 33,\n" +
                "      \"original_title\": \"Unforgiven\",\n" +
                "      \"release_date\": \"1992-08-07\",\n" +
                "      \"poster_path\": \"/9oPodyvCWyPMZJDjg29tBfFRwtG.jpg\",\n" +
                "      \"popularity\": 3.13034142901934,\n" +
                "      \"title\": \"Unforgiven\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 195\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/upTn8UYt1n92opIEIyzh8HljB0F.jpg\",\n" +
                "      \"id\": 274,\n" +
                "      \"original_title\": \"The Silence of the Lambs\",\n" +
                "      \"release_date\": \"1991-02-13\",\n" +
                "      \"poster_path\": \"/qjAyTj2BSth1EQ89vNfo0JYVPFN.jpg\",\n" +
                "      \"popularity\": 1.92532169228635,\n" +
                "      \"title\": \"The Silence of the Lambs\",\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 943\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bRT9Z3yK3SBbUMNoV4TUCEHgscG.jpg\",\n" +
                "      \"id\": 581,\n" +
                "      \"original_title\": \"Dances with Wolves\",\n" +
                "      \"release_date\": \"1990-10-19\",\n" +
                "      \"poster_path\": \"/hpmclspug1I8EwKSWhL7pWWltA.jpg\",\n" +
                "      \"popularity\": 2.68950819207689,\n" +
                "      \"title\": \"Dances with Wolves\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 199\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/uK0ihZKox9aatW6KH1yjZh8wkt3.jpg\",\n" +
                "      \"id\": 403,\n" +
                "      \"original_title\": \"Driving Miss Daisy\",\n" +
                "      \"release_date\": \"1989-12-13\",\n" +
                "      \"poster_path\": \"/iMN2pXVh0ra5fIX3jsVDRGK9FZw.jpg\",\n" +
                "      \"popularity\": 1.4339925,\n" +
                "      \"title\": \"Driving Miss Daisy\",\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 33\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/si2eYu8vpfb2Gu9jHnnbBtSXnNJ.jpg\",\n" +
                "      \"id\": 380,\n" +
                "      \"original_title\": \"Rain Man\",\n" +
                "      \"release_date\": \"1988-12-11\",\n" +
                "      \"poster_path\": \"/mTCpNdDTMGEyrkETRkVqRVkHpx1.jpg\",\n" +
                "      \"popularity\": 3.36142354299863,\n" +
                "      \"title\": \"Rain Man\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 273\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/4FfjHGlzloUqJe9h3mZK1T2olty.jpg\",\n" +
                "      \"id\": 746,\n" +
                "      \"original_title\": \"The Last Emperor\",\n" +
                "      \"release_date\": \"1987-10-29\",\n" +
                "      \"poster_path\": \"/KTirnfG6FZLKWbm8Am3EEKmZDx.jpg\",\n" +
                "      \"popularity\": 2.72225743125,\n" +
                "      \"title\": \"The Last Emperor\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 27\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/ufqPsRItWyFzdFz3MevDkxRF8pT.jpg\",\n" +
                "      \"id\": 792,\n" +
                "      \"original_title\": \"Platoon\",\n" +
                "      \"release_date\": \"1986-12-18\",\n" +
                "      \"poster_path\": \"/sYPOQI57JVNmjiLI3KeZ5KA8O9i.jpg\",\n" +
                "      \"popularity\": 4.02588777113632,\n" +
                "      \"title\": \"Platoon\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 229\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/w6VwFCdQypTKEZAkzWtyPVii3zp.jpg\",\n" +
                "      \"id\": 606,\n" +
                "      \"original_title\": \"Out of Africa\",\n" +
                "      \"release_date\": \"1985-12-10\",\n" +
                "      \"poster_path\": \"/bLXD2jp0img4RJiczAwnS7m7jF9.jpg\",\n" +
                "      \"popularity\": 0.971907130473401,\n" +
                "      \"title\": \"Out of Africa\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 24\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sHsPEij3nojL34xcnaLdnuKEfmH.jpg\",\n" +
                "      \"id\": 279,\n" +
                "      \"original_title\": \"Amadeus\",\n" +
                "      \"release_date\": \"1984-11-13\",\n" +
                "      \"poster_path\": \"/flnoqdC38mbaulAeptjynOFO7yi.jpg\",\n" +
                "      \"popularity\": 2.01916357491556,\n" +
                "      \"title\": \"Amadeus\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 199\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/8jOZrHAbHmMtcZOhFeJDtwzylRs.jpg\",\n" +
                "      \"id\": 11050,\n" +
                "      \"original_title\": \"Terms of Endearment\",\n" +
                "      \"release_date\": \"1983-11-23\",\n" +
                "      \"poster_path\": \"/xKna5S3i1ZuM0xlPpb0hgbcrfkx.jpg\",\n" +
                "      \"popularity\": 0.95771028610751,\n" +
                "      \"title\": \"Terms of Endearment\",\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/yN4mQzPthU1l3PQWxYhzWKargL5.jpg\",\n" +
                "      \"id\": 783,\n" +
                "      \"original_title\": \"Gandhi\",\n" +
                "      \"release_date\": \"1982-11-30\",\n" +
                "      \"poster_path\": \"/2z9A4FSu1YySrhhcuqkdMIXpgyN.jpg\",\n" +
                "      \"popularity\": 2.70371190796283,\n" +
                "      \"title\": \"Gandhi\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 131\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/8Fnr1gMf4dliGrfqi4382P7Lqer.jpg\",\n" +
                "      \"id\": 9443,\n" +
                "      \"original_title\": \"Chariots of Fire\",\n" +
                "      \"release_date\": \"1981-03-30\",\n" +
                "      \"poster_path\": \"/tDt0QreHAiM44km0Iek0UwLdyIW.jpg\",\n" +
                "      \"popularity\": 2.06773614114441,\n" +
                "      \"title\": \"Chariots of Fire\",\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 20\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/ooNn9rDJye7Y6cTmGniGTe12mec.jpg\",\n" +
                "      \"id\": 16619,\n" +
                "      \"original_title\": \"Ordinary People\",\n" +
                "      \"release_date\": \"1980-09-19\",\n" +
                "      \"poster_path\": \"/fxXvhczta3Pqy04JoHRfyhXuyo6.jpg\",\n" +
                "      \"popularity\": 0.8784252,\n" +
                "      \"title\": \"Ordinary People\",\n" +
                "      \"vote_average\": 8.5,\n" +
                "      \"vote_count\": 11\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/uykne2LCkVuD5NEBzicCmCHFqBa.jpg\",\n" +
                "      \"id\": 12102,\n" +
                "      \"original_title\": \"Kramer vs. Kramer\",\n" +
                "      \"release_date\": \"1979-12-19\",\n" +
                "      \"poster_path\": \"/AwqsWJGD3P9YJKpOQ48DcXptyEy.jpg\",\n" +
                "      \"popularity\": 0.913807067776869,\n" +
                "      \"title\": \"Kramer vs. Kramer\",\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"vote_count\": 29\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6y7tez5wmDxe3NktQQAQxO9OGKP.jpg\",\n" +
                "      \"id\": 11778,\n" +
                "      \"original_title\": \"The Deer Hunter\",\n" +
                "      \"release_date\": \"1978-12-08\",\n" +
                "      \"poster_path\": \"/slNJESItHPqp1CENEJQUPw8d7WE.jpg\",\n" +
                "      \"popularity\": 2.20243834939047,\n" +
                "      \"title\": \"The Deer Hunter\",\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 171\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/dbNBU5LbDQLXQEX1V0jAOY7qjO3.jpg\",\n" +
                "      \"id\": 703,\n" +
                "      \"original_title\": \"Annie Hall\",\n" +
                "      \"release_date\": \"1977-04-20\",\n" +
                "      \"poster_path\": \"/lmTPXU1xResvcAiU5DOpmvEpJ0s.jpg\",\n" +
                "      \"popularity\": 1.92268724493778,\n" +
                "      \"title\": \"Annie Hall\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 67\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/2kkyt0FLROrXt41IgSdE7goCFNQ.jpg\",\n" +
                "      \"id\": 1366,\n" +
                "      \"original_title\": \"Rocky\",\n" +
                "      \"release_date\": \"1976-11-21\",\n" +
                "      \"poster_path\": \"/lmwGr6J5y6kngFNQuFV2y1yw4OB.jpg\",\n" +
                "      \"popularity\": 6.28233152794742,\n" +
                "      \"title\": \"Rocky\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 318\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/oXaPao83XXVtyQbr1eH8HOqnz7x.jpg\",\n" +
                "      \"id\": 510,\n" +
                "      \"original_title\": \"One Flew Over the Cuckoo's Nest\",\n" +
                "      \"release_date\": \"1975-11-18\",\n" +
                "      \"poster_path\": \"/srr59GKJdDXPwnWlew9NoYfOvYV.jpg\",\n" +
                "      \"popularity\": 7.0259376675077,\n" +
                "      \"title\": \"One Flew Over the Cuckoo's Nest\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 582\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xUU1melxrkb7IXl1F7PXrtZAWWl.jpg\",\n" +
                "      \"id\": 240,\n" +
                "      \"original_title\": \"The Godfather: Part II\",\n" +
                "      \"release_date\": \"1974-12-20\",\n" +
                "      \"poster_path\": \"/tHbMIIF51rguMNSastqoQwR0sBs.jpg\",\n" +
                "      \"popularity\": 6.14372855467655,\n" +
                "      \"title\": \"The Godfather: Part II\",\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"vote_count\": 986\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qdTTCAt35taHlFeeKZwBXLuJ5z7.jpg\",\n" +
                "      \"id\": 9277,\n" +
                "      \"original_title\": \"The Sting\",\n" +
                "      \"release_date\": \"1973-12-25\",\n" +
                "      \"poster_path\": \"/9UL58y2Lcbr8UpiXKiomYhKTuIs.jpg\",\n" +
                "      \"popularity\": 2.32875,\n" +
                "      \"title\": \"The Sting\",\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 72\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6xKCYgH16UuwEGAyroLU6p8HLIn.jpg\",\n" +
                "      \"id\": 238,\n" +
                "      \"original_title\": \"The Godfather\",\n" +
                "      \"release_date\": \"1972-03-15\",\n" +
                "      \"poster_path\": \"/d4KNaTrltq6bpkFS01pYtyXa09m.jpg\",\n" +
                "      \"popularity\": 8.54426972351326,\n" +
                "      \"title\": \"The Godfather\",\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"vote_count\": 1955\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/oQl0ahcEndQGHMRfq97THau9TT1.jpg\",\n" +
                "      \"id\": 1051,\n" +
                "      \"original_title\": \"The French Connection\",\n" +
                "      \"release_date\": \"1971-10-07\",\n" +
                "      \"poster_path\": \"/n5O4322nJr6yM3MhUA3ixQy60jZ.jpg\",\n" +
                "      \"popularity\": 1.55596784715126,\n" +
                "      \"title\": \"The French Connection\",\n" +
                "      \"vote_average\": 6.1,\n" +
                "      \"vote_count\": 37\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/iCLuDtSSU0cFLH1oTM1828STIOB.jpg\",\n" +
                "      \"id\": 11202,\n" +
                "      \"original_title\": \"Patton\",\n" +
                "      \"release_date\": \"1970-01-25\",\n" +
                "      \"poster_path\": \"/6pyN7udgYaGr6uNIP2MuLUcqmPh.jpg\",\n" +
                "      \"popularity\": 2.9303869443641,\n" +
                "      \"title\": \"Patton\",\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 102\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6bkR6eMCafikq0Nvi665MwsUddk.jpg\",\n" +
                "      \"id\": 3116,\n" +
                "      \"original_title\": \"Midnight Cowboy\",\n" +
                "      \"release_date\": \"1969-05-25\",\n" +
                "      \"poster_path\": \"/cwC4TUi7nfpGDEdk4zRem4aSUmY.jpg\",\n" +
                "      \"popularity\": 0.8787276937,\n" +
                "      \"title\": \"Midnight Cowboy\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 26\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/lfD3hi4AVk05sTngDvybbuLVzqR.jpg\",\n" +
                "      \"id\": 17917,\n" +
                "      \"original_title\": \"Oliver!\",\n" +
                "      \"release_date\": \"1968-09-26\",\n" +
                "      \"poster_path\": \"/t44XtV1pNAKYrb5jIRFpcBo0XSe.jpg\",\n" +
                "      \"popularity\": 0.989556095697334,\n" +
                "      \"title\": \"Oliver!\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 15\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/nXBR8MS7v8V1i0yjHrmpLieaKHe.jpg\",\n" +
                "      \"id\": 10633,\n" +
                "      \"original_title\": \"In the Heat of the Night\",\n" +
                "      \"release_date\": \"1967-08-02\",\n" +
                "      \"poster_path\": \"/w3S3UHDpoEYiNjXgULwmbJ5ZWVa.jpg\",\n" +
                "      \"popularity\": 1.21521523836591,\n" +
                "      \"title\": \"In the Heat of the Night\",\n" +
                "      \"vote_average\": 7.6,\n" +
                "      \"vote_count\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/ivssZ1NdLhovWIEUgi9wN69dR3s.jpg\",\n" +
                "      \"id\": 874,\n" +
                "      \"original_title\": \"A Man for All Seasons\",\n" +
                "      \"release_date\": \"1966-12-12\",\n" +
                "      \"poster_path\": \"/mLFfDCdSH6wetMIIbG08hg51PbD.jpg\",\n" +
                "      \"popularity\": 0.74956530475,\n" +
                "      \"title\": \"A Man for All Seasons\",\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/wZD4CHcQOP38OtbGAWt4OnVxIfj.jpg\",\n" +
                "      \"id\": 15121,\n" +
                "      \"original_title\": \"The Sound of Music\",\n" +
                "      \"release_date\": \"1965-03-02\",\n" +
                "      \"poster_path\": \"/f5hui5D3lgzWiYyImY5i5Qzrfns.jpg\",\n" +
                "      \"popularity\": 2.10353453092086,\n" +
                "      \"title\": \"The Sound of Music\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 260\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/soKwqxI1j5rNkVfDeuarmTHetcH.jpg\",\n" +
                "      \"id\": 11113,\n" +
                "      \"original_title\": \"My Fair Lady\",\n" +
                "      \"release_date\": \"1964-10-21\",\n" +
                "      \"poster_path\": \"/sKEylXQWa15RFLaB54TpBI2eJuy.jpg\",\n" +
                "      \"popularity\": 1.02208906195364,\n" +
                "      \"title\": \"My Fair Lady\",\n" +
                "      \"vote_average\": 7.4,\n" +
                "      \"vote_count\": 46\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/lBwta7cIfHKSJ6m4eEPkydhkuOv.jpg\",\n" +
                "      \"id\": 5769,\n" +
                "      \"original_title\": \"Tom Jones\",\n" +
                "      \"release_date\": \"1963-10-06\",\n" +
                "      \"poster_path\": \"/7pn0MuzLX0tkBnNymdJtF52QQZV.jpg\",\n" +
                "      \"popularity\": 0.692875,\n" +
                "      \"title\": \"Tom Jones\",\n" +
                "      \"vote_average\": 6,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/aSYxlJmM6393RF77ubSEYVKS5Ip.jpg\",\n" +
                "      \"id\": 947,\n" +
                "      \"original_title\": \"Lawrence of Arabia\",\n" +
                "      \"release_date\": \"1962-12-10\",\n" +
                "      \"poster_path\": \"/we2lCeDzaeExUk68qyTDflHAq5m.jpg\",\n" +
                "      \"popularity\": 7.080669083372,\n" +
                "      \"title\": \"Lawrence of Arabia\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 206\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/wgjArGrch7ezI5hGjaB1oj2yb2C.jpg\",\n" +
                "      \"id\": 1725,\n" +
                "      \"original_title\": \"West Side Story\",\n" +
                "      \"release_date\": \"1961-10-18\",\n" +
                "      \"poster_path\": \"/zRQhCSREdR9h4OzEVvwhdlZNZ6m.jpg\",\n" +
                "      \"popularity\": 0.938434080257577,\n" +
                "      \"title\": \"West Side Story\",\n" +
                "      \"vote_average\": 6.3,\n" +
                "      \"vote_count\": 47\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/r1u2bLVO83dvNDODn2oTNLlzYjG.jpg\",\n" +
                "      \"id\": 284,\n" +
                "      \"original_title\": \"The Apartment\",\n" +
                "      \"release_date\": \"1960-06-15\",\n" +
                "      \"poster_path\": \"/8nrQKQjD6z0SJouKHQapXzmjFc6.jpg\",\n" +
                "      \"popularity\": 2.12692886831603,\n" +
                "      \"title\": \"The Apartment\",\n" +
                "      \"vote_average\": 8,\n" +
                "      \"vote_count\": 37\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/kV0wiMw24cgac7BqcppgkmUSGIw.jpg\",\n" +
                "      \"id\": 665,\n" +
                "      \"original_title\": \"Ben-Hur\",\n" +
                "      \"release_date\": \"1959-11-18\",\n" +
                "      \"poster_path\": \"/zKenAABNei8DgLweAuJCSYBemtk.jpg\",\n" +
                "      \"popularity\": 3.62577042294738,\n" +
                "      \"title\": \"Ben-Hur\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 120\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sivrafalYBFYiuHQZ1vUrbstTKe.jpg\",\n" +
                "      \"id\": 17281,\n" +
                "      \"original_title\": \"Gigi\",\n" +
                "      \"release_date\": \"1958-05-15\",\n" +
                "      \"poster_path\": \"/1TEeqGYW08HJoZOcEEWKTq7lGe8.jpg\",\n" +
                "      \"popularity\": 0.4485,\n" +
                "      \"title\": \"Gigi\",\n" +
                "      \"vote_average\": 6.2,\n" +
                "      \"vote_count\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/zt0iYqy0xNEnTu0RX2MfLSo2nz1.jpg\",\n" +
                "      \"id\": 826,\n" +
                "      \"original_title\": \"The Bridge on the River Kwai\",\n" +
                "      \"release_date\": \"1957-12-14\",\n" +
                "      \"poster_path\": \"/vtPR6tSHeu35rF6qTDw3Yjr9eDg.jpg\",\n" +
                "      \"popularity\": 1.98733062344074,\n" +
                "      \"title\": \"The Bridge on the River Kwai\",\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 81\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/lYDstR3BYCkS7IMnbYwvJuHBTt4.jpg\",\n" +
                "      \"id\": 2897,\n" +
                "      \"original_title\": \"Around the World in Eighty Days\",\n" +
                "      \"release_date\": \"1956-10-17\",\n" +
                "      \"poster_path\": \"/7zyt7xVJzN2e9bjIiNsCP7Js74t.jpg\",\n" +
                "      \"popularity\": 0.633665181014225,\n" +
                "      \"title\": \"Around the World in Eighty Days\",\n" +
                "      \"vote_average\": 6.5,\n" +
                "      \"vote_count\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/A4v8kRlaLtnijs0aRLQJ21tEFm9.jpg\",\n" +
                "      \"id\": 15919,\n" +
                "      \"original_title\": \"Marty\",\n" +
                "      \"release_date\": \"1955-04-11\",\n" +
                "      \"poster_path\": \"/go3g5mfa97py2tf2jQmdCv6VSY0.jpg\",\n" +
                "      \"popularity\": 0.667,\n" +
                "      \"title\": \"Marty\",\n" +
                "      \"vote_average\": 8,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/zXp2ydvhO9qGzpIsb1CWeKnn5yg.jpg\",\n" +
                "      \"id\": 654,\n" +
                "      \"original_title\": \"On the Waterfront\",\n" +
                "      \"release_date\": \"1954-07-28\",\n" +
                "      \"poster_path\": \"/sJR7CDGQZ4Rv5tL9p3LHpWPjrdI.jpg\",\n" +
                "      \"popularity\": 2.06455876175876,\n" +
                "      \"title\": \"On the Waterfront\",\n" +
                "      \"vote_average\": 8.3,\n" +
                "      \"vote_count\": 22\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/9LkxpkVwf7eGGKrBlZ4DqywwDEl.jpg\",\n" +
                "      \"id\": 11426,\n" +
                "      \"original_title\": \"From Here to Eternity\",\n" +
                "      \"release_date\": \"1953-08-05\",\n" +
                "      \"poster_path\": \"/bvWfIi0ZLeX4yaCH5rQWRiOT4aT.jpg\",\n" +
                "      \"popularity\": 1.90440489895896,\n" +
                "      \"title\": \"From Here to Eternity\",\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/pGF0cu8ksgqgnSC4fmxkIvKLkMY.jpg\",\n" +
                "      \"id\": 27191,\n" +
                "      \"original_title\": \"The Greatest Show on Earth\",\n" +
                "      \"release_date\": \"1952-01-10\",\n" +
                "      \"poster_path\": \"/2Zh8VfgVgTIeqwhmmPGkNzesNV.jpg\",\n" +
                "      \"popularity\": 0.721674555060053,\n" +
                "      \"title\": \"The Greatest Show on Earth\",\n" +
                "      \"vote_average\": 5.7,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bX1cRtMnTIKnjkXteoB5ZtbOPOu.jpg\",\n" +
                "      \"id\": 2769,\n" +
                "      \"original_title\": \"An American in Paris\",\n" +
                "      \"release_date\": \"1951-10-04\",\n" +
                "      \"poster_path\": \"/nydhf86r3wyEiJjPL9h6tr98KPF.jpg\",\n" +
                "      \"popularity\": 0.6759846095494,\n" +
                "      \"title\": \"An American in Paris\",\n" +
                "      \"vote_average\": 7.4,\n" +
                "      \"vote_count\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/gt7HbwIA5xS1s8jrjy18t3Pfnvz.jpg\",\n" +
                "      \"id\": 705,\n" +
                "      \"original_title\": \"All About Eve\",\n" +
                "      \"release_date\": \"1950-10-13\",\n" +
                "      \"poster_path\": \"/2z2J3mxpGcispYfFjg1conBlrGI.jpg\",\n" +
                "      \"popularity\": 0.6141996403992,\n" +
                "      \"title\": \"All About Eve\",\n" +
                "      \"vote_average\": 7.4,\n" +
                "      \"vote_count\": 14\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/9fbRWjx3szlRKvqf3nSNxtTAkkZ.jpg\",\n" +
                "      \"id\": 25430,\n" +
                "      \"original_title\": \"All the King's Men\",\n" +
                "      \"release_date\": \"1949-11-08\",\n" +
                "      \"poster_path\": \"/xjICuR5RauJcZDNjLV5EvaPXhmN.jpg\",\n" +
                "      \"popularity\": 0.46,\n" +
                "      \"title\": \"All the King's Men\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/2JJSyQX2elrTY7sqHwCl1xrsCdy.jpg\",\n" +
                "      \"id\": 23383,\n" +
                "      \"original_title\": \"Hamlet\",\n" +
                "      \"release_date\": \"1948-05-04\",\n" +
                "      \"poster_path\": \"/nWFbMI774M238az4k9vZk1hLyob.jpg\",\n" +
                "      \"popularity\": 0.957348903011286,\n" +
                "      \"title\": \"Hamlet\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/3DNb1C2NHf5Sbrk5LbuNJydTjXE.jpg\",\n" +
                "      \"id\": 33667,\n" +
                "      \"original_title\": \"Gentleman's Agreement\",\n" +
                "      \"release_date\": \"1947-11-11\",\n" +
                "      \"poster_path\": \"/zKdVejqnpbWCyoQnudb8R0o9bMx.jpg\",\n" +
                "      \"popularity\": 0.36455,\n" +
                "      \"title\": \"Gentleman's Agreement\",\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/kLTBdVlZuszlIqir4W4jOWNtbbQ.jpg\",\n" +
                "      \"id\": 887,\n" +
                "      \"original_title\": \"The Best Years of Our Lives\",\n" +
                "      \"release_date\": \"1946-11-21\",\n" +
                "      \"poster_path\": \"/7BeaPOkVFTKmEGaXicY3vXVhlPO.jpg\",\n" +
                "      \"popularity\": 1.1628842868725,\n" +
                "      \"title\": \"The Best Years of Our Lives\",\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/rLegRrtRlZwKbqLs9H1bcTPT7Gi.jpg\",\n" +
                "      \"id\": 28580,\n" +
                "      \"original_title\": \"The Lost Weekend\",\n" +
                "      \"release_date\": \"1945-11-16\",\n" +
                "      \"poster_path\": \"/4oLDY92VXJxBFu4VILtyGnAeYzH.jpg\",\n" +
                "      \"popularity\": 0.92,\n" +
                "      \"title\": \"The Lost Weekend\",\n" +
                "      \"vote_average\": 8,\n" +
                "      \"vote_count\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/vuYHS9E4ru61uO5DuGCGUsYopu1.jpg\",\n" +
                "      \"id\": 17661,\n" +
                "      \"original_title\": \"Going My Way\",\n" +
                "      \"release_date\": \"1944-08-06\",\n" +
                "      \"poster_path\": \"/2VhlXVPqyU2XXjCss83oXtHgage.jpg\",\n" +
                "      \"popularity\": 0.701105578521982,\n" +
                "      \"title\": \"Going My Way\",\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/nhHsH7qUySVTY57mxf231xO7Fga.jpg\",\n" +
                "      \"id\": 289,\n" +
                "      \"original_title\": \"Casablanca\",\n" +
                "      \"release_date\": \"1942-11-26\",\n" +
                "      \"poster_path\": \"/sm1QVZu5RKe1vXVHZooo4SZyHMx.jpg\",\n" +
                "      \"popularity\": 2.62623659678994,\n" +
                "      \"title\": \"Casablanca\",\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 323\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/cv1OdM7N9VyYLEGSG8iQbQfaxZ4.jpg\",\n" +
                "      \"id\": 27367,\n" +
                "      \"original_title\": \"Mrs. Miniver\",\n" +
                "      \"release_date\": \"1942-06-04\",\n" +
                "      \"poster_path\": \"/kipfyFuAAVMjRRych2uH5BBgakr.jpg\",\n" +
                "      \"popularity\": 0.763231375440324,\n" +
                "      \"title\": \"Mrs. Miniver\",\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/gfOagwHX2LGlfbRoIgCkVfNH8XT.jpg\",\n" +
                "      \"id\": 43266,\n" +
                "      \"original_title\": \"How Green Was My Valley\",\n" +
                "      \"release_date\": \"1941-10-28\",\n" +
                "      \"poster_path\": \"/ezvSKGRHVuU7U7nhpYXlHuTwGyQ.jpg\",\n" +
                "      \"popularity\": 0.3335,\n" +
                "      \"title\": \"How Green Was My Valley\",\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/rKsPmJyGl75Jp6o7XS4rxROpywa.jpg\",\n" +
                "      \"id\": 223,\n" +
                "      \"original_title\": \"Rebecca\",\n" +
                "      \"release_date\": \"1940-04-12\",\n" +
                "      \"poster_path\": \"/nPQZKmdymaNI5ZbZf2VF5xqF666.jpg\",\n" +
                "      \"popularity\": 0.910069813889976,\n" +
                "      \"title\": \"Rebecca\",\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 33\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bGRUMgSvs6wzYQRqehY4Fsup4f1.jpg\",\n" +
                "      \"id\": 770,\n" +
                "      \"original_title\": \"Gone with the Wind\",\n" +
                "      \"release_date\": \"1939-12-15\",\n" +
                "      \"poster_path\": \"/2m9qsuDpAb6aBMxbKOBU1jsP9qf.jpg\",\n" +
                "      \"popularity\": 2.88743571799339,\n" +
                "      \"title\": \"Gone with the Wind\",\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 208\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/w2GoONlwGRuf4Z5aQhvruVmlcSs.jpg\",\n" +
                "      \"id\": 34106,\n" +
                "      \"original_title\": \"You Can't Take It with You\",\n" +
                "      \"release_date\": \"1938-08-23\",\n" +
                "      \"poster_path\": \"/oqWTDqBDYOFuheepreZ1zvBLVhd.jpg\",\n" +
                "      \"popularity\": 0.81285629695597,\n" +
                "      \"title\": \"You Can't Take It with You\",\n" +
                "      \"vote_average\": 8,\n" +
                "      \"vote_count\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/2Z9hu3pAr6UUmztRJdxUE4eRHWt.jpg\",\n" +
                "      \"id\": 43278,\n" +
                "      \"original_title\": \"The Life of Emile Zola\",\n" +
                "      \"release_date\": \"1937-10-02\",\n" +
                "      \"poster_path\": \"/o5plFFBqrXVxThU7xQPqmJRgV8x.jpg\",\n" +
                "      \"popularity\": 0.46,\n" +
                "      \"title\": \"The Life of Emile Zola\",\n" +
                "      \"vote_average\": 6.2,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/zrZ90x3TFnt2HAj2OjqKhQQWruz.jpg\",\n" +
                "      \"id\": 43277,\n" +
                "      \"original_title\": \"The Great Ziegfeld\",\n" +
                "      \"release_date\": \"1936-04-08\",\n" +
                "      \"poster_path\": \"/wyB7xg4kANE0S70S6ibX5WmQncm.jpg\",\n" +
                "      \"popularity\": 0.41608112193136,\n" +
                "      \"title\": \"The Great Ziegfeld\",\n" +
                "      \"vote_average\": 3.5,\n" +
                "      \"vote_count\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/yJdiJtbv62zuBd42eA66yBX8hfM.jpg\",\n" +
                "      \"id\": 12311,\n" +
                "      \"original_title\": \"Mutiny on the Bounty\",\n" +
                "      \"release_date\": \"1935-11-08\",\n" +
                "      \"poster_path\": \"/kZ8pTLL4V4s0EwE2oTyOA1fGTje.jpg\",\n" +
                "      \"popularity\": 0.858371440730106,\n" +
                "      \"title\": \"Mutiny on the Bounty\",\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"vote_count\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/3wTCVC7d8bhvX67ScQfbBJSobpM.jpg\",\n" +
                "      \"id\": 3078,\n" +
                "      \"original_title\": \"It Happened One Night\",\n" +
                "      \"release_date\": \"1934-02-22\",\n" +
                "      \"poster_path\": \"/3jAG2wFHSJB07TxGbFTYZttBqr4.jpg\",\n" +
                "      \"popularity\": 0.817210228766524,\n" +
                "      \"title\": \"It Happened One Night\",\n" +
                "      \"vote_average\": 7.6,\n" +
                "      \"vote_count\": 24\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/adzlio3r2bYO4rSnBhNtWQ0UuhM.jpg\",\n" +
                "      \"id\": 56164,\n" +
                "      \"original_title\": \"Cavalcade\",\n" +
                "      \"release_date\": \"1933-01-01\",\n" +
                "      \"poster_path\": \"/uVmkQoxPlF8Vvx2TrLOrF08STNH.jpg\",\n" +
                "      \"popularity\": 0.586546,\n" +
                "      \"title\": \"Cavalcade\",\n" +
                "      \"vote_average\": 5.5,\n" +
                "      \"vote_count\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/uiIwVCclBveUt2PVO8F7xkPe5Cj.jpg\",\n" +
                "      \"id\": 33680,\n" +
                "      \"original_title\": \"Grand Hotel\",\n" +
                "      \"release_date\": \"1932-04-14\",\n" +
                "      \"poster_path\": \"/zyHtotFohx0wXA7wqx2gylyUqUh.jpg\",\n" +
                "      \"popularity\": 0.60988978689375,\n" +
                "      \"title\": \"Grand Hotel\",\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/vD2YkSnsXG52pOhoIulDMQCE0lL.jpg\",\n" +
                "      \"id\": 42861,\n" +
                "      \"original_title\": \"Cimarron\",\n" +
                "      \"release_date\": \"1931-01-01\",\n" +
                "      \"poster_path\": \"/o5TfT5lgfEfuf25S5kPG92dd8jm.jpg\",\n" +
                "      \"popularity\": 0.368,\n" +
                "      \"title\": \"Cimarron\",\n" +
                "      \"vote_average\": 6,\n" +
                "      \"vote_count\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/zC9aNreN9ECI61EHbQwYPAe1QHv.jpg\",\n" +
                "      \"id\": 143,\n" +
                "      \"original_title\": \"All Quiet on the Western Front\",\n" +
                "      \"release_date\": \"1930-04-21\",\n" +
                "      \"poster_path\": \"/qP9CwUQqfqxep7Ln7pUdAmfouf7.jpg\",\n" +
                "      \"popularity\": 1.48726897632244,\n" +
                "      \"title\": \"All Quiet on the Western Front\",\n" +
                "      \"vote_average\": 7.7,\n" +
                "      \"vote_count\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/69NfvNrpPI6bjj3Txp2cDsRZ5se.jpg\",\n" +
                "      \"id\": 65203,\n" +
                "      \"original_title\": \"The Broadway Melody\",\n" +
                "      \"release_date\": \"1929-06-06\",\n" +
                "      \"poster_path\": \"/dJxFUKiO7JTDBSUr4Nzct4iJikX.jpg\",\n" +
                "      \"popularity\": 0.34355675,\n" +
                "      \"title\": \"The Broadway Melody\",\n" +
                "      \"vote_average\": 5.3,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xpUbeDxBAGG30qtVn62lLU2S5SD.jpg\",\n" +
                "      \"id\": 28966,\n" +
                "      \"original_title\": \"Wings\",\n" +
                "      \"release_date\": \"1927-08-12\",\n" +
                "      \"poster_path\": \"/negcQiFVemelvl3RKv2iLj1MH17.jpg\",\n" +
                "      \"popularity\": 1.3312092375,\n" +
                "      \"title\": \"Wings\",\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"vote_count\": 7\n" +
                "    }\n" +
                "  ],\n" +
                "  \"item_count\": 85,\n" +
                "  \"iso_639_1\": \"en\",\n" +
                "  \"name\": \"Best Picture Winners - The Academy Awards\",\n" +
                "  \"poster_path\": \"/efBm2Nm2v5kQnO0w3hYcW6hVsJU.jpg\"\n" +
                "}";

        Gson gson = new Gson();
        TMDBMovieList list = gson.fromJson(json,TMDBMovieList.class);
    }

    @Test
    public void popularMoviesDeserializationTest(){
        String json = "{\n" +
                "  \"page\": 1,\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        12,\n" +
                "        878,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 135397,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Jurassic World\",\n" +
                "      \"overview\": \"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\n" +
                "      \"release_date\": \"2015-06-12\",\n" +
                "      \"poster_path\": \"/uXZYawqUsChGSj54wcuBtEdUJbh.jpg\",\n" +
                "      \"popularity\": 88.551849,\n" +
                "      \"title\": \"Jurassic World\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 435\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/jxPeRkfOoWs6gFybOa8C4xrHLrm.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        53,\n" +
                "        28,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 76341,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Mad Max: Fury Road\",\n" +
                "      \"overview\": \"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.\",\n" +
                "      \"release_date\": \"2015-05-15\",\n" +
                "      \"poster_path\": \"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg\",\n" +
                "      \"popularity\": 35.88189,\n" +
                "      \"title\": \"Mad Max: Fury Road\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"vote_count\": 815\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/cUfGqafAVQkatQ7N4y08RNV3bgu.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        18,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 254128,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"San Andreas\",\n" +
                "      \"overview\": \"In the aftermath of a massive earthquake in California, a rescue-chopper pilot makes a dangerous journey across the state in order to rescue his estranged daughter.\",\n" +
                "      \"release_date\": \"2015-05-29\",\n" +
                "      \"poster_path\": \"/6iQ4CMtYorKFfAmXEpAQZMnA0Qe.jpg\",\n" +
                "      \"popularity\": 25.002,\n" +
                "      \"title\": \"San Andreas\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.2,\n" +
                "      \"vote_count\": 234\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/2BXd0t9JdVqCp9sKf6kzMkr7QjB.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        12,\n" +
                "        10751,\n" +
                "        16,\n" +
                "        28,\n" +
                "        35\n" +
                "      ],\n" +
                "      \"id\": 177572,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Big Hero 6\",\n" +
                "      \"overview\": \"The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.\",\n" +
                "      \"release_date\": \"2014-11-07\",\n" +
                "      \"poster_path\": \"/3zQvuSAUdC3mrx9vnSEpkFX0968.jpg\",\n" +
                "      \"popularity\": 19.674015,\n" +
                "      \"title\": \"Big Hero 6\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.9,\n" +
                "      \"vote_count\": 1471\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xjjO3JIdneMBTsS282JffiPqfHW.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        10749,\n" +
                "        14,\n" +
                "        10751,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 150689,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Cinderella\",\n" +
                "      \"overview\": \"When her father unexpectedly passes away, young Ella finds herself at the mercy of her cruel stepmother and her daughters. Never one to give up hope, Ella's fortunes begin to change after meeting a dashing stranger in the woods.\",\n" +
                "      \"release_date\": \"2015-03-13\",\n" +
                "      \"poster_path\": \"/2i0JH5WqYFqki7WDhUW56Sg0obh.jpg\",\n" +
                "      \"popularity\": 18.919939,\n" +
                "      \"title\": \"Cinderella\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 276\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/7LMp3YY6WrJEExwKEyVaQnRlC76.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        35,\n" +
                "        28,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 207703,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Kingsman: The Secret Service\",\n" +
                "      \"overview\": \"Kingsman: The Secret Service tells the story of a super-secret spy organization that recruits an unrefined but promising street kid into the agency's ultra-competitive training program just as a global threat emerges from a twisted tech genius.\",\n" +
                "      \"release_date\": \"2015-02-13\",\n" +
                "      \"poster_path\": \"/oAISjx6DvR2yUn9dxj00vP8OcJJ.jpg\",\n" +
                "      \"popularity\": 17.71923,\n" +
                "      \"title\": \"Kingsman: The Secret Service\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.7,\n" +
                "      \"vote_count\": 1044\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/y5lG7TBpeOMG0jxAaTK0ghZSzBJ.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        878,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 198184,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Chappie\",\n" +
                "      \"overview\": \"Every child comes into the world full of promise, and none more so than Chappie: he is gifted, special, a prodigy. Like any child, Chappie will come under the influence of his surroundings—some good, some bad—and he will rely on his heart and soul to find his way in the world and become his own man. But there's one thing that makes Chappie different from any one else: he is a robot.\",\n" +
                "      \"release_date\": \"2015-03-06\",\n" +
                "      \"poster_path\": \"/saF3HtAduvrP9ytXDxSnQJP3oqx.jpg\",\n" +
                "      \"popularity\": 17.66911,\n" +
                "      \"title\": \"Chappie\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 492\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 157336,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Interstellar\",\n" +
                "      \"overview\": \"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.\",\n" +
                "      \"release_date\": \"2014-11-05\",\n" +
                "      \"poster_path\": \"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg\",\n" +
                "      \"popularity\": 16.688744,\n" +
                "      \"title\": \"Interstellar\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.4,\n" +
                "      \"vote_count\": 2485\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qhH3GyIfAnGv1pjdV3mw03qAilg.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        12,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"id\": 122917,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Hobbit: The Battle of the Five Armies\",\n" +
                "      \"overview\": \"Mere seconds after the events of \\\"Desolation\\\", Bilbo and Company continue to claim a mountain of treasure that was guarded long ago: But with Gandalf the Grey also facing some formidable foes of his own, the Hobbit is outmatched when the brutal army of orcs led by Azog the Defiler returns. But with other armies such as the elves and the men of Lake-Town, which are unsure to be trusted, are put to the ultimate test when Smaug's wrath, Azog's sheer strength, and Sauron's force of complete ends attack. All in all, the trusted armies have two choices: unite or die. But even worse, Bilbo gets put on a knife edge and finds himself fighting with Hobbit warfare with all of his might for his dwarf-friends, as the hope for Middle-Earth is all put in Bilbo's hands. The one \\\"precious\\\" thing to end it all.\",\n" +
                "      \"release_date\": \"2014-12-17\",\n" +
                "      \"poster_path\": \"/qrFwjJ5nvFnpBCmXLI4YoeHJNBH.jpg\",\n" +
                "      \"popularity\": 16.434565,\n" +
                "      \"title\": \"The Hobbit: The Battle of the Five Armies\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 1470\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bIlYH4l2AyYvEysmS2AOfjO7Dn8.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        28,\n" +
                "        53,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 87101,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Terminator Genisys\",\n" +
                "      \"overview\": \"The year is 2029. John Connor, leader of the resistance continues the war against the machines. At the Los Angeles offensive, John's fears of the unknown future begin to emerge when TECOM spies reveal a new plot by SkyNet that will attack him from both fronts; past and future, and will ultimately change warfare forever.\",\n" +
                "      \"release_date\": \"2015-07-01\",\n" +
                "      \"poster_path\": \"/qOoFD4HD9a2EEUymdzBQN9XF1UJ.jpg\",\n" +
                "      \"popularity\": 15.394013,\n" +
                "      \"title\": \"Terminator Genisys\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 35\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/4liSXBZZdURI0c1Id1zLJo6Z3Gu.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        14,\n" +
                "        28,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 76757,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Jupiter Ascending\",\n" +
                "      \"overview\": \"In a universe where human genetic material is the most precious commodity, an impoverished young Earth woman becomes the key to strategic maneuvers and internal strife within a powerful dynasty…\",\n" +
                "      \"release_date\": \"2015-02-27\",\n" +
                "      \"poster_path\": \"/aMEsvTUklw0uZ3gk3Q6lAj6302a.jpg\",\n" +
                "      \"popularity\": 15.209428,\n" +
                "      \"title\": \"Jupiter Ascending\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.4,\n" +
                "      \"vote_count\": 682\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/fii9tPZTpy75qOCJBulWOb0ifGp.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        36,\n" +
                "        53,\n" +
                "        10752\n" +
                "      ],\n" +
                "      \"id\": 205596,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Imitation Game\",\n" +
                "      \"overview\": \"Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain's top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.\",\n" +
                "      \"release_date\": \"2014-11-14\",\n" +
                "      \"poster_path\": \"/noUp0XOqIcmgefRnRZa1nhtRvWO.jpg\",\n" +
                "      \"popularity\": 14.06502,\n" +
                "      \"title\": \"The Imitation Game\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 1222\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/rFtsE7Lhlc2jRWF7SRAU0fvrveQ.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        12,\n" +
                "        878,\n" +
                "        28\n" +
                "      ],\n" +
                "      \"id\": 99861,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Avengers: Age of Ultron\",\n" +
                "      \"overview\": \"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.\",\n" +
                "      \"release_date\": \"2015-05-01\",\n" +
                "      \"poster_path\": \"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\",\n" +
                "      \"popularity\": 14.81874,\n" +
                "      \"title\": \"Avengers: Age of Ultron\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.8,\n" +
                "      \"vote_count\": 1259\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        14,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 118340,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Guardians of the Galaxy\",\n" +
                "      \"overview\": \"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.\",\n" +
                "      \"release_date\": \"2014-08-01\",\n" +
                "      \"poster_path\": \"/9gm3lL8JMTTmc3W4BmNMCuRLdL8.jpg\",\n" +
                "      \"popularity\": 14.51119,\n" +
                "      \"title\": \"Guardians of the Galaxy\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 2706\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/kJre98tnbNXbk5L5altHkQWGwD3.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        12,\n" +
                "        878,\n" +
                "        9648\n" +
                "      ],\n" +
                "      \"id\": 158852,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Tomorrowland\",\n" +
                "      \"overview\": \"Bound by a shared destiny, a bright, optimistic teen bursting with scientific curiosity and a former boy-genius inventor jaded by disillusionment embark on a danger-filled mission to unearth the secrets of an enigmatic place somewhere in time and space that exists in their collective memory as \\\"Tomorrowland.\\\"\",\n" +
                "      \"release_date\": \"2015-05-22\",\n" +
                "      \"poster_path\": \"/69Cz9VNQZy39fUE2g0Ggth6SBTM.jpg\",\n" +
                "      \"popularity\": 14.07089,\n" +
                "      \"title\": \"Tomorrowland\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 239\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6zJCJtcxmMUU7pjL4Ss1xkeGiyX.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        80,\n" +
                "        18,\n" +
                "        9648,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 241554,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Run All Night\",\n" +
                "      \"overview\": \"Brooklyn mobster and prolific hit man Jimmy Conlon, once known as The Gravedigger, has seen better days. Longtime best friend of mob boss. Jimmy, now 55, is haunted by the sins of his past—as well as a dogged police detective who’s been one step behind Jimmy for 30 years. But when Jimmy’s estranged son, becomes a target, Jimmy must make a choice between the crime family he chose and the real family he abandoned long ago. Now, with nowhere safe to turn, Jimmy just has one night to figure out exactly where his loyalties lie and to see if he can finally make things right.\",\n" +
                "      \"release_date\": \"2015-03-13\",\n" +
                "      \"poster_path\": \"/aqNJrAxudMRNo8jg3HOUQqdl2xr.jpg\",\n" +
                "      \"popularity\": 13.651485,\n" +
                "      \"title\": \"Run All Night\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"vote_count\": 162\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/fUn5I5f4069vwGFEEvA3HXt9xPP.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        12,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 131631,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
                "      \"overview\": \"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.\",\n" +
                "      \"release_date\": \"2014-11-20\",\n" +
                "      \"poster_path\": \"/cWERd8rgbw7bCMZlwP207HUXxym.jpg\",\n" +
                "      \"popularity\": 12.730425,\n" +
                "      \"title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 1379\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/anItUS64TeGKPv6MJ99DMv7o0Z0.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        35,\n" +
                "        10402\n" +
                "      ],\n" +
                "      \"id\": 254470,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Pitch Perfect 2\",\n" +
                "      \"overview\": \"The Bellas are back, and they are better than ever. After being humiliated in front of none other than the President of the United States of America, the Bellas are taken out of the Aca-Circuit. In order to clear their name, and regain their status, the Bellas take on a seemingly impossible task: winning an international competition no American team has ever won. In order to accomplish this monumental task, they need to strengthen the bonds of friendship and sisterhood and blow away the competition with their amazing aca-magic! With all new friends and old rivals tagging along for the trip, the Bellas can hopefully accomplish their dreams.\",\n" +
                "      \"release_date\": \"2015-05-15\",\n" +
                "      \"poster_path\": \"/qSjruLiFB4uqRtz2xheQPxG8uaB.jpg\",\n" +
                "      \"popularity\": 12.179013,\n" +
                "      \"title\": \"Pitch Perfect 2\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 189\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/8dHsvdiZLBdppKwRiZ0XZYngbeN.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        35\n" +
                "      ],\n" +
                "      \"id\": 257091,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Get Hard\",\n" +
                "      \"overview\": \"When obscenely rich hedge-fund manager James is convicted of fraud and sentenced to a stretch in San Quentin, the judge gives him one month to get his affairs in order. Knowing that he won't survive more than a few minutes in prison on his own, James desperately turns to Darnell-- a black businessman who's never even had a parking ticket -- for help. As Darnell puts James through the wringer, both learn that they were wrong about many things, including each other.\",\n" +
                "      \"release_date\": \"2015-03-27\",\n" +
                "      \"poster_path\": \"/qRzUSrN4p6B7fzA5XGm4ebFg3co.jpg\",\n" +
                "      \"popularity\": 11.9924,\n" +
                "      \"title\": \"Get Hard\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6,\n" +
                "      \"vote_count\": 122\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/razvUuLkF7CX4XsLyj02ksC0ayy.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        28,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 260346,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Taken 3\",\n" +
                "      \"overview\": \"Ex-government operative Bryan Mills finds his life is shattered when he's falsely accused of a murder that hits close to home. As he's pursued by a savvy police inspector, Mills employs his particular set of skills to track the real killer and exact his unique brand of justice.\",\n" +
                "      \"release_date\": \"2015-01-09\",\n" +
                "      \"poster_path\": \"/c2SSjUVYawDUnQ92bmTqsZsPEiB.jpg\",\n" +
                "      \"popularity\": 11.737899,\n" +
                "      \"title\": \"Taken 3\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.2,\n" +
                "      \"vote_count\": 698\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total_pages\": 11324,\n" +
                "  \"total_results\": 226478\n" +
                "}";

        Gson gson = new Gson();
        MovieListWrapper popular = gson.fromJson(json, MovieListWrapper.class);
    }

    @Test
    public void topRatedMovieDeserializationTest(){
        String json = "\n" +
                "{\n" +
                "  \"page\": 1,\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 244786,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Whiplash\",\n" +
                "      \"overview\": \"Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.\",\n" +
                "      \"release_date\": \"2014-10-10\",\n" +
                "      \"poster_path\": \"/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg\",\n" +
                "      \"popularity\": 8.441533,\n" +
                "      \"title\": \"Whiplash\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.5,\n" +
                "      \"vote_count\": 856\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/60cvl34Go8dvtDiHs9L82a79VXm.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        10749,\n" +
                "        35,\n" +
                "        16,\n" +
                "        18,\n" +
                "        10751\n" +
                "      ],\n" +
                "      \"id\": 293299,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Feast\",\n" +
                "      \"overview\": \"This Oscar-winning animated short film tells the story of one man's love life is seen through the eyes of his best friend and dog, Winston, and revealed bite by bite through the meals they share.\",\n" +
                "      \"release_date\": \"2014-11-07\",\n" +
                "      \"poster_path\": \"/4XFN435sO7t9sMiWGMtWcV9qfmq.jpg\",\n" +
                "      \"popularity\": 2.406332,\n" +
                "      \"title\": \"Feast\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.5,\n" +
                "      \"vote_count\": 80\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/W0MNr3XN95U5KLD9xIQD96YKcS.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        35,\n" +
                "        28,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"id\": 251516,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Kung Fury\",\n" +
                "      \"overview\": \"During an unfortunate series of events, a friend of Kung Fury is assassinated by the most dangerous kung fu master criminal of all time, Adolf Hitler, a.k.a Kung Führer. Kung Fury decides to travel back in time to Nazi Germany in order to kill Hitler and end the Nazi empire once and for all.\",\n" +
                "      \"release_date\": \"2015-05-28\",\n" +
                "      \"poster_path\": \"/oJWzpGCLIj3uYa0ux19T2WwzTOf.jpg\",\n" +
                "      \"popularity\": 4.224303,\n" +
                "      \"title\": \"Kung Fury\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.5,\n" +
                "      \"vote_count\": 64\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/vPbAhbnXFn183UAqOLbaXDX5I2u.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 313106,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Doctor Who: The Day of the Doctor\",\n" +
                "      \"overview\": \"In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.\",\n" +
                "      \"release_date\": \"2013-11-23\",\n" +
                "      \"poster_path\": \"/dKSwfLWxQVR37YOmZFb5S072P3G.jpg\",\n" +
                "      \"popularity\": 2.553939,\n" +
                "      \"title\": \"Doctor Who: The Day of the Doctor\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.4,\n" +
                "      \"vote_count\": 55\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 157336,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Interstellar\",\n" +
                "      \"overview\": \"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.\",\n" +
                "      \"release_date\": \"2014-11-05\",\n" +
                "      \"poster_path\": \"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg\",\n" +
                "      \"popularity\": 16.688744,\n" +
                "      \"title\": \"Interstellar\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.4,\n" +
                "      \"vote_count\": 2485\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/cqn1ynw78Wan37jzs1Ckm7va97G.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        10749,\n" +
                "        10751\n" +
                "      ],\n" +
                "      \"id\": 140420,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Paperman\",\n" +
                "      \"overview\": \"An urban office worker finds that paper airplanes are instrumental in meeting a girl in ways he never expected.\",\n" +
                "      \"release_date\": \"2012-11-02\",\n" +
                "      \"poster_path\": \"/xBo8dd2zUbMvcypwScDN3mpN7IZ.jpg\",\n" +
                "      \"popularity\": 2.684451,\n" +
                "      \"title\": \"Paperman\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.4,\n" +
                "      \"vote_count\": 162\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sFQ10h9DnjOYIF4HjtLQuZ8pnb4.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        10751\n" +
                "      ],\n" +
                "      \"id\": 13042,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Presto\",\n" +
                "      \"overview\": \"Dignity. Poise. Mystery. We expect nothing less from the great turn-of-the-century magician, Presto. But when Presto neglects to feed his rabbit one too many times, the magician finds he isn't the only one with a few tricks up his sleeve!\",\n" +
                "      \"release_date\": \"2008-06-26\",\n" +
                "      \"poster_path\": \"/A2rxR8g3y6kcjIoR2fcwtq9eppc.jpg\",\n" +
                "      \"popularity\": 1.929923,\n" +
                "      \"title\": \"Presto\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.3,\n" +
                "      \"vote_count\": 164\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/icWOFbzKGyU35nuzIHExYSjnLcc.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        10751,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"id\": 110416,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Song of the Sea\",\n" +
                "      \"overview\": \"The story of the last Seal Child’s journey home. After their mother’s disappearance, Ben and Saoirse are sent to live with Granny in the city. When they resolve to return to their home by the sea, their journey becomes a race against time as they are drawn into a world Ben knows only from his mother’s folktales. But this is no bedtime story; these fairy folk have been in our world far too long. It soon becomes clear to Ben that Saoirse is the key to their survival.\",\n" +
                "      \"release_date\": \"2014-12-19\",\n" +
                "      \"poster_path\": \"/uvNv23Arf2ZYtimiStSB2c1DAEX.jpg\",\n" +
                "      \"popularity\": 2.34488,\n" +
                "      \"title\": \"Song of the Sea\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.3,\n" +
                "      \"vote_count\": 60\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6Vb5tERWpWYlIeISYH1MDcmt499.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 265177,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Mommy\",\n" +
                "      \"overview\": \"A widowed single mother, raising her violent son alone, finds new hope when a mysterious neighbor inserts herself into their household.\",\n" +
                "      \"release_date\": \"2014-09-19\",\n" +
                "      \"poster_path\": \"/7Oq8T5XsvwgsJjc1btukMRVP4K3.jpg\",\n" +
                "      \"popularity\": 1.952857,\n" +
                "      \"title\": \"Mommy\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 119\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        878,\n" +
                "        14,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 118340,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Guardians of the Galaxy\",\n" +
                "      \"overview\": \"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.\",\n" +
                "      \"release_date\": \"2014-08-01\",\n" +
                "      \"poster_path\": \"/9gm3lL8JMTTmc3W4BmNMCuRLdL8.jpg\",\n" +
                "      \"popularity\": 14.51119,\n" +
                "      \"title\": \"Guardians of the Galaxy\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 2706\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xBKGJQsAIeweesB79KC89FpBrVr.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        80\n" +
                "      ],\n" +
                "      \"id\": 278,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Shawshank Redemption\",\n" +
                "      \"overview\": \"Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.\",\n" +
                "      \"release_date\": \"1994-09-14\",\n" +
                "      \"poster_path\": \"/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg\",\n" +
                "      \"popularity\": 4.054268,\n" +
                "      \"title\": \"The Shawshank Redemption\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 3852\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qQzxMLMJMmkEAB6cYTEa9n2Emvz.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        14,\n" +
                "        10751,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 110420,\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"original_title\": \"Ookami kodomo no Ame to Yuki\",\n" +
                "      \"overview\": \"Hana, a nineteen-year-old college student, falls in love with a man only for him to reveal his secret; he is a Wolf Man. Eventually the couple bear two children together; a son and daughter they name Ame and Yuki who both inherit the ability to transform into wolves from their father. When the man Hana fell in love with suddenly dies, she makes the decision to move to a rural town isolated from society to continue raising the children in protection.\",\n" +
                "      \"release_date\": \"2012-08-29\",\n" +
                "      \"poster_path\": \"/rDMxjCYEVnvLC4nsBpB6wjL0LDy.jpg\",\n" +
                "      \"popularity\": 2.046142,\n" +
                "      \"title\": \"Wolf Children\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 76\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qLxZZuENWJiBrmOD17Wf3qAHGQb.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        10749\n" +
                "      ],\n" +
                "      \"id\": 237791,\n" +
                "      \"original_language\": \"pt\",\n" +
                "      \"original_title\": \"Hoje Eu Quero Voltar Sozinho\",\n" +
                "      \"overview\": \"Leonardo is a blind teenager searching for independence. His everyday life, the relationship with his best friend, Giovana, and the way he sees the world change completely with the arrival of Gabriel.\",\n" +
                "      \"release_date\": \"2014-03-28\",\n" +
                "      \"poster_path\": \"/oAPCsQiWV6YUd0Gt62BOwb8aSth.jpg\",\n" +
                "      \"popularity\": 1.746087,\n" +
                "      \"title\": \"The Way He Looks\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 55\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/lH2Ga8OzjU1XlxJ73shOlPx6cRw.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 389,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"12 Angry Men\",\n" +
                "      \"overview\": \"The defense and the prosecution have rested and the jury is filing into the jury room to decide if a young Spanish-American is guilty or innocent of murdering his father. What begins as an open and shut case soon becomes a mini-drama of each of the jurors' prejudices and preconceptions about the trial, the accused, and each other.\",\n" +
                "      \"release_date\": \"1957-04-10\",\n" +
                "      \"poster_path\": \"/qcL1YfkCxfhsdO6sDDJ0PpzMF9n.jpg\",\n" +
                "      \"popularity\": 3.04376,\n" +
                "      \"title\": \"12 Angry Men\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 675\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/uIhEU2VUVgez3tKyPmMG9pf1q0g.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        14,\n" +
                "        16,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 149871,\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"original_title\": \"Kaguya Hime no Monogatari\",\n" +
                "      \"overview\": \"Found inside a shining stalk of bamboo by an old bamboo cutter and his wife, a tiny girl grows rapidly into an exquisite young lady. The mysterious young princess enthralls all who encounter her - but ultimately she must confront her fate, the punishment for her crime.\",\n" +
                "      \"release_date\": \"2013-11-23\",\n" +
                "      \"poster_path\": \"/11Az4sMt1C9sm8atgB199Z0BsIQ.jpg\",\n" +
                "      \"popularity\": 2.902988,\n" +
                "      \"title\": \"The Tale of the Princess Kaguya\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 70\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6xKCYgH16UuwEGAyroLU6p8HLIn.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 238,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Godfather\",\n" +
                "      \"overview\": \"The story spans the years from 1945 to 1955 and chronicles the fictional Italian-American Corleone crime family. When organized crime family patriarch Vito Corleone barely survives an attempt on his life, his youngest son, Michael, steps in to take care of the would-be killers, launching a campaign of bloody revenge.\",\n" +
                "      \"release_date\": \"1972-03-15\",\n" +
                "      \"poster_path\": \"/d4KNaTrltq6bpkFS01pYtyXa09m.jpg\",\n" +
                "      \"popularity\": 3.50568,\n" +
                "      \"title\": \"The Godfather\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 2451\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/ddlMODFJUjvhzrymuW7O7KPuhVL.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 169813,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Short Term 12\",\n" +
                "      \"overview\": \"A 20-something supervising staff member of a residential treatment facility navigates the troubled waters of that world alongside her co-worker and longtime boyfriend.\",\n" +
                "      \"release_date\": \"2013-08-23\",\n" +
                "      \"poster_path\": \"/wYkiNNMM1O5c2yEcj8Lf9UbaB1a.jpg\",\n" +
                "      \"popularity\": 2.287634,\n" +
                "      \"title\": \"Short Term 12\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 122\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/zXp2ydvhO9qGzpIsb1CWeKnn5yg.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        80,\n" +
                "        18\n" +
                "      ],\n" +
                "      \"id\": 654,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"On the Waterfront\",\n" +
                "      \"overview\": \"Terry Malloy dreams about being a prize fighter, while tending his pigeons and running errands at the docks for Johnny Friendly, the corrupt boss of the dockers union. Terry witnesses a murder by two of Johnny's thugs, and later meets the dead man's sister and feels responsible for his death. She introduces him to Father Barry, who tries to force him to provide information for the courts that will smash the dock racketeers.\",\n" +
                "      \"release_date\": \"1954-06-22\",\n" +
                "      \"poster_path\": \"/xXRgZKrdIT1GmTssy4EJoax725A.jpg\",\n" +
                "      \"popularity\": 0.702477,\n" +
                "      \"title\": \"On the Waterfront\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 60\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/fii9tPZTpy75qOCJBulWOb0ifGp.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        36,\n" +
                "        18,\n" +
                "        53,\n" +
                "        10752\n" +
                "      ],\n" +
                "      \"id\": 205596,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Imitation Game\",\n" +
                "      \"overview\": \"Based on the real life story of legendary cryptanalyst Alan Turing, the film portrays the nail-biting race against time by Turing and his brilliant team of code-breakers at Britain's top-secret Government Code and Cypher School at Bletchley Park, during the darkest days of World War II.\",\n" +
                "      \"release_date\": \"2014-11-14\",\n" +
                "      \"poster_path\": \"/noUp0XOqIcmgefRnRZa1nhtRvWO.jpg\",\n" +
                "      \"popularity\": 15.06502,\n" +
                "      \"title\": \"The Imitation Game\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 1222\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/ihWaJZCUIon2dXcosjQG2JHJAPN.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        35\n" +
                "      ],\n" +
                "      \"id\": 77338,\n" +
                "      \"original_language\": \"fr\",\n" +
                "      \"original_title\": \"Intouchables\",\n" +
                "      \"overview\": \"A true story of two men who should never have met - a quadriplegic aristocrat who was injured in a paragliding accident and a young man from the projects.\",\n" +
                "      \"release_date\": \"2011-11-02\",\n" +
                "      \"poster_path\": \"/4mFsNQwbD0F237Tx7gAPotd0nbJ.jpg\",\n" +
                "      \"popularity\": 3.972343,\n" +
                "      \"title\": \"The Intouchables\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 1465\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total_pages\": 166,\n" +
                "  \"total_results\": 3316\n" +
                "}";

        Gson gson = new Gson();
        MovieListWrapper toprated = gson.fromJson(json,MovieListWrapper.class);
        //List<Genre> genres = toprated.getMovies().get(0).getGenres(); //will fail because all genres in TMDBGenre were not loaded but everything works well
    }

    @Test
    public void personDeserializationTest(){
        String json = "{\"adult\":false,\"also_known_as\":[\"Scarlett Johanssen\",\"Scarlett Ingrid Johansson\"],\"biography\":\"Scarlett Johansson, born November 22, 1984, is an American actress, model and singer. She made her film debut in North (1994) and was later nominated for the Independent Spirit Award for Best Female Lead for her performance in Manny &amp; Lo (1996), garnering further acclaim and prominence with roles in The Horse Whisperer (1998) and Ghost World (2001). She shifted to adult roles with her performances in Girl with a Pearl Earring (2003) and Sofia Coppola's Lost in Translation (2003), for which she won a BAFTA award for Best Actress in a Leading Role; both films earned her Golden Globe Award nominations as well.\\n\\nA role in A Love Song for Bobby Long (2004) earned Johansson her third Golden Globe for Best Actress nomination. Johansson garnered another Golden Globe nomination for Best Supporting Actress with her role in Woody Allen's Match Point (2005). She has played the Marvel comic book character Black Widow/Natasha Romanoff in Iron Man 2 (2010), The Avengers (2012), and Captain America: The Winter Soldier (2014) and is set to reprise the role in Avengers: Age of Ultron (2015). The 2010 Broadway revival of Arthur Miller's A View From the Bridge won Johansson the Tony Award for Best Performance by a Featured Actress in a Play. As a singer, Johansson has released two albums, Anywhere I Lay My Head and Break Up.\\n\\nJohansson is considered one of Hollywood's modern sex symbols, and has frequently appeared in published lists of the sexiest women in the world, most notably when she was named the \\\"Sexiest Woman Alive\\\" by Esquire magazine in both 2006 and 2013 (the only woman to be chosen for the title twice), and the \\\"Sexiest Celebrity\\\" by Playboy magazine in 2007.\\n\\nJohansson was born in New York City. Her father, Karsten Johansson, is a Danish-born architect, and her paternal grandfather, Ejner Johansson, was a screenwriter and director. Her mother, Melanie Sloan, a producer, comes from an Ashkenazi Jewish family from the Bronx. Johansson has an older sister, Vanessa, who is an actress; an older brother, Adrian; a twin brother, Hunter (who appeared in the film Manny &amp; Lo with Scarlett); and a half-brother, Christian, from her father's re-marriage.\",\"birthday\":\"1984-11-22\",\"deathday\":\"\",\"gender\":1,\"homepage\":\"\",\"id\":1245,\"imdb_id\":\"nm0424060\",\"name\":\"Scarlett Johansson\",\"place_of_birth\":\"New York City, New York, USA\",\"popularity\":37.207817,\"profile_path\":\"/8EueDe6rPF0jQU4LSpsH2Rmrqac.jpg\",\"images\":{\"profiles\":[{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/8EueDe6rPF0jQU4LSpsH2Rmrqac.jpg\",\"height\":1920,\"iso_639_1\":null,\"vote_average\":5.50629447181171,\"vote_count\":24,\"width\":1280},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/yDYpYy09nfyXIWHC6mbsaRdLiDV.jpg\",\"height\":1800,\"iso_639_1\":null,\"vote_average\":5.40194572452637,\"vote_count\":30,\"width\":1200},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/f3c1rwcOoeU0v6Ak5loUvMyifR0.jpg\",\"height\":1800,\"iso_639_1\":null,\"vote_average\":5.38419913419913,\"vote_count\":25,\"width\":1200},{\"aspect_ratio\":0.665667166416792,\"file_path\":\"/v8qgUe7VUI1tjhvkMBSxbAQUsTC.jpg\",\"height\":667,\"iso_639_1\":null,\"vote_average\":5.34798534798535,\"vote_count\":2,\"width\":444},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/y05JNGUkd9oZLHZ6XRSYFnJYQus.jpg\",\"height\":741,\"iso_639_1\":null,\"vote_average\":5.31746031746032,\"vote_count\":3,\"width\":494},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/5zljIJOYpOEtWJVVdrnyDR0uiI.jpg\",\"height\":750,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":500},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/5AIP3FA0tXGXbWtm4T6pEkNVhhf.jpg\",\"height\":750,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":500},{\"aspect_ratio\":0.667142857142857,\"file_path\":\"/HRVCIV7uBz9aCxddikcuXgiZZd.jpg\",\"height\":700,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":467},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/eYFHUWxTCNg6lPypJCaUQXhoUop.jpg\",\"height\":2100,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":1400},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/g9xeQkuwAFxu78FyJDoM3Yx3t2T.jpg\",\"height\":750,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":500},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/iFw7g1L12c2vh5BVF0soIoYQn1l.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":5.3125,\"vote_count\":1,\"width\":1000},{\"aspect_ratio\":0.667741935483871,\"file_path\":\"/iXZv15GNVwq327Ot9TMh0ymK1kD.jpg\",\"height\":620,\"iso_639_1\":null,\"vote_average\":5.28860028860029,\"vote_count\":3,\"width\":414},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/uNxd4VL7OXtudqc50yWUWlMuAdh.jpg\",\"height\":3000,\"iso_639_1\":null,\"vote_average\":5.28083028083028,\"vote_count\":15,\"width\":2000},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/qKeafPkAMvulNMh1eJUkXXdnbDr.jpg\",\"height\":1200,\"iso_639_1\":null,\"vote_average\":5.24956970740103,\"vote_count\":20,\"width\":800},{\"aspect_ratio\":0.667272727272727,\"file_path\":\"/dOiiWyOblepQ4Bn6JhS3HTTz1Im.jpg\",\"height\":550,\"iso_639_1\":null,\"vote_average\":5.24542124542125,\"vote_count\":2,\"width\":367},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/5msUBzm2GhKCUFdPaBfVRpxYU2q.jpg\",\"height\":600,\"iso_639_1\":null,\"vote_average\":5.24542124542125,\"vote_count\":2,\"width\":400},{\"aspect_ratio\":0.665454545454545,\"file_path\":\"/oEyVZW8hNBtNy2OlmPtiwhWne1B.jpg\",\"height\":550,\"iso_639_1\":null,\"vote_average\":5.24542124542125,\"vote_count\":2,\"width\":366},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/cmvo9gzikPJ3LV6GxWQmZAg2Nct.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":5.17006802721088,\"vote_count\":14,\"width\":1000},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/tHMgW7Pg0Fg6HmB8Kh8Ixk6yxZw.jpg\",\"height\":1050,\"iso_639_1\":null,\"vote_average\":5.13562386980109,\"vote_count\":16,\"width\":700},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/kFaaI0glYiHXlLx6Eo3gU4ezEbv.jpg\",\"height\":1650,\"iso_639_1\":null,\"vote_average\":5.07730364873222,\"vote_count\":14,\"width\":1100},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/lrkMapc1t86otevADCAGEUg6qds.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":5.07389162561576,\"vote_count\":24,\"width\":1000},{\"aspect_ratio\":0.666277712952159,\"file_path\":\"/o3ZXD7Q8NqojwUOIYmhcmbGHqcv.jpg\",\"height\":857,\"iso_639_1\":null,\"vote_average\":5.04329004329004,\"vote_count\":3,\"width\":571},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/oj65IpxjOBOIFdTXTomE9isIpH.jpg\",\"height\":1563,\"iso_639_1\":null,\"vote_average\":5.04329004329004,\"vote_count\":3,\"width\":1042},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/dokrAxkB2hBldtBzvwW80T0TXGF.jpg\",\"height\":2790,\"iso_639_1\":null,\"vote_average\":5.04329004329004,\"vote_count\":3,\"width\":1860},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/3mGM8Vycmin9rSCeqbBeos4VsSS.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":5.04329004329004,\"vote_count\":3,\"width\":1000},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/1IsROboT8utZxUGrdNZWuX7KoNv.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":5.02222222222222,\"vote_count\":12,\"width\":1000},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/pYy7sWxYG3s9QnjLPNk5aFtdHjc.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":4.99389499389499,\"vote_count\":15,\"width\":1000},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/t4igqs3L3LD5cSxv1eOk1mYAlb3.jpg\",\"height\":450,\"iso_639_1\":null,\"vote_average\":4.97425997425997,\"vote_count\":11,\"width\":300},{\"aspect_ratio\":0.666666666666667,\"file_path\":\"/aPTNNvUDW6VJeE269RVInmNlhia.jpg\",\"height\":1500,\"iso_639_1\":null,\"vote_average\":4.968671679198,\"vote_count\":13,\"width\":1000},{\"aspect_ratio\":0.666842382709541,\"file_path\":\"/1tMHQrUfjvqrunCe2yyZEl8gVzg.jpg\",\"height\":1897,\"iso_639_1\":null,\"vote_average\":4.92997198879552,\"vote_count\":5,\"width\":1265}]}}";
        Gson gson = new GsonBuilder().create();
        TMDBPerson person = gson.fromJson(json, TMDBPerson.class);
    }

    @Test
    public void reviewsListWrapperTest(){
        String json = "{\"id\":244786,\"page\":1,\"results\":[{\"id\":\"54c82e03c3a36870ba000a3d\",\"author\":\"MJM\",\"content\":\"DISGUSTING NONSENSE...\\r\\n\\r\\n*** This review may contain spoilers ***\\r\\n\\r\\nI find it very sad that so many people - including so-called professional reviewers - have rated this crap so highly. I did not walk out (although I was greatly tempted to do so) but saw it to the end. A total waste of time.\\r\\n\\r\\nHere's what might spoil it for you, should you believe the BS that's being spread around this stinking pile of excrement: It could have actually been OK if it hadn't been so laughably impossibly ridiculous. Perhaps if it had been set in the fifties or the forties when people had much less developed consciousness of human rights? But even so... \\r\\n\\r\\nI suppose the moral/lesson we are supposed to learn is... if you can't warp your students enough by abuse to force them to become great musicians then it is perfectly alright to discard or destroy them in the attempt. \\r\\n\\r\\nThis glorified tyrant and bully can himself only produce music at a grade one level and so because he cannot 'do' he 'teaches?'\\r\\n\\r\\nHe does not teach, he does not inspire; he withholds approval, negatively reinforces and rules by fear, and is feared rather than respected. I would have a difficult time to point to a single (pedagogical) scene in the film that had any merit whatsoever or was worth watching for any reason. Maybe I should say that its evident popularity may be evidence that we are truly living in the end times... ha! \\r\\n\\r\\nSee the film if you want to be current, but please decide for yourself from watching it and don't believe the hype about its 'genius' or 'brilliance.' It is not either of those things; it's a poorly written, sad joke. \\r\\n\\r\\nI would expect that those people who rate it so highly A) want to seem cool because 'it's about jazz' B) have never actually been in a teacher/student situation and therefore, can only imagine how its done C) see all the other positive reviews and so must follow the herd D) don't really know their ass from their elbow or E) thought the the actor had truly grown because in Spiderman he only yell, but it THIS one, he throws chairs.... or F) all of the above.\\r\\n\\r\\nSave your money or see something uplifting instead rather than this horseshit.\",\"url\":\"https://www.themoviedb.org/review/54c82e03c3a36870ba000a3d\"},{\"id\":\"56ab260cc3a3681c54001f8a\",\"author\":\"Andres Gomez\",\"content\":\"Fantastic movie with a good cast with an impressive Miles Teller and a yet even more impressive J.K. Simmons. Decent script, great directing, selection of the repertoire and performances.\\r\\n\\r\\nJust sit down, get a good audio system and enjoy one of the best movies of the 2010s.\",\"url\":\"https://www.themoviedb.org/review/56ab260cc3a3681c54001f8a\"}],\"total_pages\":1,\"total_results\":2}";
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        MovieReviewsWrapper wrapper = gson.fromJson(json, MovieReviewsWrapper.class);

        String serialized = gson.toJson(wrapper, MovieReviewsWrapper.class);
        assertEquals(json,serialized);
    }

    @Test
    public void personListWrapperTest(){
        String json = "{\"page\":1,\"results\":[{\"profile_path\":null,\"adult\":false,\"id\":141521,\"known_for\":[{\"poster_path\":\"\\/pI6J5nrFKh4GEUZ1eGP4AEVQOAN.jpg\",\"adult\":false,\"overview\":\"Figlia di inglesi residenti in India, Mary viene ospitata, dopo la morte dei genitori, nel maniero di uno zio. Questi, vedovo, ha un figlio infermo che vive recluso nella propria stanza. Mary scopre un giardino segreto e, con l'aiuto di un contadinello, riesce a coinvolgere nelle sue scorribande in questo giardino il cuginetto, che così guarisce dalla sua malattia. Anche lo zio riacquista la serenità.\",\"release_date\":\"1993-08-13\",\"original_title\":\"The Secret Garden\",\"genre_ids\":[14,18,10751],\"id\":11236,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Il giardino segreto\",\"backdrop_path\":\"\\/zDXBA5yaxfPCnRT2y4if5w9rxLX.jpg\",\"popularity\":1.644229,\"vote_count\":78,\"video\":false,\"vote_average\":7.03},{\"poster_path\":\"\\/wD6rLdD2Ix3u9YLgE3Do8GyCHoz.jpg\",\"adult\":false,\"overview\":\"Nel 1970 quattro amiche passano la loro ultima estate di adolescenti. Si ritrovano 25 anni dopo. Episodi di vita provinciale rievocati sull'onda ambigua della nostalgia e nelle forme di un trito minimalismo al femminile, in parte riscattato dalla freschezza delle giovanissime interpreti.\",\"release_date\":\"1995-10-20\",\"original_title\":\"Now and Then\",\"genre_ids\":[35,18,10751],\"id\":9263,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Amiche per sempre\",\"backdrop_path\":\"\\/dthtFNHGLgo360zpRKhKOWgZrRe.jpg\",\"popularity\":1.391832,\"vote_count\":27,\"video\":false,\"vote_average\":5.89},{\"poster_path\":\"\\/u2E5FLOaGJYFWrtHBywqJem8fYY.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1969-01-01\",\"original_title\":\"Zeta One\",\"genre_ids\":[35,14,878],\"id\":118337,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Zeta One\",\"backdrop_path\":\"\\/tPYbYGv9yFpyLIiYtjQ1cGKi6rX.jpg\",\"popularity\":1.094422,\"vote_count\":4,\"video\":false,\"vote_average\":3.38}],\"name\":\"Walter Sparrow\",\"popularity\":3.1},{\"profile_path\":null,\"adult\":false,\"id\":1502641,\"known_for\":[{\"poster_path\":\"\\/b6Y9I8aEFxHOxgB8tAVHZamiQ1g.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1969-05-27\",\"original_title\":\"Le corps de Diane\",\"genre_ids\":[18],\"id\":357024,\"media_type\":\"movie\",\"original_language\":\"fr\",\"title\":\"Le corps de Diane\",\"backdrop_path\":null,\"popularity\":1.000218,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"James Sparrow\",\"popularity\":1.21},{\"profile_path\":\"\\/mfuklIvNtqIR4jovnDpjeQsb8z6.jpg\",\"adult\":false,\"id\":1134987,\"known_for\":[{\"poster_path\":\"\\/71fkYuMVMtdbREh9Mp3gTFmI8Bv.jpg\",\"adult\":false,\"overview\":\"Tratto dal fumetto di John Wagner e Carlos Ezquerra, e in particolare dalla storyline pubblicata su 2000 A.D., Dredd ci porta nelle strade selvagge di Mega City One, l'oasi solitaria di una quasi-civilizzata Cursed Earth.Il Giudice Dredd (Karl Urban) è il più temuto dell'elite Street Judges, con il potere di far rispettare la legge, condannando i colpevoli e uccidendoli sul posto se necessario. Olivia Thirlby interpreta il Giudice Anderson, mentre Lena Headey è Madeline Madrigal (ovvero Ma-Ma), leader di una gang che domina uno dei quartieri di Mega-City One.\",\"release_date\":\"2012-09-07\",\"original_title\":\"Dredd\",\"genre_ids\":[28,878],\"id\":49049,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Dredd\",\"backdrop_path\":\"\\/kqKcID44nGtIxhhzmziAX65abRx.jpg\",\"popularity\":3.088235,\"vote_count\":1185,\"video\":false,\"vote_average\":6.42},{\"poster_path\":\"\\/wGYhwhZAe9spFzlWSp9ikPMmYbY.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2013-01-26\",\"original_title\":\"Nothing About Nothing\",\"genre_ids\":[80,53],\"id\":191614,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Nothing About Nothing\",\"backdrop_path\":null,\"popularity\":1.001719,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Scott Sparrow\",\"popularity\":1.063},{\"profile_path\":null,\"adult\":false,\"id\":583115,\"known_for\":[{\"poster_path\":\"\\/5I95zOsQNfJD0nPxTJhfYU7Cgmp.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2011-10-25\",\"original_title\":\"3 Musketeers\",\"genre_ids\":[28,12,53],\"id\":77485,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"3 Musketeers\",\"backdrop_path\":\"\\/1sooQmWWxONsbsmiJ3f6z9DRgPS.jpg\",\"popularity\":1.071483,\"vote_count\":3,\"video\":false,\"vote_average\":5.17}],\"name\":\"Lauren Sparrow\",\"popularity\":1.0189},{\"profile_path\":null,\"adult\":false,\"id\":142467,\"known_for\":[{\"poster_path\":\"\\/cCcxut0dyLD4KMOeRRO2oysHSnP.jpg\",\"adult\":false,\"overview\":\"In luoghi sofisticati e senza tempo, Cynthia, benestante collezionista di insetti e la più giovane Evelyn sono amanti. Presentato in concorso al TFF32 (Torino Film Festival 2014), dove Sidse Babett Knudsen, nel ruolo di Cynthia, vince il premio come migliore attrice.\",\"release_date\":\"2015-01-23\",\"original_title\":\"The Duke of Burgundy\",\"genre_ids\":[18],\"id\":250225,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"The Duke of Burgundy\",\"backdrop_path\":\"\\/gClXgDxnC6Ipy9Vbw6nYmBX6BPP.jpg\",\"popularity\":1.595906,\"vote_count\":41,\"video\":false,\"vote_average\":5.37},{\"poster_path\":\"\\/vKUno7ycflDRNi65KgZXUbOfQQU.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2009-11-05\",\"original_title\":\"1\",\"genre_ids\":[10769,878,53],\"id\":49568,\"media_type\":\"movie\",\"original_language\":\"hu\",\"title\":\"1\",\"backdrop_path\":\"\\/3VHZtGn8zJmPv3jQ4zbc4KY0f3i.jpg\",\"popularity\":1.000861,\"vote_count\":3,\"video\":false,\"vote_average\":4.5}],\"name\":\"Pater Sparrow\",\"popularity\":1.001701},{\"profile_path\":\"\\/5GigfrHQubHX7OnHokECvSFVE9C.jpg\",\"adult\":false,\"id\":1538895,\"known_for\":[{\"poster_path\":\"\\/tlbS1mqX2x5lVSyuxfTwDPwnTmD.jpg\",\"popularity\":5.113943,\"id\":33907,\"overview\":\"\",\"backdrop_path\":\"\\/1d0LIjIl9LALWxKbc2Pcw7x9Yh9.jpg\",\"vote_average\":7.32,\"media_type\":\"tv\",\"first_air_date\":\"2010-09-26\",\"origin_country\":[\"GB\"],\"genre_ids\":[18],\"original_language\":\"en\",\"vote_count\":52,\"name\":\"Downton Abbey\",\"original_name\":\"Downton Abbey\"}],\"name\":\"Phoebe Sparrow\",\"popularity\":1.000006},{\"profile_path\":\"\\/wpv5m3TePP3ju8lrugwUquPDaON.jpg\",\"adult\":false,\"id\":36816,\"known_for\":[{\"poster_path\":\"\\/vRrOGQPkkDOa4LYy72ktRfsxw8f.jpg\",\"adult\":false,\"overview\":\"Una mattina come tante, l'ispettore Jack Mosley (Bruce Willis), viene incaricato di portare un piccolo criminale, Eddie Bunker, dal distretto di Polizia al Tribunale a sedici isolati di distanza, dove deve presentarsi per testimoniare in un caso di reato minore. Jack pensa che sia un incarico di routine, ma ben presto si troverà prima a dover salvare il testimone da un killer e poi scoprirà che la persona contro cui Eddie deve testimoniare è proprio un poliziotto.  L'ispettore della omicidi spiega la situazione a Jack cercando di convincerlo a far finta di essere stato preso in ostaggio da Eddie, ma Jack decide di difendere il testimone, innescando tutta una serie di eventi che cambieranno la sua vita e quella dei presenti...\",\"release_date\":\"2006-03-01\",\"original_title\":\"16 Blocks\",\"genre_ids\":[28,12,80,53],\"id\":2207,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Solo 2 ore\",\"backdrop_path\":\"\\/31SqCV9NfHvGJ8n7v60fV3oMobZ.jpg\",\"popularity\":2.610185,\"vote_count\":342,\"video\":false,\"vote_average\":6.07},{\"poster_path\":\"\\/cy5YTucxnl8bYJRcgB7rXfQ9GsJ.jpg\",\"adult\":false,\"overview\":\"New York, periodo natalizio. In un'indaffarata giornata di shopping invernale, Jonathan Trager incontra Sara Thomas quando entrambi cercano di comprare lo stesso paio di guanti. Lui vuole regalarli alla fidanzata, lei vuole tenerseli. I due trascorrono le ore successive passeggiando insieme per Manhattan, pattinando in una pista, e chiacchierando, sentendo una mutua attrazione. Alla fine della serata, Jonathan, le suggerisce di scambiarsi i numeri telefonici, ma Sara rifiuta, proponendo che sia il fato a guidare il loro futuro. Se loro sono destinati a stare insieme, gli dice, troveranno il modo di rientrare l'uno nella vita dell'altra. Entrambi scrivono il nome e numero su un oggetto: lui su una banconota da cinque dollari (che viene subito spesa), e lei su una copia de L'amore ai tempi del colera (che il giorno dopo andrà a rivendere). Se entrambi rientreanno in possesso di questi, vorrà dire che il destino li sta spingendo\",\"release_date\":\"2001-10-05\",\"original_title\":\"Serendipity\",\"genre_ids\":[35,10749],\"id\":9778,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Serendipity - Quando l'amore è magia\",\"backdrop_path\":\"\\/6CLVThDZFdxDpCL1w2NnuXaDMEk.jpg\",\"popularity\":2.117203,\"vote_count\":241,\"video\":false,\"vote_average\":6.5},{\"poster_path\":\"\\/ntKMVXdb1tVr4q3sT9vJOV9wnfN.jpg\",\"adult\":false,\"overview\":\"Nella vita è sempre necessario vivere in armonia, a ritmo di musica, e un uomo di mezza età, che trascorre le sue giornate fra casa e ufficio, con una moglie e due figli, ne è consapevole, e deve trovare una soluzione. John, un Richard Gere, piacevole e divertito, riscoprirà nel ballo e in un'affascinante insegnante, l'amore per le cose che ha.\\r Idealmente un'interessante analisi sulla vita routinaria nella società odierna, questa commedia americana, che ha la sua forza nei ruoli comprimari, fra cui spicca un'irresistibile Stanley Tucci, si lascia andare negli ultimi minuti, con una superficiale riflessione sulla crisi matrimoniale e uno zuccheroso lieto fine.\",\"release_date\":\"2004-10-15\",\"original_title\":\"Shall We Dance?\",\"genre_ids\":[18,10749,35],\"id\":4380,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Shall We Dance?\",\"backdrop_path\":\"\\/sBvFyOlfcD5B2126ewELx67Wwmi.jpg\",\"popularity\":1.961921,\"vote_count\":144,\"video\":false,\"vote_average\":5.7}],\"name\":\"David Sparrow\",\"popularity\":1.000004},{\"profile_path\":null,\"adult\":false,\"id\":1378906,\"known_for\":[{\"poster_path\":\"\\/rgVHpKRMmBOmJKBGxJhiwJ4DPvJ.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1988-01-01\",\"original_title\":\"Higher Education\",\"genre_ids\":[10749,35,18],\"id\":99789,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Higher Education\",\"backdrop_path\":\"\\/7BnZuIMciFlUh3Fu7fRmof9r1sY.jpg\",\"popularity\":1.000167,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Sharolyn Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1512671,\"known_for\":[{\"poster_path\":\"\\/ztBSsPAmy3eeI5Et6O8rWqa86kk.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2015-09-20\",\"original_title\":\"Clouds of Autumn\",\"genre_ids\":[18],\"id\":360781,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Clouds of Autumn\",\"backdrop_path\":null,\"popularity\":1.021897,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Quelemia Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1517636,\"known_for\":[{\"poster_path\":\"\\/cpKZnqwRYwoQxKUXmy6FonPIt0D.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2006-10-13\",\"original_title\":\"Kardia\",\"genre_ids\":[18],\"id\":57819,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Kardia\",\"backdrop_path\":\"\\/7zbMxYGQkugUwF1dYEavefO5b41.jpg\",\"popularity\":1.000801,\"vote_count\":1,\"video\":false,\"vote_average\":5},{\"poster_path\":\"\\/g5WEf78wBWDDqHpqRpZh4bLLPi.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2009-02-15\",\"original_title\":\"Booky's Crush\",\"genre_ids\":[18,10751],\"id\":144026,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Booky's Crush\",\"backdrop_path\":null,\"popularity\":1.000727,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Martha Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1533303,\"known_for\":[{\"poster_path\":\"\\/y94bn7BsElbCHF1aSzB6X4POUyN.jpg\",\"adult\":true,\"overview\":\"\",\"release_date\":\"2011-08-18\",\"original_title\":\"Eat-Me-Out\",\"genre_ids\":[],\"id\":367358,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Eat-Me-Out\",\"backdrop_path\":null,\"popularity\":1.001143,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Sally Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1607686,\"known_for\":[{\"poster_path\":\"\\/cLfTbf6ayKbeJe3b6CLamaaIUFO.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1975-06-06\",\"original_title\":\"Girls Come First\",\"genre_ids\":[35],\"id\":267222,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Girls Come First\",\"backdrop_path\":null,\"popularity\":1.000615,\"vote_count\":1,\"video\":false,\"vote_average\":4.5}],\"name\":\"Bobby Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1546774,\"known_for\":[{\"poster_path\":\"\\/hvKVaWfeKu6RvTqtM7tmKLHo7oF.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2014-01-01\",\"original_title\":\"I Remember You\",\"genre_ids\":[],\"id\":371806,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"I Remember You\",\"backdrop_path\":null,\"popularity\":1.002587,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"name\":\"Claudia Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":1259967,\"known_for\":[{\"poster_path\":null,\"popularity\":1,\"id\":51076,\"overview\":\"\",\"backdrop_path\":null,\"vote_average\":0,\"media_type\":\"tv\",\"first_air_date\":\"\",\"origin_country\":[],\"genre_ids\":[],\"original_language\":\"en\",\"vote_count\":0,\"name\":\"aurA\",\"original_name\":\"aurA\"}],\"name\":\"Pater Sparrow\",\"popularity\":1},{\"profile_path\":null,\"adult\":false,\"id\":230589,\"known_for\":[{\"poster_path\":\"\\/qZT15rkBfTz1kSgoesSInVm7TXH.jpg\",\"adult\":false,\"overview\":\"Joe Armstrong, il \\\"guerriero americano\\\", si reca in un'isola caraibica per una vacanza con l'amico Jackson: ma la vacanza durerà ben poco.\\r Infatti sull'isola salva un suo vecchio amico dall'aggressione di \\\"The Lion\\\", un pericoloso criminale che si scoprirà aver rapito uno scienziato locale: lo scopo di questo rapimento è la produzione di armi potentissime e la creazione di un esercito di guerrieri ninja mutanti.\\r Joe e Jackson dovranno lottare di nuovo insieme per sventare i piani criminali di \\\"The Lion\\\".\",\"release_date\":\"1987-05-01\",\"original_title\":\"American Ninja 2: The Confrontation\",\"genre_ids\":[28,12,18],\"id\":25678,\"media_type\":\"movie\",\"original_language\":\"fr\",\"title\":\"Guerriero Americano 2 - La sfida\",\"backdrop_path\":\"\\/cGVvEiAmZwa1aeyNRSNTN3GvrG8.jpg\",\"popularity\":1.623985,\"vote_count\":23,\"video\":false,\"vote_average\":4.74},{\"poster_path\":\"\\/fcMbjmldQFlpoWIzLGloII9HbMY.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1993-04-19\",\"original_title\":\"Lethal Ninja\",\"genre_ids\":[28,53],\"id\":60139,\"media_type\":\"movie\",\"original_language\":\"fr\",\"title\":\"Lethal Ninja\",\"backdrop_path\":\"\\/xEh52UuYfTeUM51PT2cqkRBlZ7.jpg\",\"popularity\":1.043887,\"vote_count\":4,\"video\":false,\"vote_average\":3.38},{\"poster_path\":\"\\/jXDgKg95YTQSPKyZtzBy4J1vzOv.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"1990-06-30\",\"original_title\":\"The Final Alliance\",\"genre_ids\":[28,18],\"id\":232687,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"The Final Alliance\",\"backdrop_path\":null,\"popularity\":1.000338,\"vote_count\":2,\"video\":false,\"vote_average\":2}],\"name\":\"Len Sparrowhawk\",\"popularity\":1.001148},{\"profile_path\":\"\\/1TIUuXGFW5wB4mbAb7XTKZLSIvD.jpg\",\"adult\":false,\"id\":1024948,\"known_for\":[{\"poster_path\":\"\\/c6mg38lxmSap4wMDiZSILCFI7ah.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2013-05-01\",\"original_title\":\"Sokrovishcha O.K.\",\"genre_ids\":[35,12,10749],\"id\":201893,\"media_type\":\"movie\",\"original_language\":\"en\",\"title\":\"Sokrovishcha O.K.\",\"backdrop_path\":\"\\/3V8p9oGP88Pe6TzcCelK20fdJaQ.jpg\",\"popularity\":1.073097,\"vote_count\":5,\"video\":false,\"vote_average\":3.5},{\"poster_path\":\"\\/I6Pot43x3MFczy85xjcrAQIqwz.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2012-03-01\",\"original_title\":\"Samoubiytsy\",\"genre_ids\":[35],\"id\":97672,\"media_type\":\"movie\",\"original_language\":\"ru\",\"title\":\"Samoubiytsy\",\"backdrop_path\":\"\\/gVQdbNZdCvMt7qrY6vAYd5MOObV.jpg\",\"popularity\":1.002143,\"vote_count\":2,\"video\":false,\"vote_average\":3.75},{\"poster_path\":\"\\/olUkqBjUziSP0ImW08QQsg6yEbR.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2011-12-31\",\"original_title\":\"Новогодняя СМСка\",\"genre_ids\":[10402,10751],\"id\":382641,\"media_type\":\"movie\",\"original_language\":\"ru\",\"title\":\"Новогодняя СМСка\",\"backdrop_path\":null,\"popularity\":1.001286,\"vote_count\":1,\"video\":false,\"vote_average\":4.5}],\"name\":\"Alexey Vorobyov\",\"popularity\":1.000155}],\"total_results\":16,\"total_pages\":1}";
        Gson gson = new Gson();
        PersonListWrapper wrapper = gson.fromJson(json, PersonListWrapper.class);
    }

    @Test
    public void movieListsWrapperTest(){
        String json = "{\"page\":1,\"results\":[{\"description\":\"Here's my list of best picture winners for the Oscars. Thought it would be neat to see them all together. There's a lot of movies here I have never even heard of.\",\"favorite_count\":50,\"id\":\"509ec17b19c2950a0600050d\",\"item_count\":87,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"Best Picture Winners - The Academy Awards\",\"poster_path\":\"/1ydP3HPsFB0aLVijHXt1obSLqlC.jpg\"},{\"description\":\"<br/>Awards\\r\\n<br/>Winners are listed first\\r\\n<br/>\\r\\n<br/>* 1. Best Picture\\r\\n<br/>Birdman – Alejandro G. Inarritu, John Lesher, James W. Skotchdopole\\r\\n<br/>American Sniper – Clint Eastwood, Robert Lorenz, Andrew Lazar, Bradley Cooper, Peter Morgan\\r\\n<br/>Boyhood – Richard Linklater, Cathleen Sutherland\\r\\n<br/>The Grand Budapest Hotel – Wes Anderson, Scott Rudin, Steven Rales, Jeremy Dawson\\r\\n<br/>The Imitation Game – Nora Grossman, Ido Ostrowsky, Teddy Schwarzman\\r\\n<br/>Selma – Christian Colson, Oprah Winfrey, Dede Gardner, Jeremy Kleiner\\r\\n<br/>The Theory of Everything – Tim Bevan, Eric Fellner, Lisa Bruce, Anthony McCarten\\r\\n<br/>Whiplash – Jason Blum, Helen Estabrook, David Lancaster\\r\\n<br/>\\r\\n<br/>* 2. Best Directing\\r\\n<br/>Alejandro G. Inarritu – Birdman\\r\\n<br/>Wes Anderson – The Grand Budapest Hotel\\r\\n<br/>Richard Linklater – Boyhood\\r\\n<br/>Bennett Miller – Foxcatcher\\r\\n<br/>Morten Tyldum – The Imitation Game\\r\\n<br/>\\r\\n<br/>* 3. Best Actor\\r\\n<br/>Eddie Redmayne – The Theory of Everything as Stephen Hawking\\r\\n<br/>Steve Carell – Foxcatcher as John Eleuthere du Pont\\r\\n<br/>Bradley Cooper – American Sniper as Chris Kyle\\r\\n<br/>Benedict Cumberbatch – The Imitation Game as Alan Turing\\r\\n<br/>Michael Keaton – Birdman as Riggan Thomson / Birdman\\r\\n<br/>\\r\\n<br/>* 4. Best Actress\\r\\n<br/>Julianne Moore – Still Alice as Dr. Alice Howland\\r\\n<br/>Marion Cotillard – Two Days, One Night as Sandra Bya\\r\\n<br/>Felicity Jones – The Theory of Everything as Jane Wilde Hawking\\r\\n<br/>Rosamund Pike – Gone Girl as Amy Elliott-Dunne\\r\\n<br/>Reese Witherspoon – Wild as Cheryl Strayed\\r\\n<br/>\\r\\n<br/>* 5. Best Supporting Actor\\r\\n<br/>J. K. Simmons – Whiplash as Terence Fletcher\\r\\n<br/>Robert Duvall – The Judge as Judge Joseph Palmer\\r\\n<br/>Ethan Hawke – Boyhood as Mason Evans, Sr.\\r\\n<br/>Edward Norton – Birdman as Mike Shiner\\r\\n<br/>Mark Ruffalo – Foxcatcher as Dave Schultz\\r\\n<br/>\\r\\n<br/>* 6. Best Supporting Actress\\r\\n<br/>Patricia Arquette – Boyhood as Olivia Evans\\r\\n<br/>Laura Dern – Wild as Barbara \\\"Bobbi\\\" Grey\\r\\n<br/>Keira Knightley – The Imitation Game as Joan Clarke\\r\\n<br/>Emma Stone – Birdman as Sam Thomson\\r\\n<br/>Meryl Streep – Into the Woods as The Witch\\r\\n<br/>\\r\\n<br/>* 7. Best Original Screenplay\\r\\n<br/>Birdman – Alejandro G. Inarritu, Nicolas Giacobone, Alexander Dinelaris, Jr. and Armando Bo\\r\\n<br/>Boyhood – Richard Linklater\\r\\n<br/>Foxcatcher – E. Max Frye and Dan Futterman\\r\\n<br/>The Grand Budapest Hotel – Wes Anderson and Hugo Guinness\\r\\n<br/>Nightcrawler – Dan Gilroy\\r\\n<br/>\\r\\n<br/>* 8. Best Adapted Screenplay\\r\\n<br/>The Imitation Game – Graham Moore from Alan Turing: The Enigma by Andrew Hodges\\r\\n<br/>American Sniper – Jason Hall from American Sniper by Chris Kyle, Scott McEwen and Jim DeFelice\\r\\n<br/>Inherent Vice – Paul Thomas Anderson from Inherent Vice by Thomas Pynchon\\r\\n<br/>The Theory of Everything – Anthony McCarten from Travelling to Infinity: My Life with Stephen by Jane Wilde Hawking\\r\\n<br/>Whiplash – Damien Chazelle from his short film of the same name\\r\\n<br/>\\r\\n<br/>* 9. Best Animated Feature Film\\r\\n<br/>Big Hero 6 – Don Hall, Chris Williams and Roy Conli\\r\\n<br/>The Boxtrolls – Anthony Stacchi, Graham Annable and Travis Knight\\r\\n<br/>How to Train Your Dragon 2 – Dean DeBlois and Bonnie Arnold\\r\\n<br/>Song of the Sea – Tomm Moore and Paul Young\\r\\n<br/>The Tale of the Princess Kaguya – Isao Takahata and Yoshiaki Nishimura\\r\\n<br/>\\r\\n<br/>* 10. Best Foreign Language Film\\r\\n<br/>Ida (Poland) in Polish  – Pawel Pawlikowski\\r\\n<br/>Leviathan (Russia) in Russian – Andrey Zvyagintsev\\r\\n<br/>Tangerines (Estonia) in Estonian and Russian – Zaza Urushadze\\r\\n<br/>Timbuktu (Mauritania) in French  – Abderrahmane Sissako\\r\\n<br/>Wild Tales (Argentina) in Spanish  – Damian Szifron\\r\\n<br/>\\r\\n<br/>* 11. Best Documentary – Feature\\r\\n<br/>Citizenfour – Laura Poitras, Mathilde Bonnefoy and Dirk Wilutzky\\r\\n<br/>Finding Vivian Maier – John Maloof and Charlie Siskel\\r\\n<br/>Last Days in Vietnam – Rory Kennedy and Keven McAlester\\r\\n<br/>The Salt of the Earth – Wim Wenders, Lelia Wanick Salgado and David Rosier\\r\\n<br/>Virunga – Orlando von Einsiedel and Joanna Natasegara\\r\\n<br/>\\r\\n<br/>* 12. Best Documentary – Short Subject\\r\\n<br/>Crisis Hotline: Veterans Press 1 – Ellen Goosenberg Kent and Dana Perry\\r\\n<br/>Joanna – Aneta Kopacz\\r\\n<br/>Our Curse – Tomasz Sliwinski and Maciej Slesicki\\r\\n<br/>The Reaper – Gabriel Serra Arguello\\r\\n<br/>White Earth – J. Christian Jensen\\r\\n<br/>\\r\\n<br/>* 13. Best Live Action Short Film\\r\\n<br/>The Phone Call – Mat Kirkby and James Lucas\\r\\n<br/>Aya – Oded Binnun and Mihal Brezis\\r\\n<br/>Boogaloo and Graham – Michael Lennox and Ronan Blaney\\r\\n<br/>Butter Lamp – Hu Wei and Julien Feret\\r\\n<br/>Parvaneh – Talkhon Hamzavi and Stefan Eichenberger\\r\\n<br/>\\r\\n<br/>* 14. Best Animated Short Film\\r\\n<br/>Feast – Patrick Osborne and Kristina Reed\\r\\n<br/>The Bigger Picture – Daisy Jacobs and Christopher Hees\\r\\n<br/>The Dam Keeper – Robert Kondo and Daisuke Tsutsumi\\r\\n<br/>Me and My Moulton – Torill Kove\\r\\n<br/>A Single Life – Joris Oprins\\r\\n<br/>\\r\\n<br/>* 15. Best Original Score\\r\\n<br/>The Grand Budapest Hotel – Alexandre Desplat\\r\\n<br/>The Imitation Game – Alexandre Desplat\\r\\n<br/>Interstellar – Hans Zimmer\\r\\n<br/>Mr. Turner – Gary Yershon\\r\\n<br/>The Theory of Everything – Johann Johannsson\\r\\n<br/>\\r\\n<br/>* 16. Best Original Song\\r\\n<br/>\\\"Glory\\\" from Selma – Music and Lyric by John Stephens (John Legend) and Lonnie Lynn (Common)\\r\\n<br/>\\\"Everything Is Awesome\\\" from The Lego Movie – Music and Lyric by Shawn Patterson\\r\\n<br/>\\\"Grateful\\\" from Beyond the Lights – Music and Lyric by Diane Warren\\r\\n<br/>\\\"I'm Not Gonna Miss You\\\" from Glen Campbell: I'll Be Me – Music and Lyric by Glen Campbell and Julian Raymond\\r\\n<br/>\\\"Lost Stars\\\" from Begin Again – Music and Lyric by Gregg Alexander and Danielle Brisebois\\r\\n<br/>\\r\\n<br/>* 17. Best Sound Editing\\r\\n<br/>American Sniper – Alan Robert Murray and Bub Asman\\r\\n<br/>Birdman – Martin Hernandez and Aaron Glascock\\r\\n<br/>The Hobbit: The Battle of the Five Armies – Brent Burge and Jason Canovas\\r\\n<br/>Interstellar – Richard King\\r\\n<br/>Unbroken – Becky Sullivan and Andrew DeCristofaro\\r\\n<br/>\\r\\n<br/>* 18. Best Sound Mixing\\r\\n<br/>Whiplash – Craig Mann, Ben Wilkins and Thomas Curley\\r\\n<br/>American Sniper – John Reitz, Gregg Rudloff and Walt Martin\\r\\n<br/>Birdman – Jon Taylor, Frank A. Montano and Thomas Varga\\r\\n<br/>Interstellar – Gary A. Rizzo, Gregg Landaker and Mark Weingarten\\r\\n<br/>Unbroken – Jon Taylor, Frank A. Montano and David Lee\\r\\n<br/>\\r\\n<br/>* 19. Best Production Design\\r\\n<br/>The Grand Budapest Hotel – Adam Stockhausen (Production Design); Anna Pinnock (Set Decoration)\\r\\n<br/>The Imitation Game – Maria Djurkovic (Production Design); Tatiana Macdonald (Set Decoration)\\r\\n<br/>Interstellar – Nathan Crowley (Production Design); Gary Fettis (Set Decoration)\\r\\n<br/>Into the Woods – Dennis Gassner (Production Design); Anna Pinnock (Set Decoration)\\r\\n<br/>Mr. Turner – Suzie Davies (Production Design); Charlotte Watts (Set Decoration)\\r\\n<br/>\\r\\n<br/>* 20. Best Cinematography\\r\\n<br/>Birdman – Emmanuel Lubezki\\r\\n<br/>The Grand Budapest Hotel – Robert Yeoman\\r\\n<br/>Ida – Lukasz Zal and Ryszard Lenczewski\\r\\n<br/>Mr. Turner – Dick Pope\\r\\n<br/>Unbroken – Roger Deakins\\r\\n<br/>\\r\\n<br/>* 21. Best Makeup And Hairstyling\\r\\n<br/>The Grand Budapest Hotel – Frances Hannon and Mark Coulier\\r\\n<br/>Foxcatcher – Bill Corso and Dennis Liddiard\\r\\n<br/>Guardians of the Galaxy – Elizabeth Yianni-Georgiou and David White\\r\\n<br/>\\r\\n<br/>* 22. Best Costume Design\\r\\n<br/>The Grand Budapest Hotel – Milena Canonero\\r\\n<br/>Inherent Vice – Mark Bridges\\r\\n<br/>Into the Woods – Colleen Atwood\\r\\n<br/>Maleficent – Anna B. Sheppard\\r\\n<br/>Mr. Turner – Jacqueline Durran\\r\\n<br/>\\r\\n<br/>* 23. Best Film Editing\\r\\n<br/>Whiplash – Tom Cross\\r\\n<br/>American Sniper – Joel Cox and Gary D. Roach\\r\\n<br/>Boyhood – Sandra Adair\\r\\n<br/>The Grand Budapest Hotel – Barney Pilling\\r\\n<br/>The Imitation Game – William Goldenberg\\r\\n<br/>\\r\\n<br/>* 24. Best Visual Effects\\r\\n<br/>Interstellar – Paul Franklin, Andrew Lockley, Ian Hunter and Scott Fisher\\r\\n<br/>Captain America: The Winter Soldier – Dan DeLeeuw, Russell Earl, Bryan Grill and Dan Sudick\\r\\n<br/>Dawn of the Planet of the Apes – Joe Letteri, Dan Lemmon, Daniel Barrett and Erik Winquist\\r\\n<br/>Guardians of the Galaxy – Stephane Ceretti, Nicolas Aithadi, Jonathan Fawkner and Paul Corbould\\r\\n<br/>X-Men: Days of Future Past – Richard Stammers, Lou Pecora, Tim Crosbie and Cameron Waldbauer\\r\\n<br/>\",\"favorite_count\":1,\"id\":\"54f87ac1c3a368126c0017c3\",\"item_count\":60,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"87th Academy Awards (Oscars 2015)\",\"poster_path\":\"/gtPN4ErdYyin1pPGLfezOHFfhe7.jpg\"},{\"description\":\"<br/>Awards \\r\\n<br/>Winners are listed first \\r\\n<br/>\\r\\n<br/>* 1. Best Picture\\r\\n<br/>12 Years a Slave – Brad Pitt, Dede Gardner, Jeremy Kleiner, Steve McQueen, and Anthony Katagas\\r\\n<br/>American Hustle – Charles Roven, Richard Suckle, Megan Ellison, and Jonathan Gordon\\r\\n<br/>Captain Phillips – Scott Rudin, Dana Brunetti, and Michael De Luca\\r\\n<br/>Dallas Buyers Club – Robbie Brenner and Rachel Winter\\r\\n<br/>Gravity – Alfonso Cuaron and David Heyman\\r\\n<br/>Her – Megan Ellison, Spike Jonze, and Vincent Landay\\r\\n<br/>Nebraska – Albert Berger and Ron Yerxa\\r\\n<br/>Philomena – Gabrielle Tana, Steve Coogan, and Tracey Seaward\\r\\n<br/>The Wolf of Wall Street – Martin Scorsese, Leonardo DiCaprio, Joey McFarland, and Emma Tillinger Koskoff\\r\\n<br/>\\r\\n<br/>* 2. Best Directing \\r\\n<br/>Alfonso Cuaron – Gravity\\r\\n<br/>David O. Russell – American Hustle\\r\\n<br/>Alexander Payne – Nebraska\\r\\n<br/>Steve McQueen – 12 Years a Slave\\r\\n<br/>Martin Scorsese – The Wolf of Wall Street\\r\\n<br/>\\r\\n<br/>* 3. Best Actor \\r\\n<br/>Matthew McConaughey – Dallas Buyers Club as Ron Woodroof\\r\\n<br/>Christian Bale – American Hustle as Irving Rosenfeld\\r\\n<br/>Bruce Dern – Nebraska as Woody Grant\\r\\n<br/>Leonardo DiCaprio – The Wolf of Wall Street as Jordan Belfort\\r\\n<br/>Chiwetel Ejiofor – 12 Years a Slave as Solomon Northup\\r\\n<br/>\\r\\n<br/>* 4. Best Actress \\r\\n<br/>Cate Blanchett – Blue Jasmine as Jeanette \\\"Jasmine\\\" Francis\\r\\n<br/>Amy Adams – American Hustle as Sydney Prosser\\r\\n<br/>Sandra Bullock – Gravity as Dr. Ryan Stone\\r\\n<br/>Judi Dench – Philomena as Philomena Lee\\r\\n<br/>Meryl Streep – August: Osage County as Violet Weston\\r\\n<br/>\\r\\n<br/>* 5. Best Supporting Actor \\r\\n<br/>Jared Leto – Dallas Buyers Club as Rayon\\r\\n<br/>Barkhad Abdi – Captain Phillips as Abduwali Muse\\r\\n<br/>Bradley Cooper – American Hustle as Agent Richard \\\"Richie\\\" DiMaso\\r\\n<br/>Michael Fassbender – 12 Years a Slave as Edwin Epps\\r\\n<br/>Jonah Hill – The Wolf of Wall Street as Donnie Azoff\\r\\n<br/>\\r\\n<br/>* 6. Best Supporting Actress \\r\\n<br/>Lupita Nyong'o – 12 Years a Slave as Patsey\\r\\n<br/>Sally Hawkins – Blue Jasmine as Ginger\\r\\n<br/>Jennifer Lawrence – American Hustle as Rosalyn Rosenfeld\\r\\n<br/>Julia Roberts – August: Osage County as Barbara Weston-Fordham\\r\\n<br/>June Squibb – Nebraska as Kate Grant\\r\\n<br/>\\r\\n<br/>* 7. Best Original Screenplay \\r\\n<br/>Her – Spike Jonze\\r\\n<br/>American Hustle – Eric Warren Singer and David O. Russell\\r\\n<br/>Blue Jasmine – Woody Allen\\r\\n<br/>Dallas Buyers Club – Craig Borten and Melisa Wallack\\r\\n<br/>Nebraska – Bob Nelson \\r\\n<br/>\\r\\n<br/>* 8. Best Adapted Screenplay \\r\\n<br/>12 Years a Slave – John Ridley from Twelve Years a Slave by Solomon Northup\\r\\n<br/>Before Midnight – Richard Linklater, Julie Delpy, and Ethan Hawke; characters based on the films Before Sunrise and Before Sunset\\r\\n<br/>Captain Phillips – Billy Ray from A Captain's Duty by Richard Phillips and Stephan Talty\\r\\n<br/>Philomena – Steve Coogan and Jeff Pope from The Lost Child of Philomena Lee by Martin Sixsmith\\r\\n<br/>The Wolf of Wall Street – Terence Winter from The Wolf of Wall Street by Jordan Belfort\\r\\n<br/>\\r\\n<br/>* 9. Best Animated Feature Film \\r\\n<br/>Frozen – Chris Buck, Jennifer Lee, and Peter Del Vecho\\r\\n<br/>The Croods – Kirk DeMicco, Chris Sanders, and Kristine Belson\\r\\n<br/>Despicable Me 2 – Chris Renaud, Pierre Coffin and Chris Meledandri\\r\\n<br/>Ernest & Celestine – Benjamin Renner and Didier Brunner\\r\\n<br/>The Wind Rises – Hayao Miyazaki and Toshio Suzuki\\r\\n<br/>\\r\\n<br/>* 10. Best Foreign Language Film \\r\\n<br/>The Great Beauty (Italy) in Italian – Paolo Sorrentino\\r\\n<br/>The Broken Circle Breakdown (Belgium) in Dutch – Felix Van Groeningen\\r\\n<br/>The Hunt (Denmark) in Danish – Thomas Vinterberg\\r\\n<br/>The Missing Picture (Cambodia) in French – Rithy Panh\\r\\n<br/>Omar (Palestine) in Arabic – Hany Abu-Assad\\r\\n<br/>\\r\\n<br/>* 11. Best Documentary – Feature \\r\\n<br/>20 Feet from Stardom – Morgan Neville, Gil Friesen (posthumous award), and Caitrin Rogers\\r\\n<br/>The Act of Killing – Joshua Oppenheimer and Signe Byrge Sorensen\\r\\n<br/>Cutie and the Boxer – Zachary Heinzerling and Lydia Dean Pilcher\\r\\n<br/>Dirty Wars – Richard Rowley and Jeremy Scahill\\r\\n<br/>The Square – Jehane Noujaim and Karim Amer\\r\\n<br/>\\r\\n<br/>* 12. Best Documentary – Short Subject \\r\\n<br/>The Lady in Number 6 – Malcolm Clarke and Nicholas Reed\\r\\n<br/>CaveDigger – Jeffrey Karoff\\r\\n<br/>Facing Fear – Jason Cohen\\r\\n<br/>Karama Has No Walls – Sara Ishaq\\r\\n<br/>Prison Terminal: The Last Days of Private Jack Hall – Edgar Barens\\r\\n<br/>\\r\\n<br/>* 13. Best Live Action Short Film \\r\\n<br/>Helium – Anders Walter and Kim Magnusson\\r\\n<br/>That Wasn't Me – Esteban Crespo\\r\\n<br/>Just Before Losing Everything – Xavier Legrand and Alexandre Gavras\\r\\n<br/>Do I Have to Take Care of Everything? – Selma Vilhunen and Kirsikka Saari\\r\\n<br/>The Voorman Problem – Mark Gill and Baldwin Li\\r\\n<br/>\\r\\n<br/>* 14. Best Animated Short Film \\r\\n<br/>Mr Hublot – Laurent Witz and Alexandre Espigares\\r\\n<br/>Feral – Daniel Sousa and Dan Golden\\r\\n<br/>Get a Horse! – Lauren MacMullan and Dorothy McKim\\r\\n<br/>Possessions – Shuhei Morita\\r\\n<br/>Room on the Broom – Max Lang and Jan Lachauer\\r\\n<br/>\\r\\n<br/>* 15. Best Original Score \\r\\n<br/>Gravity – Steven Price\\r\\n<br/>The Book Thief – John Williams\\r\\n<br/>Her – William Butler and Owen Pallett\\r\\n<br/>Philomena – Alexandre Desplat\\r\\n<br/>Saving Mr. Banks – Thomas Newman\\r\\n<br/>\\r\\n<br/>* 16. Best Original Song \\r\\n<br/>\\\"Let It Go\\\" from Frozen – Kristen Anderson-Lopez and Robert Lopez\\r\\n<br/>\\\"Happy\\\" from Despicable Me 2 – Pharrell Williams\\r\\n<br/>\\\"The Moon Song\\\" from Her – Karen Orzolek and Spike Jonze\\r\\n<br/>\\\"Ordinary Love\\\" from Mandela: Long Walk to Freedom – U2\\r\\n<br/>\\r\\n<br/>* 17. Best Sound Editing \\r\\n<br/>Gravity – Glenn Freemantle\\r\\n<br/>All Is Lost – Steve Boeddeker and Richard Hymns\\r\\n<br/>Captain Phillips – Oliver Tarney\\r\\n<br/>The Hobbit: The Desolation of Smaug – Brent Burge and Chris Ward\\r\\n<br/>Lone Survivor – Wylie Stateman\\r\\n<br/>\\r\\n<br/>* 18. Best Sound Mixing \\r\\n<br/>Gravity – Skip Lievsay, Niv Adiri, Christopher Benstead, and Chris Munro\\r\\n<br/>Captain Phillips – Chris Burdon, Mark Taylor, Mike Prestwood Smith, and Chris Munro\\r\\n<br/>The Hobbit: The Desolation of Smaug – Christopher Boyes, Michael Hedges, Michael Semanick, and Tony Johnson\\r\\n<br/>Inside Llewyn Davis – Skip Lievsay, Greg Orloff, and Peter F. Kurland\\r\\n<br/>Lone Survivor – Andy Koyama, Beau Borders, and David Brownlow\\r\\n<br/>\\r\\n<br/>* 19. Best Production Design \\r\\n<br/>The Great Gatsby – Catherine Martin (Production Design); Beverley Dunn (Set Decoration)\\r\\n<br/>American Hustle – Judy Becker (Production Design); Heather Loeffler (Set Decoration)\\r\\n<br/>Gravity – Andy Nicholson (Production Design); Rosie Goodwin and Joanne Woollard (Set Decoration)\\r\\n<br/>Her – K. K. Barrett (Production Design); Gene Serdena (Set Decoration)\\r\\n<br/>12 Years a Slave – Adam Stockhausen (Production Design); Alice Baker (Set Decoration)\\r\\n<br/>\\r\\n<br/>* 20. Best Cinematography \\r\\n<br/>Gravity – Emmanuel Lubezki\\r\\n<br/>The Grandmaster – Philippe Le Sourd\\r\\n<br/>Inside Llewyn Davis – Bruno Delbonnel\\r\\n<br/>Nebraska – Phedon Papamichael\\r\\n<br/>Prisoners – Roger Deakins\\r\\n<br/>\\r\\n<br/>* 21. Best Makeup And Hairstyling \\r\\n<br/>Dallas Buyers Club – Adruitha Lee and Robin Mathews\\r\\n<br/>Jackass Presents: Bad Grandpa – Stephen Prouty\\r\\n<br/>The Lone Ranger – Joel Harlow and Gloria Pasqua-Casny\\r\\n<br/>\\r\\n<br/>* 22. Best Costume Design \\r\\n<br/>The Great Gatsby – Catherine Martin\\r\\n<br/>American Hustle – Michael Wilkinson\\r\\n<br/>The Grandmaster – William Chang Suk Ping\\r\\n<br/>The Invisible Woman – Michael O'Connor\\r\\n<br/>12 Years a Slave – Patricia Norris\\r\\n<br/>\\r\\n<br/>* 23. Best Film Editing \\r\\n<br/>Gravity – Alfonso Cuaron and Mark Sanger\\r\\n<br/>American Hustle – Jay Cassidy, Crispin Struthers, and Alan Baumgarten\\r\\n<br/>Captain Phillips – Christopher Rouse\\r\\n<br/>Dallas Buyers Club – John Mac McMurphy and Martin Pensa[b]\\r\\n<br/>12 Years a Slave – Joe Walker\\r\\n<br/>\\r\\n<br/>* 24. Best Visual Effects \\r\\n<br/>Gravity – Tim Webber, Chris Lawrence, Dave Shirk, and Neil Corbould\\r\\n<br/>The Hobbit: The Desolation of Smaug – Joe Letteri, Eric Saindon, David Clayton, and Eric Reynolds\\r\\n<br/>Iron Man 3 – Christopher Townsend, Guy Williams, Erik Nash, and Dan Sudick\\r\\n<br/>The Lone Ranger – Tim Alexander, Gary Brozenich, Edson Williams, and John Frazier\\r\\n<br/>Star Trek Into Darkness – Roger Guyett, Patrick Tubach, Ben Grossmann, and Burt Dalton\\r\\n<br/>\",\"favorite_count\":1,\"id\":\"54fd9d14c3a36848080052dd\",\"item_count\":57,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"86th Academy Awards (Oscars 2014)\",\"poster_path\":\"/4yGn5tOsAFBq5Eqk8g1kMHX3dwt.jpg\"},{\"description\":\"<br/>Awards \\r\\n<br/>Winners are listed first \\r\\n<br/>\\r\\n<br/>* 1. Outstanding Picture (Best Picture)\\r\\n<br/>Wings - Lucien Hubbard\\r\\n<br/>The Racket - Howard Hughes\\r\\n<br/>Seventh Heaven - William Fox\\r\\n<br/>\\r\\n<br/>* 2. Unique and Artistic Production\\r\\n<br/>Sunrise: A Song of Two Humans - William Fox\\r\\n<br/>Chang: A Drama of the Wilderness - Merian C. Cooper and Ernest B. Schoedsack\\r\\n<br/>The Crowd - Irving Thalberg\\r\\n<br/>\\r\\n<br/>* 3. Best Director, Comedy Picture (Best Directing)\\r\\n<br/>Lewis Milestone – Two Arabian Knights\\r\\n<br/>Ted Wilde – Speedy\\r\\n<br/>\\r\\n<br/>* 4. Best Director, Dramatic Picture (Best Directing)\\r\\n<br/>Frank Borzage – Seventh Heaven\\r\\n<br/>Herbert Brenon – Sorrell and Son\\r\\n<br/>King Vidor – The Crowd\\r\\n<br/>\\r\\n<br/>* 5. Best Actor in a Leading Role (Best Actor)\\r\\n<br/>Emil Jannings – The Last Command and The Way of All Flesh\\r\\n<br/>Richard Barthelmess – The Noose and The Patent Leather Kid\\r\\n<br/>\\r\\n<br/>* 6. Best Actress in a Leading Role (Best Actress)\\r\\n<br/>Janet Gaynor – Seventh Heaven, Street Angel and Sunrise: A Song of Two Humans\\r\\n<br/>Louise Dresser – A Ship Comes In\\r\\n<br/>Gloria Swanson – Sadie Thompson\\r\\n<br/>\\r\\n<br/>* 7. Best Writing, Original Story (Best Story)\\r\\n<br/>Underworld – Ben Hecht\\r\\n<br/>The Last Command – Lajos Biro\\r\\n<br/>\\r\\n<br/>* 8. Best Writing, Adapted Story (Best Adapted Screenplay)\\r\\n<br/>Seventh Heaven – Benjamin Glazer\\r\\n<br/>Glorious Betsy – Anthony Coldeway\\r\\n<br/>The Jazz Singer – Alfred A. Cohn\\r\\n<br/>\\r\\n<br/>* 9. Best Cinematography \\r\\n<br/>Sunrise: A Song of Two Humans – Charles Rosher and Karl Struss\\r\\n<br/>The Devil Dancer – George Barnes\\r\\n<br/>The Magic Flame – George Barnes\\r\\n<br/>Sadie Thompson – George Barnes\\r\\n<br/>\\r\\n<br/>* 10. Best Art Direction (Best Production Design)\\r\\n<br/>The Dove and Tempest – William Cameron Menzies\\r\\n<br/>Seventh Heaven – Harry Oliver\\r\\n<br/>Sunrise: A Song of Two Humans – Rochus Gliese\\r\\n<br/>\\r\\n<br/>* 11. Best Engineering Effects \\r\\n<br/>Wings – Roy Pomeroy\\r\\n<br/>(No specific film) – Ralph Hammeras\\r\\n<br/>(No specific film) – Nugent Slaughter\\r\\n<br/>\\r\\n<br/>* 12. Best Writing, Title Writing \\r\\n<br/>(No specific film) – Joseph Farnham\\r\\n<br/>(No specific film) – George Marion, Jr.\\r\\n<br/>The Private Life of Helen of Troy – Gerald Duffy\\r\\n<br/>\",\"favorite_count\":1,\"id\":\"55085ac092514110da001818\",\"item_count\":24,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"1st Academy Awards (Oscars 1929)\",\"poster_path\":\"/A9rXdnnpp1LAwkb8Z686XmwLNxf.jpg\"},{\"description\":\"<br/>Awards \\r\\n<br/>Winners are listed first \\r\\n<br/>\\r\\n<br/>* 1. Best Picture\\r\\n<br/>Argo – Grant Heslov, Ben Affleck, and George Clooney\\r\\n<br/>Amour – Margaret Menegoz, Stefan Arndt, Veit Heiduschka, and Michael Katz\\r\\n<br/>Beasts of the Southern Wild – Dan Janvey, Josh Penn, and Michael Gottwald\\r\\n<br/>Django Unchained – Stacey Sher, Reginald Hudlin, and Pilar Savone\\r\\n<br/>Les Miserables – Tim Bevan, Eric Fellner, Debra Hayward, and Cameron Mackintosh\\r\\n<br/>Life of Pi – Gil Netter, Ang Lee, and David Womark\\r\\n<br/>Lincoln – Steven Spielberg and Kathleen Kennedy\\r\\n<br/>Silver Linings Playbook – Donna Gigliotti, Bruce Cohen, and Jonathan Gordon\\r\\n<br/>Zero Dark Thirty – Mark Boal, Kathryn Bigelow, and Megan Ellison\\r\\n<br/>\\r\\n<br/>* 2. Best Directing \\r\\n<br/>Ang Lee – Life of Pi\\r\\n<br/>Michael Haneke – Amour\\r\\n<br/>David O. Russell – Silver Linings Playbook\\r\\n<br/>Steven Spielberg – Lincoln\\r\\n<br/>Benh Zeitlin – Beasts of the Southern Wild\\r\\n<br/>\\r\\n<br/>* 3. Best Actor \\r\\n<br/>Daniel Day-Lewis – Lincoln as Abraham Lincoln\\r\\n<br/>Bradley Cooper – Silver Linings Playbook as Patrick \\\"Pat Jr.\\\" Solitano\\r\\n<br/>Hugh Jackman – Les Miserables as Jean Valjean\\r\\n<br/>Joaquin Phoenix – The Master as Freddie Quell\\r\\n<br/>Denzel Washington – Flight as William \\\"Whip\\\" Whitaker\\r\\n<br/>\\r\\n<br/>* 4. Best Actress \\r\\n<br/>Jennifer Lawrence – Silver Linings Playbook as Tiffany Maxwell\\r\\n<br/>Jessica Chastain – Zero Dark Thirty as Maya\\r\\n<br/>Emmanuelle Riva – Amour as Anne Laurent\\r\\n<br/>Quvenzhane Wallis – Beasts of the Southern Wild as Hushpuppy\\r\\n<br/>Naomi Watts – The Impossible as Maria Bennett\\r\\n<br/>\\r\\n<br/>* 5. Best Supporting Actor \\r\\n<br/>Christoph Waltz – Django Unchained as Dr. King Schultz\\r\\n<br/>Alan Arkin – Argo as Lester Siegel\\r\\n<br/>Robert De Niro – Silver Linings Playbook as Patrizio \\\"Pat Sr,\\\" Solitano\\r\\n<br/>Philip Seymour Hoffman – The Master as Lancaster Dodd\\r\\n<br/>Tommy Lee Jones – Lincoln as Thaddeus Stevens\\r\\n<br/>\\r\\n<br/>* 6. Best Supporting Actress \\r\\n<br/>Anne Hathaway – Les Miserables as Fantine\\r\\n<br/>Amy Adams – The Master as Peggy Dodd\\r\\n<br/>Sally Field – Lincoln as Mary Todd Lincoln\\r\\n<br/>Helen Hunt – The Sessions as Cheryl Cohen-Greene\\r\\n<br/>Jacki Weaver – Silver Linings Playbook as Dolores Solitano\\r\\n<br/>\\r\\n<br/>* 7. Best Original Screenplay \\r\\n<br/>Django Unchained – Quentin Tarantino\\r\\n<br/>Amour – Michael Haneke\\r\\n<br/>Flight – John Gatins\\r\\n<br/>Moonrise Kingdom – Wes Anderson and Roman Coppola\\r\\n<br/>Zero Dark Thirty – Mark Boal\\r\\n<br/>\\r\\n<br/>* 8. Best Adapted Screenplay \\r\\n<br/>Argo – Chris Terrio from The Master of Disguise by Antonio J. Mendez & The Great Escape by Joshuah Bearman\\r\\n<br/>Beasts of the Southern Wild – Lucy Alibar and Benh Zeitlin from Juicy and Delicious by Lucy Alibar\\r\\n<br/>Life of Pi – David Magee from Life of Pi by Yann Martel\\r\\n<br/>Lincoln – Tony Kushner from Team of Rivals: The Political Genius of Abraham Lincoln by Doris Kearns Goodwin\\r\\n<br/>Silver Linings Playbook – David O. Russell from The Silver Linings Playbook by Matthew Quick\\r\\n<br/>\\r\\n<br/>* 9. Best Animated Feature Film \\r\\n<br/>Brave – Mark Andrews and Brenda Chapman\\r\\n<br/>Frankenweenie – Tim Burton\\r\\n<br/>ParaNorman – Sam Fell and Chris Butler\\r\\n<br/>The Pirates! Band of Misfits – Peter Lord\\r\\n<br/>Wreck-It Ralph – Rich Moore\\r\\n<br/>\\r\\n<br/>* 10. Best Foreign Language Film \\r\\n<br/>Amour (Austria) in French – Michael Haneke\\r\\n<br/>Kon-Tiki (Norway) in English and Norwegian – Joachim Ronning and Espen Sandberg\\r\\n<br/>No (Chile) in Spanish – Pablo Larrain\\r\\n<br/>A Royal Affair (Denmark) in Danish – Nikolaj Arcel\\r\\n<br/>War Witch (Canada) in French – Kim Nguyen\\r\\n<br/>\\r\\n<br/>* 11. Best Documentary – Feature \\r\\n<br/>Searching for Sugar Man – Malik Bendjelloul and Simon Chinn\\r\\n<br/>5 Broken Cameras – Emad Burnat and Guy Davidi\\r\\n<br/>The Gatekeepers – Dror Moreh, Philippa Kowarsky, and Estelle Fialon\\r\\n<br/>How to Survive a Plague – David France and Howard Gertler\\r\\n<br/>The Invisible War – Kirby Dick and Amy Ziering\\r\\n<br/>\\r\\n<br/>* 12. Best Documentary – Short Subject \\r\\n<br/>Inocente – Sean Fine and Andrea Nix Fine\\r\\n<br/>Kings Point – Sari Gilman and Jedd Wider\\r\\n<br/>Mondays at Racine – Cynthia Wade and Robin Honan\\r\\n<br/>Open Heart – Kief Davidson and Cori Shepherd Stern\\r\\n<br/>Redemption – Jon Alpert and Matthew O'Neill\\r\\n<br/>\\r\\n<br/>* 13. Best Live Action Short Film \\r\\n<br/>Curfew – Shawn Christensen\\r\\n<br/>Asad – Bryan Buckley and Mino Jarjoura\\r\\n<br/>Buzkashi Boys – Sam French and Ariel Nasr\\r\\n<br/>Death of a Shadow (Dood Van Een Schaduw) – Tom Van Avermaet and Ellen De Waele\\r\\n<br/>Henry – Yan England\\r\\n<br/>\\r\\n<br/>* 14. Best Animated Short Film \\r\\n<br/>Paperman – John Kahrs\\r\\n<br/>Adam and Dog – Minkyu Lee\\r\\n<br/>Fresh Guacamole – PES\\r\\n<br/>Head over Heels – Timothy Reckart and Fodhla Cronin O'Reilly\\r\\n<br/>The Longest Daycare – David Silverman\\r\\n<br/>\\r\\n<br/>* 15. Best Original Score \\r\\n<br/>Life of Pi – Mychael Danna\\r\\n<br/>Anna Karenina – Dario Marianelli\\r\\n<br/>Argo – Alexandre Desplat\\r\\n<br/>Lincoln – John Williams\\r\\n<br/>Skyfall – Thomas Newman\\r\\n<br/>\\r\\n<br/>* 16. Best Original Song \\r\\n<br/>\\\"Skyfall\\\" from Skyfall – Adele Adkins and Paul Epworth\\r\\n<br/>\\\"Before My Time\\\" from Chasing Ice – J. Ralph\\r\\n<br/>\\\"Everybody Needs a Best Friend\\\" from Ted – Walter Murphy and Seth MacFarlane\\r\\n<br/>\\\"Pi's Lullaby\\\" from Life of Pi – Mychael Danna and Bombay Jayashri\\r\\n<br/>\\\"Suddenly\\\" from Les Miserables – Claude-Michel Schonberg, Herbert Kretzmer, and Alain Boublil\\r\\n<br/>\\r\\n<br/>* 17. Best Sound Editing \\r\\n<br/>Skyfall – Per Hallberg and Karen Baker Landers\\r\\n<br/>Zero Dark Thirty – Paul N. J. Ottosson\\r\\n<br/>Argo – Erik Aadahl and Ethan Van der Ryn\\r\\n<br/>Django Unchained – Wylie Stateman\\r\\n<br/>Life of Pi – Eugene Gearty and Philip Stockton\\r\\n<br/>\\r\\n<br/>* 18. Best Sound Mixing \\r\\n<br/>Les Miserables – Andy Nelson, Mark Paterson, and Simon Hayes\\r\\n<br/>Argo – John Reitz, Gregg Rudloff, and Jose Antonio Garcia\\r\\n<br/>Life of Pi – Ron Bartlett, D. M. Hemphill, and Drew Kunin\\r\\n<br/>Lincoln – Andy Nelson, Gary Rydstrom, and Ronald Judkins\\r\\n<br/>Skyfall – Scott Millan, Greg P. Russell, and Stuart Wilson\\r\\n<br/>\\r\\n<br/>* 19. Best Production Design \\r\\n<br/>Lincoln – Rick Carter and Jim Erickson\\r\\n<br/>Anna Karenina – Sarah Greenwood and Katie Spencer\\r\\n<br/>The Hobbit: An Unexpected Journey – Dan Hennah, Ra Vincent, and Simon Bright\\r\\n<br/>Les Miserables – Eve Stewart and Anna Lynch-Robinson\\r\\n<br/>Life of Pi – David Gropman and Anna Pinnock\\r\\n<br/>\\r\\n<br/>* 20. Best Cinematography \\r\\n<br/>Life of Pi – Claudio Miranda\\r\\n<br/>Anna Karenina – Seamus McGarvey\\r\\n<br/>Django Unchained – Robert Richardson\\r\\n<br/>Lincoln – Janusz Kaminski\\r\\n<br/>Skyfall – Roger Deakins\\r\\n<br/>\\r\\n<br/>* 21. Best Makeup And Hairstyling \\r\\n<br/>Les Miserables – Lisa Westcott and Julie Dartnell\\r\\n<br/>Hitchcock – Howard Berger, Peter Montagna, and Martin Samuel\\r\\n<br/>The Hobbit: An Unexpected Journey – Peter Swords King, Rick Findlater, and Tami Lane\\r\\n<br/>\\r\\n<br/>* 22. Best Costume Design \\r\\n<br/>Anna Karenina – Jacqueline Durran\\r\\n<br/>Les Miserables – Paco Delgado\\r\\n<br/>Lincoln – Joanna Johnston\\r\\n<br/>Mirror Mirror – Eiko Ishioka\\r\\n<br/>Snow White and the Huntsman – Colleen Atwood\\r\\n<br/>\\r\\n<br/>* 23. Best Film Editing \\r\\n<br/>Argo – William Goldenberg\\r\\n<br/>Life of Pi – Tim Squyres\\r\\n<br/>Lincoln – Michael Kahn\\r\\n<br/>Silver Linings Playbook – Jay Cassidy and Crispin Struthers\\r\\n<br/>Zero Dark Thirty – Dylan Tichenor and William Goldenberg\\r\\n<br/>\\r\\n<br/>* 24. Best Visual Effects \\r\\n<br/>Life of Pi – Bill Westenhofer, Guillaume Rocheron, Erik-Jan de Boer, and Donald R. Elliott\\r\\n<br/>The Hobbit: An Unexpected Journey – Joe Letteri, Eric Saindon, David Clayton, and R. Christopher White\\r\\n<br/>Marvel's The Avengers – Janek Sirrs, Jeff White, Guy Williams, and Dan Sudick\\r\\n<br/>Prometheus – Richard Stammers, Trevor Wood, Charley Henley, and Martin Hill\\r\\n<br/>Snow White and the Huntsman – Cedric Nicolas-Troyan, Philip Brennan, Neil Corbould, and Michael Dawson\\r\\n<br/>\",\"favorite_count\":1,\"id\":\"550d9488c3a36848740066be\",\"item_count\":52,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"85th Academy Awards (Oscars 2013)\",\"poster_path\":\"/m62yQgbaaEVa95VIo4yry6FF4Vk.jpg\"},{\"description\":\"The Academy Awards or The Oscars is an annual American awards ceremony honouring cinematic achievements in the film industry. The various category winners are awarded a copy of a statuette, officially the Academy Award of Merit, which is better known as \\\"Oscar\\\". The first award for excellence in cinematic achievements was presented in 1929 and continues to honour every year as it goes by. Here are the collection of winning memento for the category for \\\"Best Motion Picture of the Year\\\".....\",\"favorite_count\":1,\"id\":\"55441de9c3a3680cd7002fee\",\"item_count\":87,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"The Annual Academy Awards (Oscars)\",\"poster_path\":\"/dCyUwcbYvj2wfMWzmz3YkQtuLwi.jpg\"},{\"description\":\"<br/>Awards \\r\\n<br/>\\r\\n<br/>* 1. Best Picture\\r\\n<br/>The Big Short – Brad Pitt, Dede Gardner, and Jeremy Kleiner\\r\\n<br/>Bridge of Spies – Steven Spielberg, Marc Platt, and Kristie Macosko Krieger\\r\\n<br/>Brooklyn – Finola Dwyer and Amanda Posey\\r\\n<br/>Mad Max: Fury Road – Doug Mitchell and George Miller\\r\\n<br/>The Martian – Simon Kinberg, Ridley Scott, Michael Schaefer and Mark Huffam\\r\\n<br/>The Revenant – Arnon Milchan, Steve Golin, Alejandro G. Iñárritu, Mary Parent and Keith Redmon\\r\\n<br/>Room – Ed Guiney\\r\\n<br/>Spotlight – Michael Sugar, Steve Golin, Nicole Rocklin and Blye Pagon Faust\\r\\n<br/>\\r\\n<br/>* 2. Best Directing \\r\\n<br/>Lenny Abrahamson – Room\\r\\n<br/>Alejandro G. Iñárritu – The Revenant\\r\\n<br/>Tom McCarthy – Spotlight\\r\\n<br/>Adam McKay – The Big Short\\r\\n<br/>George Miller – Mad Max: Fury Road\\r\\n<br/>\\r\\n<br/>* 3. Best Actor \\r\\n<br/>Bryan Cranston – Trumbo as Dalton Trumbo\\r\\n<br/>Matt Damon – The Martian as Mark Watney\\r\\n<br/>Leonardo DiCaprio – The Revenant as Hugh Glass\\r\\n<br/>Michael Fassbender – Steve Jobs as Steve Jobs\\r\\n<br/>Eddie Redmayne – The Danish Girl as Lili Elbe / Einar Wegener\\r\\n<br/>\\r\\n<br/>* 4. Best Actress \\r\\n<br/>Cate Blanchett – Carol as Carol Aird\\r\\n<br/>Brie Larson – Room as Joy \\\"Ma\\\" Newsome\\r\\n<br/>Jennifer Lawrence – Joy as Joy Mangano\\r\\n<br/>Charlotte Rampling – 45 Years as Kate Mercer\\r\\n<br/>Saoirse Ronan – Brooklyn as Eilis Lacey\\r\\n<br/>\\r\\n<br/>* 5. Best Supporting Actor \\r\\n<br/>Christian Bale – The Big Short as Michael Burry\\r\\n<br/>Tom Hardy – The Revenant as John Fitzgerald\\r\\n<br/>Mark Ruffalo – Spotlight as Michael Rezendes\\r\\n<br/>Mark Rylance – Bridge of Spies as Rudolf Abel\\r\\n<br/>Sylvester Stallone – Creed as Rocky Balboa\\r\\n<br/>\\r\\n<br/>* 6. Best Supporting Actress \\r\\n<br/>Jennifer Jason Leigh – The Hateful Eight as Daisy Domergue\\r\\n<br/>Rooney Mara – Carol as Therese Belivet\\r\\n<br/>Rachel McAdams – Spotlight as Sacha Pfeiffer\\r\\n<br/>Alicia Vikander – The Danish Girl as Gerda Wegener\\r\\n<br/>Kate Winslet – Steve Jobs as Joanna Hoffman\\r\\n<br/>\\r\\n<br/>* 7. Best Original Screenplay \\r\\n<br/>Bridge of Spies – Matt Charman, Ethan Coen and Joel Coen\\r\\n<br/>Ex Machina – Alex Garland\\r\\n<br/>Inside Out – Josh Cooley, Ronnie del Carmen, Pete Docter and Meg LeFauve\\r\\n<br/>Spotlight – Tom McCarthy and Josh Singer\\r\\n<br/>Straight Outta Compton – Andrea Berloff, Jonathan Herman, S. Leigh Savidge and Alan Wenkus\\r\\n<br/>\\r\\n<br/>* 8. Best Adapted Screenplay \\r\\n<br/>The Big Short – Adam McKay and Charles Randolph from The Big Short by Michael Lewis\\r\\n<br/>Brooklyn – Nick Hornby from Brooklyn by Colm Tóibín\\r\\n<br/>Carol – Phyllis Nagy from The Price of Salt by Patricia Highsmith\\r\\n<br/>The Martian – Drew Goddard from The Martian by Andy Weir\\r\\n<br/>Room – Emma Donoghue from Room by Emma Donoghue\\r\\n<br/>\\r\\n<br/>* 9. Best Animated Feature Film \\r\\n<br/>Anomalisa – Charlie Kaufman, Duke Johnson and Rosa Tran\\r\\n<br/>Boy & the World – Alê Abreu\\r\\n<br/>Inside Out – Pete Docter and Jonas Rivera\\r\\n<br/>Shaun the Sheep Movie – Mark Burton and Richard Starzak\\r\\n<br/>When Marnie Was There – Hiromasa Yonebayashi and Yoshiaki Nishimura\\r\\n<br/>\\r\\n<br/>* 10. Best Foreign Language Film \\r\\n<br/>Embrace of the Serpent (Colombia) in Spanish – Ciro Guerra\\r\\n<br/>Mustang (France) in Turkish – Deniz Gamze Ergüven\\r\\n<br/>Son of Saul (Hungary) in Hungarian – László Nemes\\r\\n<br/>Theeb (Jordan) in Arabic – Naji Abu Nowar\\r\\n<br/>A War (Denmark) in Danish – Tobias Lindholm\\r\\n<br/>\\r\\n<br/>* 11. Best Documentary – Feature \\r\\n<br/>Amy – Asif Kapadia and James Gay-Rees\\r\\n<br/>Cartel Land – Matthew Heineman and Tom Yellin\\r\\n<br/>The Look of Silence – Joshua Oppenheimer and Signe Byrge Sørensen\\r\\n<br/>What Happened, Miss Simone? – Liz Garbus, Amy Hobby and Justin Wilkes\\r\\n<br/>Winter on Fire: Ukraine's Fight for Freedom – Evgeny Afineevsky and Den Tolmor\\r\\n<br/>\\r\\n<br/>* 12. Best Documentary – Short Subject \\r\\n<br/>Body Team 12 – David Darg and Bryn Mooser\\r\\n<br/>Chau, Beyond the Lines – Courtney Marsh and Jerry Franck\\r\\n<br/>Claude Lanzmann: Spectres of the Shoah – Adam Benzine\\r\\n<br/>A Girl in the River: The Price of Forgiveness – Sharmeen Obaid-Chinoy\\\\\\\\\\r\\n<br/>Last Day of Freedom – Dee Hibbert-Jones and Nomi Talisman\\r\\n<br/>\\r\\n<br/>* 13. Best Live Action Short Film \\r\\n<br/>Ave Maria – Eric Dupont and Basil Khalil\\r\\n<br/>Day One – Henry Hughes\\r\\n<br/>Everything Will Be Okay – Patrick Vollrath\\r\\n<br/>Shok – Jamie Donoughue\\r\\n<br/>Stutterer – Serena Armitage and Benjamin Cleary\\r\\n<br/>\\r\\n<br/>* 14. Best Animated Short Film \\r\\n<br/>Bear Story – Pato Escala Pierart and Gabriel Osorio Vargas\\r\\n<br/>Prologue – Imogen Sutton and Richard Williams\\r\\n<br/>Sanjay's Super Team – Nicole Paradis Grindle and Sanjay Patel\\r\\n<br/>We Can't Live Without Cosmos – Konstantin Bronzit\\r\\n<br/>World of Tomorrow – Don Hertzfeldt\\r\\n<br/>\\r\\n<br/>* 15. Best Original Score \\r\\n<br/>Bridge of Spies – Thomas Newman\\r\\n<br/>Carol – Carter Burwell\\r\\n<br/>The Hateful Eight – Ennio Morricone\\r\\n<br/>Sicario – Jóhann Jóhannsson\\r\\n<br/>Star Wars: The Force Awakens – John Williams\\r\\n<br/>\\r\\n<br/>* 16. Best Original Song \\r\\n<br/>\\\"Earned It\\\" from Fifty Shades of Grey – Music and Lyrics by Belly, Stephan Moccio, Jason \\\"Daheala\\\" Quenneville, and The Weeknd\\r\\n<br/>\\\"Manta Ray\\\" from Racing Extinction – Music by J. Ralph, Lyrics by Antony Hegarty\\r\\n<br/>\\\"Simple Song #3\\\" from Youth – Music and Lyrics by David Lang\\r\\n<br/>\\\"Til It Happens to You\\\" from The Hunting Ground – Music and Lyrics by Lady Gaga and Diane Warren\\r\\n<br/>\\\"Writing's on the Wall\\\" from Spectre – Music and Lyrics by Jimmy Napes and Sam Smith\\r\\n<br/>\\r\\n<br/>* 17. Best Sound Editing \\r\\n<br/>Mad Max: Fury Road – Mark A. Mangini and David White\\r\\n<br/>The Martian – Oliver Tarney\\r\\n<br/>The Revenant – Martin Hernández and Lon Bender\\r\\n<br/>Sicario – Alan Robert Murray\\r\\n<br/>Star Wars: The Force Awakens – Matthew Wood and David Acord\\r\\n<br/>\\r\\n<br/>* 18. Best Sound Mixing \\r\\n<br/>Bridge of Spies – Andy Nelson, Gary Rydstrom and Drew Kunin\\r\\n<br/>Mad Max: Fury Road – Chris Jenkins, Gregg Rudloff and Ben Osmo\\r\\n<br/>The Martian – Paul Massey, Mark Taylor and Mac Ruth\\r\\n<br/>The Revenant – Jon Taylor, Frank A. Montaño, Randy Thom and Chris Duesterdiek\\r\\n<br/>Star Wars: The Force Awakens – Andy Nelson, Christopher Scarabosio and Stuart Wilson\\r\\n<br/>\\r\\n<br/>* 19. Best Production Design \\r\\n<br/>Bridge of Spies – Rena DeAngelo, Bernhard Henrich and Adam Stockhausen\\r\\n<br/>The Danish Girl – Michael Standish and Eve Stewart\\r\\n<br/>Mad Max: Fury Road – Colin Gibson and Lisa Thompson\\r\\n<br/>The Martian – Celia Bobak and Arthur Max\\r\\n<br/>The Revenant – Jack Fisk and Hamish Purdy\\r\\n<br/>\\r\\n<br/>* 20. Best Cinematography \\r\\n<br/>Carol – Ed Lachman\\r\\n<br/>The Hateful Eight – Robert Richardson\\r\\n<br/>Mad Max: Fury Road – John Seale\\r\\n<br/>The Revenant – Emmanuel Lubezki\\r\\n<br/>Sicario – Roger Deakins\\r\\n<br/>\\r\\n<br/>* 21. Best Makeup And Hairstyling \\r\\n<br/>The 100-Year-Old Man Who Climbed Out the Window and Disappeared – Love Larson and Eva von Bahr\\r\\n<br/>Mad Max: Fury Road – Lesley Vanderwalt, Elka Wardega and Damian Martin\\r\\n<br/>The Revenant – Siân Grigg, Duncan Jarman and Robert Pandini\\r\\n<br/>\\r\\n<br/>* 22. Best Costume Design \\r\\n<br/>Carol – Sandy Powell\\r\\n<br/>Cinderella – Sandy Powell\\r\\n<br/>The Danish Girl – Paco Delgado\\r\\n<br/>Mad Max: Fury Road – Jenny Beavan\\r\\n<br/>The Revenant – Jacqueline West\\r\\n<br/>\\r\\n<br/>* 23. Best Film Editing \\r\\n<br/>The Big Short – Hank Corwin\\r\\n<br/>Mad Max: Fury Road – Margaret Sixel\\r\\n<br/>The Revenant – Stephen Mirrione\\r\\n<br/>Spotlight – Tom McArdle\\r\\n<br/>Star Wars: The Force Awakens – Maryann Brandon and Mary Jo Markey\\r\\n<br/>\\r\\n<br/>* 24. Best Visual Effects \\r\\n<br/>Ex Machina – Mark Williams Ardington, Sara Bennett, Paul Norris and Andrew Whitehurst\\r\\n<br/>Mad Max: Fury Road – Andrew Jackson, Dan Oliver, Andy Williams and Tom Wood\\r\\n<br/>The Martian – Anders Langlands, Chris Lawrence, Richard Stammers and Steven Warner\\r\\n<br/>The Revenant – Richard McBride, Matt Shumway, Jason Smith and Cameron Waldbauer\\r\\n<br/>Star Wars: The Force Awakens – Chris Corbould, Roger Guyett, Paul Kavanagh and Neal Scanlan\\r\\n<br/>\",\"favorite_count\":1,\"id\":\"569bc01dc3a36858c6000030\",\"item_count\":57,\"iso_639_1\":\"bg\",\"list_type\":\"movie\",\"name\":\"88th Academy Awards (Oscars 2016)\",\"poster_path\":\"/ch5lXYTKXlLjRpqVzztkc0Y34U0.jpg\"},{\"description\":\"A list of the films that were nominated at the 2010 Oscars for best picture.\",\"favorite_count\":3,\"id\":\"50956fd2760ee3698a001fb0\",\"item_count\":10,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"2010 Oscar Nominations for Best Picture - 82nd Academy Awards\",\"poster_path\":\"/8iwe0iP49A6Gqcv31jBleZDZqI4.jpg\"},{\"description\":\"Here's my list of best picture winners for the Oscars.\",\"favorite_count\":1,\"id\":\"51de878a19c295767a26b495\",\"item_count\":5,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"Best Picture Winners - The Academy Awards\",\"poster_path\":\"/9BI7XGMMgSbLLzykBfW20B4weMY.jpg\"},{\"description\":\"A list of the films that were nominated at the 2009 Oscars for best picture.\",\"favorite_count\":2,\"id\":\"50957064760ee3698a001fc0\",\"item_count\":5,\"iso_639_1\":\"en\",\"list_type\":\"movie\",\"name\":\"2009 Oscar Nominations for Best Picture - 81st Academy Awards\",\"poster_path\":\"/gShtwIvdSHgCEQRZfymNkEUEwFm.jpg\"}],\"total_pages\":3,\"total_results\":21}";
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        MovieListsWrapper wrapper = gson.fromJson(json, MovieListsWrapper.class);
        List<TMDBMovieList> lists = wrapper.getLists();
        String descr = lists.get(1).getDescription();
        String plain = Html.fromHtml(descr).toString();
    }

    @Test
    public void collectionListWrapperTest(){
        String json = "{\"page\":1,\"results\":[{\"id\":286904,\"backdrop_path\":\"/9DA9dxRE0fRlpl4amBmLCjQdZay.jpg\",\"name\":\"Ultimate Avengers Collection\",\"poster_path\":\"/kUCn2BUhItvzyirayEiv83XNHW8.jpg\"},{\"id\":86311,\"backdrop_path\":\"/zuW6fOiusv4X9nnW3paHGfXcSll.jpg\",\"name\":\"The Avengers Collection\",\"poster_path\":\"/aC3VJyuNpymHAf9pyQqB20EK4v6.jpg\"}],\"total_pages\":1,\"total_results\":2}";
        Gson gson = new Gson();
        CollectionListWrapper wrapper = gson.fromJson(json, CollectionListWrapper.class);
    }

    @Test
    public void movieListWrapperForSearch(){
        String json = "{\"page\":1,\"results\":[{\"poster_path\":\"\\/cezWGskPY5x7GaglTTRN4Fugfb8.jpg\",\"adult\":false,\"overview\":\"When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!\",\"release_date\":\"2012-04-25\",\"genre_ids\":[878,28,12],\"id\":24428,\"original_title\":\"The Avengers\",\"original_language\":\"en\",\"title\":\"The Avengers\",\"backdrop_path\":\"\\/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg\",\"popularity\":6.542235,\"vote_count\":8213,\"video\":false,\"vote_average\":7.31},{\"poster_path\":\"\\/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\",\"adult\":false,\"overview\":\"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.\",\"release_date\":\"2015-04-22\",\"genre_ids\":[28,12,878],\"id\":99861,\"original_title\":\"Avengers: Age of Ultron\",\"original_language\":\"en\",\"title\":\"Avengers: Age of Ultron\",\"backdrop_path\":\"\\/570qhjGZmGPrBGnfx70jcwIuBr4.jpg\",\"popularity\":9.349543,\"vote_count\":3619,\"video\":false,\"vote_average\":7.42},{\"poster_path\":\"\\/pPEbiPHyXeRGPxrVnq9JGnYV1pe.jpg\",\"adult\":false,\"overview\":\"\",\"release_date\":\"2018-04-25\",\"genre_ids\":[12,878,28],\"id\":299536,\"original_title\":\"Avengers: Infinity War - Part I\",\"original_language\":\"en\",\"title\":\"Avengers: Infinity War - Part I\",\"backdrop_path\":null,\"popularity\":5.032371,\"vote_count\":37,\"video\":false,\"vote_average\":7.32},{\"poster_path\":\"\\/we6igIU5gXVwuSL6M6pJP75TwEf.jpg\",\"adult\":false,\"overview\":\"When a nuclear missile was fired at Washington in 1945, Captain America managed to detonate it in the upper atmosphere. But then he fell miles into the icy depths of the North Atlantic, where he remained lost for over sixty years. But now, with the world facing the very same evil, Captain America must rise again as our last hope for survival.\",\"release_date\":\"2006-02-21\",\"genre_ids\":[16,28,878],\"id\":14609,\"original_title\":\"Ultimate Avengers\",\"original_language\":\"en\",\"title\":\"Ultimate Avengers\",\"backdrop_path\":\"\\/mZO4V0ALx15QTgWr4SaXYGT7i60.jpg\",\"popularity\":1.869758,\"vote_count\":38,\"video\":false,\"vote_average\":6.25},{\"poster_path\":\"\\/7cJGRajXMU2aYdTbElIl6FtzOl2.jpg\",\"adult\":false,\"overview\":\"British Ministry agent John Steed, under direction from \\\"Mother\\\", investigates a diabolical plot by arch-villain Sir August de Wynter to rule the world with his weather control machine. Steed investigates the beautiful Doctor Mrs. Emma Peel, the only suspect, but simultaneously falls for her and joins forces with her to combat Sir August.\",\"release_date\":\"1998-08-13\",\"genre_ids\":[53],\"id\":9320,\"original_title\":\"The Avengers\",\"original_language\":\"en\",\"title\":\"The Avengers\",\"backdrop_path\":\"\\/8YW4rwWQgC2JRlBcpStMNUko13k.jpg\",\"popularity\":1.868546,\"vote_count\":100,\"video\":false,\"vote_average\":4.68},{\"poster_path\":\"\\/i4f2Gko4ogs6C49QVucCcjNAYos.jpg\",\"adult\":false,\"overview\":\"When Rumpelstiltskin destroys the Magic Mirror and escapes to the modern world, the four princesses of \\\"Once Upon a Time\\\"-Cinderella, Sleeping Beauty, Snow White, and Rapunzel-are sucked through the portal too. Well-trained and endowed with magical powers, the four women must fight Rumpelstiltskin and his army of thralls before he enslaves everyone on Earth.\",\"release_date\":\"2015-03-17\",\"genre_ids\":[14,28,12],\"id\":323660,\"original_title\":\"Avengers Grimm\",\"original_language\":\"en\",\"title\":\"Avengers Grimm\",\"backdrop_path\":\"\\/2tklhhTTGKXZLKdP6VasBbas8Nn.jpg\",\"popularity\":1.763157,\"vote_count\":19,\"video\":false,\"vote_average\":3.58},{\"poster_path\":\"\\/zC6MRi5aKmiMvnTVFARfzFpD7EN.jpg\",\"adult\":false,\"overview\":\"The continuation of the Infinity War film.\",\"release_date\":\"2019-04-25\",\"genre_ids\":[878,28,12],\"id\":299534,\"original_title\":\"Avengers: Infinity War - Part II\",\"original_language\":\"en\",\"title\":\"Avengers: Infinity War - Part II\",\"backdrop_path\":null,\"popularity\":2.806552,\"vote_count\":4,\"video\":false,\"vote_average\":9.5},{\"poster_path\":\"\\/u7vvexSU81Qk20yU7Vog23Ogob.jpg\",\"adult\":false,\"overview\":\"Mysterious Wakanda lies in the darkest heart of Africa, unknown to most of the world. An isolated land hidden behind closed borders, fiercely protected by its young king - the Black Panther. But when brutal alien invaders attack, the threat leaves the Black Panther with no option but to go against the sacred decrees of his people and ask for help from outsiders.\",\"release_date\":\"2006-08-08\",\"genre_ids\":[16,28,878],\"id\":14611,\"original_title\":\"Ultimate Avengers 2\",\"original_language\":\"en\",\"title\":\"Ultimate Avengers 2\",\"backdrop_path\":\"\\/85NqI4WuCim6dZexmTPUAi13Af0.jpg\",\"popularity\":1.941106,\"vote_count\":29,\"video\":false,\"vote_average\":6.21},{\"poster_path\":\"\\/ln4gZahk1PcTANtogVTgUD22tuC.jpg\",\"adult\":false,\"overview\":\"When the Jade Empress steals the world's largest diamonds, super heroes Bikini Avenger and Thong Girl must stop her before she uses the gems to build a dangerous sci-fi weapon.\",\"release_date\":\"2015-02-24\",\"genre_ids\":[35],\"id\":347158,\"original_title\":\"Bikini Avengers\",\"original_language\":\"en\",\"title\":\"Bikini Avengers\",\"backdrop_path\":null,\"popularity\":1.183122,\"vote_count\":1,\"video\":false,\"vote_average\":0},{\"poster_path\":\"\\/zdzOyOMaufI7h11KPKVsgXLdRhT.jpg\",\"adult\":false,\"overview\":\"Philip Kwok plays a repentant killer who vows to destroy the masked gang of which he was a member. A young fighter and his martial arts brothers come to the town to catch the killers, but one of them is not to be trusted!\",\"release_date\":\"1981-05-15\",\"genre_ids\":[28,10769],\"id\":63441,\"original_title\":\"Cha shou\",\"original_language\":\"en\",\"title\":\"Masked Avengers\",\"backdrop_path\":\"\\/nrwT1fQTGgy62xSJ6v501EAQukS.jpg\",\"popularity\":1.014331,\"vote_count\":3,\"video\":false,\"vote_average\":5.83},{\"poster_path\":\"\\/jEIwVDDQH8KYLGXgUIUIDDwXJKS.jpg\",\"adult\":false,\"overview\":\"This classical tale of Shaolin Temple disciples versus the Manchurian Ching government displays Shaolin martial arts at its best in empty hand combat. After the siege of the Shaolin Monastery by the Ching gevernment in the 18th century, students of Shaolin led by Hung See-Kwan, continue to rebel agains the Manchus. Hung then joins forces with the well-known hero Fong Sai Yuk. Hung is now a wanted criminal by Ching leader Kow Ching Chung, former disciple of Shaolin. Fong's association with Hung brings tragedy to his family as they are raided and killed by Kow's troops. Fong and Hung prepare for the final battle as they vow to bring Kow to his knees to avenge Shaolin and their families.\",\"release_date\":\"1994-09-19\",\"genre_ids\":[28],\"id\":40830,\"original_title\":\"Shao Lin ying xiong zhi Feng Shi-Yu Hong Zhi-Guan\",\"original_language\":\"en\",\"title\":\"Shaolin Avengers\",\"backdrop_path\":null,\"popularity\":1.000183,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":\"\\/oeYE9CWaT2PO8zJcUzu2zCA3t1b.jpg\",\"adult\":false,\"overview\":\"Charlie and Rhonda are a sweet and comfortable married couple on vacation with their lovely daughter Daphne. They find a rundown boarding house and its haggard owner, Joseph, an ex-con whose mother has just died and left him the house. He doesn't know why this cheerful couple would want to vacation in the worst part of Los Angeles, but he doesn't know they're vacationing from outer space, and their idea of fun is murdering lowlife out on the streets\",\"release_date\":\"1996-08-03\",\"genre_ids\":[35,878],\"id\":58906,\"original_title\":\"Alien Avengers\",\"original_language\":\"en\",\"title\":\"Alien Avengers\",\"backdrop_path\":null,\"popularity\":1.00026,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":\"\\/s3XzOPDrJOngUDXpaC4kLtp1ASr.jpg\",\"adult\":false,\"overview\":\"The children of the Avengers hone their powers and go head to head with the very enemy responsible for their parents' demise.\",\"release_date\":\"2008-09-02\",\"genre_ids\":[16,10751],\"id\":14613,\"original_title\":\"Next Avengers: Heroes of Tomorrow\",\"original_language\":\"en\",\"title\":\"Next Avengers: Heroes of Tomorrow\",\"backdrop_path\":\"\\/uwUeHfak6cNDntMRqClBuy4UGQb.jpg\",\"popularity\":1.45924,\"vote_count\":28,\"video\":false,\"vote_average\":6.36},{\"poster_path\":\"\\/6zBkbmqB857edSNt08fJpv1Tqqt.jpg\",\"adult\":false,\"overview\":\"After interfering with a top secret mission, THE PUNISHER is taken into custody by S.H.I.E.L.D. AGENT and AVENGER, BLACK WIDOW. At the orders of Director Nick Fury, Punisher and Black Widow are sent on a mission to stop LEVIATHAN, a global terrorist organization, that plans to sell stolen S.H.I.E.L.D. technology to the highest bidder. Now, the vigilante and spy must work together to prevent this technology from falling into the wrong hands. The fate of the world, and of the AVENGERS, hangs in the balance.\",\"release_date\":\"2014-03-25\",\"genre_ids\":[16,878,28],\"id\":257346,\"original_title\":\"Avengers Confidential: Black Widow & Punisher\",\"original_language\":\"en\",\"title\":\"Avengers Confidential: Black Widow & Punisher\",\"backdrop_path\":\"\\/pFKUJMdd5AotbHz7yjdNR8CSBDV.jpg\",\"popularity\":2.197546,\"vote_count\":37,\"video\":false,\"vote_average\":6.31},{\"poster_path\":\"\\/sPN52tE6Hn37G6pzFMRQ0prN8xS.jpg\",\"adult\":false,\"overview\":\"Three macabre short stories about gambling, vengeance and homicide.\",\"release_date\":\"1981-04-02\",\"genre_ids\":[],\"id\":157421,\"original_title\":\"Gui Yu\",\"original_language\":\"en\",\"title\":\"Avengers from Hell\",\"backdrop_path\":null,\"popularity\":1.000865,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":\"\\/s0mBWDRBLfe6BH4daWEr6bTHtht.jpg\",\"adult\":false,\"overview\":\"Sci-fi comedy directed by Dave Payne.\",\"release_date\":\"1998-01-01\",\"genre_ids\":[10770,35,878],\"id\":223291,\"original_title\":\"Alien Avengers II\",\"original_language\":\"en\",\"title\":\"Alien Avengers II\",\"backdrop_path\":null,\"popularity\":1.004382,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":\"\\/imTUeuHuxVLxC7sxKqi2G0RPF7k.jpg\",\"adult\":false,\"overview\":\"This Australian children's film is about scientist Bill Stewart goes to Fiji with his son Tim to investigate the appearance of the Crown of Thorns starfish in the reefs off the island.\",\"release_date\":\"1973-10-20\",\"genre_ids\":[],\"id\":392031,\"original_title\":\"Avengers of the Reef\",\"original_language\":\"en\",\"title\":\"Avengers of the Reef\",\"backdrop_path\":null,\"popularity\":1.000021,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":null,\"adult\":false,\"overview\":\"Shaolin fist-fighter Kang Tau Kan defends businesses from neighborhood toughs. To fulfill a promise to his dying father, Kang returns home to look after his mother and sister, where he finds that land developer Wang is bribing officials to obtain big parcels of land. Kang, however, refuses to sell. In reprisal, Wang sets Kang's farm ablaze, killing his mother and sibling -- forcing Kang to seek vengeance. Shiue Jia Ian and Ou Yang Pey Shan star.\",\"release_date\":\"\",\"genre_ids\":[],\"id\":318401,\"original_title\":\"Buddhist Shaolin Avengers\",\"original_language\":\"en\",\"title\":\"Buddhist Shaolin Avengers\",\"backdrop_path\":null,\"popularity\":1.000017,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":null,\"adult\":false,\"overview\":\"THE 4th series of  Avengers Assemble\",\"release_date\":\"\",\"genre_ids\":[],\"id\":374127,\"original_title\":\"Avengers Kang Dynasty\",\"original_language\":\"en\",\"title\":\"Avengers Kang Dynasty\",\"backdrop_path\":null,\"popularity\":1,\"vote_count\":0,\"video\":false,\"vote_average\":0},{\"poster_path\":null,\"adult\":false,\"overview\":\"An insider's look at the first year of an activist group known as the Lesbian Avengers.\",\"release_date\":\"1993-01-01\",\"genre_ids\":[99],\"id\":377364,\"original_title\":\"Lesbian Avengers Eat Fire Too\",\"original_language\":\"en\",\"title\":\"Lesbian Avengers Eat Fire Too\",\"backdrop_path\":null,\"popularity\":1.000082,\"vote_count\":0,\"video\":false,\"vote_average\":0}],\"total_results\":31,\"total_pages\":2}";
        Gson gson = new Gson();

        MovieListWrapper wrapper = gson.fromJson(json, MovieListWrapper.class);
    }

    @Test
    public void creditsWrapperTest(){
        String movieCreditsJson = "{\"id\":271110,\"cast\":[{\"cast_id\":9,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"543ecb490e0a2667450001db\",\"id\":16828,\"name\":\"Chris Evans\",\"order\":0,\"profile_path\":\"/kRlx7PxXkom7Daj8Z2HmcbPQB1o.jpg\"},{\"cast_id\":10,\"character\":\"Tony Stark / Iron Man\",\"credit_id\":\"543ecb5fc3a3684fe90001a9\",\"id\":3223,\"name\":\"Robert Downey Jr.\",\"order\":1,\"profile_path\":\"/r7WLn4Kbnqb6oJ8TmSI0e4LkWTj.jpg\"},{\"cast_id\":14,\"character\":\"Natasha Romanoff / Black Widow\",\"credit_id\":\"54b95becc3a3686c6800520e\",\"id\":1245,\"name\":\"Scarlett Johansson\",\"order\":2,\"profile_path\":\"/8EueDe6rPF0jQU4LSpsH2Rmrqac.jpg\"},{\"cast_id\":15,\"character\":\"James Buchanan 'Bucky' Barnes / The Winter Soldier\",\"credit_id\":\"54b95c039251411d77004980\",\"id\":60898,\"name\":\"Sebastian Stan\",\"order\":3,\"profile_path\":\"/8MOp9cazWpC4CrGLZnD11A6Dv8c.jpg\"},{\"cast_id\":17,\"character\":\"Sam Wilson / Falcon\",\"credit_id\":\"54ce33afc3a3687f92005096\",\"id\":53650,\"name\":\"Anthony Mackie\",\"order\":4,\"profile_path\":\"/5VGGJ0Co8SC94iiedWb2o3C36T.jpg\"},{\"cast_id\":18,\"character\":\"Clint Barton / Hawkeye\",\"credit_id\":\"54fadad59251417b26001187\",\"id\":17604,\"name\":\"Jeremy Renner\",\"order\":5,\"profile_path\":\"/g8gheNEdPSXWH5SnjfjTYWj5ziU.jpg\"},{\"cast_id\":23,\"character\":\"Wanda Maximoff / Scarlet Witch\",\"credit_id\":\"553a2e6ac3a3684022001284\",\"id\":550843,\"name\":\"Elizabeth Olsen\",\"order\":6,\"profile_path\":\"/8vgj3i5ByHUHP6p2jN2o5pcNbaL.jpg\"},{\"cast_id\":26,\"character\":\"The Vision\",\"credit_id\":\"554ba79cc3a3685e5800278d\",\"id\":6162,\"name\":\"Paul Bettany\",\"order\":7,\"profile_path\":\"/xN2pJ3DIPacYviSSwDovxizPS2w.jpg\"},{\"cast_id\":27,\"character\":\"Lieutenant James \\\"Rhodey\\\" Rhodes / War Machine\",\"credit_id\":\"554ba7adc3a3685e630024fe\",\"id\":1896,\"name\":\"Don Cheadle\",\"order\":8,\"profile_path\":\"/4PvWfLvABO5n1ZfzK76vol9Bqae.jpg\"},{\"cast_id\":28,\"character\":\"Scott Lang / Ant-Man\",\"credit_id\":\"554ba7ed925141469c002586\",\"id\":22226,\"name\":\"Paul Rudd\",\"order\":9,\"profile_path\":\"/oUJyLVn3kCmQuFeug4SBIo7Tc02.jpg\"},{\"cast_id\":11,\"character\":\"T'Challa / Black Panther\",\"credit_id\":\"544fe6eec3a368023c0024b7\",\"id\":172069,\"name\":\"Chadwick Boseman\",\"order\":10,\"profile_path\":\"/xE2sR6skskfCmbVKkebbDXSURiT.jpg\"},{\"cast_id\":33,\"character\":\"Peter Parker / Spider-Man\",\"credit_id\":\"5589c2489251410dd4000308\",\"id\":1136406,\"name\":\"Tom Holland\",\"order\":11,\"profile_path\":\"/v06Zp6sQYLeW14jHOf3yinW0Tva.jpg\"},{\"cast_id\":12,\"character\":\"Zemo\",\"credit_id\":\"546b762d92514101ec001e4f\",\"id\":3872,\"name\":\"Daniel Brühl\",\"order\":12,\"profile_path\":\"/caphIBQdN9ct4gvhZb3svSQHoq6.jpg\"},{\"cast_id\":16,\"character\":\"Brock Rumlow / Crossbones\",\"credit_id\":\"54c6739dc3a368792900aa24\",\"id\":81685,\"name\":\"Frank Grillo\",\"order\":13,\"profile_path\":\"/vpAbhSIPEeX4S699YqPyfGJ2qxy.jpg\"},{\"cast_id\":29,\"character\":\"Secretary of State Thaddeus \\\"Thunderbolt\\\" Ross\",\"credit_id\":\"554ba80ec3a3685e58002795\",\"id\":227,\"name\":\"William Hurt\",\"order\":14,\"profile_path\":\"/mf5GiYZjURQ72CPtY1kBva7mqIK.jpg\"},{\"cast_id\":25,\"character\":\"Sharon Carter / Agent 13\",\"credit_id\":\"554aff6a925141469c001048\",\"id\":84247,\"name\":\"Emily VanCamp\",\"order\":15,\"profile_path\":\"/1vpRa1vnzvPiNMLOq2IkS16ZKPc.jpg\"},{\"cast_id\":24,\"character\":\"Everett K. Ross\",\"credit_id\":\"5549db4e9251413820000a90\",\"id\":7060,\"name\":\"Martin Freeman\",\"order\":16,\"profile_path\":\"/ashlWz2KDQTbo8NPUbVOwcB3zXJ.jpg\"},{\"cast_id\":153,\"character\":\"May Parker\",\"credit_id\":\"570ddf48c3a3680a390015fc\",\"id\":3141,\"name\":\"Marisa Tomei\",\"order\":17,\"profile_path\":\"/l87UKhZ1ethWmn8lksmLZ2LcQJ1.jpg\"},{\"cast_id\":154,\"character\":\"King T'Chaka\",\"credit_id\":\"5716b7afc3a3686678012c97\",\"id\":51878,\"name\":\"John Kani\",\"order\":18,\"profile_path\":\"/iOKWcdeCNbEREAWMWIZBy6p805j.jpg\"},{\"cast_id\":155,\"character\":\"Howard Stark\",\"credit_id\":\"5716b8289251413d30000b9d\",\"id\":21134,\"name\":\"John Slattery\",\"order\":19,\"profile_path\":\"/jKlkyLBTSQH3AIEkITGaplFdbj.jpg\"},{\"cast_id\":151,\"character\":\"Miriam\",\"credit_id\":\"570c14c5c3a36802b0000b56\",\"id\":1981,\"name\":\"Alfre Woodard\",\"order\":20,\"profile_path\":\"/aCAjUOrV2WG3OaLUvQHVkyk8S2P.jpg\"},{\"cast_id\":35,\"character\":\"FedEx Driver\",\"credit_id\":\"565ae5a2925141691e001be1\",\"id\":7624,\"name\":\"Stan Lee\",\"order\":21,\"profile_path\":\"/dTr2gJPL7jELKVkcjtoNx80uVKR.jpg\"},{\"cast_id\":157,\"character\":\"Maria Stark\",\"credit_id\":\"5716b9a3c3a3685e54000a3e\",\"id\":15250,\"name\":\"Hope Davis\",\"order\":22,\"profile_path\":\"/m1RBUwfxms0o4PAOaHYaGT0DpAj.jpg\"},{\"cast_id\":156,\"character\":\"F.R.I.D.A.Y. (voice)\",\"credit_id\":\"5716b8b69251414e7c000a29\",\"id\":62105,\"name\":\"Kerry Condon\",\"order\":23,\"profile_path\":\"/xkkZOXsL04UfKhTIzsDae9oAxCl.jpg\"},{\"cast_id\":152,\"character\":\"M.I.T. Liaison\",\"credit_id\":\"570c14d6c3a36802b9000acf\",\"id\":161932,\"name\":\"Jim Rash\",\"order\":24,\"profile_path\":\"/eWBHlcgATCzoAqNDI7xiAPi7g1d.jpg\"},{\"cast_id\":30,\"character\":\"Auctioneer\",\"credit_id\":\"554be7cec3a3685e58002f3e\",\"id\":592495,\"name\":\"Ray Sahetapy\",\"order\":25,\"profile_path\":\"/nqKNGkVUltpsOnGejWLSpqhvd4N.jpg\"},{\"cast_id\":55,\"character\":\"Karpov\",\"credit_id\":\"56944483c3a3680ea80004ea\",\"id\":116969,\"name\":\"Gene Farber\",\"order\":26,\"profile_path\":\"/hgkrTtK6ixHdX7G1v78mC5UaEmc.jpg\"},{\"cast_id\":56,\"character\":\"Security Chief\",\"credit_id\":\"5694449c9251414b7200045b\",\"id\":139900,\"name\":\"Florence Kasumba\",\"order\":27,\"profile_path\":\"/oLKR9435H3sjeCWWvD0rLGsL5t9.jpg\"},{\"cast_id\":158,\"character\":\"UN Staffer Gibson\",\"credit_id\":\"5716bbbf925141695b000810\",\"id\":232256,\"name\":\"Amelia Morck\",\"order\":28,\"profile_path\":null},{\"cast_id\":159,\"character\":\"Stark's Assistant\",\"credit_id\":\"5716bbdec3a3685378017b87\",\"id\":78430,\"name\":\"Julianna Guill\",\"order\":29,\"profile_path\":\"/myHcPhxZcDk9yCL2F2yafQudMih.jpg\"}],\"crew\":[{\"credit_id\":\"537d792c0e0a2624c0001210\",\"department\":\"Directing\",\"id\":19271,\"job\":\"Director\",\"name\":\"Anthony Russo\",\"profile_path\":\"/mwokQ8u2RgeFRkDUtcNctTgd8bg.jpg\"},{\"credit_id\":\"537d793e0e0a2624bd001166\",\"department\":\"Directing\",\"id\":19272,\"job\":\"Director\",\"name\":\"Joe Russo\",\"profile_path\":\"/5bMVczVDqLJFpfLQZhQ4hhwkSQD.jpg\"},{\"credit_id\":\"569442309251414b640003c4\",\"department\":\"Writing\",\"id\":18866,\"job\":\"Characters\",\"name\":\"Jack Kirby\",\"profile_path\":null},{\"credit_id\":\"537d79700e0a2624bd00116d\",\"department\":\"Writing\",\"id\":5551,\"job\":\"Screenplay\",\"name\":\"Christopher Markus\",\"profile_path\":\"/tyeKi52yruPdxOkEMKhBKCnkp5V.jpg\"},{\"credit_id\":\"537d79820e0a2624b400118a\",\"department\":\"Writing\",\"id\":5552,\"job\":\"Screenplay\",\"name\":\"Stephen McFeely\",\"profile_path\":\"/fa8DAGpANcBTTXO4bbNMrCFufmV.jpg\"},{\"credit_id\":\"569442269251414b780003a5\",\"department\":\"Writing\",\"id\":18996,\"job\":\"Characters\",\"name\":\"Joe Simon\",\"profile_path\":null},{\"credit_id\":\"537d79eb0e0a2624b700118b\",\"department\":\"Production\",\"id\":10850,\"job\":\"Producer\",\"name\":\"Kevin Feige\",\"profile_path\":\"/AewbqQQT0FbcE358rcbopZ3zgDV.jpg\"},{\"credit_id\":\"5694427ac3a3680eb0000454\",\"department\":\"Editing\",\"id\":35176,\"job\":\"Editor\",\"name\":\"Jeffrey Ford\",\"profile_path\":\"/jcnSoKsJj7131oScRDmg8HMhK77.jpg\"},{\"credit_id\":\"550f0042c3a3681db2009b56\",\"department\":\"Sound\",\"id\":227440,\"job\":\"Original Music Composer\",\"name\":\"Henry Jackman\",\"profile_path\":null},{\"credit_id\":\"550f0061c3a3683dd6002cb0\",\"department\":\"Production\",\"id\":113672,\"job\":\"Executive Producer\",\"name\":\"Alan Fine\",\"profile_path\":\"/7Ntt3WWg25ivLT8Os3LeZW1WxIC.jpg\"},{\"credit_id\":\"550f006e92514164ac000de0\",\"department\":\"Production\",\"id\":1349452,\"job\":\"Associate Producer\",\"name\":\"Lars P. Winther\",\"profile_path\":null},{\"credit_id\":\"550f008092514107010030fc\",\"department\":\"Production\",\"id\":1117747,\"job\":\"Co-Producer\",\"name\":\"Mitchell Bell\",\"profile_path\":null},{\"credit_id\":\"566c5c6292514173ff00ce47\",\"department\":\"Writing\",\"id\":87172,\"job\":\"Comic Book\",\"name\":\"Mark Millar\",\"profile_path\":null},{\"credit_id\":\"5694425fc3a3680ea800044d\",\"department\":\"Camera\",\"id\":967026,\"job\":\"Director of Photography\",\"name\":\"Trent Opaloch\",\"profile_path\":null},{\"credit_id\":\"56944292c3a3680ea300041a\",\"department\":\"Production\",\"id\":57027,\"job\":\"Executive Producer\",\"name\":\"Louis D'Esposito\",\"profile_path\":\"/pNvtXPy8kil9WWFtySahnNbvc3R.jpg\"},{\"credit_id\":\"5694429d9251414b6e000410\",\"department\":\"Production\",\"id\":7624,\"job\":\"Executive Producer\",\"name\":\"Stan Lee\",\"profile_path\":\"/dTr2gJPL7jELKVkcjtoNx80uVKR.jpg\"},{\"credit_id\":\"569442bfc3a3680e9f00039e\",\"department\":\"Production\",\"id\":1067682,\"job\":\"Executive Producer\",\"name\":\"Nate Moore\",\"profile_path\":null},{\"credit_id\":\"569442d89251414b6e000427\",\"department\":\"Production\",\"id\":10903,\"job\":\"Co-Producer\",\"name\":\"Henning Molfenter\",\"profile_path\":null},{\"credit_id\":\"569442f1c3a3680e9d0003b1\",\"department\":\"Production\",\"id\":1089142,\"job\":\"Co-Producer\",\"name\":\"Christoph Fisser\",\"profile_path\":null},{\"credit_id\":\"569443159251414b720003de\",\"department\":\"Production\",\"id\":10905,\"job\":\"Co-Producer\",\"name\":\"Charlie Woebcken\",\"profile_path\":null},{\"credit_id\":\"5694433d9251414b720003f9\",\"department\":\"Production\",\"id\":8703,\"job\":\"Executive Producer\",\"name\":\"Patricia Whitcher\",\"profile_path\":null},{\"credit_id\":\"5694435e9251414b64000416\",\"department\":\"Production\",\"id\":113674,\"job\":\"Executive Producer\",\"name\":\"Victoria Alonso\",\"profile_path\":\"/pj6Fht1kv5CZybSkZt9dhZwVaAJ.jpg\"},{\"credit_id\":\"569443729251414b7200040d\",\"department\":\"Production\",\"id\":7232,\"job\":\"Casting\",\"name\":\"Sarah Finn\",\"profile_path\":\"/wLRJ2HJ3dOSF11xlUCobDxufmnf.jpg\"},{\"credit_id\":\"5694438e9251414b6b0003c1\",\"department\":\"Art\",\"id\":9343,\"job\":\"Production Design\",\"name\":\"Owen Paterson\",\"profile_path\":null},{\"credit_id\":\"56e547fac3a3685aa800646f\",\"department\":\"Art\",\"id\":936841,\"job\":\"Supervising Art Director\",\"name\":\"Greg Berry\",\"profile_path\":null},{\"credit_id\":\"569443c1c3a3680eb00004b6\",\"department\":\"Costume & Make-Up\",\"id\":10970,\"job\":\"Costume Design\",\"name\":\"Judianna Makovsky\",\"profile_path\":null},{\"credit_id\":\"569443d59251414b67000428\",\"department\":\"Art\",\"id\":2529,\"job\":\"Set Decoration\",\"name\":\"Ronald R. Reiss\",\"profile_path\":null},{\"credit_id\":\"569443e3c3a3680e9f0003ef\",\"department\":\"Art\",\"id\":1172441,\"job\":\"Art Direction\",\"name\":\"Gregory S. Hooper\",\"profile_path\":null},{\"credit_id\":\"56e54c43c3a3685a92006886\",\"department\":\"Costume & Make-Up\",\"id\":1319825,\"job\":\"Costume Supervisor\",\"name\":\"Nick Scarano\",\"profile_path\":null},{\"credit_id\":\"56bd04abc3a3681806000ad8\",\"department\":\"Directing\",\"id\":1576050,\"job\":\"Assistant Director\",\"name\":\"Frank Reina\",\"profile_path\":null},{\"credit_id\":\"56e5486bc3a3685aa400654f\",\"department\":\"Art\",\"id\":1389129,\"job\":\"Art Department Coordinator\",\"name\":\"Theresa Greene\",\"profile_path\":null},{\"credit_id\":\"56e548e792514109d80050dd\",\"department\":\"Art\",\"id\":1530686,\"job\":\"Assistant Art Director\",\"name\":\"Andres Cubillan\",\"profile_path\":null},{\"credit_id\":\"56e548f892514109d80050e0\",\"department\":\"Art\",\"id\":1340093,\"job\":\"Assistant Art Director\",\"name\":\"Matthew Gatlin\",\"profile_path\":null},{\"credit_id\":\"56e54909c3a3685a9000707e\",\"department\":\"Art\",\"id\":1393435,\"job\":\"Assistant Art Director\",\"name\":\"Jim Wallis\",\"profile_path\":null},{\"credit_id\":\"56e5491d92514103c5002f59\",\"department\":\"Art\",\"id\":1338964,\"job\":\"Assistant Art Director\",\"name\":\"Michael Fissneider\",\"profile_path\":null},{\"credit_id\":\"56e5493c9251411fef00229a\",\"department\":\"Art\",\"id\":1378162,\"job\":\"Construction Coordinator\",\"name\":\"Stacey S. McIntosh\",\"profile_path\":null},{\"credit_id\":\"56e549bf9251416d46006587\",\"department\":\"Crew\",\"id\":1004624,\"job\":\"Property Master\",\"name\":\"Russell Bobbitt\",\"profile_path\":null},{\"credit_id\":\"56e549d59251413269003e1a\",\"department\":\"Crew\",\"id\":1590390,\"job\":\"Property Master\",\"name\":\"Eckart Friz\",\"profile_path\":null},{\"credit_id\":\"56e54a079251413269003e22\",\"department\":\"Production\",\"id\":1345611,\"job\":\"Casting\",\"name\":\"Tara Feldstein\",\"profile_path\":null},{\"credit_id\":\"56e54a1b92514115ec003e37\",\"department\":\"Production\",\"id\":1345610,\"job\":\"Casting\",\"name\":\"Chase Paris\",\"profile_path\":null},{\"credit_id\":\"56e54a2dc3a3685a92006841\",\"department\":\"Production\",\"id\":1543191,\"job\":\"Casting Associate\",\"name\":\"Jason B. Stamey\",\"profile_path\":null},{\"credit_id\":\"56e54a5c92514115ec003e45\",\"department\":\"Crew\",\"id\":1590391,\"job\":\"Armorer\",\"name\":\"Hayden Bilson\",\"profile_path\":null},{\"credit_id\":\"56e54aa1c3a3685a900070b4\",\"department\":\"Crew\",\"id\":1543230,\"job\":\"Armorer\",\"name\":\"Ron Licari\",\"profile_path\":null},{\"credit_id\":\"56e54ab7c3a3685a9e006aa8\",\"department\":\"Crew\",\"id\":1530726,\"job\":\"Armorer\",\"name\":\"Larry Zanoff\",\"profile_path\":null},{\"credit_id\":\"56e54aecc3a3685aa0006aba\",\"department\":\"Directing\",\"id\":1355532,\"job\":\"Script Supervisor\",\"name\":\"Kerry Lyn McKissick\",\"profile_path\":null},{\"credit_id\":\"56e54b0592514115ec003e5d\",\"department\":\"Directing\",\"id\":1494288,\"job\":\"Script Supervisor\",\"name\":\"Mari Wilson\",\"profile_path\":null},{\"credit_id\":\"56e54b1dc3a3685a92006865\",\"department\":\"Production\",\"id\":1342054,\"job\":\"Researcher\",\"name\":\"Joel Thingvall\",\"profile_path\":null},{\"credit_id\":\"56e54bcbc3a3685a9a006583\",\"department\":\"Sound\",\"id\":1400088,\"job\":\"Music Editor\",\"name\":\"Daniel Pinder\",\"profile_path\":null},{\"credit_id\":\"56e54bf69251416d40006c36\",\"department\":\"Sound\",\"id\":24192,\"job\":\"Music Supervisor\",\"name\":\"Dave Jordan\",\"profile_path\":null},{\"credit_id\":\"56e54c5ac3a3685a9a00658f\",\"department\":\"Costume & Make-Up\",\"id\":1586282,\"job\":\"Costume Supervisor\",\"name\":\"Stefanie Bruhn\",\"profile_path\":null},{\"credit_id\":\"56e54c7ec3a3685a9a006599\",\"department\":\"Costume & Make-Up\",\"id\":1533084,\"job\":\"Assistant Costume Designer\",\"name\":\"Pablo Borges\",\"profile_path\":null},{\"credit_id\":\"56e54c92c3a3685a96006f93\",\"department\":\"Costume & Make-Up\",\"id\":1590392,\"job\":\"Assistant Costume Designer\",\"name\":\"Michael Crow\",\"profile_path\":null},{\"credit_id\":\"56e54ca5c3a3685a90007105\",\"department\":\"Costume & Make-Up\",\"id\":11106,\"job\":\"Assistant Costume Designer\",\"name\":\"Lisa Tomczeszyn\",\"profile_path\":null},{\"credit_id\":\"56e54cc7c3a3685aa40065e1\",\"department\":\"Costume & Make-Up\",\"id\":1590393,\"job\":\"Set Costumer\",\"name\":\"Chris Allegro\",\"profile_path\":null},{\"credit_id\":\"56e54cdd9251413269003e85\",\"department\":\"Costume & Make-Up\",\"id\":1399320,\"job\":\"Set Costumer\",\"name\":\"Valentina Aulisi\",\"profile_path\":null},{\"credit_id\":\"56e54cffc3a3685aa800654c\",\"department\":\"Costume & Make-Up\",\"id\":1417839,\"job\":\"Set Costumer\",\"name\":\"David Butler\",\"profile_path\":null},{\"credit_id\":\"56e54d13c3a3685a920068b1\",\"department\":\"Costume & Make-Up\",\"id\":1590394,\"job\":\"Set Costumer\",\"name\":\"Steven Butler\",\"profile_path\":null},{\"credit_id\":\"56e54d2e9251416d40006c63\",\"department\":\"Costume & Make-Up\",\"id\":1477793,\"job\":\"Set Costumer\",\"name\":\"Dustin Fletcher\",\"profile_path\":null},{\"credit_id\":\"56e54dabc3a3685a9a0065c5\",\"department\":\"Camera\",\"id\":1378241,\"job\":\"Camera Operator\",\"name\":\"Maurice K. McGuire\",\"profile_path\":null},{\"credit_id\":\"56e54dc4c3a3685aa4006607\",\"department\":\"Camera\",\"id\":1439104,\"job\":\"Camera Operator\",\"name\":\"Onofrio Nino Pansini\",\"profile_path\":null},{\"credit_id\":\"56e54dd8c3a3685aa4006609\",\"department\":\"Camera\",\"id\":40766,\"job\":\"Camera Operator\",\"name\":\"Jörg Widmer\",\"profile_path\":null},{\"credit_id\":\"56e54df392514109d800517c\",\"department\":\"Camera\",\"id\":239788,\"job\":\"Camera Operator\",\"name\":\"Charles Schner\",\"profile_path\":null},{\"credit_id\":\"56e54e0492514115ec003ec8\",\"department\":\"Camera\",\"id\":1411271,\"job\":\"Camera Operator\",\"name\":\"Michael J. Walker\",\"profile_path\":null},{\"credit_id\":\"56e54e16c3a3685aa0006b0a\",\"department\":\"Camera\",\"id\":1567950,\"job\":\"Camera Operator\",\"name\":\"Eric Laudadio\",\"profile_path\":null},{\"credit_id\":\"56e54e2b92514103c5002feb\",\"department\":\"Camera\",\"id\":1400092,\"job\":\"Helicopter Camera\",\"name\":\"Jeremy Braben\",\"profile_path\":null},{\"credit_id\":\"56e54e3fc3a3685a90007134\",\"department\":\"Camera\",\"id\":1403415,\"job\":\"Helicopter Camera\",\"name\":\"David B. Nowell\",\"profile_path\":null},{\"credit_id\":\"56e54e6192514103c5002ff2\",\"department\":\"Camera\",\"id\":1494210,\"job\":\"Steadicam Operator\",\"name\":\"Mark Goellnicht\",\"profile_path\":null},{\"credit_id\":\"56e54e829251416525002502\",\"department\":\"Camera\",\"id\":1400082,\"job\":\"Still Photographer\",\"name\":\"Zade Rosenthal\",\"profile_path\":null},{\"credit_id\":\"56e54eb79251416d40006c90\",\"department\":\"Crew\",\"id\":19002,\"job\":\"Second Unit Cinematographer\",\"name\":\"Jim Whitaker\",\"profile_path\":null},{\"credit_id\":\"56e54ee392514103c500300b\",\"department\":\"Lighting\",\"id\":1204332,\"job\":\"Gaffer\",\"name\":\"Jeff Murrell\",\"profile_path\":null},{\"credit_id\":\"56e54efac3a3685aa800657c\",\"department\":\"Lighting\",\"id\":40778,\"job\":\"Gaffer\",\"name\":\"Albrecht Silberberger\",\"profile_path\":null},{\"credit_id\":\"56e54f10c3a3685aa800657f\",\"department\":\"Lighting\",\"id\":1392943,\"job\":\"Gaffer\",\"name\":\"Joshua Davis\",\"profile_path\":null},{\"credit_id\":\"56e54f3292514115ec003efd\",\"department\":\"Lighting\",\"id\":1590395,\"job\":\"Gaffer\",\"name\":\"Mike Pearce\",\"profile_path\":null},{\"credit_id\":\"56e54f5392514109d800519b\",\"department\":\"Crew\",\"id\":12575,\"job\":\"Second Unit Cinematographer\",\"name\":\"Patrick Loungway\",\"profile_path\":null},{\"credit_id\":\"56e54f8fc3a3685a9a00660b\",\"department\":\"Camera\",\"id\":189241,\"job\":\"Additional Camera\",\"name\":\"Peter Hawkins\",\"profile_path\":null},{\"credit_id\":\"56e54fd89251413269003ee1\",\"department\":\"Costume & Make-Up\",\"id\":1424894,\"job\":\"Hair Department Head\",\"name\":\"Camille Friend\",\"profile_path\":\"/oqRHAueWWqslWfVHRGQAjEd8vTI.jpg\"},{\"credit_id\":\"56e55004c3a3685a92006904\",\"department\":\"Costume & Make-Up\",\"id\":1444908,\"job\":\"Hairstylist\",\"name\":\"Cydney Cornell\",\"profile_path\":null},{\"credit_id\":\"56e5501ac3a3685a9e006b61\",\"department\":\"Costume & Make-Up\",\"id\":1442097,\"job\":\"Hairstylist\",\"name\":\"Jeri Baker\",\"profile_path\":null},{\"credit_id\":\"56e5505f9251416d40006ccc\",\"department\":\"Costume & Make-Up\",\"id\":1548530,\"job\":\"Hairstylist\",\"name\":\"Robert Wilson\",\"profile_path\":null},{\"credit_id\":\"56e55091c3a3685aa0006b58\",\"department\":\"Costume & Make-Up\",\"id\":1590400,\"job\":\"Makeup Artist\",\"name\":\"Fawn Ortega\",\"profile_path\":null},{\"credit_id\":\"56e550ae9251416d40006cdb\",\"department\":\"Costume & Make-Up\",\"id\":1590401,\"job\":\"Makeup Artist\",\"name\":\"Laura Dandridge\",\"profile_path\":null},{\"credit_id\":\"56e550c29251413269003efa\",\"department\":\"Costume & Make-Up\",\"id\":102343,\"job\":\"Makeup Artist\",\"name\":\"Allan A. Apone\",\"profile_path\":null},{\"credit_id\":\"56e550db925141652500255b\",\"department\":\"Costume & Make-Up\",\"id\":23787,\"job\":\"Makeup Artist\",\"name\":\"Deborah La Mia Denaver\",\"profile_path\":null},{\"credit_id\":\"56e55143c3a3685a9e006b9b\",\"department\":\"Editing\",\"id\":1590402,\"job\":\"Dialogue Editor\",\"name\":\"Ryan J. Frias\",\"profile_path\":null},{\"credit_id\":\"56e5515b92514109d80051cc\",\"department\":\"Editing\",\"id\":1445834,\"job\":\"Dialogue Editor\",\"name\":\"Stuart McCowan\",\"profile_path\":null},{\"credit_id\":\"56e551869251413269003f1a\",\"department\":\"Sound\",\"id\":1364411,\"job\":\"Boom Operator\",\"name\":\"Randall L. Johnson\",\"profile_path\":null},{\"credit_id\":\"56e551a2c3a3685aa0006b7d\",\"department\":\"Sound\",\"id\":1590403,\"job\":\"Boom Operator\",\"name\":\"Etienne Haug\",\"profile_path\":null},{\"credit_id\":\"56e551b592514103c500308c\",\"department\":\"Sound\",\"id\":1590404,\"job\":\"Boom Operator\",\"name\":\"Malo Thouément\",\"profile_path\":null},{\"credit_id\":\"56e551cac3a3685aa0006b88\",\"department\":\"Sound\",\"id\":80827,\"job\":\"Foley\",\"name\":\"Shelley Roden\",\"profile_path\":null},{\"credit_id\":\"56e551e59251416525002589\",\"department\":\"Sound\",\"id\":8159,\"job\":\"Sound Designer\",\"name\":\"Shannon Mills\",\"profile_path\":null},{\"credit_id\":\"56e551fe925141652500258e\",\"department\":\"Sound\",\"id\":1394418,\"job\":\"Sound Effects Editor\",\"name\":\"Jeremy Bowker\",\"profile_path\":null},{\"credit_id\":\"56e5521d92514115ec003f7b\",\"department\":\"Sound\",\"id\":3996,\"job\":\"Sound Re-Recording Mixer\",\"name\":\"Tom Johnson\",\"profile_path\":null},{\"credit_id\":\"56e552339251416525002597\",\"department\":\"Sound\",\"id\":8166,\"job\":\"Sound Re-Recording Mixer\",\"name\":\"Juan Peralta\",\"profile_path\":null},{\"credit_id\":\"56e5524d925141652500259d\",\"department\":\"Sound\",\"id\":8159,\"job\":\"Supervising Sound Editor\",\"name\":\"Shannon Mills\",\"profile_path\":null},{\"credit_id\":\"56e552649251416d460066ca\",\"department\":\"Sound\",\"id\":16344,\"job\":\"Supervising Sound Editor\",\"name\":\"Daniel Laurie\",\"profile_path\":null},{\"credit_id\":\"56e552f092514115ec003fa7\",\"department\":\"Visual Effects\",\"id\":1409237,\"job\":\"Animation Supervisor\",\"name\":\"Pimentel A. Raphael\",\"profile_path\":null},{\"credit_id\":\"56e5530892514103c50030b9\",\"department\":\"Visual Effects\",\"id\":1590405,\"job\":\"Animation Supervisor\",\"name\":\"Simone Kraus Townsend\",\"profile_path\":null},{\"credit_id\":\"56e553369251411fef0023fc\",\"department\":\"Crew\",\"id\":1590406,\"job\":\"CG Supervisor\",\"name\":\"David Marsh\",\"profile_path\":null},{\"credit_id\":\"56e5534ec3a3685a9e006c00\",\"department\":\"Crew\",\"id\":1408352,\"job\":\"CG Supervisor\",\"name\":\"Pavel Pranevsky\",\"profile_path\":null},{\"credit_id\":\"56e553eb9251416d46006707\",\"department\":\"Crew\",\"id\":1530231,\"job\":\"Special Effects Coordinator\",\"name\":\"Gerd Nefzer\",\"profile_path\":null},{\"credit_id\":\"56e5542ac3a3685a90007214\",\"department\":\"Visual Effects\",\"id\":1590407,\"job\":\"Special Effects Supervisor\",\"name\":\"Carlo Perez\",\"profile_path\":null},{\"credit_id\":\"56e55449c3a3685aa40066f4\",\"department\":\"Visual Effects\",\"id\":15356,\"job\":\"Special Effects Supervisor\",\"name\":\"Daniel Sudick\",\"profile_path\":null},{\"credit_id\":\"56e55486c3a3685aa8006665\",\"department\":\"Visual Effects\",\"id\":1590408,\"job\":\"Visual Effects Coordinator\",\"name\":\"Matthew Lloyd\",\"profile_path\":null},{\"credit_id\":\"56e554b0c3a3685a960070d1\",\"department\":\"Visual Effects\",\"id\":1338241,\"job\":\"Visual Effects Coordinator\",\"name\":\"Sean McGrath\",\"profile_path\":null},{\"credit_id\":\"56e554c9c3a3685a920069ca\",\"department\":\"Visual Effects\",\"id\":1403408,\"job\":\"Visual Effects Coordinator\",\"name\":\"Jennifer Mizener\",\"profile_path\":null},{\"credit_id\":\"56e554ed9251416d40006d8c\",\"department\":\"Visual Effects\",\"id\":1543227,\"job\":\"Visual Effects Coordinator\",\"name\":\"Brittany Montero\",\"profile_path\":null},{\"credit_id\":\"56e55538c3a3685a9e006c4b\",\"department\":\"Visual Effects\",\"id\":1590409,\"job\":\"Visual Effects Coordinator\",\"name\":\"Adam Pere\",\"profile_path\":null},{\"credit_id\":\"56e5555592514115ec003ff2\",\"department\":\"Visual Effects\",\"id\":1580858,\"job\":\"Visual Effects Coordinator\",\"name\":\"Cole Darby\",\"profile_path\":null},{\"credit_id\":\"56e5556cc3a3685a960070f1\",\"department\":\"Crew\",\"id\":1590410,\"job\":\"Visual Effects Editor\",\"name\":\"Samuel Perkins\",\"profile_path\":null},{\"credit_id\":\"56e5558ac3a3685a9e006c58\",\"department\":\"Visual Effects\",\"id\":1590411,\"job\":\"Visual Effects Producer\",\"name\":\"Jen Underdahl\",\"profile_path\":null},{\"credit_id\":\"56e555acc3a3685a9a0066e6\",\"department\":\"Visual Effects\",\"id\":1590412,\"job\":\"Visual Effects Supervisor\",\"name\":\"Huseyin Caner\",\"profile_path\":null},{\"credit_id\":\"56e555c79251416d4600673b\",\"department\":\"Visual Effects\",\"id\":1590413,\"job\":\"Visual Effects Supervisor\",\"name\":\"Dan Deleeuw\",\"profile_path\":null},{\"credit_id\":\"56e555e0c3a3685aa4006734\",\"department\":\"Visual Effects\",\"id\":1472788,\"job\":\"Visual Effects Supervisor\",\"name\":\"Jamie Hallett\",\"profile_path\":null},{\"credit_id\":\"56e555f9c3a3685a90007258\",\"department\":\"Visual Effects\",\"id\":1379990,\"job\":\"Visual Effects Supervisor\",\"name\":\"Russell Earl\",\"profile_path\":null},{\"credit_id\":\"56e55616c3a3685a9000725e\",\"department\":\"Visual Effects\",\"id\":1327027,\"job\":\"Visual Effects Supervisor\",\"name\":\"Vincent Cirelli\",\"profile_path\":null},{\"credit_id\":\"56e5563bc3a3685a9600710c\",\"department\":\"Editing\",\"id\":1548461,\"job\":\"First Assistant Editor\",\"name\":\"James Andrykowski\",\"profile_path\":null},{\"credit_id\":\"56e55652c3a3685a9e006c81\",\"department\":\"Editing\",\"id\":1590414,\"job\":\"First Assistant Editor\",\"name\":\"Cassie Dixon\",\"profile_path\":null},{\"credit_id\":\"56e55678c3a3685a96007118\",\"department\":\"Editing\",\"id\":1590415,\"job\":\"First Assistant Editor\",\"name\":\"Christos Voutsinas\",\"profile_path\":null},{\"credit_id\":\"56e556ce92514115ec00401d\",\"department\":\"Production\",\"id\":1590416,\"job\":\"Researcher\",\"name\":\"Lisa Fiorito\",\"profile_path\":null}]}";
        String personCreditsJson = "{\"cast\":[{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"52fe4313c3a36847f8038851\",\"id\":1771,\"original_title\":\"Captain America: The First Avenger\",\"poster_path\":\"/dlIPGXPxXQTp9kFrRzn0RsfUelx.jpg\",\"release_date\":\"2011-07-22\",\"title\":\"Captain America: The First Avenger\"},{\"adult\":false,\"character\":\"Johnny Storm / Human Torch\",\"credit_id\":\"52fe4328c3a36847f803ead3\",\"id\":1979,\"original_title\":\"4: Rise of the Silver Surfer\",\"poster_path\":\"/fXpziQgnBnB4bLgjKhjTbLQumE5.jpg\",\"release_date\":\"2007-06-12\",\"title\":\"Fantastic 4: Rise of the Silver Surfer\"},{\"adult\":false,\"character\":\"Jake Wyler\",\"credit_id\":\"52fe44389251416c7502cf7d\",\"id\":11397,\"original_title\":\"Not Another Teen Movie\",\"poster_path\":\"/tBOG4R39TFJ2EPBfwlJFzrgcsix.jpg\",\"release_date\":\"2001-12-07\",\"title\":\"Not Another Teen Movie\"},{\"adult\":false,\"character\":\"Lucas Lee\",\"credit_id\":\"52fe4445c3a368484e01986b\",\"id\":22538,\"original_title\":\"Scott Pilgrim vs. the World\",\"poster_path\":\"/lafRuPbjEQrrHG9QEaoyV2znZC.jpg\",\"release_date\":\"2010-07-27\",\"title\":\"Scott Pilgrim vs. the World\"},{\"adult\":false,\"character\":\"Syd\",\"credit_id\":\"52fe4481c3a36847f809a31f\",\"id\":7515,\"original_title\":\"London\",\"poster_path\":\"/pnTRNDfdxdyx2tYKrTPlO3rcKk4.jpg\",\"release_date\":\"2005-02-10\",\"title\":\"London\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"52fe4495c3a368484e02b19b\",\"id\":24428,\"original_title\":\"The Avengers\",\"poster_path\":\"/cezWGskPY5x7GaglTTRN4Fugfb8.jpg\",\"release_date\":\"2012-04-25\",\"title\":\"The Avengers\"},{\"adult\":false,\"character\":\"Hayden \\\"Harvard Hottie\\\"\",\"credit_id\":\"52fe44e09251416c75044061\",\"id\":12435,\"original_title\":\"The Nanny Diaries\",\"poster_path\":\"/vaARLtfmTHbNpcZycgYLV62M7ye.jpg\",\"release_date\":\"2007-08-24\",\"title\":\"The Nanny Diaries\"},{\"adult\":false,\"character\":\"Johnny Storm\",\"credit_id\":\"52fe4524c3a36847f80bed85\",\"id\":9738,\"original_title\":\"Fantastic Four\",\"poster_path\":\"/aJwUBmUA11lkNVSJ3if3h3xHSFd.jpg\",\"release_date\":\"2005-07-07\",\"title\":\"Fantastic Four\"},{\"adult\":false,\"character\":\"Ryan\",\"credit_id\":\"52fe4527c3a36847f80bf7d7\",\"id\":9759,\"original_title\":\"Cellular\",\"poster_path\":\"/wguhhHAHoh2ECwjf5oHRH0P9ial.jpg\",\"release_date\":\"2004-09-06\",\"title\":\"Cellular\"},{\"adult\":false,\"character\":\"Nick Gant\",\"credit_id\":\"52fe456b9251416c75055c17\",\"id\":13455,\"original_title\":\"Push\",\"poster_path\":\"/shk0MSuHOdBiQfHjLdcXDF6iXC9.jpg\",\"release_date\":\"2009-02-06\",\"title\":\"Push\"},{\"adult\":false,\"character\":\"Kyle\",\"credit_id\":\"52fe45729251416c75056dcd\",\"id\":13505,\"original_title\":\"The Perfect Score\",\"poster_path\":\"/1y14WqlW9UsCCiKVZEDro3VKK3j.jpg\",\"release_date\":\"2004-01-30\",\"title\":\"The Perfect Score\"},{\"adult\":false,\"character\":\"Jensen\",\"credit_id\":\"52fe457e9251416c910345e3\",\"id\":34813,\"original_title\":\"The Losers\",\"poster_path\":\"/e67D7pMpWoo1ckY2QQaKYxhvVuy.jpg\",\"release_date\":\"2010-04-23\",\"title\":\"The Losers\"},{\"adult\":false,\"character\":\"Jimmy\",\"credit_id\":\"52fe4595c3a368484e063815\",\"id\":28424,\"original_title\":\"The Loss of a Teardrop Diamond\",\"poster_path\":\"/cEZPlmTgOHPVD90AmhS3JaXvrmy.jpg\",\"release_date\":\"2008-01-01\",\"title\":\"The Loss of a Teardrop Diamond\"},{\"adult\":false,\"character\":\"Colin Shea\",\"credit_id\":\"52fe46adc3a368484e09dd1b\",\"id\":63492,\"original_title\":\"What's Your Number?\",\"poster_path\":\"/yugpF7km9nEE5GLpSWMSkGKHGNd.jpg\",\"release_date\":\"2011-09-30\",\"title\":\"What's Your Number?\"},{\"adult\":false,\"character\":\"Stewart Stanton\",\"credit_id\":\"52fe46f39251416c75088e5f\",\"id\":16873,\"original_title\":\"Battle for Terra\",\"poster_path\":\"/hE71YvRdNaILXxPf0iASqqFTCSv.jpg\",\"release_date\":\"2007-09-06\",\"title\":\"Battle for Terra\"},{\"adult\":false,\"character\":\"Robert Pronge\",\"credit_id\":\"52fe47a7c3a368484e0d2a65\",\"id\":68812,\"original_title\":\"The Iceman\",\"poster_path\":\"/xLurXBsrgkNMg2Im1KA4HXC56xv.jpg\",\"release_date\":\"2012-09-01\",\"title\":\"The Iceman\"},{\"adult\":false,\"character\":\"Bryce\",\"credit_id\":\"52fe47e19251416c750a88bb\",\"id\":19583,\"original_title\":\"Fierce People\",\"poster_path\":\"/pvDpR2HXJz7dtFLA89CCsSW1WOa.jpg\",\"release_date\":\"2005-01-01\",\"title\":\"Fierce People\"},{\"adult\":false,\"character\":\"Mike Weiss\",\"credit_id\":\"52fe486bc3a368484e0f78bd\",\"id\":72432,\"original_title\":\"Puncture\",\"poster_path\":\"/l97mC5sjjz1B8OL6khwbQzOb4a3.jpg\",\"release_date\":\"2011-09-23\",\"title\":\"Puncture\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"52fe49d8c3a36847f81a957d\",\"id\":100402,\"original_title\":\"Captain America: The Winter Soldier\",\"poster_path\":\"/5TQ6YDmymBpnF005OyoB7ohZps9.jpg\",\"release_date\":\"2014-03-20\",\"title\":\"Captain America: The Winter Soldier\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"52fe4a449251416c750e3465\",\"id\":99861,\"original_title\":\"Avengers: Age of Ultron\",\"poster_path\":\"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg\",\"release_date\":\"2015-04-22\",\"title\":\"Avengers: Age of Ultron\"},{\"adult\":false,\"character\":\"Detective Paul Diskant\",\"credit_id\":\"52fe42ebc3a36847f802cf6f\",\"id\":1266,\"original_title\":\"Street Kings\",\"poster_path\":\"/nFbZvElg1peBts1SYrfPkxUc3QG.jpg\",\"release_date\":\"2008-04-10\",\"title\":\"Street Kings\"},{\"adult\":false,\"character\":\"Mace\",\"credit_id\":\"52fe42ecc3a36847f802d387\",\"id\":1272,\"original_title\":\"Sunshine\",\"poster_path\":\"/upgi8oTlMthM9sweAyBoXqr8doZ.jpg\",\"release_date\":\"2007-04-05\",\"title\":\"Sunshine\"},{\"adult\":false,\"character\":\"Casey (voice)\",\"credit_id\":\"52fe42ecc3a36847f802d401\",\"id\":1273,\"original_title\":\"TMNT\",\"poster_path\":\"/4hGzZ2DAjdu6IjHT7dGfiVatHEu.jpg\",\"release_date\":\"2007-03-22\",\"title\":\"TMNT\"},{\"adult\":false,\"character\":\"Curtis\",\"credit_id\":\"52fe4ad6c3a36847f81e449d\",\"id\":110415,\"original_title\":\"Snowpiercer\",\"poster_path\":\"/oP0ZWr6MsaQ1TV7xvnZJMKSfz0H.jpg\",\"release_date\":\"2013-08-01\",\"title\":\"Snowpiercer\"},{\"adult\":false,\"character\":\"Nick Vaughan\",\"credit_id\":\"53cfc2f0c3a368777a00767d\",\"id\":283350,\"original_title\":\"Before We Go\",\"poster_path\":\"/b9YNJaIqkA2zoNdP4ORtpVMnmVo.jpg\",\"release_date\":\"2014-09-11\",\"title\":\"Before We Go\"},{\"adult\":false,\"character\":\"Narrator\",\"credit_id\":\"53a30ec5c3a3682ac2000021\",\"id\":277547,\"original_title\":\"Playing It Cool\",\"poster_path\":\"/mBzSxaPOcq8XwXq4qkkyy8Ev9Go.jpg\",\"release_date\":\"2014-09-26\",\"title\":\"Playing It Cool\"},{\"adult\":false,\"character\":\"Judd\",\"credit_id\":\"53d5f110c3a3686b8800548c\",\"id\":134803,\"original_title\":\"The Newcomers\",\"poster_path\":\"/2BPsbGavyJFxLy5ySfKyxNVYbK3.jpg\",\"release_date\":\"2000-01-01\",\"title\":\"The Newcomers\"},{\"adult\":false,\"character\":\"Steve Rogers\",\"credit_id\":\"540f904e0e0a26124e0007e6\",\"id\":291718,\"original_title\":\"On the Front Line\",\"poster_path\":\"/oNK3S9T1MMwyklnAbxcAkotMSa9.jpg\",\"release_date\":\"2014-09-09\",\"title\":\"On the Front Line\"},{\"adult\":false,\"character\":\"Himself\",\"credit_id\":\"545a3a4fc3a36825f2000096\",\"id\":299969,\"original_title\":\"Marvel: 75 Years, From Pulp to Pop!\",\"poster_path\":\"/g716rAncfsYzny2eZoxX8txjdRw.jpg\",\"release_date\":\"2014-11-04\",\"title\":\"Marvel: 75 Years, From Pulp to Pop!\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"54a9cfc0c3a3680c2900575e\",\"id\":299536,\"original_title\":\"Avengers: Infinity War - Part I\",\"poster_path\":\"/pPEbiPHyXeRGPxrVnq9JGnYV1pe.jpg\",\"release_date\":\"2018-04-25\",\"title\":\"Avengers: Infinity War - Part I\"},{\"adult\":false,\"character\":\"Captain America (uncredited)\",\"credit_id\":\"52fe4933c3a368484e11f6ef\",\"id\":76338,\"original_title\":\"Thor: The Dark World\",\"poster_path\":\"/bnX5PqAdQZRXSw3aX3DutDcdso5.jpg\",\"release_date\":\"2013-10-29\",\"title\":\"Thor: The Dark World\"},{\"adult\":false,\"character\":\"Steve Rogers\",\"credit_id\":\"5595a51b9251417b2c000471\",\"id\":102899,\"original_title\":\"Ant-Man\",\"poster_path\":\"/D6e8RJf2qUstnfkTslTXNTUAlT.jpg\",\"release_date\":\"2015-07-14\",\"title\":\"Ant-Man\"},{\"adult\":false,\"character\":\"Himself / Steve Rogers / Captain America\",\"credit_id\":\"532e3e0dc3a3685fbb002e5a\",\"id\":259910,\"original_title\":\"Marvel Studios: Assembling a Universe\",\"poster_path\":\"/5LLBKBH4udb0wJveefs1acQ2pW9.jpg\",\"release_date\":\"2014-03-18\",\"title\":\"Marvel Studios: Assembling a Universe\"},{\"adult\":false,\"character\":\"Himself\",\"credit_id\":\"56a43ece925141524c00024b\",\"id\":379040,\"original_title\":\"Marvel's Captain America: 75 Heroic Years\",\"poster_path\":\"/wbLhzgT3eFrwJ0BFRNJjiOR7gaG.jpg\",\"release_date\":\"2016-01-19\",\"title\":\"Marvel's Captain America: 75 Heroic Years\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"543ecb490e0a2667450001db\",\"id\":271110,\"original_title\":\"Captain America: Civil War\",\"poster_path\":\"/rDT86hJCxnoOs4ARjrCiRej7pOi.jpg\",\"release_date\":\"2016-04-27\",\"title\":\"Captain America: Civil War\"},{\"adult\":false,\"character\":\"Steve Rogers / Captain America\",\"credit_id\":\"573fbff0c3a3680727000136\",\"id\":299534,\"original_title\":\"Avengers: Infinity War - Part II\",\"poster_path\":\"/zC6MRi5aKmiMvnTVFARfzFpD7EN.jpg\",\"release_date\":\"2019-04-25\",\"title\":\"Avengers: Infinity War - Part II\"}],\"crew\":[{\"adult\":false,\"credit_id\":\"53cfc356c3a368777a007683\",\"department\":\"Directing\",\"id\":283350,\"job\":\"Director\",\"original_title\":\"Before We Go\",\"poster_path\":\"/b9YNJaIqkA2zoNdP4ORtpVMnmVo.jpg\",\"release_date\":\"2014-09-11\",\"title\":\"Before We Go\"},{\"adult\":false,\"credit_id\":\"554bb668c3a3685e4e0026ca\",\"department\":\"Production\",\"id\":283350,\"job\":\"Producer\",\"original_title\":\"Before We Go\",\"poster_path\":\"/b9YNJaIqkA2zoNdP4ORtpVMnmVo.jpg\",\"release_date\":\"2014-09-11\",\"title\":\"Before We Go\"},{\"adult\":false,\"credit_id\":\"554bb6dec3a3685e4c0029e3\",\"department\":\"Production\",\"id\":277547,\"job\":\"Executive Producer\",\"original_title\":\"Playing It Cool\",\"poster_path\":\"/mBzSxaPOcq8XwXq4qkkyy8Ev9Go.jpg\",\"release_date\":\"2014-09-26\",\"title\":\"Playing It Cool\"}],\"id\":16828}";
        Gson movieGson = new GsonBuilder()
                .registerTypeHierarchyAdapter(TMDBCredit.class, TMDBCredit.createDeserializer(true))
                .create();
        Gson personGson = new GsonBuilder()
                .registerTypeHierarchyAdapter(TMDBCredit.class, TMDBCredit.createDeserializer(false))
                .create();
        CreditsWrapper movieCreditsWrapper = movieGson.fromJson(movieCreditsJson, CreditsWrapper.class);
        CreditsWrapper personCreditsWrapper = personGson.fromJson(personCreditsJson, CreditsWrapper.class);
    }


}