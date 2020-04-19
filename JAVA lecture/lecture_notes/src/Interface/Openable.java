package Interface;
//用来定义一个东西是否可以打开的属性。
//如果可以打开，则打开，同时还要有打开和关闭的功能

public interface Openable {
    boolean isOpen();
    void open();
    void close();
}
