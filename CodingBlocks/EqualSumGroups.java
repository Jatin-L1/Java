package CodingBlocks;

import java.util.ArrayList;
import java.util.List;

public class EqualSumGroups {
    private static int count = 0; 
    public static void findEqualSumGroups(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            System.out.println("No valid groupings exist.");
            return;
        }

        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        count = 0; 
        findSubsets(nums, 0, 0, totalSum / 2, group1, group2);
        System.out.println(count);
    }

    private static void findSubsets(int[] nums, int index, int currentSum, int targetSum, List<Integer> group1, List<Integer> group2) {
        if (index == nums.length) {
            if (currentSum == targetSum) {
                group2.clear();
                List<Integer> tempGroup1 = new ArrayList<>(group1); 
                for (int num : nums) {
                    if (!tempGroup1.contains(num)) {
                        group2.add(num);
                    }
                }
                if (!group1.isEmpty() && !group2.isEmpty()) { 
                    printGroups(group1, group2);
                    count++;
                }
            }
            return;
        }
        group1.add(nums[index]);
        findSubsets(nums, index + 1, currentSum + nums[index], targetSum, group1, group2);
        group1.remove(group1.size() - 1); 
        findSubsets(nums, index + 1, currentSum, targetSum, group1, group2);
    }

    private static void printGroups(List<Integer> group1, List<Integer> group2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < group1.size(); i++) {
            sb1.append(group1.get(i));
            if (i < group1.size() - 1) {
                sb1.append(" ");
            }
        }

        for (int i = 0; i < group2.size(); i++) {
            sb2.append(group2.get(i));
            if (i < group2.size() - 1) {
                sb2.append(" ");
            }
        }

        System.out.println(sb1.toString() + " and " + sb2.toString());
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: 4\n1 2 3 4");
        findEqualSumGroups(nums1);

        int[] nums2 = {10, 4, 6, 3, 7, 9, 2};
        System.out.println("\nInput: 7\n10 4 6 3 7 9 2");
        findEqualSumGroups(nums2);

        int[] nums3 = {1, 1, 1, 1};
        System.out.println("\nInput: 4\n1 1 1 1");
        findEqualSumGroups(nums3); 

        int[] nums4 = {1, 5, 11, 5};
        System.out.println("\nInput: 4\n1 5 11 5");
        findEqualSumGroups(nums4); 

        int[] nums5 = {1, 2, 3, 4, 5, 6};
        System.out.println("\nInput: 6\n1 2 3 4 5 6");
        findEqualSumGroups(nums5);
    }
}
