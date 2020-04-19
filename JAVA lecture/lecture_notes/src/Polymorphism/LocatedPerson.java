package Polymorphism;

public abstract class LocatedPerson extends Person {



    public LocatedPerson(String name, int age){
        super(name,age);


    }

    //----- abstract method -------------
    public abstract String contactInstructions();


    public String toString(){
        return "name: "+getName()+"  age: "+getAge();
    }





}
