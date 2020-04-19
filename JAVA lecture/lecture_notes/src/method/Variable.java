package method;

public class Variable {
    /********/
    // global variable 比如要放在所有函数之外，直接隶属于一个class，并且要加上static，表示全局变量
    static int global_value = 1;			//static 表示全局变量
    static final int DAY_PER_WEEK = 7;      //final表示不可更改

    public static void main(String[] args) {
        // variable test
        System.out.println("the glabal variable value is:"+global_value);
        testVariable();
        //local_var =40;如果把local var 放在 method之外，就会报错


    }
    private static void testVariable() {
        int local_var = 100;
        System.out.println("the local variable value is: "+local_var);//loal只能在一个method之内用

        System.out.println("the global variable value becomes: "+(global_value+1));//global variable可以被子函数调用
        //必须要加上括号才行，
        System.out.println("the week days="+DAY_PER_WEEK);//也是全局变量

        //DAY_PER_WEEK+1；这样做是违法的，因为 final不可更改。
    }

}
