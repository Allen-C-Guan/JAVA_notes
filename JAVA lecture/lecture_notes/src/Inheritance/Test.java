package Inheritance;

public class Test {
    public static void main(String[] args) {

        Student s1 = new Student("allen","Guan",13,897291,"EE");


        /*另一套构造的方法。
        Person s = new Person("allen","guan",13);
        Student s1 = new Student(s,897291,"EE");
         */

        //子类继承类父类的instance variable
        System.out.println("\ninstance part");
        System.out.println(s1.first_Name);
        System.out.println(s1.last_Name);
        System.out.println(s1.ages);

        //子类继承父类的全部method
        System.out.println("\nmethod part");
        System.out.println(s1.getAge());
        s1.setAge(25);
        System.out.println(s1.getAge());

        //子类还有自己的扩展method，父类却没有
        System.out.println("\nextended part");
        System.out.println(s1.getFullInformation());

        //overriding
        System.out.println("\noverride part");
        System.out.println(s1.whole_Name());
        //调用overiden的method
        System.out.println("\noverriden part");
        System.out.println(s1.superwhole_Name());

        //late binding（动态绑定）与向上继承
        //下面是为了证明，如果子类和父类都有完全相同的属性或method，那么编译逻辑会优先选择子类的属性和method
        System.out.println("\ndynamic binding part");
        System.out.println(s1.getID());
        System.out.println(s1.ID);//父类的ID是123456，子类的ID是897291
        //这种统一的定义的结果就是，这是一个纯粹的subclass，因此他无论如何都会优先调用子类的var和method，只有没办法才会调用父类
        //而无论是 getID 这个method 和 还是 ID 这个var，均是子类都有的，因此，他均会返回子类数据。



        //---------------  动态绑定（多态） ----------------


        /*动态绑定指的是，用父类定义一个新的子类
        该方法的目的是为了减少多余的类，让类在子类和父类之间灵活转换。
        其实现的方法是：在定义的时候，其实是给足了子类的信息，但是也仅仅是记住了子类的信息，并没有去真的去定义一个子类，
        相反去利用这些信息去定义了一个父类。

        但是只要你需要，你可以通过cast将这个obj从父类很方便的变成子类，这时候，之前记录的子类信息也会被重新载入到子类构造器里，
        这个被cast过的类和你直接定义一个子类没有任何区别。

        这时候就显示出动态绑定的优势了： 即 cast == 新建一个子类；
        如果你不cast，那就是个父类！！ 这就是优势


        这种奇怪的定义方法造成的结果是：该obj会继承父类的属性（instance var），和全部的父类方法，但如果子类和父类有相同的method， 会优先使用子类的。
        因此，如果一个method只有子类里有，你还是用不了，你能用的method的范围不会超过父类。

        只所以会造成这种效果是因为，这种定义方式，method并不会在编译的时候就被确定下来，编译器只是把所有的相同名称的method（子类和父类均是）
        写下来作为备选，而只有当函数真的被调用执行的时候，系统会从所有备选的method中选一个最合适的，优先子类，如果子类没有，则会向上寻找父类

        动态绑定的时候，其总结如下
        成员变量：
        编译看父类，运行看父类
        成员method：
        编译看父类，运行看子类。
        静态方法：
        编译看父类，运行看父类

        原因就是多态的弊端，就是：不能使用子类特有的成员属性和子类特有的成员方法。

        那么如果我们还想继续子类里面特有的成员变量，我们该怎么办呢？

        cast！！！
        若Person s2 = new Student()
        我们可以 s2 =(Student) s2;  这个时候s2就可以使用student的特有方法了
        而用方法的时候要 ((Student) s2).method  把obj和cast括在一起去。




         */
        System.out.println("\ntest 多态和动态绑定");
        Person s2 = new Student("Cecilia","piggy",30,946257,"CC" );
        System.out.println("original"+s2.ID);//person里面的默认ID为123456 student里面的是946257
        System.out.println("casted"+((Student)s2).ID);
        System.out.println("method "+s2.getID());//如果调用person的method那么就返回的123456，如果调用student调用的是946257。
        //这里调用的明显是父类的ID(var)，和子类的Method(getID)，这种混合调用的方法（取父类constructor和于子类共同的method
        // 虽然不知道有什么用，但是很牛逼的样子。

        /*
        System.out.println(s2.department);虽然我在上面定义的时候已经定义了department的参数了，但是S2还是没有这个attribute，
         这说明s2完全的继承了person的constructor，可以你初始化的时候，不写department还真就不行。但是写了你也用不了
        */
        System.out.println(((Student) s2).getDepartment());//但你可以这么用，把s2转换为student类型

        /*
        System.out.println(s2.getFullInformation);
        这个method只有子类里面有，也是用不了的，因为s2归根结底还是一个父类。只不过是可以使用子类相同的method而已，没有的还是没有
         */

        System.out.println(((Student) s2).getFullInformation());


        /*通过上面的分析可以得到结论， Class1 obj = new Class 2, class1决定了obj的属性(constructor)，而class2 决定了
        obj的相同的method的选择。

         */

        //------------------   instance of -----------------
        System.out.println("\ninstance of test");

        System.out.println(s1 instanceof Student);

        System.out.println(s1 instanceof Person);

        //--------------- getClass --------------------
        System.out.println("\ngetClass test");

        System.out.println(s1.getClass());



        // upcasting 与 downcasting
        /*
        父类 转换成子类，有时候可以，有时候不行，但子类一定可以cast成父类。
         */
        System.out.println("\n upcasting");
        Person p1 = new Person("allen","Guan",19);
        Student ptos = (Student) p1;
        System.out.println(ptos.getFullInformation());

    }
}
