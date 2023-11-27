package ru.ashukhardin.kinoteka.utils;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.ashukhardin.kinoteka.movie;

@Dao
public interface MovieDBInterface {
    @Insert
    void insert(movie item);

    @Delete
    void delete(movie item);

    @Update
    void update(movie item);
    @Query("SELECT * FROM 'movie'")
    List<movie> getAll();

    @Query("SELECT * FROM 'movie' where id IN (:id)")
    movie getmovieById(int id);
}
