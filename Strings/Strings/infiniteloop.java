package Strings;

public class infiniteloop { 
        public static void main(String[] args) {
            while (true) {
                System.out.println("The fan is running.");
                
                // Sleep for 1 second to simulate a delay
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }
        }
    }
    
