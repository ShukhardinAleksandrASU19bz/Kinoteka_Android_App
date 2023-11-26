
package ru.ashukhardin.kinoteka.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Backdrop {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

}
