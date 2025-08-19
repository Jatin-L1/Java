package CodingBlocks;

import java.util.*;
import java.lang.*;

class Solution {

    public int solve() {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt(); 
        int l = scanner.nextInt(); 
        int[] rank = new int[l];
        for (int i = 0; i < l; i++) {
            rank[i] = scanner.nextInt();
        }

        int low = 0;
        int high = 0;
        for (int r : rank) {
            high = Math.max(high, r * p * (p + 1) / 2); 
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int parathasCooked = 0;
            for (int r : rank) {
                int n = (int) (Math.sqrt((2.0 * mid) / r + 0.25) - 0.5); 
                parathasCooked += n;
            }

            if (parathasCooked >= p) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solve());
    }
}
