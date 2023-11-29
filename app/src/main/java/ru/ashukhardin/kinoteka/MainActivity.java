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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private RadioGroup radioGroup;
    private RadioButton radioButtonName;
    private RadioButton radioButtonId;
    private RadioButton radioButtonRandom;
    private  Call<Movie> call;
    private int searchParam;

    private static ApiInterface kinoapi;
    String token ="8NM326T-N1F4YK5-J644Y4B-94E73RB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.main_search_field);
        searchButton = findViewById(R.id.button_main_search);
        addMovieButton = findViewById(R.id.bt_addMovieMain);
        radioGroup = findViewById(R.id.rg_MA_searchRadioGroup);

        //radioButtonName = findViewById(R.id.radio_name);
        //radioButtonId = findViewById(R.id.radio_id);
        //radioButtonRandom = findViewById(R.id.radio_random);
        searchParam =1;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio = findViewById(checkedId);
                switch (String.valueOf(radio.getText())) {

                    case "По названию":
                        searchParam =1;
                        break;
                    case "По Id":
                        searchParam =2;
                        break;
                    case "Случайный":
                        searchParam =3;
                        break;

                    default:
                        break;
                }
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kinoapi = RetrofitFactory.getRetrofit();
                switch (searchParam) {
                    case 1:
                        call = kinoapi.getMovieName(String.valueOf(searchField.getText()));
                        break;
                    case 2:
                        call = kinoapi.getMovieId(Integer.parseInt(String.valueOf(searchField.getText())));
                        break;
                    case 3:
                        call = kinoapi.getMovieRandom();
                        break;
                    default:
                        break;
                }
                call.enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        Log.d("123", "IN QUERY " + response.code() + response.body().getDocs());

                        movie = response.body();
                        if (movie.getDocs().get(0).getName() == "") {
                            Toast.makeText(getApplicationContext(), "Фильм не найден",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(MainActivity.this, FilmItemActivity.class);
                            intent.putExtra("action", "search");
                            intent.putExtra("poster", movie.getDocs().get(0).getPoster().getUrl());
                            intent.putExtra("logo", movie.getDocs().get(0).getLogo().getUrl());
                            intent.putExtra("movie_id", movie.getDocs().get(0).getId());
                            intent.putExtra("name", movie.getDocs().get(0).getName());
                            intent.putExtra("genre", movie.getDocs().get(0).getGenres().get(0).getName());
                            intent.putExtra("year", movie.getDocs().get(0).getYear());
                            intent.putExtra("desc", movie.getDocs().get(0).getDescription());
                            startActivity(intent);
                        }
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