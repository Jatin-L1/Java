package Strings;

public class resouce {
        public static void main(String[] args) {
            while (true) {
                // Perform some heavy calculations
                double result = 0;
                for (int i = 0; i < 1000000; i++) {
                    result += Math.sqrt(i) * Math.sin(i);
                }
                
                // Print the result to avoid optimizations
                System.out.println("Current result: " + result);
            }
        }
    }
    
