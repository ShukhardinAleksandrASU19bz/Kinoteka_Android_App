package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.EditText;

import ru.ashukhardin.kinoteka.utils.AppDB;
import ru.ashukhardin.kinoteka.utils.MovieDBInterface;

public class MovieAddActivity extends AppCompatActivity {

    private String nameDB="movie_database";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_add);

        AppDB appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,nameDB)
                .allowMainThreadQueries()
                .build();
        MovieDBInterface movieDBInterface = appDB.movieDBInterface();

        EditText movieEditText = findViewById(R.id.ET_MAA_name);
    }
}