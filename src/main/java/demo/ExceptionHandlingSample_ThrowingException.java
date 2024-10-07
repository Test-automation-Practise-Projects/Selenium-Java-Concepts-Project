package demo;

public class ExceptionHandlingSample_ThrowingException {


    public static void main(String[] args) {
        try {
            exceptions();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //When we throw the exception, exception will come but it won't be handled here, instead iw will be thrown to main function
    public static void exceptions() throws Exception{

            System.out.println("Hellow world");
            int i = 1/0;
            System.out.println("Completed");
    }

}


