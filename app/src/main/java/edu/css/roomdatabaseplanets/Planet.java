package edu.css.roomdatabaseplanets;

import android.arch.persistence.room.ColumnInfo;

import android.arch.persistence.room.Entity;

import android.arch.persistence.room.PrimaryKey;

import android.support.annotation.NonNull;

@Entity(tableName = "planet_table")
public class Planet {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "planet_id")
    private Long id; //the primary key in the database

    @NonNull
    @ColumnInfo(name = "planet_name")
    private String name;        // planet name

    @ColumnInfo(name = "planet_gravity")
    private Float gravity;      // gravity value on this planet's surface

    /**
     * Constructor
     * @param name the planet name
     * @param gravity the planet's gravity
     */
    public Planet(String name, Float gravity) {
        this.id = null;
        this.name = name;
        this.gravity = gravity;
    }

    /**
     * Returns the id of the planet
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the gravity of the planet
     * @return
     */
    public Float getGravity() {
        return gravity;
    }

    /**
     * Changes the gravity of the planet
     * @param gravity the new gravity
     */
    public void setGravity(Float gravity) {
        this.gravity = gravity;
    }

    /**
     * Returns the name of the planet
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the planet
     * @param name the new planet name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string about the planet
     * @return
     */
    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", gravity=" + gravity +
                '}';
    }
}
