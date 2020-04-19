package Polymorphism;

public class Test {
    public static void main(String[] args) {
        HomedPerson h1 = new HomedPerson("allen",25,"0468849666");
        System.out.println(h1.contactInstructions());
        System.out.println(h1.getName());
        System.out.println(h1.getAge());
        System.out.println(h1.getPhoneNumber());

         /*抽象类的概念的作用
        该类的概念主要好处是统一父类，其实继承本身也可以统一父类，但是继承的局限性太大，子类通常受到父类影响很大，可是如果你定义的是抽象类
        那么你内部是什么没关系，且父类的抽象方法也会产生多态来让method的使用变得很复杂。
         */

        HomedPerson h2 = new HomedPerson("c",42,"6666666");
        HomedPerson h3 = new HomedPerson("y",30,"8888888");

        HospitalisedPerson y1 = new HospitalisedPerson("w",78,"royal","502");
        HospitalisedPerson y2 = new HospitalisedPerson("u",9,"royal","402");
        HospitalisedPerson y3 = new HospitalisedPerson("m",2,"royal","302");


        /*
        这里我们就采用了这个方法，其中不管是hospital还是homed都是located的类，因此我们就可以统一父类，方便处理！！！
         */
        LocatedPerson [] lostPersonList = {h1,h2,h3,y1,y2,y3};
        for(LocatedPerson p: lostPersonList){
            System.out.print(p);
            System.out.println("  place:  "+p.contactInstructions());
        }






    }
}
