package mutable_Objects;

public class Test {
    public static void main(String args[]) {

        //先建立两个人
        Person p1 = new Person("Allen","Guan");
        Person p2 = new Person("Shuo","Piggy");

        // 在建立一个missing person
        MissingPerson match = new MissingPerson(p1,p2,"Melbourne");
        System.out.println(match.matchlist());
        System.out.println(match.getlocation());
        System.out.println("");


        //privacy leaks（第一种constructor）
		/*我们已经成功的建立了match obj，就是说match里面的名字本来应该是都齐全的。
		竟经过了filter。可是我们仍然可以通过更改p1.setname的形式，把p1的名字改成空。
		利用set.name可以绕过filter的检查而实现违法操作
		*/

		//如果我们采用第二种constructor的方式，那么你会发现，无论你怎么改变p1和p2， missing person的值是不会变的。
        p1.setfirst_Name("nano");
        System.out.println("seekers name of p1 is: "+match.getseeker_name());
        System.out.println("");
        //此时p1的值就不在符合其filter的值了

        //person 的复制
        Person p_orig = new Person("allen","chen");
        Person p_fake_copy = p_orig;
        //这里我们只是复制了pointer而已，其物理地址是同一个。
        Person p_copy = new Person(p_orig);
        //我们通过copy constructor 用一个obj去建立了一个新的obj

        p_orig.setfirst_Name("none");
        System.out.println("the orig become to: "+p_orig.getfirst_Name());
        System.out.println("the fake copy become to: "+p_fake_copy.getfirst_Name());
        System.out.println("the copy become to: "+p_copy.getfirst_Name());
        System.out.println("");



        //filter的作用
        Person p3 = new Person("","");
        MissingPerson match_new = new MissingPerson(p3,p2,"Melbourne");
        System.out.println("");
        //及时报错
    }

}
