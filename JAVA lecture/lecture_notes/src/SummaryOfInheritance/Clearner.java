package SummaryOfInheritance;

public class Clearner extends HoursStuff {
//    int hours;
//    int age;
//    String name;

    /*
    这里就是最简单的bug，在这个类里面，我们定义了这个类自己的instance var,但是我们只初始化了父类的constructor，
    我们自己的instance var在constructor里面没有被初始化。

    因此最简单的解决办法就是直接不再重新定义这些变量了，这样的化，系统在编译的时候，发现自己并没有属于自己的instance variable，
    就会直接继承了父类，这个时候所有hour name，等就自动的对应到了父类上了。
     */
    private int bouns;

    public Clearner(String name, int age, int hours, int bouns) {
        super(name, age, hours);
        this.bouns = bouns;
    }


    //你发现， 它的父类HourStuff已经实例化了一部分method了，因此都不需要再实例化了。而只有getSalary是继续抽象的method
    //这个具体的类，我们需要的实例化仅剩下的一个method
    @Override
    public int getSalary(boolean fullAttendence) {
        if(fullAttendence){
            return hours*basicSalary+100+bouns;
        }else {
            return hours * basicSalary+bouns;
        }
    }


    @Override
    public String toString(){
        return "name: "+name+"\nage: "+age+"\nhours: "+hours;
    }


    //---equals的overriding
    @Override
    /*
    1. 由于是overriding，signature一定是固定的。
    2. 判定是否是null
    3. 判定class是否是同类(是不是同类（判定getClass的结果是否相同），// 一般不太用// 是不是它爸爸类的,如果是就用父类来判定（super.equals(other))
    4。down cast others
     */
    public boolean equals(Object other){
        if(other == null || this.getClass()!= other.getClass()||!super.equals(other)){
            return false;
        }
        Clearner tmp = (Clearner) other;
        /*TODO
        这里开始对比tmp的内容和others的input是否相同
         */

        return true;

    }
}
