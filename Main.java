import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int nofTC;
		nofTC = sc.nextInt();
		for(int i =0;i<nofTC;i++){
			int noOfAvailableRose = sc.nextInt();
			int[] price = new int[noOfAvailableRose];
			for(int x =0;x<noOfAvailableRose;x++){
				price[x] = sc.nextInt();
			}
			int money = sc.nextInt();
			for(int j =0;j<price.length;j++){
				boolean flag = false;
				for(int k =0;k<j;k++){
					if(price[k]+price[j]==money && price[j]<=price[k]){
							flag = true;
							System.out.println("Deepak should buy roses whose prices are "+price[j]+" and "+price[k]+".");
											
						}
				}
				if(flag) break;
			}
		}
    }
}
