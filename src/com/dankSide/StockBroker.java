package com.dankSide;

import java.io.FileNotFoundException;

public class StockBroker implements Observer {
    private String name;

    public StockBroker(String name) {
        this.name = name;
    }

    @Override
    public void update(AbstractObservable element){

        String s = String.format("%s is updated on %s",name,element);

        try {
            Main.printTextAndStdout(s,"sonuçlar.txt");
        }catch (FileNotFoundException e){
            e.getMessage();
        }

    }
}
