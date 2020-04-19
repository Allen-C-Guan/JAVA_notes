package Test;

public class Gtest <T1, T2> {
    T1 var1;
    T2 var2;
    public Gtest(T1 var1, T2  var2){
        this.var1 = var1;
        this.var2 = var2;
    }

    public static void main(String[] args) {
        Gtest<String, Integer> allen = new Gtest<String, Integer>("Allen",25);
    }


}
