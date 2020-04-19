package Interface;
/*
在interface里面，所有的
变量： public static final（常量）
method：public abstract

因此在interface里面根本不需要写这些东西，直接从类开始写就行了

这个interface定义了查看的属性。是否可以查看，查看之后会发现更细节的内容


这个interface只规定一个var和一个getDetailedDescription()的method
 */
public interface Inspectable{
    String detailIntro = "Looking closer, you see";//在interface里定义的变量在外面就都可以用啦！！并且是静态（全局）变量
    String getDetailedDescription();
}