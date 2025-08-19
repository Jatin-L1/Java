package FileHandaling;
import java.io.*;

// class : OutputHandler
// Resposibilites:
// 1. wrtie raw bytes to the console (OutputStreamWriter)
// 2. Wrtie characters/lines to a file ( filewriter , BufferWriter)
// 3. Append vs overwrite
public class OutputHandler {
     
    // writes text and characters firelty to the console
    // via using OutputStreamWriter 
    public void writetoConsole(){
        System.out.println(">> writetoConsole()");
        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello my name is jatin sharma");
            osw.write("A");
            osw.write("\n");
            osw.write("Radhika is a egoist girl");
            osw.flush(); // ensure it is printed
            
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }



    // overwrite ( or creates) a file with the given text
    // usses FileWriter-> bufferwriter for efficiency.
    public void writeToFile(String filename , String text){
        System.out.println(">>Write to file");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(text);
            bw.newLine();
            
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // appends text to ans exsisting file
    // using fileWriter -> bufferWriter for efficincy
    public void appendToFile(String filename , String text){
        System.out.println(">> append to the file");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename , true))) {{
            bw.write(text);
            bw.newLine();
        }
            
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }


    
}
