package Generic;
/*
通常情况下container的目的是用于存储多个obj的容器，从而间接地实现了method返回多个obj

而container 必须是完完全全immutable的。
所有变量都是private final.

input是Object，剩下的就是getter.
 */


public class WeakerPair {
    private final Object first;//这里用的是obj，因此没有什么筛选的功能
    private final Object second;

    public WeakerPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getSecond() {
        return second;
    }

    public Object getFirst() {
        return first;
    }

    public String toString(){
       return super.toString();
    }


//------- wrapper  boxing unboxing ------

    /*
    我们有上面container的局限性就是传入的参数必须是obj，而如果我想传入primitive 的参数例如int，char这些都不是obj啊

    这时候就需要一个东西把primitive类型的数据变成obj，这个东西就是wrapper。


    但是现在java可以自己变换了（从primitive到object），不需要wrapper了。这种操作叫autoboxing
     */



    //---- test ---
    public static void main(String[] args) {
        WeakerPair w = new WeakerPair(1,6);
        System.out.println(w.getFirst());

        // Integer 是 obj， int是primitive。
        //boxing   把primitive变成obj
        Integer i = new Integer(42);

        int j = i.intValue();

        int k = i;


    }
}
