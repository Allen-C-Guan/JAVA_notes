package immutable_objects;

public class Calculator {
    //      instance variable     //
    //要在函数之外定义，但却在object建立之时获的
    //只有当obj建立了才能获得。使用方法是obj.var
    //class.instance_var是非法的


    /*这里我们定义在method之外，理论上可以是class var，但是你看生命周期，无论是color 还是
     * price，每个函数值都是在instance被定义的同时传进来的，而不是说class本身就有的，因此
     * color和price都是instance var
     * */
    private String color;//instance variable赋值之前要先定义
    private double price;
    public String owner;


    //   class variable

    public static String model = "FX-82";
    //以static来定义，要在函数之外定义， 在class建立的时候就被赋值了
    //使用方法是 class.var = obj.var
    //特点是，所有这个class的obj都会有相同的class var

    public static final String brand = "Casio";




    //          constructor          //
    /*我们在constructor完成的是对所有定义在所有method之外的instance 变量的赋值！
     * */

    public Calculator(String color, double price, String owner) {
        this.color = color;//constructor赋值的是instance variables(所有函数之外的）
        this.price = price;//this表示object的属性，而不是传参
        //price=price这种写法就很奇怪！this就是避免这个问题。
        this.owner = owner;

        System.out.println("the color is: "+this.color);
        System.out.println("the price is: "+this.price);
        //你可以在constructor里给一些隐式的返回（print就是），但是return是肯定不可以的

    }

    //------------constructor的overloading --------------
    //在这里，你可以重新定义一个constructor，来实现overloading，当然signature不能相同
    //系统在编译的时候会自动的去matching signature

    public Calculator(String color, double price) {
        this.color = color;
        this.price = price;

    }

    //           method        //
    public double add(double a, double b) {
        return a+b;
    }

    public double multiply(double a,double b) {
        return a*b;
    }




    //          Accessor        //
    //color 和 price都是private类型的，我们如果想获得他们的值，只能通过class内的method去
    //接触到。
    //因此我们写一个public的 get开头的函数，用于返回class内部的private var
    //这时候，其他class可以通过接触到public的get函数，函数返回一个class内部的private var
    //这个函数就像个内奸一样，把自己家的私事往外说。

    public String getcolor() {
        return this.color;//返回的是object的color
    }
    public double getprice() {
        return this.price;
    }

    //----------------setter----------//
    //setter是为了改变class中private的内容，是一个改变private数据的通道
    public void setcolor(String color) {
        this.color = color;
    }
    public void setprice(double price) {
        this.price = price;
    }
}

