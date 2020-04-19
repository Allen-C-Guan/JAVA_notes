package method;

public class Example2 {
    public static void myCar(String a) {
        String str = a;
        System.out.println("this sentence from Example class!"+str);
    }
    private static void myCar2() {//只对被人保护，自己可以调用
        System.out.println("a");
    }
}
