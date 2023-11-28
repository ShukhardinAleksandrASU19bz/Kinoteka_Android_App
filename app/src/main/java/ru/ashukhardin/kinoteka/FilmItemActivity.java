package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.ashukhardin.kinoteka.utils.App;
import ru.ashukhardin.kinoteka.utils.AppDB;
import ru.ashukhardin.kinoteka.utils.MovieDBInterface;

public class FilmItemActivity extends AppCompatActivity {

    private ImageView logoImg;
    private  ImageView posterImg;
    private String logoUrl = null;
    private String posterUrl = null;
    private int movie_id;
    private String name;
    private  String description;
    private  String genre;
    private  int year;
    private TextView nameTextview;
    private TextView genreTextview;
    private TextView yearTextview;
    private TextView descTextview;
    private MovieDBInterface movieDBInterface;
    private Intent mainActIntent;
     private Button kp_aboutButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_item);


        kp_aboutButton = findViewById(R.id.kp_about_button);
        logoImg = findViewById(R.id.IV_logo);
        nameTextview = findViewById(R.id.tV_movieName);
        genreTextview = findViewById(R.id.tV_genre);
        yearTextview = findViewById(R.id.tV_year);
        descTextview = findViewById(R.id.tV_description);
        posterImg = findViewById(R.id.iV_poster);

        mainActIntent = getIntent();
        /*if (mainActIntent.hasExtra("")) {
            String someText = mainActIntent.getStringExtra("");
        }*/
        if (mainActIntent.getStringExtra("action").equals("search")) {

            nameTextview.setFocusable(false);
            nameTextview.setFocusableInTouchMode(false);
            nameTextview.setClickable(false);
            genreTextview.setFocusable(false);
            genreTextview.setFocusableInTouchMode(false);
            genreTextview.setClickable(false);
            yearTextview.setFocusable(false);
            yearTextview.setFocusableInTouchMode(false);
            yearTextview.setClickable(false);
            descTextview.setFocusable(false);
            descTextview.setFocusableInTouchMode(false);
            descTextview.setClickable(false);

            posterUrl = getIntent().getStringExtra("poster");
            movie_id = getIntent().getExtras().getInt("movie_id");
            logoUrl = getIntent().getExtras().getString("logo");
            name = getIntent().getStringExtra("name");
            description = getIntent().getStringExtra("desc");
            genre = getIntent().getStringExtra("genre");
            year = getIntent().getExtras().getInt("year");

            descTextview.setText("Описание:" + description);
            yearTextview.setText("Год: " + year);
            genreTextview.setText("Жанр: " + genre);
            nameTextview.setText("Название: " + name);

            Picasso.with(FilmItemActivity.this)
                    .load(logoUrl)
                    .placeholder(R.drawable.poster_placeholder)
                    .error(R.drawable.poster_error)
                    .into(logoImg);

            Picasso.with(FilmItemActivity.this)
                    .load(posterUrl)
                    .placeholder(R.drawable.poster_placeholder)
                    .error(R.drawable.poster_error)
                    .into(posterImg);

            movieDBInterface = App.getInstance().getDatabase().movieDBInterface();
        } else if (mainActIntent.getStringExtra("action").equals("add")) {
            kp_aboutButton.setClickable(false);
            kp_aboutButton.setVisibility(View.INVISIBLE);
            descTextview.setHint("Введите описание");
            yearTextview.setHint("Введите Год: ");
            genreTextview.setHint("Введите Жанр: ");
            nameTextview.setHint("Ввведите Название: ");

            name = String.valueOf(nameTextview.getText());
            description = String.valueOf(descTextview.getText());
            genre = String.valueOf(genreTextview.getText());
            //year =Integer.parseInt(String.valueOf(yearTextview.getText()));
        }

    }

    public void onKpAboutButtonClick(View view) {
        openWebPage("https://www.kinopoisk.ru/film/" + movie_id);
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onAddColClick(View view) {
        movie newItem = new movie();
        newItem.setName(name);
        newItem.setDescription(description);
        newItem.setGenre(genre);
        newItem.setYear(year);
        newItem.setKp_id(movie_id);
        newItem.setPoster(posterUrl);
        movieDBInterface.insert(newItem);
    }
}