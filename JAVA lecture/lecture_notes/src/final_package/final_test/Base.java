package final_package.final_test;

public class Base {
    protected int count;
    public int foo = 1;
    public Base () {
        count = 1;
    }

    /*obj的几个默认的方法
        1. getClass() 获得的是obj的class，其print的内容是 class class_name;
        2. getName() 是string里面内容，其目的是为了获得string的name。即去掉class

        因此如果你连用obj.getClass().getName()
        先获取一个字符串类的class的名称，而后又获得了string的name。


        toString就是这么写的，即默认返回的是class的名字，+ at +地址

        地址是如何写的呢？
        首先hashCode()会给出一个integer的地址
        你咋把integer转换成16进制就好了。

        而地址是用16进制表示的 toHexString()
         */
    public String toString(){
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }


}
