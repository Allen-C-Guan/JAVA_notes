package Interface;

import java.util.Arrays;

public class Sack extends DungeonItem implements Openable {

    /*
    sack（袋子）要有自己的属性：是否是系上的，
    袋子里都有些什么东西（当时里面的每个东西都应该是个DungeonItem的类）
    描述性的词语。
     */
    String detail;
    DungeonItem[] contents = new DungeonItem[0];
    private boolean tied = false;


    public Sack(String detail){
        this.detail = detail;
    }

    //---- add items -----
    public void addItem(DungeonItem item){
        if(item instanceof Openable){ //如果item是一种可以打开的物品，我们需要先关上,instanceof 返回的是该obj是否属于该类或者iterface
            ((Openable)item).close();//我们需要把这个obj 强行变成Openable的类，然后给他关上。其实只要是Openable（)就应该可以被关上，即使不被cast
        }

        /*----- 非常经典的array增长的一个模块
        1.System.copyarray()
        2.尾部加上新的值
        3.自我更新
         */
        //我们要想改变array，重新建立一个array，并把老得array赋值过来，新的加进去
        DungeonItem[] newContents = new DungeonItem[contents.length+1];

        //将array 复制过来
        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(contents, 0, newContents, 0, contents.length);

        newContents[contents.length]= item;
        contents = newContents;
    }



    //------- DungeonItem --------------
    @Override
    /*
    袋子的getDescription，如果有东西就一个一个拿出来，打印描述
    如果没有东西就不描述
    还有判定袋子有没有系上。

     */
    public String getDescription() {
        String  descr = "a"+ detail+"snack";
        if(tied){
            descr += "用细麻线绑起来了";
        }else{
            descr += "containing"+(contents.length>0 ? ":" : "啥也没有啊");
            //这是if else的简单写法。（ statement ? A : B ） 如果statement是真的，则 括号里面是A，不然就是B

            //把array取出来，一个个拿出来看描述。
            for(DungeonItem item : contents){
                descr += "\n\t"+item.getDescription();
            }
        }
        return descr;
    }

    //Openable
    //是否可以直接打开取决于有没有系上
    @Override
    public boolean isOpen() {
        return !tied;
    }

    //打开就不系上
    @Override
    public void open() {
        tied =false;

    }

    //关上就系上
    @Override
    public void close() {
        tied =true;

    }
}
