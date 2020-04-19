package Lab8;

public class DressShoe extends Shoe {


    private HeelType heeltype;

    //默认空obj！
    public DressShoe() {
        super();
        heeltype = HeelType.HEEL;
    }



    public DressShoe (String color, String designer, float size, HeelType heeltype){
        super(color,designer,size);
        this.heeltype = heeltype;
    }


    //通常情况还要overload tostring （我懒得写类）和equail
    public String toString(){
        return super.toString();
    }


    //这里有个牛逼的写法！！
    //在class里面用class有的method，我们不用写实例化的部分，例如getColor(),到时候实例化以后，会自动填充上的。


    /*
    equail通常用来判定两个obj是不是一样的，其传入的参数是  Object大类！！！
    而判定的逻辑是这样的：
    if 这是个null return 滚
    else if 是不是一个class的（getClass()) （对比的是classd名字）
    else 要cast到同一类，为了防止继承的出现导致的混乱的关系（因为继承，即使父子关系也认为是一个类）
        而后对比各个属性是否一样。
     */
    public boolean equals(Object o){  //一定是Object类。
        if(o == null){
            return  false;
        }else if (getClass() != o.getClass()){
            return false;
        }else{
            DressShoe others = (DressShoe) o;  //这个cast很精髓
            return others.getColor() == getColor();
        }
    }
}
