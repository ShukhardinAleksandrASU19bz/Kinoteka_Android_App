package ru.ashukhardin.kinoteka.utils;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.room.Room;

public class App  extends Application {
    public static App instance;
    private AppDB database;
    private String nameDB="movie_database";
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        database = Room.databaseBuilder(this,AppDB.class,nameDB).allowMainThreadQueries().build();
    }
    public static App getInstance(){
        return instance;
    }
    public AppDB getDatabase(){
        return database;
    }

}
