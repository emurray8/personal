/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author emurr_000
 */

public class BlamazonRewards {
    private BufferedReader reader = new BufferedReader(new FileReader("Customers.txt"));
    public static void main(String[] args) throws IOException{
        new BlamazonRewards();

    }
    public BlamazonRewards() throws IOException{
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        Heap<Integer> heap = new Heap<Integer>();
        //read the text file into string, delimited with a ;
        String s = "";
        String whole = "";
        while((s = reader.readLine()) != null){
        whole += s + ";";

        }
        //split each set of name, money, years, and registration into a string array
        String[] directory = whole.split(";");
        //make a 2d array of the last array that allows selecting each individual piece of data from the each set
        String[][] infoDirect = new String[directory.length][];
        for(int i = 0; i < directory.length; i++){
            infoDirect[i] = directory[i].split(",");
        }
        //removes useless space character for parsing
        for(int i = 0; i < infoDirect.length; i++){
            infoDirect[i][1] = infoDirect[i][1].substring(1);
            infoDirect[i][2] = infoDirect[i][2].substring(1);
            infoDirect[i][3] = infoDirect[i][3].substring(1);
        }
        //places name and priority number of each person into a hashmap
        for(int i = 0; i < infoDirect.length; i++) {
                Customer c = new Customer(infoDirect[i][0], Integer.parseInt(infoDirect[i][1]), Integer.parseInt(infoDirect[i][2]), Integer.parseInt(infoDirect[i][3]));
                c.setPriority();
               hmap.put(c.getPriority(), c.getName());
        }
        //inserts entries of hashmap into heap
        for (HashMap.Entry<Integer, String> entry : hmap.entrySet()) {
            
            heap.insert(entry.getKey());
        }
        //use the heap to get the largest priority numbers
        int[] largest = new int[5];
        largest[0] = heap.peekTop();
        heap.removeTop();        
        largest[1] = heap.peekTop();
        heap.removeTop();
        largest[2] = heap.peekTop();
        heap.removeTop();
        largest[3] = heap.peekTop();
        heap.removeTop();
        largest[4] = heap.peekTop();
        //print data
        for(int i = 0; i < largest.length; i++){
            System.out.println("#" + (i+1) + " " + hmap.get(largest[i]) + " " + Integer.toString(largest[i]));
        }
    }
    private class Customer{
        private String name = "";
        private int money = 0;
        private int years = 0;
        private int registered = 0;
        private int priorityNum = 0;
        public Customer(String n, int m, int y, int r){
            name = n;
            money = m;
            years = y;
            registered = r;
            
        }
        public String getName(){
            return name;
        }
        public int getPriority(){
            return priorityNum;
        }
        public void setPriority(){
            priorityNum = (money / 1000) + years - registered;
        }

        
    }
}




