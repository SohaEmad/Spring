package com.example.demo.hello;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class Greeting {

    private long id;
    private String content;
    private ArrayList<String> data = new ArrayList<>();

    public Greeting(){
      //  addall();

        data.add( "Client A");
        data.add( "Client B");
        data.add( "Client C");
        data.add("Client D");
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




  /*  public void addall() {
        for (int i = 0; i < 7; i++) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            data.add(generatedString);
        }
    }


    public  ArrayList getdata (){
        return data;
    }*/
}