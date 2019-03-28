package edu.css.roomdatabaseplanets;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PlanetDAO {

    @Insert
    void insert(Planet planet);

    @Query("DELETE FROM planet_table")
    void deleteAll();

    @Query("SELECT * from planet_table ORDER BY planet_id ASC")
    LiveData<List<Planet>> getAllPlanets();

    @Query("SELECT * FROM planet_table WHERE planet_name = :planetName")
    LiveData<List<Planet>> findPlanetByName(String planetName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertPlanet(Planet... planet);

    @Update
    void update(Planet planet);

    @Delete
    void delete(Planet planet);
}

