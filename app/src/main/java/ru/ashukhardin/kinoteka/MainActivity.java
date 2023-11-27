package ru.ashukhardin.kinoteka;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
    private Button serialButton;

    private static ApiInterface kinoapi;
    String token ="8NM326T-N1F4YK5-J644Y4B-94E73RB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.main_search_field);
        searchResult = findViewById(R.id.tV_search_result);
        searchButton = findViewById(R.id.button_main_search);
        posterImg = findViewById(R.id.poster);

        serialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;
                Intent serialActivitiIntent = new Intent(context,SerialActivity.class);
                startActivity(serialActivitiIntent);
                // startActivityForResult();
            }
        });

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
                        Intent intent = new Intent(MainActivity.this, film_item.class);
                        intent.putExtra("logo",movie.getDocs().get(0).getLogo().getUrl() );
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

   /*
    public void onSerialClick(View view) {
        Intent intent = new Intent(MainActivity.this, SerialActivity.class);
        startActivity(intent);

    }*/

    public void onFilmClick(View view) {
        Intent intent = new Intent(MainActivity.this, FilmActivity.class);
        startActivity(intent);
    }

    public void onSearchClick(View view) {

    }

}