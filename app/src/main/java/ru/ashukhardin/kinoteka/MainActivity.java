package ru.ashukhardin.kinoteka;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.ashukhardin.kinoteka.Movie.Movie;
import ru.ashukhardin.kinoteka.utils.ApiInterface;
import ru.ashukhardin.kinoteka.utils.RetrofitFactory;

public class MainActivity extends AppCompatActivity {

    private EditText searchField;
    private TextView searchResult;
    private Button searchButton;
    private ImageView posterImg;
    private Movie movie;
    private Button addMovieButton;

    private static ApiInterface kinoapi;
    String token ="8NM326T-N1F4YK5-J644Y4B-94E73RB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.main_search_field);
        //searchResult = findViewById(R.id.tV_search_result);
        searchButton = findViewById(R.id.button_main_search);
        addMovieButton = findViewById(R.id.bt_addMovieMain);
        //posterImg = findViewById(R.id.poster);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinoapi = RetrofitFactory.getRetrofit();
                Call<Movie> call = kinoapi.getMovie(String.valueOf(searchField.getText()));
                call.enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        Log.d("123", "IN QUERY " + response.code() + response.body().getDocs());

                        movie = response.body();
                        searchResult.append(movie.getDocs().get(0).getName()+ "\n");
                        searchResult.append(movie.getDocs().get(0).getYear()+ "\n");
                        searchResult.append(movie.getDocs().get(0).getGenres().get(1).getName() + "\n");
                        searchResult.append(movie.getDocs().get(0).getId() + "\n");
                        searchResult.append(movie.getDocs().get(0).getPoster().getUrl() + "\n");

                        Picasso.with(MainActivity.this)
                                .load(movie.getDocs().get(0).getPoster().getUrl())
                                .placeholder(R.drawable.poster_placeholder)
                                .error(R.drawable.poster_error)
                                .into(posterImg);
                        Intent intent = new Intent(MainActivity.this, FilmItemActivity.class);
                        intent.putExtra("action", "search");
                        intent.putExtra("poster",movie.getDocs().get(0).getPoster().getUrl() );
                        intent.putExtra("logo",movie.getDocs().get(0).getLogo().getUrl() );
                        intent.putExtra("movie_id",movie.getDocs().get(0).getId());
                        intent.putExtra("name",movie.getDocs().get(0).getName());
                        intent.putExtra("genre",movie.getDocs().get(0).getGenres().get(0).getName());
                        intent.putExtra("year",movie.getDocs().get(0).getYear());
                        intent.putExtra("desc",movie.getDocs().get(0).getDescription());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        searchButton.setOnClickListener(onClickListener);
    }

    public void onFilmClick(View view) {
        Intent intent = new Intent(MainActivity.this, FilmActivity.class);
        startActivity(intent);
    }

    public void onKPButtonClick(View view) {
        openWebPage("https://www.kinopoisk.ru/");
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void onAddMovieClick(View view) {
        Intent intent = new Intent(MainActivity.this, FilmItemActivity.class);
        intent.putExtra("action", "add" );
        startActivity(intent);
    }
}