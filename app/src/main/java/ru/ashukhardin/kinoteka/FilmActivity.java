package ru.ashukhardin.kinoteka;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.PrimaryKey;
import androidx.room.Room;

import android.content.Intent;
import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import ru.ashukhardin.kinoteka.utils.AppDB;
import ru.ashukhardin.kinoteka.utils.MovieDBInterface;
import ru.ashukhardin.kinoteka.utils.RV_adapter;

public class FilmActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private RV_adapter movieAdapter;
    private String nameDB="movie_database";
    private Button addButton;
    private List<movie> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        movieList = findViewById(R.id.recyclerView_movie);

        addButton = findViewById(R.id.bt_FA_add);


        AppDB appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,nameDB)
                .allowMainThreadQueries()
                .build();
        MovieDBInterface movieDBInterface = appDB.movieDBInterface();
        list = movieDBInterface.getAll();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(layoutManager);
        movieList.setHasFixedSize(true); // фиксированный размер для улучшения быстродействия

        movieAdapter = new RV_adapter(list,this);
        movieList.setAdapter(movieAdapter);

    }

    public void onAddButtonClick(View view) {
        Intent intent = new Intent(FilmActivity.this, MovieAddActivity.class);
        //startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}