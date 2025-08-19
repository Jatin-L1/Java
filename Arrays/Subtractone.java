import java.util.Scanner;

public class Subtractone {
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb= new StringBuilder();
        
        while(n>0){
            int rem = n%10;
            if(rem==0) rem = 9;
            rem--;
            sb.append(rem);
            n = n/10;
        }
        sb.reverse();
        System.out.println(Integer.parseInt(sb.toString()));
    }
}

