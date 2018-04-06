/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author evan
 */
public class Worker {
    private String file;
    public static void main(String args[]) throws IOException{
        new Worker().go(args);
    }
    public void go(String args[]) throws FileNotFoundException, IOException{
        file = args[0];
        Scanner in = new Scanner(System.in);
        List<Player> players = new ArrayList<>(); 
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null){
            String[] data = line.split(",");
            String name = data[0];
            double gamesPlayed = Double.parseDouble(data[1]);
            double homeRuns = Double.parseDouble(data[2]);
            double percentage = (homeRuns/gamesPlayed)*100;
            if(gamesPlayed > 300 && percentage > 5.5){
                players.add(new Player(name, gamesPlayed, percentage));
            }
            line = reader.readLine();

        }
        for(Player p : players){
            p.print();
        }
    }
    private class Player{
        String name;
        double games;
        double percentage;
        public Player(String n, double g, double p){
            name = n;
            games = g;
            percentage = p;
        }
        public void print(){
            System.out.printf("%s %s %s %s%.2f\n", "Found ", name, "with HR percentage: ", "%", percentage);
        }
    }
}