package com.company;

/*
4. Třída **MovieDatabase** pro databázi, která bude obsahovat atribut pole filmů,
   případně ještě počet filmů, které má uložené v poli.
   Dále konstruktor, gettery a settery, metoda toString() - může vypisovat jen nějaké
   základní informace o databázi (počet filmů), asi není potřeba vypisovat celý obsah databáze.
   Dále by tato třída mohla obsahovat následující metody:
   - metoda pro nalezení nejstaršího filmu v databázi
   - metoda pro nalezení nejnovějšího filmu v databázi
   - metoda pro nalezení nejdelšího filmu
   - metoda pro nalezení nejlépe hodnoceného filmu v databázi
   - metoda pro nalezení všech filmů zadaného režiséra - metoda bude mít parametr příjmení
     režiséra a prohledá všechny filmy a vrátí pole filmů, které režíroval
   - metoda pro nalezení všech filmů zadaného herce - metoda bude mít parametr příjmení
     herce a prohledá všechny filmy a vrátí pole filmů, ve kterých hrál
   - metoda pro výpočet průměrného hodnocení filmů v zadaném seznamu
     (případně i další statistiky: nejhorší hodnocení, nejlepší hodnocení, medián hodnocení,...).
     Tato metoda může být statická a může počítat filmy z libovolného pole, lze tedy
     například předchozí metodou získat pole všech filmů nějakého herce a pak touto metodou
     spočítat průměrné hodnocení.
   - případně další - co vás napadne ;-)
 */

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private List<Movie> movieArray;

    public MovieDatabase(List<Movie> movieArray) {
        this.movieArray = movieArray;
    }

    public List<Movie> getMovieArray() {
        return movieArray;
    }

    public void setMovieArray(List<Movie> movieArray) {
        this.movieArray = movieArray;
    }

    @Override
    public String toString() {
        return "MovieDatabase{" +
                "movieArray=" + movieArray +
                '}';
    }

    /*4. Třída **MovieDatabase** pro databázi, která bude obsahovat atribut pole filmů,
   případně ještě počet filmů, které má uložené v poli.
   Dále konstruktor, gettery a settery, metoda toString() - může vypisovat jen nějaké
   základní informace o databázi (počet filmů), asi není potřeba vypisovat celý obsah databáze.
   Dále by tato třída mohla obsahovat následující metody:
   - metoda pro nalezení nejstaršího filmu v databázi
   - metoda pro nalezení nejnovějšího filmu v databázi
   - metoda pro nalezení nejdelšího filmu
   - metoda pro nalezení nejlépe hodnoceného filmu v databázi
   - metoda pro nalezení všech filmů zadaného režiséra - metoda bude mít parametr příjmení
     režiséra a prohledá všechny filmy a vrátí pole filmů, které režíroval
   - metoda pro nalezení všech filmů zadaného herce - metoda bude mít parametr příjmení
     herce a prohledá všechny filmy a vrátí pole filmů, ve kterých hrál
   - metoda pro výpočet průměrného hodnocení filmů v zadaném seznamu
     (případně i další statistiky: nejhorší hodnocení, nejlepší hodnocení, medián hodnocení,...).
     Tato metoda může být statická a může počítat filmy z libovolného pole, lze tedy
     například předchozí metodou získat pole všech filmů nějakého herce a pak touto metodou
     spočítat průměrné hodnocení.
   - případně další - co vás napadne ;-)
     */
    static int getAverageRating(List<Movie> movies){
        if(movies==null){
            return -1;
        }else {
            int sumrating = 0;
            for (int i = 0; i < movies.size(); i++) {
                sumrating += movies.get(i).getRating();
            }
            return sumrating / movies.size();
        }
    }

    public int findTheOldest(){
        int min = movieArray.get(0).getDateRelease();
        for (int i = 1; i < movieArray.size() ; i++) {
            if(movieArray.get(i).getDateRelease()<min){
                min= movieArray.get(i).getDateRelease();
            }
        }
        return min;
    }

    public int findTheNewest(){
        int max = movieArray.get(0).getDateRelease();
        for (int i = 1; i < movieArray.size() ; i++) {
            if(movieArray.get(i).getDateRelease()>max){
                max= movieArray.get(i).getDateRelease();
            }
        }
        return max;
    }
    public int findTheLongest(){
        int max = movieArray.get(0).getTimeDuration();
        for (int i = 1; i < movieArray.size() ; i++) {
            if(movieArray.get(i).getTimeDuration()>max){
                max= movieArray.get(i).getTimeDuration();
            }
        }
        return max;
    }
    public int findBestRating(){
        int max = movieArray.get(0).getRating();
        for (int i = 1; i < movieArray.size() ; i++) {
            if(movieArray.get(i).getRating()>max){
                max= movieArray.get(i).getRating();
            }
        }
        return max;
    }
    public List<Movie> findFilmOfDirector(String surname){
        List<Movie> directorFilm = new ArrayList<>() ;        //počet filmů
        for (int i = 0; i < movieArray.size(); i++) {
            for (int j = 0; j < movieArray.get(i).getDirectors().size(); j++) {
                if(movieArray.get(i).getDirectors().get(j).getSurname().equals(surname)){
                    directorFilm.add(movieArray.get(i));
                }
            }
        }
        return directorFilm;
    }

    public List<Movie> findFilmOfActor(String surname){
        List<Movie> actorFilm = new ArrayList<>();
        for (int i = 0; i < movieArray.size(); i++) {
            for (int j = 0; j < movieArray.get(i).getActors().size(); j++) {
                if(movieArray.get(i).getActors().get(j).getSurname().equals(surname)){
                    actorFilm.add(movieArray.get(i));
                }
            }
        }
        return actorFilm;
    }

    public List<Movie> findRatingBetween(int max, int min){
        List<Movie> ratingBetween = new ArrayList<>();
        for (int i = 0; i < movieArray.size(); i++) {
            if(movieArray.get(i).getRating()>=min&& movieArray.get(i).getRating()<=max){
                ratingBetween.add(movieArray.get(i));
            }
        }

        return ratingBetween;
    }

    public List<Movie> findTimeDurationBetween(int max, int min){
        List<Movie> durationBetween = new ArrayList<>();
        for (int i = 0; i < movieArray.size(); i++) {
            if(movieArray.get(i).getTimeDuration()>=min&& movieArray.get(i).getTimeDuration()<=max){
                durationBetween.add(movieArray.get(i));
            }
        }
        return durationBetween;
    }
    public List<Movie> findWithGenre(String genre){
        List<Movie> withGenreMovies = new ArrayList<>();
        for (int i = 0; i < movieArray.size(); i++) {
            for (int j = 0; j < movieArray.get(i).getGenres().length; j++) {
                if(movieArray.get(i).getGenres()[j].equals(genre)){
                    withGenreMovies.add(movieArray.get(i));
                }
            }
        }
        return withGenreMovies ;
    }

    public List<Movie> findWithDate(int date){
        List<Movie> withDateMovies = new ArrayList<>();
        for (int i = 0; i < movieArray.size(); i++) {
            if(date== movieArray.get(i).getDateRelease()){
                withDateMovies.add(movieArray.get(i));
            }
        }
        return withDateMovies;
    }

    static void printMovies(List<Movie> movies){
        if(movies==null){
            System.out.println("Dané filmy nejsou v databázi!");
        }else{
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(movies.get(i));
            }
        }
    }
}


