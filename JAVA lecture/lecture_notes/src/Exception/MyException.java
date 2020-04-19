package Exception;

/*
你可以通过继承建立属于自己的exception

设计exception的方法和建立一般的class是一样的。

而不一样的是 extends Exception 和 super(msg)的用法来继承和传递message。
 */
public class MyException extends Exception{
    public MyException(){
        super();
    }

    public MyException(String msg){
        super(msg);
    }


}
