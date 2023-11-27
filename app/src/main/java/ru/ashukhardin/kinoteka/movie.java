package ru.ashukhardin.kinoteka;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class movie {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private Integer year;
    private Integer kp_id;
    private String description;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setKp_id(Integer kp_id) {
        this.kp_id = kp_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String poster;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getKp_id() {
        return kp_id;
    }

    public String getDescription() {
        return description;
    }

    public String getPoster() {
        return poster;
    }

    public String getGenre() {
        return genre;
    }

    private String genre;


    public movie (){

    }

    public movie(Integer id, String name, Integer year, Integer kp_id, String description, String poster, String genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.kp_id = kp_id;
        this.description = description;
        this.poster = poster;
        this.genre = genre;
    }
    public movie(String name) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.kp_id = kp_id;
        this.description = description;
        this.poster = poster;
        this.genre = genre;
    }

}
