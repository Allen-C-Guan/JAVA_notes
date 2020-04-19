package Lab2;

/*
String.length()的使用

String.indexOf(" pattern") 可以找到字符串中对应的字符串的位置(只返回第一个match上的字符的index）
String.substring(index_begin, index_end) 左闭右开区间。也可以不用end，默认到结尾
 */


//记得import Scanner
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);//Scanner(System.in)是个固定搭配。
        System.out.println("input a sentence");
        String str = kbd.nextLine();
        System.out.println("the message length is: "+ str.length());


        // String.indexOf(" pattern")

        int match_index = str.indexOf("is");
        System.out.println(match_index);
        System.out.println(str.substring(0,match_index));
        System.out.println(str.substring(match_index));



    }
}
