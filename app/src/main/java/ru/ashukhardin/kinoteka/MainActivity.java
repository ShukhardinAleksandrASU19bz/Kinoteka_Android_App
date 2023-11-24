package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText searchField;
    private TextView searchResult;
    private Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchField = findViewById(R.id.main_search_field);
        searchResult = findViewById(R.id.tV_search_result);
        searchButton = findViewById(R.id.button_main_search);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchResult.setText("!!!!");
            }
        };

      searchButton.setOnClickListener(onClickListener);
    }

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