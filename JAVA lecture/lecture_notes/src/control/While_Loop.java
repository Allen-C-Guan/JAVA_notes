package control;

import java.util.Scanner;

public class While_Loop {
    public static void main(String[] args) {

        Scanner kbd = new Scanner (System.in);
        System.out.println("choose an counting method, 1 for while, 2 do while");
        //放在next之前，因为next不得到string他是不会继续执行的
        int method = kbd.nextInt();
        System.out.println("the number you want to count: ");
        int cnt = kbd.nextInt();
        int i, j ;
        i=j=cnt;



        if (method == 1) {

            while (i>0){
                System.out.println(i);
                i--;
            }
        }

        else if (method == 2) {

            do {
                System.out.println(j);
                j--;
            }while(j>0);	//当你把input设置成0的时候，发现，do while 至少执行一次
        }
        else {
            System.out.println("the method is wrong");
        }
    }
}

