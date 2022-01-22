package com.company;

import java.util.ArrayList;
import java.util.List;

public class Serial {
    private List<Episode> episodeArray;

    public Serial(Episode episode) {
        List<Episode >episodeArray = new ArrayList<>();
        episodeArray.add(episode);
        this.episodeArray = episodeArray;
    }

    public List<Episode> getEpisodeArray() {
        return episodeArray;
    }

    public void setEpisodeArray(List<Episode> episodeArray) {
        this.episodeArray = episodeArray;
    }
}
