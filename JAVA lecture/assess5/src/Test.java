public class Test {

    public static void main(String[] args) {

//        ChessPiece s1 = new Rook(2,4);
//        System.out.println(s1.getColumn());
//        System.out.println(s1.getRow());
//
//        System.out.println(s1.validMove(4,4));
//        System.out.println(s1);

//        ChessPiece s2 = new Bishop(2,4);
//        System.out.println(s2.getColumn());
//        System.out.println(s2.getRow());
//
//        System.out.println(s2.validMove(4,6));
//        System.out.println(s2);


        ChessPiece s2 = new Knight(4,4);
        System.out.println(s2.getColumn());
        System.out.println(s2.getRow());

        System.out.println(s2.validMove(5,6));
        System.out.println(s2);


    }
}
