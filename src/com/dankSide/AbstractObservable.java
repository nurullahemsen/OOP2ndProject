package com.dankSide;

import java.util.ArrayList;
import java.util.List;

public abstract  class AbstractObservable {

    private List<Observer> obs = new ArrayList<Observer>();

    /**
     * Adds an observer object to obs list.
     *
     */
    public synchronized void addObserver(Observer element) {
        if (!obs.contains(element)) {
            obs.add(element);
        }
    }

    public synchronized void deleteObserver(Observer o) {
        obs.remove(o);
    } //Deletes an observer object from the list if needed.

    public abstract void notifyObservers(); // Needed to notify all observers.


    public synchronized void deleteObservers() {
        obs.clear();
    } //Delete all observers.

    public List<Observer> getObs() {
        return obs;
    }
}
