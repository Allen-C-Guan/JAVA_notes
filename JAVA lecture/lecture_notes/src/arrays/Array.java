package arrays;

import java.util.Arrays;

public class Array {
    public static void main(String[] args){
        //array的初始化

        //方法1

        /*创建的时候就赋值（通常用于constant的创建）
        int 表示array里面的类型，可以是primate （int, double) 也可以是class （Checker, String,等）
        要求是array的除了内容之外，长度和类型都是不可更改的。
         */
        int [] array_1 = {1,2,3,4,5,6,7};    //大括号赋值法，只适用于初始化中



        //方法2  = 方法1，都是静态方法，定义即确定
        //上面的方法等同于下面的方法
        int [] array_test;
        array_test = new int [] {1,2,3,4,5,6,7};

        System.out.println("print only one element: "+array_1[3]+"\n");



        //方法3 动态方法 用的时候再赋值

        /*先创建后赋值
        array的赋值很奇怪，必须要用 new + datatype [length] 的形式来确定长度。而后one by one 的赋值。
         */
        int [] array_2;
        array_2 = new int[10];//这里10指的是array的长度，
        System.out.println("default int value is: "+array_2[2]+"\n");//default的值是0。

        //我们可以一个index一个index的赋值
        // array.length 是一个默认的array的method，可以返回其值
        for (int i = 0; i <  array_2.length; i++){
            array_2[i] = i;
        }





        // java中 类似于 python中for in 用法(这里面，被迭代的可以是obj）
        //创建一个element是obj的array
        Person [] personList;          //以Person Obj为element的array
        personList = new Person[2];    //长度是2的
        personList[0] = new Person("Allen","Guan");
        personList[1] = new Person("Shuo","Piggy");


        //这里 Person p表示 p是通过personList这个array里面一个一个拿出来的，这个python for in完全一样
        //这个方法的牛逼之处，在于批量操作同一类obj

        for (Person p : personList){
            System.out.println(p.getfirst_Name());
        }




        //高维array
        /*
        在JAVA里面，并没有直接的高维array，取而代之的是array的嵌套完成的高维度array
         */
        int [][] twoDArray = new int[10][9];
        //在这个array里面，10是外层的array，9是内层的array
        //因此我们可以把10看成是行的数量，9是列的数量
        System.out.println("the length of 2D array is: "+twoDArray.length);
        //你可以看到如果你观察这个array这个array的长度仍然是个10的array，只是每个array里面仍然是个array
        System.out.println("the length of inner array is: "+ twoDArray[1].length);
        //这里你可以看到内层array的维度

        //矩阵的初始化
        int index = 1;
        for (int i=0; i < twoDArray.length; i++) {
            for(int j = 0; j<twoDArray[i].length; j++){
                twoDArray[i][j] = index;
                index++;
            }
        }

        // 打印一下矩阵
        for (int i=0; i < twoDArray.length; i++) {       //这里twoDArray.length就直接是外层的长度了
            for(int j = 0; j<twoDArray[i].length; j++){  //由于高维度的array，是通过嵌套实现的，因此可以每行的长度不同的。
                System.out.print(twoDArray[i][j]+",");

            }
            System.out.print("\n");
        }


        //method的调用
        System.out.println(copyAArray(array_2)[2]);


        System.out.println(Character.getNumericValue('C'));
        System.out.println(Character.getNumericValue('D'));
        System.out.println(Character.getNumericValue('H'));
        System.out.println(Character.getNumericValue('S'));


        //Copy array 的方法
        // Arrays.copyOfRange(original_array, end_index) and copyOf( original_array, begin_index, end_index)
        // Arrays.toString(array)可以把array输出。你直接print array得到是是hashcode().

        System.out.println("\n\ncopy test");
        int [] a1 = {1,2,3,4,5};
        int [] a2 = Arrays.copyOf(a1,3);
        int [] a3 = Arrays.copyOfRange(a1,2,4);
        int [] a4 = new int[6];


//        a4 = Arrays.fill(a4,2,4);


        System.out.println(a2.toString());
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));



    }




    //创建一个以array为传参，array为返回的method
    //       int[] 表示 return是array       int[] 其后的表示array变量是array
    public static int[] copyAArray(int[] array){
        int[] array_method = array;
        return  array_method;
    }




}
