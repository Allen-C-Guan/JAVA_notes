package Generic;

import java.util.*;

/*
这么做的目的是可以让object之间被sort，而sort的标准是compareTo定义的正负数。

sort的常用方法是：
Collections.sort()  用在list的身上
Arrays.sort()       用在array的身上
 */

public class Students extends Person implements Comparable<Person>{

    private String name;
    private int age;
    public int ID;

    public Students(Person p, int ID){
        super(p.getName(),p.getAge());
        this.ID = ID;
    }


    @Override

    /*
    compareTo是Comparable执行的基础, comparable interface利用的是 comparaTo返回的值正负来比较大小的，如果返回值为正，就是大于，返回值是负的就是小于

    而compareTo 是把所有对比的内容都cast为输入的类，例如在本例子中，在对比的时候，他会把students cast成为Person，而后利用Person里面的方法来执行而后对比。

    如果你不需要继承，只是自己和自己类对比，那么所有类写自己就好了，并去掉extend

    例如Comparable<Students>

    compareTo(Students o)
     */
    public int compareTo(Person o) {
        return age-o.getAge();
    }






    public static void main(String[] args) {
        Person p1 = new Person("allen",9);
        Person p2 = new Person("celila", 60);

        Students s1 = new Students(p1,432423);
        Students s2 = new Students(p2,10000);

        //comparable测试
        Students [] array = {s2,s1};

        for(Students temp : array){
            System.out.println(temp.getName());
        }

        Arrays.sort(array);

        for(Students temp : array){
            System.out.println(temp.getName());
        }


        //----------- arraylist -----------
        //ArrayList 的实现是基于interface而来的，你在放东西之前，实例化的时候才开始定义往里放的是什么type。
        //使用ArrayList的时候，我们需要用generic的方法，
        // 即 ArrayList<type> name = new ArrayList<type> ();

        ArrayList<Person> list = new ArrayList<Person>();
        //由于继承的关系，我们的list可以放所有person和person子类的obj在里面
        list.add(s1);
        list.add(s2);
        list.add(p1);
        list.add(p2);


        //Collection
        //collection是给抽象的类，不能被实例化，但是你可以用动态绑定啊， ArrayList可以被实例化啊，

        Collection<Person>  collection = new ArrayList<>();

        //同理list也是
        
        List<Person> l = new LinkedList<>();


    }


}
