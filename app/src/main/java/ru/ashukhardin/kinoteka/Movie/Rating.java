
package ru.ashukhardin.kinoteka.Movie;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Rating {

    @SerializedName("kp")
    @Expose
    private Double kp;
    @SerializedName("imdb")
    @Expose
    private Double imdb;
    @SerializedName("filmCritics")
    @Expose
    private Double filmCritics;
    @SerializedName("russianFilmCritics")
    @Expose
    private Integer russianFilmCritics;
    @SerializedName("await")
    @Expose
    private Object await;

    public Double getKp() {
        return kp;
    }

    public void setKp(Double kp) {
        this.kp = kp;
    }

    public Double getImdb() {
        return imdb;
    }

    public void setImdb(Double imdb) {
        this.imdb = imdb;
    }

    public Double getFilmCritics() {
        return filmCritics;
    }

    public void setFilmCritics(Double filmCritics) {
        this.filmCritics = filmCritics;
    }

    public Integer getRussianFilmCritics() {
        return russianFilmCritics;
    }

    public void setRussianFilmCritics(Integer russianFilmCritics) {
        this.russianFilmCritics = russianFilmCritics;
    }

    public Object getAwait() {
        return await;
    }

    public void setAwait(Object await) {
        this.await = await;
    }

}
