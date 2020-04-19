package immutable_objects;

public class Test {

    public static void main(String[] args) {
        //     定义一个新的object 名为my_cal     //

        Calculator my_cal = new Calculator("red",20,"Allen");
        System.out.println("");

        //          使用class内的功能        //

        double sum = my_cal.add(2,56.7);
        System.out.println("the sum of two number is: "+sum);

        double multiply = my_cal.multiply(3,67673);
        System.out.println("the product of two number is: "+multiply);
        System.out.println("");

        //         使用accessor来获取privat信息             //

        String color = my_cal.getcolor();
        System.out.println("the color of this calculator is: "+color);

        double price = my_cal.getprice();
        System.out.println("the price of this calculator is: "+price);
        System.out.println("");

        //-------------------setter-------------------
        System.out.println("the color now is: "+my_cal.getcolor());
        my_cal.setcolor("black");
        System.out.println("the color become to: "+my_cal.getcolor());
        System.out.println("");



        //               获取public的参数值                   //

        /*属性（instance var)的获取方法为 classname.instance_var_name
         * ie. Allen.laptop  返回的就是mac
         * 与函数不同的就是少个括号（因为本来也不需要传入参数了）
         * */
        String owner = my_cal.owner;
        System.out.println("the owner of this calculator is: "+owner);

        //my_cal.owner是一个public的变量，因此可以获取
        //my_cal.color这个属性由于在定义之时是private，因此无法被获取



        //            instance var 和 class var 的区别

        System.out.println("class var is: "+Calculator.model);
        System.out.println("object var is:"+ my_cal.model);
        System.out.println("object another var is: "+my_cal.owner);
        System.out.println("");
        //以上三种都是合法的
		/*
		Calculator.owner;
		这个很明显就不合法了，owner这个属性是instance的，class自然是call不出来的
		*/


        //                   static的用法和性质                   //

        my_cal.model = "FX-100";
        System.out.println("the model of my calculator become to: "+my_cal.model);
        System.out.println("now the class var also become to: "+Calculator.model);
        System.out.println("");
        Calculator new_cal = new Calculator("blue",49,"Cecilia");
        System.out.println("the model of new calculator become to: "+new_cal.model);
        System.out.println("");
        //static变量是一个静止的，全局变量，所有赋值都是地址链接，而不是复制，因此你通过任何
        //手段改变了static变量，都会让这个变量永久的改变



        //         public和 private的区别和使用方法         //

        my_cal.owner = "Cecillia";
        System.out.println("now the owner of this car become to: "+my_cal.owner );
        System.out.println("");
        //我可以在不改变class的情况，就可以改变 my_cal的属性值！！！这是多么危险的事情
        //你不到我家，我就能把计算器从你的变成我的，这就是public的风险！！！！

        /********/
        //my_cal.color 是你如何都改变不了的，只要你定义完成，并且你没有碰过calculator
        //的定义。因此对于private而言，改变的唯一方法是你更改class，除此之外毫无办法。


        //             final            //
        //上面说了 public的风险，可是你又要共享，怎么解决这个问题？
        //final就可以解决这个问题，如果你加个finial，即使被别人看到了又怎么样，还是什么都做不了

        String brand = my_cal.brand ;
        System.out.println("");
        //my_cal.brand = "philip";
        //这是违法的，因此final只给看不给摸。



        //-------------------toString()----------------------
        //toString()是系统自动生成的，默认的是用于返回object的位置和属性
        //使用方法很特别，只要call这个object， 其返回值等于toString的返回

        System.out.println(my_cal.toString());
        System.out.println(my_cal);
        System.out.println("");



        //------------overloading of constructor----------------

        //我们可以通过对constructor的overloading来对设置多个class的入口
        Calculator her_cal = new Calculator("red",30);
        System.out.println("her_cal price is: "+her_cal.owner);
        System.out.println("");
        //此时就会输出null，这就是null的功能，即如果没有定义，系统会自己给出默认值 null，或者0
        //即使你没有在初始化的时候定义，但是你仍然可以在class之外对其改变



        //------------- 用一个obj去定义另一个obj-------------

        //obj的赋值本质上是地址的复制，并没有新建
        //这导致，所有的赋值都公用一套内存，任意一个obj发生了变换，所有obj都发生变换

        Calculator other_cal = her_cal;
        System.out.println("price of her calculator is: "+her_cal.getprice());
        other_cal.setprice(50);
        System.out.println("price of her calculator become to: "+her_cal.getprice());
        System.out.println(" ");




        //---------------  class的    --------------


    }

}
