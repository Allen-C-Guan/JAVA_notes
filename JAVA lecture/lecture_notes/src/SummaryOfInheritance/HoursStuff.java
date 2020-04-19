package SummaryOfInheritance;

public abstract class HoursStuff implements Stuff{

    protected final String name;
    protected final int age;
    protected int hours;
    protected int salary;

    public HoursStuff(String name,int age, int hours){
        this.name = name;
        this.age = age;
        this.hours = hours;
    }


    //继承的接口还可以是继续抽象下去
    @Override
    public abstract int getSalary(boolean fullAttendence);




    //在这个抽象类中，以下这些method都已经被实例化了

    @Override
    public int getBasicSalary() {
        return basicSalary;
    }



    @Override
    public String getName() {
        return name;
    }



    @Override
    public int getAge() {
        return age;
    }

}
