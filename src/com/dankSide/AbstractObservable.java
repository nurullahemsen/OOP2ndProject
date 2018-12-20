package com.dankSide;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractObservable {

    private List<Observer> obs = new ArrayList<Observer>();

    public synchronized void addObserver(Observer element) {
        if (!obs.contains(element)) {
            obs.add(element);
        }
    }

    public synchronized void deleteObserver(Observer o) {
        obs.remove(o);
    }

    public abstract  void notifyObservers();


    public synchronized void deleteObservers() {
        obs.clear();
    }

    public List<Observer> getObs() {
        return obs;
    }
}
