package OOPS.Lec_Four;

public class a {
    private int num; // we cant get the value of num in other  files so we will use the concept of getters and setters.
    // if we dont use any public private etc tho humm issko same package main access kar sakte hain but outside the package no no no!!
    String name;
    int[] arr;


    //getter function
    public int getNum(){
        return num;
    }
    public a(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
    
    
}
