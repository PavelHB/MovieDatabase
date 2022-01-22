package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialDatabase {
    private List<Serial> serialArray;

    public SerialDatabase(List<Serial> serialArray) {
        this.serialArray = serialArray;
    }

    public List<Serial> getSerialArray() {
        return serialArray;
    }

    public void setSerialArray(List<Serial> serialArray) {
        this.serialArray = serialArray;
    }

    static int isSerialExist(String originalName, List<Serial> serials){
        for (int i = 0; i < serials.size(); i++) {
            if(serials.get(i) ==null)return -1;
            if(serials.get(i).getEpisodeArray().get(0).getOriginalName().equals(originalName))
                return i;
        }
        return -1;
    }

    static List<Serial> makeSerialsFromEpisodes(List<Episode> episodes){
        if(episodes!=null) {
            List<Serial> serials = new ArrayList<>();
            int index=0;
            for (int i = 0; i < episodes.size(); i++) {
                index=SerialDatabase.isSerialExist(episodes.get(i).getOriginalName(),serials);
                if(index==-1){
                    serials.add(new Serial(episodes.get(i)));
                }else{
                    serials.get(index).getEpisodeArray().add(episodes.get(i));
                }
            }
            return serials;
        }else{
            return null;
        }
    }
    public int findAverageRatingOfSerial(String originalName){
        int averageRating=0;
        int count=0;
        for (int i = 0; i < getSerialArray().size(); i++) {
            for (int j = 0; j < getSerialArray().get(i).getEpisodeArray().size(); j++) {
                if(getSerialArray().get(i).getEpisodeArray().get(j).getOriginalName().equals(originalName)){
                    averageRating+= getSerialArray().get(i).getEpisodeArray().get(j).getRating();
                    count++;
                }
            }
        }
        if(count==0){
            return -1;
        }
        return averageRating/count;
    }
    public Serial findSerialByName(String name){
        for (int i = 0; i < getSerialArray().size(); i++) {
            if(getSerialArray().get(i).getEpisodeArray().get(0).getOriginalName().equals(name)){
                return getSerialArray().get(i);
            }
        }
        return null;
    }

    public List<Episode> findBestEpisodeOfSerial(Serial serial){
        int bestRating =0;
        int count =0;
        for (int i = 0; i < serial.getEpisodeArray().size(); i++) {     //find value of best rating
            if(serial.getEpisodeArray().get(i).getRating()>bestRating){
                bestRating= serial.getEpisodeArray().get(i).getRating();
            }
        }
        List<Episode> episodes = new ArrayList<>();
        for (int i = 0; i < serial.getEpisodeArray().size(); i++) {     //find number of episodes with best rating
            if(serial.getEpisodeArray().get(i).getRating()==bestRating){
                episodes.add(serial.getEpisodeArray().get(i));
            }
        }
        return episodes;
    }

    static void printEpisodes(List<Episode> episodes){
        if(episodes==null){
            System.out.println("Dané episody neexistuje!");
        }else{
            for (int i = 0; i < episodes.size(); i++) {
                System.out.println(episodes.get(i));
            }
        }
    }


    public String findBestSerial(){
        String bestName = null;
        int bestRating=0;
        for (int i = 0; i < getSerialArray().size(); i++) {
            if(findAverageRatingOfSerial(getSerialArray().get(i).getEpisodeArray().get(0).getOriginalName())>bestRating){
                bestName= getSerialArray().get(i).getEpisodeArray().get(0).getOriginalName();
            }
        }
        return bestName;
    }

    static void printSerial(Serial serial){
        if(serial==null){
            System.out.println("Daný seriál není v databázi!");
        }else{
            for (int i = 0; i < serial.getEpisodeArray().size(); i++) {
                System.out.println(serial.getEpisodeArray().get(i));
            }
        }
    }

    public int timeDurationOfSerial(Serial serial){
        if(serial!=null) {
            int timeDuration = 0;
            for (int i = 0; i < serial.getEpisodeArray().size(); i++) {
                timeDuration += serial.getEpisodeArray().get(i).getTimeDuration();
            }
            return timeDuration;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "SerialDatabase{" +
                "serialArray=" + serialArray +
                '}';
    }
}
