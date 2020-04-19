package Inheritance;

public class Person {

    //protected关键字表示，可以被继承者查看，而private连继承者也无法看到
    protected String first_Name;
    protected String last_Name;
    protected int ages;


    //ID是两个都有定义的
    protected int ID = 123456;

    //---------------constructor----------------
    public Person(String first_Name, String last_Name, int ages){

        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.ages = ages;

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
        return this.first_Name;
    }

    public String getlast_Name() { return this.last_Name; }

    public int getAge(){return  this.ages ;};

    public int getID(){return this.ID;}


    //-------------------setter--------------
    public void setfirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }


    public void setlast_Name(String last_Name) {
        this.last_Name = last_Name;
    }


    public void setAge(int ages) {
        this.ages = ages;
    }

    public int setID(int ID){return this.ID = ages;}
}
