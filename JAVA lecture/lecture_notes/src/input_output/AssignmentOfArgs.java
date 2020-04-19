package input_output;

public class AssignmentOfArgs {
    public static void main(String[] args) {

        //println表示单开一行，而且输出完结束，args的设置要在
        //右键-->run as--》configuration——》arguments中的第一栏来设置
        //args的index是按字符串来分的，只要没有空格，就全都是arg0里面的

        System.out.println("the first args is "+args[0]);
        System.out.println("the second args is "+args[1]);

    }

}
