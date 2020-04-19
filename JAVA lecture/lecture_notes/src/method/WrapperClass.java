package method;

public class WrapperClass {

    public static void main (String[] args) {
        double pi=3.1415;
        String text = "PI should equal to: ";
        String Str1 = text+pi;   				//这样也能自动转换



        /* 两种基本变化
         * 1. 从其他primitive变成String   --开头大写.toString
         * 2. 从string变成其他 			--开头大写.parseByte(str)
         */
        String Str2 = Double.toString(pi);     //把pi从double 变成了string
        //int num1 = Integer.parseInt("A");


        System.out.println(Str1);
        //System.out.println(num1);
    }

}
