package ru.ashukhardin.kinoteka;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private Movie movie;
    private static ApiInterface kinoapi;
    String token ="8NM326T-N1F4YK5-J644Y4B-94E73RB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.main_search_field);
        searchResult = findViewById(R.id.tV_search_result);
        searchButton = findViewById(R.id.button_main_search);


        kinoapi = RetrofitFactory.getRetrofit();


        Call<Movie> call = kinoapi.getMovie("5%20%D1%8D%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Log.d("123", "IN QUERY " + response.code() + response.body().getDocs());

                Movie list = response.body();
                searchResult.append(list.getDocs().get(0).getName()+ "\n");
                searchResult.append(list.getDocs().get(0).getYear()+ "\n");
                searchResult.append(list.getDocs().get(0).getGenres().get(1).getName() + "\n");
                searchResult.append(list.getDocs().get(0).getId() + "\n");
                //searchResult.setText(response.body().);
               // Log.d("123", list);

            }



            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                searchResult.setText("Ошибка");
            }
        });
    }
       // View.OnClickListener onClickListener = new View.OnClickListener() {
           /* @Override
            public void onClick(View v) {
                kinoapi = RetrofitFactory.getRetrofit();
                searchResult.setText("Ответ");
                kinoapi.getMovie(token,"Малышка на миллион").enqueue(new Callback<ru.ashukhardin.kinoteka.utils.Movie>() {
                    @Override
                    public void onResponse(Call<ru.ashukhardin.kinoteka.utils.Movie> call, Response<ru.ashukhardin.kinoteka.utils.Movie> response) {
                        searchResult.setText("Ответ"+response.body().getYear());
                    }
                    @Override
                    public void onFailure(Call<ru.ashukhardin.kinoteka.utils.Movie> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
                //searchResult.setText(kinoapi.);
            }*/
       // };
     // searchButton.setOnClickListener(onClickListener);



    public void onSerialClick(View view) {
        Intent intent = new Intent(MainActivity.this, SerialActivity.class);
        startActivity(intent);

    }

    public void onFilmClick(View view) {
        Intent intent = new Intent(MainActivity.this, FilmActivity.class);
        startActivity(intent);
    }

    public void onSearchClick(View view) {

    }

}