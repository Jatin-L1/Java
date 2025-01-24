import java.util.Scanner;

public class sumsfArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();  // Read the number of test cases
        
        // Iterate over test cases
        for (int x = 0; x < cases; x++) {
            int n = sc.nextInt();  // Size of the first array
            int m = sc.nextInt();  // Size of the second array
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            // Read the arrays
            for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
            for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

            // Initialize variables to store the sums and the result
            int sum1 = 0, sum2 = 0, result = 0;
            int i = 0, j = 0;

            // Process both arrays
            while (i < n && j < m) {
                if (arr1[i] < arr2[j]) {
                    sum1 += arr1[i];  // Add to sum1 if arr1[i] is smaller
                    i++;
                } else if (arr1[i] > arr2[j]) {
                    sum2 += arr2[j];  // Add to sum2 if arr1[i] is greater
                    j++;
                } else {
                    // If both elements are equal, take the max of sum1 and sum2 and add the common element
                    result += Math.max(sum1, sum2) + arr1[i];
                    sum1 = 0;  // Reset sum1 after switching
                    sum2 = 0;  // Reset sum2 after switching
                    i++;
                    j++;
                }
            }

            // Process the remaining elements of arr1 (if arr2 is exhausted)
            while (i < n) {
                sum1 += arr1[i];
                i++;
            }

            // Process the remaining elements of arr2 (if arr1 is exhausted)
            while (j < m) {
                sum2 += arr2[j];
                j++;
            }

            // Add the maximum of sum1 and sum2 to the result
            result += Math.max(sum1, sum2);

            // Output the result for this test case
            System.out.println(result);
        }
    }
}
