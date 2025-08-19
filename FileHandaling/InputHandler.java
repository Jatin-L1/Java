// class : InputHandlers
// Responsibilties:

// 1. read raw bytes from system.in (inputStreamReader)
// 2. read characters from text files ( fileReader)
// 3. read full lines via bufferReaders( conse & file)


package FileHandaling;

import java.io.InputStreamReader;
import java.io.*;

public class InputHandler {

    // reads raw bytes from the keyboard one at a time
    // convertying them to chars
    
    public void readBytesFromConsole(){
        System.out.println(">> readbytefromconsole()");
        try(InputStreamReader isr = new InputStreamReader(System.in)){
            int b = isr.read();
            while(isr.ready()){
                System.out.println((char)b);
                b = isr.read();
            }
            System.out.println();
        } catch(IOException e){
            System.out.println("IOException:" + e.getMessage());
        }
    }

    // read raw chars from a file one by one
    // using filenmae
    public void readCharFromFile(String filename){
        System.out.println(">> readCharFromFile");
        try (FileReader fr = new FileReader(filename)){
            int c = fr.read(); // int value return karega
            while(fr.ready()){
                System.out.println((char)c);
                c= fr.read();
            }
            System.out.println();
        } catch (IOException e){
            System.out.println("IOException" +  e.getMessage());
        }

    }

    // read a full line from the console 
    // using InputStreamReader -> BufferedReader;
    public String  readLineFromConsole(){
        System.out.println(">> readLineFromConsoleusingbuffer");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            return br.readLine();
        } catch (IOException e){
            System.out.println("IOException" +  e.getMessage());
            return null;
        }
    }

    // reads all lines from a text file 
    // using filereader -> bufferreader

    public void  readLinesFromFile(String filename){
        System.out.println(">> readLinesFromfileusingbuffer");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) !=null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println("IOException" +  e.getMessage());
        }
    }
    
}
