package Polymorphism;


/*在声明的时候在class前面加一个abstract可以让class变成一个抽象的类。
而abstract class 的意义在于规定一个class的框架，如果你想写个抽象的class，这个class中你规定了signatures， 你规定了函数名称，instance var的时候，
你把整个class的对外表现都定好了。这个时候你就可以写一个abstract class。所有用你的abstract class扩展出来的class，必须都要有
相同的功能和变量，即使每个功能实现的目的不同


写abstract class的方法和写一般class的方法一样，要有constructor，可以继承，可以有方法。
这个方法就分很多，可以是抽象的方法（不需要给body），也可以是具体的方法。



可以看到这个abstract class继承了Person, 那么这个抽象类就和Person父类有关，而如果用抽象类定义出的具体类的化，具体类就也和Person有关
因此这个抽象类还起到关联的作用




接口和抽象类都是继承树的上层，他们的共同点如下：
1)	都是上层的抽象层。
2)	都不能被实例化
3)	都能包含抽象的方法，这些抽象的方法用于描述类具备的功能，但是不比提供具体的实现。
他们的区别如下：
1)	在抽象类中可以写非抽象的方法，从而避免在子类中重复书写他们，这样可以提高代码的复用性，这是抽象类的优势；接口中只能有抽象的方法。
2)	一个类只能继承一个直接父类，这个父类可以是具体的类也可是抽象类；但是一个类可以实现多个接口。


 */


public abstract class Contact extends Person {
    private String contactInfo;
    public Contact(String name, int age){
        super(name, age);
    }
    /*----        concrete method -------- */
    public String toString(){
        return this.getName()+": "+this.getAge();
    }


    //--------- abstract method -----------------
    /*
    只要你继承了我的contact，你这个class就一定要有一个method，它的名字交contactPerson.我不管你返回d是啥，反正你一定要有
     */
    abstract String contactPerson();
}
