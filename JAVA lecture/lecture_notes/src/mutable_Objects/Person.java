package mutable_Objects;

public class Person {
    private String first_Name;
    private String last_Name;

    //---------------constructor----------------
    public Person(String first_Name,String last_Name){

        this.first_Name = first_Name;
        this.last_Name = last_Name;

    }
    //----------------copy constructor--------------
    //主要利用signature达到constructor overloading 的功能
    //实现的功能是：一个obj去建立一个instance var 完全相同的另一个obj

    public Person(Person orig) {
        this.first_Name = orig.first_Name;
        this.last_Name = orig.last_Name;
    }

    //------------------method-------------------
    public String whole_Name() {
        return this.first_Name+this.last_Name;
    }


    //------------------getter------------------

    public String getfirst_Name() {
        return first_Name;
    }

    public String getlast_Name() {
        return last_Name;
    }


    //-------------------setter--------------
    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }


    public void setlast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

}
