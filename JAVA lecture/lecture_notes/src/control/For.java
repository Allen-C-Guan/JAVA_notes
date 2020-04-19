package control;

import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("plz choose the method of counting: \n 1 for normal\n 2 for without 5\n 3 for until 4");
        int method = kbd.nextInt();

        if (method == 1) {
            for (int i = 0; i<=10; i++) {
                System.out.println(i);
            }
        }

        else if (method == 2) {
            for (int i = 0; i<=10; i++) {
                if(i == 5) continue	;	//continue just end this time of loop, jump to the loop of next time
                System.out.println(i);
            }
        }
        else if (method == 3){
            for (int i = 0; i<=10; i++) {
                if(i == 5) break	;	//break just kill this loop and jump outside the loop
                System.out.println(i);
            }
        }
        else {
            System.out.println("illage method");
        }
    }
}
