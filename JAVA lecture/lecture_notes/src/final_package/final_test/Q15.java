package final_package.final_test;

public class Q15 {


    public static void main(String[] args) {
        int i = 0;
        try{
            i = 1;
            throw new MyException(i);
//            i = 2;
        } catch( MyException e ) {
            i = e.getErrorCode();
        } catch ( Exception e ) {
            i = 3;
        }finally {
            System.out.println(i);
        }

    }


}
