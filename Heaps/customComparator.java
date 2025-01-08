package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    int rno;
    double perc;
    String name;
    Student(int rno, double perc, String name) {
        this.rno = rno;
        this.perc = perc;
        this.name = name;
    }
    public int compareTo(Student s){
        return this.rno - s.rno;
    }

}

public class customComparator {
    public static void print(Student[] arr){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i].name+" ");
            System.out.print(arr[i].rno+" ");
            System.out.println(arr[i].perc+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Student[] s = new Student[4];
        s[0] = new Student(2026, 8.88, "Jatin");
        s[1] = new Student(2052, 7.5, "Radhu");
        s[2] = new Student(2017, 8, "Ishaan");
        s[3] = new Student(0746, 7.8, "Aadi");
        print(s);
        Arrays.sort(s);
        print(s);
    }
    public int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele  : arr){
            pq.add(ele);
        }
        int cost = 0;
        while(!pq.isEmpty()){
            cost+=pq.remove();
        }
        return cost;
        
    }
}
