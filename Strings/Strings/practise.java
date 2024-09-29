package Strings;

import java.util.Scanner;

public class practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String atr = "Akshit";
        // String str = sc.nextLine();
        // System.out.print(str.length());
        // System.out.println();
        // System.out.print(str.charAt(4));
        // System.out.println();
        // System.out.print(str.indexOf('t'));
        // System.out.println();
        // System.out.print(str.lastIndexOf('a'));
        // System.err.println();
        // System.out.print(str.compareTo(atr));
        // System.out.println();
        // System.out.print(str.startsWith("ja"));
        // System.out.println();
        // System.out.print(str.contains("ti"));
        // System.out.println();
        // System.out.println(str.endsWith("fdg"));
        // System.out.println();
        // System.out.print(str.toLowerCase());
        // System.out.println();
        // System.out.print(str.toUpperCase());
        // System.out.println();
        // System.out.print(str.substring(2,str.length()-1));
        // System.out.println();

        // char[] bh = {'a','b','c','d'};
        // System.out.print(bh[2]);
        // System.out.println();
        // int a = 10;
        // String r = a +"";
        // System.out.print(r);
        // System.out.println();
        // String g = Integer.toString(a);
        // System.out.print(g);

        // String g = "JATIN";

        // String h = new String("Jatin");
        // System.out.print(g);
        // System.out.print(h);
        // System.out.print("Enter the string: ");
        // String str = sc.nextLine();
        // String arr = "";
        // int n = str.length();
        // for(int i =0;i<n;i++){
        //     if(i%2==0){
        //         arr +='a';  
        //     }
        //     else {
        //         arr += str.charAt(i);
        //     }
        // }
        //  str = new String(arr);
        // System.out.print(str);
        // String s = "Jatin";
        // StringBuilder sb = new StringBuilder("abc");
        // System.out.println(s);
        // System.out.println(sb);
        StringBuilder sbc = new StringBuilder(sc.nextLine());
        // sbc.setCharAt(0, 'J');
        // sbc.setCharAt(1, '2');
        // sbc.append("Sharma");
        // sbc.insert(6, "Kumar");
        // sbc.delete(1,5);
        // System.out.println(sbc);
        int n = sbc.length();
        int i =0;
        int j = n-1;
        while(i<j){
            char temp =sbc.charAt(i);
            sbc.setCharAt(i, sbc.charAt(j));
            sbc.setCharAt(j, temp);
            i++;
            j--;
        }
        
        System.out.println(sbc);
        sc.close();
    }
}
