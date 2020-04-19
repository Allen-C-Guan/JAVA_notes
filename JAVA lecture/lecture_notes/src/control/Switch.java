package control;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("input a method, 1 for without break, 2 for with break");
        int method = kbd.nextInt();
        System.out.println("input a value u want to judge (1-5):");
        int var = kbd.nextInt();




        if (method == 1) {
            switch (var) {
                case(1):
                case(2):
                case(3):
                    System.out.println("the var is less or equal 3");
                case(4):
                    System.out.println("the value is 4");
                case(5):
                    System.out.println("the value is 5");
                default:
                    System.out.println("illegal number");
			/*
			case(6):
				System.out.println("test");
			*/

            }
        }
        else if (method == 2) {
            switch (var) {
                case(1):
                case(2):
                case(3):
                    System.out.println("the var is less or equal 3");
                    break;
                case(4):
                    System.out.println("the value is 4");
                    break;
                case(5):
                    System.out.println("the value is 5");
                    break;
                default:
                    System.out.println("illegal number");
                    break;
            }
        }

        else {
            System.out.println("illegal method");
        }
    }

}
