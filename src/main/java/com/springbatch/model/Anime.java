package com.springbatch.model;

public class Anime {
    private String anime_id;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private double rating;
    private int members;

    public Anime(String anime_id, String name, String genre, String type, int episodes, double rating, int members) {
        this.anime_id = anime_id;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.members = members;
    }

}
