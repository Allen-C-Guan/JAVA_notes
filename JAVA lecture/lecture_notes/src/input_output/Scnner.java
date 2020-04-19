package input_output;

import java.util.Scanner;
public class Scnner {
    public static void main(String[] args) {
        Scanner kbd	=new Scanner(System.in);
        System.out.print("Enter 4 number:");
        int num = kbd.nextInt();
        int num2 = kbd.nextInt();
        String str1=kbd.next();
        System.out.printf("the first number is %d\n",num);
        System.out.printf("the second number is %d\n",num2);
        System.out.println("the third string is "+str1);
        String str2 = kbd.nextLine();
        System.out.printf("the next line is %s\n",str2);

	/*initial scanner的方法

	step1. creat an scanner obj  Scanner var = new Scanner(System.in);
	step2, get the value for scanner obj
			 int var1=obj.nextInt();(左右类型要对应上)


	nextInt 以空格为Int的分隔符。光标每次会把从*当前位置*到*空格*之间的内容都抓取到
	并赋值给variable。
	next()一定要读取到有效字符后才可以结束输入，
    对输入有效字符之前遇到的空格键、Tab键或Enter键等结束符，next()方法会自动将其去掉，
    只有在输入有效字符之后，next()方法才将其后输入的空格键、Tab键或Enter键等视为分隔符或结束符。
    nextLine()方法的结束符只是Enter键，即nextLine()方法返回的是Enter键之前的所有字符，
	method 开头小写，后面到每个字母开头大写
	nextline本质上是从光标当前所在位置，获取到改行到结尾，
	什么都得不到也是有可能的。*/
    }
}
