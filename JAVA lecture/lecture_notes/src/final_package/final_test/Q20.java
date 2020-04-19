package final_package.final_test;

public class Q20 {
    public static void main(String[] args){
        ClassA myObj1 = new ClassA(); ClassA myObj2 = new ClassA(); myObj1.a=2;
        myObj2.a=2;
        ClassB.ResetA1(myObj1);
        ClassB.ResetA2(myObj2);

        System.out.println(myObj1.a);
        System.out.println(myObj2.a);

    }




}
