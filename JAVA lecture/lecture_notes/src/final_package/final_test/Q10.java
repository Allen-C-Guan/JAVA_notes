package final_package.final_test;

public class Q10 {
    public static void main(String[] args) {
        Inherited inheritedObject = new Inherited();
        int i = inheritedObject.addCount();
        System.out.println(i);


        System.out.println(inheritedObject.getClass());
        String str = "adfadf";
        System.out.println(str.getClass().getName());
        System.out.println(inheritedObject.getClass().getName());
        System.out.println(inheritedObject);
    }

}
