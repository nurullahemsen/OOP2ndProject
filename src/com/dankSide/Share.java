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

    public void setPrice(int price) {
        if(this.price != price){
            this.price = price;
            notifyObservers();
            try {
                Main.printTextAndStdout("\n","file.txt");
                }catch (FileNotFoundException e){
                e.getMessage();
                }
        }
    }

    public void updateShare(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int negORpos = 1;
                Random r = new Random();
                int timeCounter = 0;
                while(timeCounter < 10000){
                    int time = r.nextInt(1000);
                    Main.wait(time);
                    timeCounter += time;
                    if(r.nextDouble() <0.3){
//                        String s = String.format("time: %3d ms",timeCounter);
//                        try {
//                            Main.printTextAndStdout(s,"file.txt");
//                        }catch (FileNotFoundException e){
//                            e.getMessage();
//                        }
                        setPrice(getPrice() + negORpos*r.nextInt(3));
                        negORpos *= -1;
                    }
                }

            }
        });
        t.start();
    }
}
