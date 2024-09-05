package Assignments.Strings;

import java.util.Scanner;

public class maximuninstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n =sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextLine();
        }
        int k =0;
        int max = Integer.parseInt(arr[0]);
        for(int i =1;i<n;i++){
            if(Integer.parseInt(arr[i])>max){
                max = Integer.parseInt(arr[i]);
                k = i;
            }
        }
        System.out.print(arr[k]);


    }
}


























// package Assignments.Strings;

// import java.util.Scanner;

// public class maximuninstring {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter n: ");
//         int n = sc.nextInt();
//         sc.nextLine(); // Consume the newline character after the integer input
//         String[] arr = new String[n];
        
//         // Read the strings from the user
//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter string " + (i + 1) + ": ");
//             arr[i] = sc.nextLine();
//         }
        
//         // Initialize max with the first element parsed as an integer
//         int k = 0;
//         int max = Integer.parseInt(arr[0]);
        
//         // Find the maximum integer value in the array
//         for (int i = 1; i < n; i++) {
//             int current = Integer.parseInt(arr[i]);
//             if (current > max) {
//                 max = current;
//                 k = i;
//             }
//         }
        
//         // Print the string with the maximum integer value
//         System.out.println("The string with the maximum integer value is: " + arr[k]);
//     }
// }
