package Lab3;
/*
这个lab知识点：
1. switch 支持 byte, short, char, int
2. char要用''单引号
3. String.ChatAt(index)可以获得第几个。
4. Switch中default用法
 */

import java.util.Scanner;

public class compass {

    public static void main(String[] args) {
        System.out.print("PLZ input an direction: ");
        Scanner kbd = new Scanner(System.in);
        String direction = kbd.next();
        char d = direction.charAt(0);


        switch (d) {
            case ('N'):
                System.out.println("0 degree");
                break;
            case('S'):
                System.out.println("180 degree");
                break;
            case('W'):
                System.out.println("270 degree");
                break;
            case('E'):
                System.out.println("90 degree");
            default:
                System.out.println("Error");
                System.exit(1);

        }

    }

}
