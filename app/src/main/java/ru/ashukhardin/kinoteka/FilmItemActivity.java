package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    private String nameDB="movie_database";
    private TextView nameTextview;
    private TextView genreTextview;
    private TextView yearTextview;
    private TextView descTextview;
    private MovieDBInterface movieDBInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_item);

        logoImg = findViewById(R.id.IV_logo);
        nameTextview = findViewById(R.id.tV_movieName);
        genreTextview = findViewById(R.id.tV_genre);
        yearTextview = findViewById(R.id.tV_year);
        descTextview = findViewById(R.id.tV_description);
        posterImg = findViewById(R.id.iV_poster);



        /*
        Intent mainActIntent = getIntent();
        if (mainActIntent.hasExtra("")) {
            String someText = mainActIntent.getStringExtra("");
        }*/
        posterUrl = getIntent().getStringExtra("poster");
        movie_id = getIntent().getExtras().getInt("movie_id");
        logoUrl = getIntent().getExtras().getString("logo");
        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("desc");
        genre = getIntent().getStringExtra("genre") ;
        year = getIntent().getExtras().getInt("year");

        descTextview.setText("Описание:" + description);
        yearTextview.setText("Год: " + year);
        genreTextview.setText("Жанр: "+genre);
        nameTextview.setText("Название: "+ name);



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

        AppDB appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,nameDB)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        movieDBInterface = appDB.movieDBInterface();
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