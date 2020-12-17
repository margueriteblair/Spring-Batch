package com.springbatch.completed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animes")
public class Anime {

    @Id
    private String anime_id;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private double rating;
    private int members;

    public Anime() {}

    public Anime(String anime_id, String name, String genre, String type, int episodes, double rating, int members) {
        this.anime_id = anime_id;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.members = members;
    }


    public String getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(String anime_id) {
        this.anime_id = anime_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Anime{");
        sb.append("id=").append(anime_id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", episodes='").append(episodes).append('\'');
        sb.append(", ratings='").append(rating).append('\'');
        sb.append(", members='").append(members).append('\'');
        sb.append("}");
        return sb.toString();
    }


}
