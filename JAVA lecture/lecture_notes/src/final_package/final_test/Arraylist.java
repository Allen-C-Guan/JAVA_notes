package final_package.final_test;

public class Arraylist {

    /*
    ArrayList 是兼顾了list和array，但其中的add和remove确实list的操作逻辑。add表示插入，而不是覆盖，remove也是pointer的remove和重新连接

    lastIndexOf()是从array的后面向前找（通过调用equals），因此找到的是最后一个相同的地方。而IndexOf()是从前向后找。找到的第一个相同的地方

    contains是用来找是否包含该内容的。
     */
    public static void main(String[] args) {
        java.util.ArrayList<Double> marks = new java.util.ArrayList<Double>();
        marks.add(3.0);
        marks.add(2.5);
        marks.add(4.7);
        marks.add(3, 3.9);
        marks.add(1, 1.5);
        double a = marks.get(2);
        double b = marks.get(4);
        marks.remove(2);
        marks.remove(1);
        int c = marks.lastIndexOf(3.9);
        boolean d = marks.contains(2.5);
        int e = marks.indexOf(4.7);


        String str = "b";

        System.out.println(str.compareTo("B"));
    }
}
