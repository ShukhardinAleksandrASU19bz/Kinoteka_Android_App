package ru.ashukhardin.kinoteka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class film_item extends AppCompatActivity {

    private ImageView logoImg;
    private String logoUrl=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_item);

        logoImg = findViewById(R.id.IV_logo);

        logoUrl = getIntent().getExtras().getString("logo");
        Picasso.with(film_item.this)
                .load(logoUrl)
                .placeholder(R.drawable.poster_placeholder)
                .error(R.drawable.poster_error)
                .into(logoImg);
    }
}