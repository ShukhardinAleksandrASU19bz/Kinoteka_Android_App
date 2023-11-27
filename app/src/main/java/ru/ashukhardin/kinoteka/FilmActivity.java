package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ru.ashukhardin.kinoteka.utils.RV_adapter;

public class FilmActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private RV_adapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        movieList = findViewById(R.id.recyclerView_movie);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(layoutManager);
        movieList.setHasFixedSize(true); // фиксированный размер для улучшения быстродействия

        movieAdapter = new RV_adapter(100,this);
        movieList.setAdapter(movieAdapter);

    }
}