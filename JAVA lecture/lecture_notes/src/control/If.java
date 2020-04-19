package control;

import java.util.Scanner;

// in this class we could know the format of if in java

public class If
{
    public static void main (String[] args)
    {

        // scanner part
        Scanner input = new Scanner(System.in);


        System.out.println("type a int num： ");
        int x = input.nextInt();//x是int，而从scanner里面获取的也必须是int
        System.out.println("plz choose the judging method, 1 for method 1, 2 for method 2");
        int method = input.nextInt();

        //the general method of  if
        if (method == 1)  // 两个等于，一定放在括号里面
        {
            if (x<0)
            {
                System.out.println("the number of input is negitive");
            }
            else if (x>0)
            {
                System.out.println("the number of input is positive");
            }
            else
            {
                System.out.println("the number of input is zero");

            }
        }
        else if (method == 2)
        {
            if (x<0) System.out.println("the number of input is negitive");//写在同一行的时候，分号不能忘记
            else if (x>0) System.out.println("the number of input is positive");
            else System.out.println("the number of input is zero");

        }
        else {
            System.out.println("plz input the legal method!!! ");
        }
    }
}


