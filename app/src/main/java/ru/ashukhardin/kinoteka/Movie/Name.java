
package ru.ashukhardin.kinoteka.Movie;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Name {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("type")
    @Expose
    private Object type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

}
