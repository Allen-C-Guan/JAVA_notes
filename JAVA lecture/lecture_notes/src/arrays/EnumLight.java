package arrays;
enum Signal {
    Green, Yellow, Red;
}
public class EnumLight {
    private Signal color ;

    // enum与switch的联合使用的方法！！目的是增加可读性。

        //-------constructor------
        public EnumLight(Signal light){
            Signal color = light;
        }

        public Signal change() {
            switch (color) {
                case Red:
                    return  Signal.Green;

                case Yellow:
                    return  Signal.Red;

                case Green:
                    return Signal.Yellow;

                default:
                    return Signal.Red;
            }
        }
        public Signal getSignalColor(){
            return color;
        }


    public static void main(String[] args) {
       Signal s = Signal.Green;
       EnumLight e = new EnumLight(Signal.Green);
       System.out.println(e.change());






       //compareTo 可以表示index相差的大小
       System.out.println(s.compareTo(Signal.Yellow));






    }


}
