package Assignments.Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class smallestmissing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // Sort the array to use binary search
        Arrays.sort(arr);

        int missingNumber = findMissing(arr, n);
        System.out.println("The smallest missing positive number is: " + missingNumber);

        sc.close();
    }

    private static int findMissing(int[] arr, int n) {
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == mid + 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo + 1;
    }
}
