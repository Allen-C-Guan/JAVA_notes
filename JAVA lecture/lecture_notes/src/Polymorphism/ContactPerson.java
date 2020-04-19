package Polymorphism;

public class ContactPerson extends Contact {
    //--- constructor ----
    public ContactPerson(String name, int age) {
        super(name, age);
    }

    //由于test是Contact的子类，而contact里面已经定义了说，这个类里一定有个方法叫contactPerson，所以你就一定要写，不写不行！！
    @Override
    String contactPerson() {
        return "not supported yet";
    }






    //----------------- test -------------------------

    public static void main(String[] args) {

        //person可以被实例化但是contact就不行
        Person p1 = new Person("bob",22);
        //Contact c = new Contact("bob",22);

        ContactPerson c1 = new ContactPerson("allen",25);

        //abstract中定义的抽象方法（在子类中被具体化）
        System.out.println(c1.contactPerson());

        //abstract定义的具体方法
        System.out.println(c1.toString());

        //继承了父类的instance和method

        System.out.println(c1.getAge());
        System.out.println(c1.getName());

    }


}
