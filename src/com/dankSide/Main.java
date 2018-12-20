package com.dankSide;

import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        init();

    }
    public static void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            e.getMessage();
        }
    }

    public static void printTextAndStdout(String print, String fileName) throws FileNotFoundException{
        PrintStream ps_console = System.out;

        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file,true);

        // Create new print stream for file.
        PrintStream ps = new PrintStream(fos);

        // Set output to text file
        System.setOut(ps);
        System.out.println(print);

        // Set console print stream.
        System.setOut(ps_console);
        System.out.println(print);
    }
    public static void clearFile() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("file.txt");
        pw.close();
    }
    public static void init() throws FileNotFoundException{


        clearFile();


        StockBroker erich = new StockBroker("Erich Ludendorff");
        StockBroker arthur = new StockBroker("Arthur Curry");
        StockBroker paul = new StockBroker("Paul von Hindenburg");
        StockBroker john = new StockBroker("John Monash");
        StockBroker douglas = new StockBroker("Douglas Haig");
        StockBroker conrad = new StockBroker("Conrad von Hotzendorf");
        StockBroker ferdinand = new StockBroker("Ferdinand Foch");
        StockBroker philippe = new StockBroker("Philippe Pétain");
        StockBroker enver = new StockBroker("Enver Pasha");


        Share UK = new Share("British war bonds",35);
        UK.addObserver(arthur);
        UK.addObserver(john);
        UK.addObserver(douglas);
        UK.addObserver(philippe);
        Share France = new Share("French war bonds",25);
        France.addObserver(philippe);
        France.addObserver(ferdinand);
        France.addObserver(arthur);
        Share Germany = new Share("German war bonds",40);
        Germany.addObserver(erich);
        Germany.addObserver(paul);
        Germany.addObserver(enver);
        Germany.addObserver(conrad);
        Germany.addObserver(philippe);
        Share AustriaHungary = new Share("Austrian war bonds",15);
        AustriaHungary.addObserver(conrad);
        AustriaHungary.addObserver(erich);
        Share OttomanEmpire = new Share("Turkish war bonds",10);
        OttomanEmpire.addObserver(paul);
        OttomanEmpire.addObserver(enver);



        UK.updateShare();
        France.updateShare();
        Germany.updateShare();
        AustriaHungary.updateShare();
        OttomanEmpire.updateShare();

    }
}
