package Lab4;
/*
String 里面contains的用法！！
 */
public class test {
    public static void main(String[] args){
        printMovies a = new printMovies();
        a.inputMovies("Avengers1");
        a.inputMovies("Avengers2");
        a.inputMovies("Avengers3");
        a.inputMovies("Avengers4");
        a.inputMovies("Avengers5");
        a.printList();



        //关于string 的API  contains
        // contains 返回的是true or false，用于判定是否含有字符串。
        String str = "this is a good day to die! ";
        System.out.println(str.contains("day"));

    }
}
