package Interface;

public class CarvedBox extends DungeonItem implements Openable, Inspectable {

    /*
    盒子的定义：
    1。有些文字在盒子上
    2。这是个小盒子，所以只有一个东西在里面
    3。 一个flag表示打开
     */
    private final String inscription;//题词
    private DungeonItem contents = null;//
    private boolean open =false;

    public CarvedBox(String inscription) {
        this.inscription = inscription;
    }

    public void addItem(DungeonItem item){
        if(item instanceof Openable){
            ((Openable)item).close();
        }

        if(contents == null){
            contents = item;
        }else{
            System.out.println("盒子满了欧 亲");
        }
    }


    @Override
    /*
    若东西是开启的，就显示内容，若东西是关闭的，显示铭文
     */
    public String getDescription() {
        String descr ="这是一个华丽的木盒子";
        if(open){
            descr += "站在旁边等待揭晓";
            if(contents == null){
                descr += " 啥也没有";
            }else{
                descr += ":\n    "+ contents.getDescription();
            }
        }else{//若box是关闭的就显示铭文
            descr += " 封面上有精美的符文";
        }



        return descr;
    }

    @Override
    public String getDetailedDescription() {
        if(open) return "关上盒子再看细节";
        return detailIntro +"铭文是： '"+inscription+"'";
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void open() {
        open = true;
    }

    @Override
    public void close() {

        open = false;
    }
}
