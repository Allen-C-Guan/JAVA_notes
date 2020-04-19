package Lab8;
/*
知识点：
equails的用法
getClass()的用法
一般的class都需要一个默认constructor with nan input param
 */





public class Test {
    public static void main(String[] args) {


        //---- class 中 getclass()的用法

        //getclass(),返回的是所属class的名字
        Shoe s = new Shoe("3", "4",699);
        System.out.println(s.getClass());

    }
}
