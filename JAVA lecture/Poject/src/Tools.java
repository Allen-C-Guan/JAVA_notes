import java.util.Arrays;

public class Tools {






    public static final int A = 10;
    public static final int T = 29;
    public static final int J = 19;
    public static final int Q = 26;
    public static final int K = 20;


    //-------------------  getSortedRanks   --------------------
    //getRank Method return the sorted numerical ranks of the input arguments in array.

    public static int [] getSortedRanks (String [] args){
        int [] rank = new int [args.length];

        for(int i = 0; i<args.length;i++) {
            rank[i]=Character.getNumericValue(args[i].charAt(0)) ;
        }

        for(int i = 0; i<rank.length;i++){

            switch(rank[i]){
                case(A): rank[i] = 1; break;
                case(T): rank[i] = 10; break;
                case(J): rank[i] = 11; break;
                case(Q): rank[i] = 12; break;
                case(K): rank[i] = 13; break;
            }
        }

        Arrays.sort(rank);//这个方法没有返回，是在原来array基础上sort的。
        return rank;
    }




    //-------------------  getSuits   --------------------
    // getSuit return an array with type enum,including all suits information.

    public static Classify.Suits [] getSuits(String [] args){
        Classify.Suits [] suits = new Classify.Suits[args.length];
        for(int i=0; i<suits.length; i++){
             suits[i] = Classify.Suits.valueOf(String.valueOf(args[i].charAt(1)));
        }
        return suits;
    }






//    //---------- setClass  ----------
//    public static final int hight_card = 0;
//    public static final int one_pair = 1;
//    public static final int two_pair = 2;
//    public static final int three_of_a_kind = 3;
//    public static final int straight = 4;
//    public static final int flush = 5;
//    public static final int flush_house = 6;
//    public static final int four_of_a_kind = 7;
//    public static final int straight_flash = 8;
//
//
//    public static Classify.CardType setClass(int level){
//        switch (level){
//            case(hight_card):return Classify.CardType.HIGH_CARD;
//            case(one_pair):return Classify.CardType.ONE_PAIR;
//            case(two_pair):return Classify.CardType.TWO_PAIR;
//            case(three_of_a_kind):return Classify.CardType.THREE_OF_A_KIND;
//            case(straight):return Classify.CardType.STRAIGHT;
//            case(flush):return Classify.CardType.FLUSH;
//            case(flush_house):return Classify.CardType.FULL_HOUSE;
//            case(four_of_a_kind):return Classify.CardType.FOUR_OF_A_KIND;
//            case(straight_flash):return Classify.CardType.STRAIGHT_FLASH;
//        }
//        return  Classify.CardType.ERRORTYPE;
//    }





}
