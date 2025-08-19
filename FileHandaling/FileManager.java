package FileHandaling;
import java.io.*;

// class FileManager
// Responsibilties:
// 1 create a file if does not exists.
// 2. delete a file
public class FileManager {

    //created a new file
    // return true if file is creatred flase if alread is presnt

    public boolean createFile(String filename){
        System.out.println("Creation of files");
        File f = new File(filename);
        try  {
            if(f.createNewFile()){
                System.out.println("Created your file");
                return true;
            } else{
                System.out.println("File already exsists");
                return false;
            }
            
        } catch (IOException e) {
            System.out.println("IOException: "+ e.getMessage());
            return false;
        }
    }

    // delted the given file name
    // retunrn true id delteld sucessfuly

    public boolean deleteFile(String filename){
        System.out.println("Deleltion of files");
        File f = new File(filename);
            if(f.delete()){
                System.out.println("deleted your file");
                return true;
            } else{
                System.out.println("failed to delete you file");
                return false;
            }
    }
    
}
