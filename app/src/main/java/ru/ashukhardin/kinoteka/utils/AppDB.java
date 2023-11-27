package ru.ashukhardin.kinoteka.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.ashukhardin.kinoteka.movie;

@Database(entities = {movie.class},version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract MovieDBInterface movieDBInterface();
}
