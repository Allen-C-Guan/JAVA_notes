public class CheckerChecker {

    public static void main(String[] args) {
        //--------------------- set bug ----------------------



        //-----------------   bug 1 always red ---------------
        boolean error1 = false;
        Checker a = new Checker(false);
        if (a.isRed()){
            error1 = true;
        }
        System.out.println( "bug 1 result "+error1);

        //-----------------   bug 2 TRANSPOSE_position -----------
        boolean error2 = false;
        Checker b = new Checker (true , 3, 5);

        if (!(b.getRow() == 3 && b.getColumn() == 5)){
            error2 = true;
        }
        System.out.println("bug 2 result "+error2);

        //------------------  bug 3 TRANSPOSE_MOVE ---------------
        boolean error3 = false;
        Checker c = new Checker(false, 2, 2);
        c.move(1,-1);

        if (!(c.getRow() == 3 && c.getColumn() == 1)){
            error3 = true;
        }
        System.out.println("bug 3 result "+error3);

        //------------------  bug 4 allow backwards   ----------
        boolean error4 = false;
        Checker d = new Checker(false, 2, 2);
        d.move(-1,-1);

        if (!(d.getRow() == 2 && d.getColumn() == 2)){
            error4 = true;
        }
        System.out.println("bug 4 result "+error4);

        //-----------------  bug 5 ALLOW_TOO_FAR --------------
        boolean error5 = false;
        Checker e = new Checker(false, 2, 2);
        e.move(2,2);
        if (!(e.getRow() == 2 && e.getColumn() == 2)){
            error5 = true;
        }
        System.out.println("bug 5 result "+error5);

        //---------------- bug6  ALLOW_OFF_LEFT --------------
        boolean error6 = false;

        Checker f = new Checker(true, 3, 1);
        //f.setBug(6);
        f.move(-1,-1);
        if (!(f.getRow() == 3 && f.getColumn() == 1)){
            error6 = true;
        }
        System.out.println("bug 6 result "+error6);

        //---------------- bug 7 ALLOW_OFF_RIGHT --------------
        boolean error7 = false;

        Checker g = new Checker(false, 4, 8);
        //g.setBug(7);
        g.move(1,1);
        //System.out.println(g.getRow());
        //System.out.println(g.getColumn());
        if (!(g.getRow() == 4 && g.getColumn() == 8)){
            error7 = true;
        }
        System.out.println("bug 7 result "+error7);

        //--------------- bug 8 ALLOW_OFF_TOP ------------
        boolean error8 = false;

        Checker h = new Checker(false, 8, 6);
        //h.setBug(8);
        h.move(1,1);

        if (!(h.getRow() == 8 && h.getColumn() == 6)){
            error8 = true;
        }
        System.out.println("bug 8 result "+error8);

        //-------------- bug 9 ALLOW_OFF_BOTTOM ------------
        boolean error9 = false;

        Checker i = new Checker(false, 0, 4);
        if (!(i.getRow() == 1 && i.getColumn() == 1)){
            error9 = true;
        }
        System.out.println("bug 9 result "+error9);



        // ---------------- bug 10 ALLOW_INVALID_SQUARE -----------
        boolean error10 = false;

        Checker j = new Checker(false, 4, 5);
        if (!(j.getRow() == 1 && j.getColumn() == 1)){
            error10 = true;
        }
        System.out.println("bug 10 result "+error10);


        boolean error = error1||error2||error3||error4||error5||error6||error7||error8||error9||error10;
        if(error){
            System.out.println("BUG");
        }
        else{
            System.out.println("CORRECT");
        }
    }


}
