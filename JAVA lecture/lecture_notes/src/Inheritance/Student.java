package Inheritance;

public class Student extends Person {
    public int ID;
    public String department;



    //------------ constructor --------------------
    /*当父类中没有无参constructor的时候，你的子类constructor中必须要显示的调用父类constructor super(a,b,c...)
    constructor中调用constructor的例子*/

    public Student(String first_Name, String last_Name, int ages,int ID, String department){

        //另一种构造的方法
        //不管哪一种方法，都要求constructor之间要对应上。

    //public Student(Person orig,int ID, String department){

        //如果用到父类的属性，那么，调用父类的constructor就必须先写。

        super(first_Name, last_Name, ages);//这句话相当于父类的调用构造器 public Person(first_Name, last_Name, ages);

        //super(orig);//另一种调用的方法

        this.ID = ID;
        this.department = department;



    }



    //--------------  method  -------------
    //添加父类里面没有的method

    public String getFullInformation(){
        return this.first_Name+": " + this.ID+": " + this.department;
    }

    //----------- overriding -----------
    /*overriding指的是，如果你想让子类覆盖掉父类的一些功能，你可以用这个方法。
    这个方法的关键在于两点，1。是覆盖，2。是一样。
    覆盖：两个method 只能挑一个来运行，不能随便搞
    一样：method名称和signature均完全一样（如果signature不一样 那叫overloading）
     */
    @Override
    public String whole_Name(){
        return this.first_Name;
    }

    //--------- 调用 overriden method--------
    //调用方法就是在另写一个。

    public String superwhole_Name(){
        return super.whole_Name();
    }


    //---------- accessor ----------
    //子类父类共有的method！


    @Override
    public int getID(){return this.ID;}

    public String getDepartment(){return this.department;}





}
