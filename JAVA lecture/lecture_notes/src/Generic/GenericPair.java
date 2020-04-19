package Generic;

/*
我们在weakerPair的时候，让所有的input的类型都是obj，这也就意味着，所有obj都能进来，且无法辨别顺序。这样很不好

我们有没有什么办法先不确定它的type，一旦实例化之后再确定它的tape呢？
这就是Generic 我们用 <type1, type2,...>  这里type1和type2都表示某一种type，一旦实例化以后 type1和type2的值就确定下来了，这让这个
pair变得特别的灵活，而且一旦实例化之后，还能指定类型。这就是优势


 */
public class GenericPair<T1,T2> {

    /*
    这里t1，一会是string，一会是integer，可你用的方法都是完全相同的，实现这个的原因就是多态 (polymorphism).（用完全相同的函数处理多种类型的数据）
     */
    private final T1 first;
    private final T2 second;

    public GenericPair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }


    public T2 getSecond() {
        return second;
    }

    public T1 getFirst() {
        return first;
    }

    //generic的使用方法
    /*
    使用方法和class一样，只是多了一样标注一下类型，仅此而已！标注了以后，该实例的type类型就不能再改了。
     */
    public static void main(String[] args) {
        GenericPair<Integer,String> p1 = new GenericPair<Integer,String>(4,"nothing ");

        System.out.println(p1.first);
    }

//    @Override
//    public int compareTo(String o) {
//        return 0;
//    }
}

