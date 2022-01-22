package com.company;


import java.util.Arrays;
import java.util.List;
/*
3. Třída **Movie** pro filmy. Bude obsahovat minimálně atributy pro originální název,
   český/slovenský název, rok natočení, žánr (může být String, případně pole Stringů),
   režiséra/režiséry (může jich být i víc, tak lze využít pole),
   herce (zde jich určitě bude víc, tak určitě použít pole), hodnocení, délka filmu,
   případně další, pokud vás něco napadne.
   Pak samozžejmě konstruktor (alespoň jeden), gettery, settery, metoda toString().
 */

public class Movie {
    private String originalName;
    private String czechName;
    private int dateRelease;
    private int timeDuration;       //min
    private List<Director> directors;
    private String[] genres;
    private List<Actor> actors;
    private int rating;
    private String aboutFilm;

    public Movie(String originalName, String czechName, int dateRelease, int timeDuration,
                 List<Director> directors, String[] genres, List<Actor> actors, int rating, String aboutFilm) {
        this.originalName = originalName;
        this.czechName = czechName;
        this.dateRelease = dateRelease;
        this.timeDuration = timeDuration;
        this.directors = directors;
        this.genres = genres;
        this.actors = actors;
        this.rating =rating;
        this.aboutFilm = aboutFilm;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getCzechName() {
        return czechName;
    }

    public void setCzechName(String czechName) {
        this.czechName = czechName;
    }

    public int getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(int dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAboutFilm() {
        return aboutFilm;
    }

    public void setAboutFilm(String aboutFilm) {
        this.aboutFilm = aboutFilm;
    }



    @Override
    public String toString() {
        return originalName +
                " " + czechName +
                " " + Arrays.toString(genres) +
                " "+ dateRelease +
                " " + timeDuration +
                "min, directors = " +directors +
                ", actors = " + actors +
                ", rating = " + rating +
                ", " + aboutFilm ;
    }
}


