package OOPS.Lec_Six;

public class ExceptionHandling {
    public static void main(String[] args) {
        int a =5;
        int b =0;
        try{
            divide(a, b);

        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("Normal Execption");
            // this exception is executed if the execption is not arithmetic exception
        }
        finally{
            System.out.println("This is always execute");
            //there can only be one finally block
        }
    }
    static int divide(int a, int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException(
                "Division by zero is not possible"
            );
        }
        return a/b;
    }

    // throws is just used to declare an exception
    
}
