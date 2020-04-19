package Interface;
/*
Scroll(卷轴)是一个地牢中的一类物品，因此必然是继承于地牢这个抽象类，因此scroll也必须有描述。extends DungeonItem
而后我需要scroll可以被查看，因此scroll因此同时具有查看这个属性  implements Inspectable
 */
public class Scroll extends DungeonItem implements Inspectable {
    private final String scrollText;
    public Scroll(String scrollTest){
        this.scrollText = scrollTest;
    }

    //初步的一个描述（继承于items）
    @Override
    public String getDescription() {

        return "褪色的卷轴，上面覆盖着几乎无法辨认的华丽文字";
    }


    //详细的说明，继承于inspectable
    @Override
    public String getDetailedDescription() {
        return detailIntro+"the following words:\n"+scrollText;
        // interface中的变量(只要继承了就可以随便用)    Scroll的instance var
    }


}
