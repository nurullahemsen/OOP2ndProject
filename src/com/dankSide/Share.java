package com.dankSide;

import java.io.FileNotFoundException;
import java.util.Random;

public class Share extends AbstractObservable {
    private String companyName;
    private int price;

    public Share(String name, int price){
        this.companyName = name;
        this.price = price;

    }

    /**
     * Synchronized method, only one can execute in a multiple thread environment at one given moment.
     * It calls update method of all the obeservers
     */
    @Override
    public synchronized void notifyObservers() {
        for(Observer observer : super.getObs()){
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "" + companyName + " currently at "  + price + "$";
    }

    public int getPrice() {
        return price;
    }

    /**
     * This method updates the price and notify all observers observing it.
     * @param price price of the Share, integer
     */
    public void setPrice(int price) {
        if(this.price != price){
            this.price = price;
            notifyObservers();
            try {
                Main.printTextAndStdout("\n","sonuçlar.txt");
                }catch (FileNotFoundException e){
                e.getMessage();
                }
        }
    }

    /**
     * This methods updates each share independently using threads.
     * First it creates a thread with an unnamed Runnable object.
     * Inside the Runnable object a run method is implemented.
     * In the thread an object has 30% probabiliy to update in every time sequence.
     * A time sequence is randomly selected milliseconds which extends from 0 ms to 1000 ms.
     * At each update the absolute update multiplier is multiplied with (-1) in order to price to go up or down concurrently.
     * The method finishes with starting the thread.
     */
    public void updateShare(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int multiplier = 1;
                Random r = new Random();
                int timeCounter = 0;
                while(timeCounter < 10000){
                    int time = r.nextInt(1000);
                    Main.wait(time);
                    timeCounter += time;
                    if(r.nextDouble() <0.3){
                        setPrice(getPrice() + multiplier*r.nextInt(3));
                        multiplier *= -1;
                    }
                }
            }
        });
        t.start();
    }
}
