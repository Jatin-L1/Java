package FileHandaling;
// class Main
// Orceshtrtrates all handlers to demstrater the  full io flow.

public class Main {
    public static void main(String[] args) {
        InputHandler in = new InputHandler();
        OutputHandler out = new OutputHandler();
        FileManager fm = new FileManager();


        String str = "HELLO";
        String str1 = "I have  a Bitch behaviour";
        // 1. Read a line from console
        System.out.println("Enter a quck note: ");
        String note = in.readLineFromConsole();

        // 2. Create a new file
        fm.createFile("radhika.txt");

        // 3. Write the note radhika.txt

        out.writeToFile("radhika.txt", str);

        //4 append to file 

        out.appendToFile("radhika.txt", str1 );

        // 5 read and display raw chars form the radhika.txt

        in.readCharFromFile("radhika.txt");

        //6 read and display full line from radhika.txt

        in.readLinesFromFile("radhika.txt");


        // 7. show console output via outputStreamWriter
        out.writetoConsole();


        //8. Creation and deltion of fie
        fm.createFile("tempfile.tmp");
        fm.deleteFile("tempfile.tmp");








    }
    
}
