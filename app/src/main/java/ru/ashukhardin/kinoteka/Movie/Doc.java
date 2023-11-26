
package ru.ashukhardin.kinoteka.Movie;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Doc {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alternativeName")
    @Expose
    private String alternativeName;
    @SerializedName("enName")
    @Expose
    private String enName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("movieLength")
    @Expose
    private Integer movieLength;
    @SerializedName("isSeries")
    @Expose
    private Boolean isSeries;
    @SerializedName("ticketsOnSale")
    @Expose
    private Boolean ticketsOnSale;
    @SerializedName("totalSeriesLength")
    @Expose
    private Object totalSeriesLength;
    @SerializedName("seriesLength")
    @Expose
    private Object seriesLength;
    @SerializedName("ratingMpaa")
    @Expose
    private String ratingMpaa;
    @SerializedName("ageRating")
    @Expose
    private Integer ageRating;
    @SerializedName("top10")
    @Expose
    private Object top10;
    @SerializedName("top250")
    @Expose
    private Integer top250;
    @SerializedName("typeNumber")
    @Expose
    private Integer typeNumber;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("names")
    @Expose
    private List<Name> names;
    @SerializedName("logo")
    @Expose
    private Logo logo;
    @SerializedName("poster")
    @Expose
    private Poster poster;
    @SerializedName("backdrop")
    @Expose
    private Backdrop backdrop;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("votes")
    @Expose
    private Votes votes;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres;
    @SerializedName("countries")
    @Expose
    private List<Country> countries;
    @SerializedName("releaseYears")
    @Expose
    private List<Object> releaseYears;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public Boolean getIsSeries() {
        return isSeries;
    }

    public void setIsSeries(Boolean isSeries) {
        this.isSeries = isSeries;
    }

    public Boolean getTicketsOnSale() {
        return ticketsOnSale;
    }

    public void setTicketsOnSale(Boolean ticketsOnSale) {
        this.ticketsOnSale = ticketsOnSale;
    }

    public Object getTotalSeriesLength() {
        return totalSeriesLength;
    }

    public void setTotalSeriesLength(Object totalSeriesLength) {
        this.totalSeriesLength = totalSeriesLength;
    }

    public Object getSeriesLength() {
        return seriesLength;
    }

    public void setSeriesLength(Object seriesLength) {
        this.seriesLength = seriesLength;
    }

    public String getRatingMpaa() {
        return ratingMpaa;
    }

    public void setRatingMpaa(String ratingMpaa) {
        this.ratingMpaa = ratingMpaa;
    }

    public Integer getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(Integer ageRating) {
        this.ageRating = ageRating;
    }

    public Object getTop10() {
        return top10;
    }

    public void setTop10(Object top10) {
        this.top10 = top10;
    }

    public Integer getTop250() {
        return top250;
    }

    public void setTop250(Integer top250) {
        this.top250 = top250;
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    public Backdrop getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(Backdrop backdrop) {
        this.backdrop = backdrop;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Votes getVotes() {
        return votes;
    }

    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Object> getReleaseYears() {
        return releaseYears;
    }

    public void setReleaseYears(List<Object> releaseYears) {
        this.releaseYears = releaseYears;
    }

}
