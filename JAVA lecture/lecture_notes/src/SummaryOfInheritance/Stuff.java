package SummaryOfInheritance;

//interface 可以继承interface 但是不能继承class，继承只能从抽象到具体，或者从自己继承自己，不能从具体到抽象
public interface Stuff extends Person {
    int basicSalary = 20;
    int getBasicSalary();
    int getSalary(boolean fullAttendence);
}
