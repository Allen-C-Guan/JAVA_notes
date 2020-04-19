package Lab8;

//private不要忘记！！！

public class Shoe {
    protected String color;
    protected String designer;
    protected float size;

    //一般class都要给一个默认的空的实例化！！
    public Shoe(){
        this.color = "";
        this.designer = "";
        this.size= 0;
    }

    public Shoe(String color, String designer, float size){
        this.color = color;
        this.designer = designer;
        this.size = size;
    }











    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
