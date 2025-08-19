package Radhika.HashSet;

import java.util.HashSet;

public class Execution {
    // hashset in java interfaces / Data Structers
    // insert  , remove , search ---- o(1);
    // Hashset se element lete hain tho woh random order main atte hain...
    public static void main(String[] args) {
        // hashset use kab karna hain jab  question unique  , tracking jaise sabdh dikhte hain
        
        HashSet<Integer> set = new HashSet<>(); // yeh humara set declare ho gya
        set.add(1); // element add hota hain
        set.add(2);

        System.out.println(set);
        set.add(2);

        System.out.println(set); // hashset main sirf unique elements atte hain...
        // how to iterate over hashset..



        for(int ele : set){
            System.out.print(ele+" ");
        }   
    }

}
