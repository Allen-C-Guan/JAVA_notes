package method;

public class Usage_Of_Method {

    public static void main(String[] args) {
        //main也只是一个函数而已，和其他所有函数没有任何区别，只是人们习惯在一main命名的method里面调用其他函数
        //myCar("Honda");
        System.out.println("this car is : "+Usage_Of_Method.myCar("Honda")); //在定义过后，该函数整体在类型上，就变成一个string了，
        //所有可以对string使用的方法，都可以对这个函数使用。

        System.out.println(myCar("honda",10000));//当input的参数列表的类型不同的时候，java会自动选择对应的method

        System.out.println("is that car is mime? "+isMyCar("yes"));//return 是boolean的例子

        /* public 和 private 的区别 */
        Example2.myCar("dafdsf");//对于public的method，我们可以采用 Class.method()的方式来调用（和python相同）

        /****************/
        //Example2.myCar2();这里myCar2是一个private，因此不可以被其他class调用。
    }

    private static String myCar(String text) {
		/*在java里面，一个函数的声明的格式是固定的，
		即 public/private（通常情况下，除非需要跨class使用，不然method都是private的）+ static（表示后面的string是静态且是一个全局变量）
		+ type（返回值的类型，只要声明了有返回值，就必须有，不能没有）+ name（小写开头，大写分割单词）
		 */
        System.out.println("this is my car:"+text);
        if (text == "Honda"){
            return "yellow";
        }
        else {
            return "blue" ;	//return 可以用很多，但是，return必须要保证每个逻辑流都有且只有一个，并且没有一条逻辑流是没有return的
        }
    }
    private static String myCar(String name, int value) {
		/* signature=方法名+传入形参数据类型列表，与方法的返回值一点关系都没有。
		 * 这样做的优点在于，java可以通过不同的input列表，来自动的对应不同的function，得出不同的结果
		因此，如果name + 传入的参数的类型完全相同，signature就是相同的，那么java会认为是同一个method，
		但是如果仅有返回的type是不同的，那么这两个函数是具有相同signature的，  **这样的命名方式和违法的，**
		*/
        String result = "the name of my car is: "+ name+"\n"+"the value of my car is: "+value;
        return result;
    }
    private static boolean isMyCar(String judge) {
        // 这个返回值就是boolean了
        if (judge == "yes") {
            return true;
        }else {
            return false;
        }
    }



}
