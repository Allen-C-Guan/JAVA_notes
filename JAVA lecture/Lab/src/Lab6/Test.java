package Lab6;
/*
    这里我们把这些变量都不是final的时候，如果有setter的存在。那么这些obj的属性是可以被改变的。

    什么是privacy lack 指的是如果你在使用和复制这些obj的时候，如果你不是新建一个属于自己的obj，那么当你引用的obj被改变的时候，你自己的也变了

    你需要做的就是新建一个constructor 这个constructor input是自己的类，output也是自己的类，但是其目的是新建，不是复制pointer
     */

public class Test {
    public static void main(String[] args) {
        Movie2 m = new Movie2("Dark knight",3,100);
        System.out.println(m);


        //这种copy就是deep copy不会有leak了
        Movie2 n = new Movie2(m);

    }
}
