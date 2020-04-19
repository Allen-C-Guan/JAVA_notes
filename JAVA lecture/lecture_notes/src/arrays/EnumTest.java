package arrays;

public class EnumTest {
    public enum Color {
        /*Enum是一种特殊的class，这种class可以不实例化（Color.RED.index）, 也可以实例化（ Color r = Color.RED)，通常情况用于存储Constant

        Enum的作用在于，利用enum可以很方便的定义一堆带有属性的常量。而不需要在重新去定义，并且如果定义为enum还可以使用他的method。
        因此用enum定义的常量，不但不需要在初始化，赋值，定义属性，还有现成的功能可以给用

        Enum的逻辑是这样的 RED,GREEN,BLANK在使用Color.RED的时候，

                                       ！！！RED就会替代（继承）Color成为class！！！！，

        这很重要！！！！，这是编写这里面函数的逻辑，因此RED，GREEN，都公用一套变量name和index，并可以使用class的全部method,通过继承实现的。
         */


        //这里面变量，例如RED（红色，1）指的是RED具有两个属性，属性1是"红色"，属性2是"1"。

        //这是最简单的使用方法，就是单纯的把enum当成label来看待！！

        RED("红色", 1),
        GREEN("绿色", 2),
        BLANK("白色", 3),
        YELLO("黄色", 4);



        // 定义RED，GREEN的属性类型
        private String name;//这就是name的值
        private int index;

        // 构造方法

        //在enum里面的构造方法指的是constant的属性
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }


        //可以自定义一个函数放在这里面，这个函数就会被所有constant所使用。

        public int getIndex(){
            return this.index;

        }

        // 覆盖方法
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }
    }

    //------------------------- testing ----------------------------

    public static void main(String[] args) {

        //我们可以直接查看这些常量的类变量以及其属性

        System.out.println(Color.RED.name+Color.RED.index);

        //如果我们需要一个RED常量，我们可以新建一个，之后a就具有了RED的全部属性和功能，定义起来很容易！
        Color a = Color.RED;


        //还可以使用他的method


        //---------------------- toString  -------------很重要-----
        //toString 通常default是把变量变成字符串输出，例如：你有obj.RED 但是你不能打印啊，你只要RED.toString()得到的就是"RED"
        //而不是obj RED
        //如果我们使用打印功能，例如 println(RED),他会自动的执行RED.toString(），来作为RED的输出内容。
        //如果我们对系统override，就会覆盖掉这个
        System.out.println("\ntoString() testing");
        System.out.println(Color.RED.toString());

        // ---------------------  values()   -----------------------

        System.out.println("\nvalues() testing");
        //该方法以list的形式返回的是Color里全部的实例类型，
        System.out.println(Color.values());
        Color [] c = Color.values();
        for(Color temp: c){
            //temp是Color的实例，
            System.out.println(temp);//这里打来的都是通过toString()打印的
        }


        //---------------- ------ ordinal  ------------------------
        //这个方法返回的是这一堆变量里面的index(从0开始）
        System.out.println("\nordinal testing");
        System.out.println(Color.YELLO.ordinal());


        //------------- compareTo --------
        //compareTo实际上对比就是oridnal，括号外的ordinal减去括号里的ordinal

        System.out.println("\ncompareTo testing");
        System.out.println(Color.RED.compareTo(Color.YELLO));
        Color r = Color.RED;
        Color g = Color.GREEN;
        System.out.println(r.compareTo(g));

        //实例话之后也可以比较，function也被继承。


        //------------ equals ----------
        //对比两个enum的类型，是否是同一种类型
        System.out.println("\nequals testing");
        System.out.println(r.equals(g));


        //---------------  valueOf -----------！！！！这个很重要
        //其中valueOf方法会把一个String类型的名称转变成枚举项，也就是在枚举项中查找字面值和该参数相等的枚举项。
        //这个很重要，因为这个方法可以把input和enum类型的数据连接起来！！！你的input可以是String，而我通过String来定义enum。

        System.out.println("\nvalueOf testing");
        Color Y = Color.valueOf("YELLO");
        //g现在就是Color.GREEN了
        //这是一种通过查找名字来赋值枚举变量的方法。



        //--------------- name（） --------------
        //name 和valueOf是互逆的两个函数， name把enum变成String， valueOf把String变成name
        System.out.println("\nname() testing");
        System.out.println(g.name());







        //---------- 调用自己写的函数也行 ---------
        System.out.println("\ncustom function testing");
        System.out.println(Color.YELLO.getIndex());


        //-------  创建enum的array  ----------
        System.out.println("\nenum array testing");
        Color[] many_colors = {Color.YELLO,Color.RED,Color.BLANK};
        for(Color temp: many_colors){
            System.out.print(temp.name+", ");
        }







    }


}