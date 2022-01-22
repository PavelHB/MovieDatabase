package com.company;

/*
Ve třídě Main vytvořte databázi herců, režisérů a filmů (případně i seriálů) - můžete
využít způsob, který jsme si ukazovali na konci poslední lekce,
tedy přes vhodně strukturovaný text, který lze pomocí metody split() rozparsovat
a následně v cyklu vytvořit velké množství objektů.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // český název/originální název/rok/trvání/režiséři/žánry/herci/hodnocení/popis
        String moviesFile="Alien/Vetřelec/1979/117/Ridley Scott/Horor,Scifi/Sigourney Weawer,Tom Skerritt,Veronica Cartwright," +
                "Harry Dean-Stanton,John Hurt,Ian Holm,Yaphet Kotto,Bolaji Badejo,Helen Horton/90/Super film;" +
                "Aliens/Vetřelci/1986/137/James Cameron/Scifi,Thiller,Akční,Dobrodružný,Horor/Sigourney Weawer,Carrie Henn,Michael Biehn," +
                "Paul Reiser,Lance Henriksen,Bill Paxton,William Hope,Jennette Goldstein,Al Matthews,Mark Rolston/90/Super Pokračování;" +
                "Guadians of the Galaxy Vol. 2/Strážci Galaxie Vol. 2/2017/136/James Gunn/Akční,Dobrodružný,Scifi,Fantasy,Komedie/" +
                "Chris Pratt,Zoe Saldana,Dave Bautista,Bradley Cooper,Vin Diesel,Michael Rooker,Karen Gillan,Pom Klementieff,Kurt Russel/80/Řežba;" +
                "Forrest Gump/Forrest Gump/1994/142/Robert Zemeckis/Drama,Komedie,Romantický/Tom Hanks,Robin Wright,Gary Sinise,Mykelti Williamson," +
                "Sally Field,Haley Joel-Osment,Peter Dobson,Siobhan Fallon-Hogan,Hanna Hall,Brett Rice/94/Oscar;" +
                "The Matrix/Matrix/1999/136/Lilly Wachowski,Lana Wachowski/Akční,Scifi/Keanu Reeves,Laurence Fishburne,Carrie-Anne Moss," +
                "Hugo Weaving,Gloria Foster,Joe Pantoliano,Belinda McClory,Robert Taylor/90/Top Scifi;" +
                "Rocky II/Rocky 2/1979/114/Sylvester Stallone/Drama,Sportovní/Sylvester Stallone,Talia Shire,Burt Young,Carl Weathers," +
                "Burgess Meredith,Tony Burton,Joe Spinell,Sylvia Meals,Frank McRae/75/Italský hřebec to je!;" +
                "Gladiator/Gladiátor/2000/155/Ridley Scott/Akční,Dobrodružný,Drama/Russel Crowe,Joaquin Phoenix,Connie Nielsen,Oliver Reed," +
                "Richard Harris,Derek Jacobi,Djimon Hounsou,John Schrapnel,Tomas Arana/88/Moc pěkný film;" +
                "The Terminator/Terminátor/1984/107/James Cameron/Akční,Scifi,Thiller/Arnold Swarzenegger,Michael Biehn,Linda Hamilton,Paul Winfield," +
                "Lance Henriksen,Rick Rossovich,Earl Boen,Dick Miller,Franco Columbu/87/Na tu dobu neuvěřitelný;" +
                "Armageddon/Armageddon/1998/151/Michael Bay/Akční,Dobrodružný,Scifi,Thiller/Bruce Willis,Billy Bob-Thorton,Ben Affleck,Liv Tyler," +
                "Will Patton,Steve Buscemi,William Fichtner,Owen Wilson,Michael Clarke-Duncan/75/Pecka příběh  s dojemným koncem";

        List<Director> directors = new ArrayList<>();
        int indexD = 0;
        List<Actor> actors = new ArrayList<>();
        int indexA = 0;                                                      //actor index
        String[] movieFile=moviesFile.split(";");                       // split to one movie
        List<Movie> movies = new ArrayList<>();                         // array of movies
        for (int i = 0; i < movieFile.length; i++) {
            String[] atributs = movieFile[i].split("/");               // split to  atributs
            String[] directorsFile = atributs[4].split(",");             // split directors
            List<Director> helpDirectors = new ArrayList<>();
            for (int j = 0; j < directorsFile.length; j++) {
                String[] directorFile = directorsFile[j].split(" ");        // split to name and surname
                int index = (Director.isDirectorExist(directorFile[0],directorFile[1],directors));
                // if director exist in directors field, function return index of field with that director
                if(index==-1) { //if not function return -1
                    directors.add(new Director(directorFile[0], directorFile[1]));
                    helpDirectors.add(directors.get(indexD));
                    indexD++;   // increasing index for next director
                }else{
                    helpDirectors.add(directors.get(index));
                }
            }
            //    0               1             2     3       4    5      6     7         8
            // český název/originální název/rok/trvání/režiséři/žánry/herci/hodnocení/popis
            String[] genres = atributs[5].split(",");
            String[] actorsFile = atributs[6].split(",");
            List<Actor> helpActors = new ArrayList<>();
            for (int j = 0; j < actorsFile.length; j++) {
                String[] actorFile = actorsFile[j].split(" ");        // split to name and surname
                int index = (Actor.isActorExist(actorFile[0],actorFile[1],  actors));     // like the director
                if(index==-1){
                    actors.add(new Actor(actorFile[0], actorFile[1]));
                    helpActors.add(actors.get(indexA));
                    indexA++;
                }else{
                    helpActors.add(actors.get(index));
                }
            }
            movies.add(new Movie(atributs[0],           // name
                        atributs[1],                        // original name
                        Integer.parseInt(atributs[2]),      // dateRelease
                        Integer.parseInt(atributs[3]),      // time Duration
                        helpDirectors,                       // directors
                        genres,                                 // genres
                        helpActors,                              //actors
                        Integer.parseInt(atributs[7]),          //rating
                        atributs[8]                            //about
            ));

        }
        MovieDatabase movieDatabase= new MovieDatabase(movies);
        //original,czech,nS,nE,eName,Localdate,time,director,genres,actors,rating,about
        String serialsFile = "" +
                "Dexter/Dexter/1/1/Dexter/1.10.2006/53/Michael Cuesta/Krimi,Drama,Mysteriózní,Thiller/Michael C.Hall,Julie Benz,Jennifer Carpenter," +
                "Erik King,David Zayas,James Remar,C.S. Lee,Margo Martindale,Dominic Janes,Christina Robinson,Daniel Goldman,Patrick Michael-Buckley" +
                "/85/pilot;" +
                "Dexter/Dexter/1/2/Crocodile/8.10.2006/55/Michael Cuesta/Krimi,Drama,Mysteriózní,Thiller/Michael C.Hall,Julie Benz,Jennifer Carpenter," +
                "Erik King,David Zayas,James Remar,Geoff Pierson,Sam Trammell,Rudolf Martin,Richard Gunn,Lisa Kaminir,Christina Robinson,C.S. Lee"+
                "/85/second;" +
                "The Big Bang Theory/Teorie velkého třesku/1/1/Pilot/24.9.2007/23/James Burrows/Komedie,Romantický/Johnny Galecki,Jim Parsons," +
                "Kaley Cuoco,Simon Helberg,Kunal Nayyar,Vernee Watson,Brian Patrick Wade/93/pilot;" +
                "The Big Bang Theory/Teorie velkého třesku/1/2/The Big Bran Hypothesis/24.9.2007/23/James Burrows/Komedie,Romantický/Johnny Galecki," +
                "Jim Parsons,Kaley Cuoco,Simon Helberg,Kunal Nayyar/94/second;" +
                "Dexter/Dexter/1/3/Popping Cherry/15.10.2006/51/Michael Cuesta/Krimi,Drama,Mysteriózní,Thiller/Michael C.Hall,Julie Benz,Jennifer Carpenter," +
                "Erik King,David Zayas,James Remar,Geoff Pierson,C.S. Lee,Brad William-Henke,Scotts Wiliam-Winters,Mark L.Young" +
                "/84/third;" +
                "Narcos/Narcos/1/1/Descenso/28.8.2015/57/José Padilha/Životopisný,Krimi,Drama/Wagner Moura,Boyd Holbrook,Pedro Pascal,Joanna Christie," +
                "Maurice Compte,André Mattos,Robert Urbina,Diego Catano,Jorge A.Jimenez,Paulina Gaitan,Luis Guzmán/92/first;" +
                "Narcos/Narcos/1/2/The Sword of Simón Bolivar/28.8.2015/46/José Padilha/Životopisný,Krimi,Drama/Wagner Moura,Boyd Holbrook,Pedro Pascal,Joanna Christie," +
                "Maurice Compte,André Mattos,Robert Urbina,Diego Catano,Jorge A.Jimenez,Paulina Gaitan,Paulina Garcia,Luis Guzmán/91/second";
        String[] serialFile = serialsFile.split(";");       // like movies
        List<Episode> episodes =new ArrayList<>();
        for (int i = 0; i < serialFile.length; i++) {
            String [] atributs = serialFile[i].split("/");
            //  0        1     2    3        4    5          6     7       8       9      10    11
            //original/czech/nS  /      nE/eName/Localdate/time/director/genres,actors,rating,about
            String[] directorsFile = atributs[7].split(",");        // if there are more directors
            List<Director> helpDirectors = new ArrayList<>();
            for (int j = 0; j < directorsFile.length; j++) {
                String[] directorFile = directorsFile[j].split(" ");        // split to name and surname
                int index = (Director.isDirectorExist(directorFile[0],directorFile[1],directors));
                if(index==-1) {
                    directors.add(new Director(directorFile[0], directorFile[1]));
                    helpDirectors.add(directors.get(indexD));
                    indexD++;
                }else{
                    helpDirectors.add(directors.get(index));
                }
            }
            String[] date = atributs[5].split("\\.");
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
            String[] genres = atributs[8].split(",");
            String[] actorsFile = atributs[9].split(",");
            List<Actor> helpActors = new ArrayList<>();
            for (int j = 0; j < actorsFile.length; j++) {
                String[] actorFile = actorsFile[j].split(" ");        // split to name and surname
                int index = (Actor.isActorExist(actorFile[0],actorFile[1],actors));
                if(index==-1){
                    actors.add(new Actor(actorFile[0], actorFile[1]));
                    helpActors.add(actors.get(indexA));
                    indexA++;
                }else{
                    helpActors.add(actors.get(index));;
                }
            }
            //  0        1     2    3        4    5          6     7       8       9      10    11
            //original/czech/nS  /      nE/eName/Localdate/time/director/genres,actors,rating,about
            episodes.add(new Episode(atributs[0],
                        atributs[1],
                        Integer.parseInt(atributs[2]),
                        Integer.parseInt(atributs[3]),
                        atributs[4],
                        localDate,
                        Integer.parseInt(atributs[6]),
                        helpDirectors,
                        genres,
                        helpActors,
                        Integer.parseInt(atributs[10]),
                        atributs[11]
            ));
        }
        SerialDatabase serialDatabase=new SerialDatabase(SerialDatabase.makeSerialsFromEpisodes(episodes));
        //function in SerialDatabase makes serialDatabase from episodes;

        System.out.println();

        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }

        System.out.println("List of directors:");
        for (int i = 0; i < indexD; i++) {
            System.out.printf("%s, ",directors.get(i));
            if((i+1)%15==0){
                System.out.print("\n");
            }
        }
        System.out.println("\nList of actors:");
        for (int i = 0; i < indexA; i++) {
            System.out.printf("%s, ",actors.get(i));
            if((i+1)%15==0){
                System.out.print("\n");
            }
            if(i==indexA-1){
                System.out.println("Počet herců v databázi: "+actors.size());
            }
        }
        /*
        System.out.println("Nový herec Pavel Linhart");
        movies[1].getActors().add(new Actor("Pavel","Linhart"));
        System.out.println(movies.get(1));
         */
        System.out.println("The oldest films:");
        List<Movie> oldest = movieDatabase.findWithDate(movieDatabase.findTheOldest());         // we can save
        MovieDatabase.printMovies(oldest);
        System.out.println("The newest films:");
        MovieDatabase.printMovies(movieDatabase.findWithDate(movieDatabase.findTheNewest()));
        System.out.println("The 1930 films:");
        MovieDatabase.printMovies(movieDatabase.findWithDate(1930));
        System.out.println("The movies longer than 90 min and shorter than 120 min:");
        MovieDatabase.printMovies(movieDatabase.findTimeDurationBetween(120,90));
        System.out.println("The longest films:");
        MovieDatabase.printMovies(movieDatabase.findTimeDurationBetween(movieDatabase.findTheLongest(),movieDatabase.findTheLongest()));
        System.out.println("The best rating movies with "+movieDatabase.findBestRating()+"% rating");
        MovieDatabase.printMovies(movieDatabase.findRatingBetween(movieDatabase.findBestRating(),movieDatabase.findBestRating()));
        System.out.println("The Scott's films:");
        MovieDatabase.printMovies(movieDatabase.findFilmOfDirector("Scott"));
        System.out.println("The Weawer's films:");
        MovieDatabase.printMovies(movieDatabase.findFilmOfActor("Weawer"));
        System.out.println("The rating of all films in this database is: "+ MovieDatabase.getAverageRating(movieDatabase.getMovieArray())+"%");
        System.out.println("The rating of all films of Weawer in this database is: "
                +MovieDatabase.getAverageRating(movieDatabase.findFilmOfActor("Weawer"))+"%");
        System.out.println("Scifi-films: ");
        MovieDatabase.printMovies(movieDatabase.findWithGenre("Scifi"));
        System.out.println("Thiller-films");
        MovieDatabase.printMovies(movieDatabase.findWithGenre("Thiller"));
        /*for (int i = 0; i < episodes.length; i++) {
            System.out.println(episodes[i]);
        }*/
        System.out.println("Nejlepé hodnocený seriál se jmenuje: "+serialDatabase.findBestSerial());
        System.out.println("Nejlépe hodnocená/hodnocené episoda/episody nejlépe hodnocenného seriálu:");
        SerialDatabase.printEpisodes(serialDatabase.findBestEpisodeOfSerial(serialDatabase.findSerialByName(serialDatabase.findBestSerial())));
        System.out.println("Průměrné hodnocení seriálu: "+serialDatabase.findBestSerial()+ " = "
                +serialDatabase.findAverageRatingOfSerial(serialDatabase.findBestSerial())+"%");
        System.out.println("Jednotlivé epizody nejlepšího seriálu \""  +serialDatabase.findBestSerial() + "\" v databázi:");
        SerialDatabase.printSerial(serialDatabase.findSerialByName(serialDatabase.findBestSerial()));
        System.out.println("Délka všech epizod nejlépe hodnocenného seriálu v databázi: "
                + serialDatabase.timeDurationOfSerial(serialDatabase.findSerialByName(serialDatabase.findBestSerial()))+"min");
        System.out.println("Nejlépe hodnocená/hodnocené episoda/episody Dexter:");
        SerialDatabase.printEpisodes(serialDatabase.findBestEpisodeOfSerial(serialDatabase.findSerialByName("Dexter")));
        System.out.println("Jednotlivé epizody seriálu Dexter v databázi:");
        SerialDatabase.printSerial(serialDatabase.findSerialByName("Dexter"));
        System.out.println("Délka všech epizod seriálu Dexter v databázi: "
                + serialDatabase.timeDurationOfSerial(serialDatabase.findSerialByName("Dexter"))+"min");
        System.out.println("Průměrné hodnocení seriálu Dexter:"
                +serialDatabase.findAverageRatingOfSerial("Dexter")+"%");
        System.out.println("Jednotlivé epizody seriálu The Simpsons v databázi:");
        SerialDatabase.printSerial(serialDatabase.findSerialByName("The Simpsons"));
        System.out.println("Délka všech epizod seriálu The Simpsons v databázi: "
                + serialDatabase.timeDurationOfSerial(serialDatabase.findSerialByName("The Simpsons"))+"min");
        System.out.println("Průměrné hodnocení seriálu The Simpsons:"
                +serialDatabase.findAverageRatingOfSerial("The Simpsons"));

    }
}
