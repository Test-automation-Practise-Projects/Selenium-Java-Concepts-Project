package demo;

public class ExceptionHandlingSample {
    public static void main(String[] args) {

            try{
                System.out.println("Hellow world");
                int i = 1/0;
                System.out.println("Completed");
            }
            catch (Exception exp){
                System.out.println("Came to catch block");
                System.out.println("Exception is: "+exp.getMessage());
                System.out.println("Reason is: "+exp.getCause());
                exp.printStackTrace(); //gives the line which cause this exception

            }

            //finally block is executed irrespective of whether there is a exception or not
            finally {
                System.out.println("Came to Finally block");
            }

        }

}
