package input_output;

public class Printf {
    public static void main(String[] args) {
        int age = 18;
        System.out.printf("he is %d years old\n", age);
        double crzy_num = 12345.7789655;
        double pi = 3.1415926535;
        int i = 5;


        //pre/post increment
        System.out.println("the result of pre increment of 5 is " + (++i));
        i--;
        System.out.println("the result of post increment of 5 is " + (i++));
        //++在前面的话，就是+1优先计算。
        //++在后面，就是执行完这句话以后，在+1，
        //如果用于计数没有区别。


        //printf
        System.out.printf("the crazy number is %1.2f\n", crzy_num);
        System.out.printf("the float form of the age is %2.5f\n", (double) age);
        //我们可以看到，1.2 并不能限制小数点前面的数字的位数，小数点前面的位数
        //是最小值，如果不够也要尊重事实的数据，小数点后面的位数是固定位数，多了
        //舍去，少了补上0
        System.out.printf("the value of pi is %9.2f (right-justified).\n", pi);
        System.out.printf("the value of pi is %-9.2f (left-justified).\n", pi);
        //左右对齐的问题，数值是不变的，空格的个数也不变，取决于空格和数值的相对位置


        //casting
        System.out.printf("change the int（age=18） into float/double %1.5f\n", (double) age);
        //casting 即在variable前面加一个括号，里面写上type，强制转换type
        System.out.printf("change the float(pi) into int %d\n", (int) pi);
        //还可以往短了去改
    }

}

