public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10,11,12};
        int[] ans =new int[arr1.length+arr2.length];
        int i =0,j=0 , k=0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i]>arr2[j]) {
                ans[k] = arr2[j++];
            }
            else{
                ans[k] = arr1[i++];
            }
            k++;
        }
        if (i==arr1.length) {
            while (j<arr2.length) {
                ans[k++] = arr2[j++];
            }
        }
        if (j==arr2.length) {
            while (i<arr1.length) {
                ans[k++] = arr1[i++];
            }
        }
        for(int ele : ans){
            System.out.println(ele);
        }

    }
}
