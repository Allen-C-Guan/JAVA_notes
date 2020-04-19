package tuple;

public class Tuple {

    //建立tuple的泛形！！
    //建立的时候我们可以发现，我们不需要定义tuple的类型，A，B的类型还没有定下来。
    // 只有在我们实例话的时候，我们可以自己定义！
    public static class TwoTuple<A, B> {
        public final A first;  //A是变量名，first是变量的value
        public final B second;

        public TwoTuple(A a, B b) {
            this.first = a;
            this.second = b;
        }
    }


    public static void main(String[] args) {
        TwoTuple<String,Integer> sdf = new TwoTuple<String,Integer>("Greeks",1);
        System.out.println(sdf.first);
        System.out.println(sdf.second);

        //你看，tuple只规定了传入的参数是2个，我们可以利用这个参数，随意的在实例化的时候在定义tuple的类型
        TwoTuple<Integer,String> lala = new TwoTuple<Integer,String>(3,"lalal");
        System.out.println(lala.first);
        System.out.println(lala.second);
    }
}
