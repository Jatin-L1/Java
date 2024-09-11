package Merge_Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class practice {
    // Define answer as an ArrayList of Integer
    static ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        int[] array = {80, 30, 50, 20, 60, 10, 70, 40};
        answer = new ArrayList<>();
        mergeSort(array); // Perform merge sort
        System.out.println(answer); // Print the answer
    }

    private static void merge(int[] arr, int[] brr, int[] ans) {
        int i = 0;
        int j = 0;
        int c = 0;

        while (i < arr.length && j < brr.length) {

            if (arr[i] > brr[j]) {
                ans[c] = brr[j];
                c++;
                j++;
            } else {
                ans[c] = arr[i]; 
                c++;
                i++;
            }
        }

        if (i == arr.length) {
            while (j < brr.length) {
                ans[c] = brr[j];
                c++;
                j++;
            }
        }
        if (j == brr.length) {
            while (i < arr.length) {
                ans[c] = arr[i];
                c++;
                i++;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> mergeSort(int[] arr) {
        int n = arr.length;
        // if (n > 1) {
        //     // Convert int[] to ArrayList<Integer> and add to the answer
        //     ArrayList<Integer> currentList = new ArrayList<>();
        //     for (int num : arr) {
        //         currentList.add(num); // Add each element to the current list
        //     }
        //     answer.add(currentList); // Add the current sorted array to answer
        // } else {
        //     return answer;
        // }
        if (n==1) {
            return answer;
        }

        // Splitting the array into two halves
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];

        for (int i = 0; i < n / 2; i++) {
            a[i] = arr[i];
        }
        for (int i = 0; i < n - n / 2; i++) {
            b[i] = arr[i + n / 2];
        }

        // Recursively call mergeSort on both halves
        mergeSort(a);
        mergeSort(b);

        // Merging both halves
        merge(a, b, arr);

      
        ArrayList<Integer> mergedList = new ArrayList<>();
        for (int num : arr) {
            mergedList.add(num); 
        }
        answer.add(mergedList);

        return answer;
    }
}
