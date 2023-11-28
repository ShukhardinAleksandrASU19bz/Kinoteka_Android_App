package ru.ashukhardin.kinoteka;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
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

import ru.ashukhardin.kinoteka.utils.App;
import ru.ashukhardin.kinoteka.utils.AppDB;
import ru.ashukhardin.kinoteka.utils.MovieDBInterface;
import ru.ashukhardin.kinoteka.utils.RV_adapter;

public class FilmActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private RV_adapter movieAdapter;
    private List<movie> list;
    private  MovieDBInterface movieDBInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        movieList = findViewById(R.id.recyclerView_movie);

        movieDBInterface = App.getInstance().getDatabase().movieDBInterface();
        list = movieDBInterface.getAll();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        movieList.setLayoutManager(layoutManager);
        movieList.setHasFixedSize(true); // фиксированный размер для улучшения быстродействия

        movieAdapter = new RV_adapter(list,this);
        movieList.setAdapter(movieAdapter);

        LiveData<List<movie>> liveData = movieDBInterface.getAllLive();
        liveData.observe(this, new Observer<List<movie>>() {
            @Override
            public void onChanged(List<movie> movieList) {
                list.clear();
                list.addAll(movieDBInterface.getAll());
                movieAdapter.notifyDataSetChanged();
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT
        | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                movie item = list.get(viewHolder.getAdapterPosition());
                movieDBInterface.delete(item);
            }
        }).attachToRecyclerView(movieList);

    }

}