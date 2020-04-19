public  class Classify {








    //------------- card type enum    ---------
    private enum CardType {
        HIGH_CARD(0),
        ONE_PAIR(1),
        TWO_PAIR(2),
        THREE_OF_A_KIND(3),
        STRAIGHT(4),
        FLUSH(5),
        FULL_HOUSE(6),
        FOUR_OF_A_KIND(7),
        STRAIGHT_FLASH(9),
        ERRORTYPE(10);


        // card type constructor
        int level;
        private CardType(int level){
            this.level = level;
        }

    }

    
    //---------------- suit enum -------------------
    public enum Suits{
        C ("Clubs"),
        D ("Diamonds"),
        H ("Hearts"),
        S ("Spades");

        private String name;
        private Suits(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    //-------------------- tuple -----------------------

    public static class Tuple<cardtype1,card_ranks1_1, card_ranks1_2,cardtype2,card_ranks2,cardtype3,card_ranks3>{
        cardtype1 pairs;
        card_ranks1_1 ranks_of_pairs1;
        card_ranks1_2 ranks_of_pairs2;
        cardtype2 three_of_a_kind;
        card_ranks2 ranks_of_3kinds;
        cardtype3 four_of_a_kind;
        card_ranks3 ranks_of_4kinds;

        //       tuple constructor

        Tuple(cardtype1 cardtype1, card_ranks1_1 num1_1, card_ranks1_2 num1_2, cardtype2 cardtype2, card_ranks2 num2, cardtype3 cardtype3, card_ranks3 num3){
            this.pairs = cardtype1;
            this.ranks_of_pairs1 = num1_1;
            this.ranks_of_pairs2 = num1_2;
            this.three_of_a_kind = cardtype2;
            this.ranks_of_3kinds = num2;
            this.four_of_a_kind = cardtype3;
            this.ranks_of_4kinds = num3;

        }
    }


    //--------------------- method ------------------------


    //------------------  boolean isFlush  ----------------
    private static boolean isFlush(Classify.Suits[] suits){
        return suits[0] == suits[1] && suits[1] == suits[2] &&
                suits[2] == suits[3]&&suits[3] == suits[4];
    }

    
    
    //----------------- boolean isString()   --------------

    private static boolean isStraight(int[] ranks){
        return ranks[0]+1==ranks[1]&&ranks[1]+1==ranks[2] &&
                ranks[2]+1==ranks[3]&&ranks[3]+1==ranks[4];
    }

    
    
    //----------------------  N of a kind  - return a Tuple -----------------

    /**
     * this method get the card type corresponding to input ranks
     * @param ranks
     * @return the card type (enum type)
     */

    private static Tuple<CardType,Integer,Integer, CardType,Integer, CardType,Integer>   nOfAKind(int[] ranks){

        //initial variables
        int i = 0;
        int runlength;

        Tuple<CardType,Integer,Integer, CardType,Integer, CardType,Integer>
                cardtype  = new Tuple<CardType,Integer,Integer, CardType,Integer, CardType,Integer>
                (CardType.ONE_PAIR,0,0, CardType.THREE_OF_A_KIND,0, CardType.FOUR_OF_A_KIND,0);

        //classification
        while(i<ranks.length){
            runlength  = 1;

            while(i+runlength < ranks.length && ranks[i+runlength]==ranks[i]){
                runlength++;
            }
            int n_of_a_kind = runlength;
            switch(n_of_a_kind){
                case(2):
                    if(cardtype.ranks_of_pairs1 ==0){
                        cardtype.ranks_of_pairs1 = ranks[i+runlength-1];
                    }else{
                        cardtype.ranks_of_pairs2 = ranks[i+runlength-1];
                    }

                    break;
                case(3):
                    cardtype.ranks_of_3kinds = ranks[i+runlength-1];
                    break;
                case(4):
                    cardtype.ranks_of_4kinds = ranks[i+runlength-1];
                    break;
            }
            i = i+runlength;
        }


        return cardtype;
    }



    //-----------------  classification ---------------------

    public static CardType Classification(int[] ranks, Classify.Suits[] suits){

        int ranks_of_pairs1 =nOfAKind(ranks).ranks_of_pairs1;
        int ranks_of_pairs2 =nOfAKind(ranks).ranks_of_pairs2;
        int ranks_of_3kinds =nOfAKind(ranks).ranks_of_3kinds;
        int ranks_of_4kinds =nOfAKind(ranks).ranks_of_4kinds;

        //judge full , straight and full straight
        if(isFlush(suits)){

            if(isStraight(ranks)){
                return CardType.STRAIGHT_FLASH;
            }else{
                return CardType.FLUSH;
            }
        }else if(isStraight(ranks)){
            return CardType.STRAIGHT;

         //2 pairs, 4 kinds, full+pairs , full + 2 singles pairs
        }else{
            if(ranks_of_pairs2!=0){
                return CardType.TWO_PAIR;

            }else if(ranks_of_4kinds!=0){
                return CardType.FOUR_OF_A_KIND;

            }else if(ranks_of_3kinds!=0){
                if(ranks_of_pairs1!=0){
                    return CardType.FULL_HOUSE;
                }else{
                    System.out.println("a "+ranks_of_3kinds+"Full "+" with 2 single ");
                    return CardType.THREE_OF_A_KIND;
                }

            }else if(ranks_of_pairs1!=0){
                return CardType.ONE_PAIR;

            }else{
                return CardType.HIGH_CARD;
            }

        }
    }

}
