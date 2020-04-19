package SummaryOfInheritance;

/* 在这个程序里，逻辑是这样的，stuff interface继承了Person interface， hoursstuff（抽象的类） 应用了 stuff interface。clearner
继承了hoursstuff 成为一个具体的类

在整个过程中，我们发现，java中的类只能从抽象继承到具体。不能逆向继承，而在这个过程中，类被不断的细分，从纯抽象到一半抽象一半具体，在到完全具体
这就是完整的不段分类的结果，随着越来越具体，方法和var也逐渐具体。

当从interface到abstract Hourstuff你可以发现，你可以实现一部分interface的功能，你也可以继续让一部分method继续抽象下去。



而且子类如果没定义的method或者variable的化，就和父类公用，如果定义了，（没有用动态绑定的化），那就用自己的！


 */



public class test {
    public static void main(String[] args) {
      Clearner c1 = new Clearner("allen", 25,50,100);

      System.out.println(c1.getSalary(true));

      HoursStuff c2 =  new Clearner("cecilia",5,4,100);
      /*抽象类的抽象方法的作用就是这么的牛逼。
      c2是一个抽象的类，并且有个抽象的方法getSalary，在这个抽象的方法中，并没有什么乱用，而动态绑定的出现变得让这个有了意义，
      c2有两个method，一个是hourstuff.getSalary(抽象method）一个是clearner. getSalary一个具体的方法，而动态绑定把这两个
      method都绑定在了这里，但是真正运行的时候，运行的其实是 clearner. getSalary，这是动态绑定的逻辑，当父子重复method的时候
      会优先选择子类的method。因此这里也就自动的选择了clearner. getSalary这个实体方法。

      这也就是多态， 你看继承产生多态，具体类继承抽象类，多态让抽象类也有了具体的method，通过建立一个子类。
       */
      c2.getSalary(false);
      System.out.println(c2.getSalary(false));

      //这里toString 很明显用的是子类的 toString 这就是动态绑定。



        /*
        关于类的归属问题：
        你可以看到c1都可以是以上的类的子类，虽然java中类不能同时有两个爹，但是可以有爷爷，太爷爷。
         */



        System.out.println(c1 instanceof Stuff);
        System.out.println(c1 instanceof Person);
        System.out.println(c1 instanceof HoursStuff);
        System.out.println(c1 instanceof Clearner);



        System.out.println(c1.getClass());



    }
}
