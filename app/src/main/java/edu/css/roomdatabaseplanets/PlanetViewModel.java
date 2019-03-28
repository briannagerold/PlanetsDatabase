package edu.css.roomdatabaseplanets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class PlanetViewModel extends AndroidViewModel {
    private PlanetRepository mRepository;

    private LiveData<List<Planet>> mAllPlanet;

    public PlanetViewModel (Application application) {
        super(application);
        mRepository = new PlanetRepository(application);
        mAllPlanet = mRepository.getAllPlanets();
    }

    LiveData<List<Planet>> getAllWords() { return mAllPlanet; }

    public void insert(Planet planet) { mRepository.insert(planet);}
}
