package final_package.final_test.Final_mistakes;

import java.util.Arrays;

public class String_Analysis {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abff";
        String s3 = s1;

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1==s3);

        System.out.println(s1.compareTo(s2));

        //----str.toCharArray ------

        //把string变成char array
        String str = "fgfasdfggg";
        char[] strs = str.toCharArray();

        //-------Arrays.sort-------
        //sort array
        Arrays.sort(strs);
        System.out.println(strs);

        //------charAt-------
        System.out.println(str.charAt(4));


        //------- indexof -----
        //返回的是第一个找到的,如果找不到，会返回-1；
        System.out.println("\n");
        System.out.println(str.indexOf("w"));


        //----toUpperCase-----

        System.out.println(str.toUpperCase());

        //------ substring --------
        System.out.println(str.substring(1,4));






        //---------------------------------------------------example-------------------------------------------------
//        testOverlap("asd","aidski");
        System.out.println(testOverlap("aswd","aidski"));


    }

    public  static boolean testOverlap(String s1, String s2){
        for(int i=0; i<s1.length();i++){
            for(int j=0; j<s2.length();j++){
                if(s2.indexOf(s1.charAt(i))==-1){
                    return false;
                }
            }
        }
        return true;
    }


}
