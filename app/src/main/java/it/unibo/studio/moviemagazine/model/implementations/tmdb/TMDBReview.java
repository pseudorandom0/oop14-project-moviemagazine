package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import java.util.Locale;

import it.unibo.studio.moviemagazine.model.interfaces.Review;

/**
 * Review of a movie
 */
public class TMDBReview implements Review {

    private String id;
    private String author;
    private String content;
    private String language;
    private String url;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Locale getLanguage() {
        return new Locale(this.language);
    }
}
