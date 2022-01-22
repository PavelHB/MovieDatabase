package com.company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Episode {
    private String originalName;
    private String czechName;
    private int numberOfSeries;
    private int numberOfEpisode;
    private String episodeName;
    private LocalDate dateRelease;
    private int timeDuration;       //min
    private List<Director> directors;
    private String[] genres;
    private List<Actor>actors;
    private int rating;
    private String aboutEpisode;
    //original,czech,nS,nE,eName,Localdate,time,director,genres,actors,rating,about
    public Episode(String originalName, String czechName, int numberOfSeries, int numberOfEpisode, String episodeName,
                   LocalDate dateRelease, int timeDuration, List<Director> directors, String[] genres, List<Actor> actors,
                   int rating, String aboutEpisode) {
        this.originalName = originalName;
        this.czechName = czechName;
        this.numberOfSeries = numberOfSeries;
        this.numberOfEpisode = numberOfEpisode;
        this.episodeName = episodeName;
        this.dateRelease = dateRelease;
        this.timeDuration = timeDuration;
        this.directors = directors;
        this.genres = genres;
        this.actors = actors;
        this.rating = rating;
        this.aboutEpisode = aboutEpisode;
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

    public int getNumberOfSeries() {
        return numberOfSeries;
    }

    public void setNumberOfSeries(int numberOfSeries) {
        this.numberOfSeries = numberOfSeries;
    }

    public int getNumberOfEpisode() {
        return numberOfEpisode;
    }

    public void setNumberOfEpisode(int numberOfEpisode) {
        this.numberOfEpisode = numberOfEpisode;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
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

    public String getAboutEpisode() {
        return aboutEpisode;
    }

    public void setAboutEpisode(String aboutEpisode) {
        this.aboutEpisode = aboutEpisode;
    }

    @Override
    public String toString() {
        return  originalName + ' ' +
                czechName + ' ' +
                "s" + numberOfSeries +
                "e" + numberOfEpisode +
                " " +episodeName + " " +
                dateRelease + " " +
                timeDuration + "min"+
                ", directors=" + directors +
                " " + Arrays.toString(genres) +
                ", actors=" + actors +
                ", rating=" + rating +
                ", " + aboutEpisode ;
    }
}
