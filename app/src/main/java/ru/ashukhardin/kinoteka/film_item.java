package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class film_item extends AppCompatActivity {

    private ImageView logoImg;
    private String logoUrl = null;
    private int movie_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_item);

        logoImg = findViewById(R.id.IV_logo);

        /*
        Intent mainActIntent = getIntent();
        if (mainActIntent.hasExtra("")) {
            String someText = mainActIntent.getStringExtra("");
        }*/
       // movie_id = getIntent().getExtras().getInt("movie)id");
        logoUrl = getIntent().getExtras().getString("logo");
        Picasso.with(film_item.this)
                .load(logoUrl)
                .placeholder(R.drawable.poster_placeholder)
                .error(R.drawable.poster_error)
                .into(logoImg);
    }

    /*public void onKpAboutButtonClick(View view) {
        openWebPage("https://www.kinopoisk.ru/" + movie_id);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

     */
}