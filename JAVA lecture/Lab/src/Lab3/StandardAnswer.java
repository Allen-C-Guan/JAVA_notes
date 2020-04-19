package Lab3;

public class StandardAnswer {
    public static void main(String[] args){
    // Print out column headings
        System.out.print("  *  ");
        for (int i = 1; i <= 10; ++i) {
        System.out.printf("| %3d ", i);          //我们采用%3d的方法让数字前面空2行！！！
                                                    //并且可以把竖杠和数字和在一起
    }
        System.out.println();

//    // Print table

        //在这里他高明的地方在用把竖杠和数字两行合并在一个循环里去打印了。这个逻辑很牛逼！能合并的逻辑越多，代码实现起来越清晰，越简单
        for (int row = 1; row <= 10; ++row) {
            // Print out separator line
            System.out.print("-----");
            for (int i = 1; i <= 10; ++i) {
                System.out.print("+-----");
            }
            System.out.println();

            // Print row heading
            System.out.printf(" %3d ", row);

            // Print row data
            for (int column = 1; column <= 10; ++column) {
                System.out.printf("| %3d ", row * column);
            }
            System.out.println();
    }
}
}
