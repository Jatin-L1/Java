package Stack;

public class StockSpan {
    public static void main(String[] args) {
        int price[] = {10,4,5,90,120,80};
        int n = price.length;
        int s[] = new int[n];

        calculateSpan(price , n , s);
        printArray(s);

    }

    public static void printArray(int[] s) {
        // for(int ele : s){
        //     System.out.println(ele+" ");
        // }
        System.out.println(Arrays.toString(s));

    }

    @Override
    public String toString() {
        return "StockSpan []";
    }

    private static void calculateSpan(int[] price, int n, int[] s) {
        s[0] = 1;
        for(int i =1;i<n;i++){
            s[i] =1;
            for(int j =i;j>=0 && (price[i]>=price[j]) ; j--){
                s[i]++;
            }
        }
    }
}
