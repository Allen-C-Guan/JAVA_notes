/*

This class is used to record all the information of a player, including player name,input, ranks,
suits, card type and some key information about the card type (ie. the rank of a pair, highest rank)

This class is mainly to achieve the following process:
1. record input args
2. getting rank, suits from args
3. classify the category depending on ranks and suits

ps:
all 3 steps are finished in constructor which means all information have be recorded and calculated
just at instancing object
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Player {

    // instance vars
    private int[] ranks;
    private Suits[] suits;
    private KeyRanks key_ranks;
    private CardType cardtype;
    private String [] inputs;
    private String player_name;

    //-------------- constructor -------------
    /**
     * constructor
     * this constructor finish all steps(get player's all information)
     * @param inputs
     */
    public Player(String [] inputs,String player_name){

        this.ranks = new int [inputs.length];
        this.suits = new Player.Suits[inputs.length];
        this.inputs = inputs;
        this.player_name = player_name;

        this.ranks = decodeAndSortRanks(this.inputs); //take out the sorted ranks from input args
        this.suits = setSuitsArray(this.inputs);       //take out the suits from input args
        this.key_ranks = nOfAKind(this.ranks);        //record key ranks from sorted ranks
        this.cardtype = Classifier(this.key_ranks);   //category card type depend on key ranks and suits type
    }


    /**
     * this class record the key information:
     * 1. the value of pairs if it have(including smaller pairs, bigger pairs)
     * 2. the value of 3,4 of a kind if it have
     * 3. the value of Highest rank
     * otherwise equal = 0
     */
    public class KeyRanks {
        private int SMALLER_PAIR = 0;
        private int BIGGER_PAIR = 0;
        private int THREE_OF_A_KIND = 0;
        private int FOUR_OF_A_KIND = 0;
        private int HIGHEST_RANK = 0;

        int getSMALLER_PAIR(){
            return SMALLER_PAIR;
        }
        int getBIGGER_PAIR(){
            return BIGGER_PAIR;
        }
        int getTHREE_OF_A_KIND(){
            return THREE_OF_A_KIND;
        }
        int getFOUR_OF_A_KIND(){
            return FOUR_OF_A_KIND;
        }
        int getHIGHEST_RANK(){
            return HIGHEST_RANK;
        }

    }


    //------------- card type enum    ---------
    public enum CardType {
        ERRORTYPE,
        STRAIGHT_FLASH,
        FOUR_OF_A_KIND,
        FULL_HOUSE,
        FLUSH,
        STRAIGHT,
        THREE_OF_A_KIND,
        TWO_PAIR,
        ONE_PAIR,
        HIGH_CARD;
    }

    //---------------- suit enum -------------------
    public enum Suits {
        C("Clubs"),
        D("Diamonds"),
        H("Hearts"),
        S("Spades");

        public String name;

        private Suits(String name) {
            this.name = name;
        }

    }

    //---------------- public method ----------------

    /**
     * the key point of this method is: recording < all possible > card type in the list,
     * at the end, sorting the list and return the largest card type
     * @param keyRanks
     * @return Largest type
     */
    private CardType Classifier(KeyRanks keyRanks) {


        List<CardType> card_type_list = new ArrayList<CardType>();

        if(isFlush()&&isStraight()){
            card_type_list.add(CardType.STRAIGHT_FLASH);
        }
        if (isFlush()) {
            card_type_list.add(CardType.FLUSH);
        }
        if (isStraight()) {
            card_type_list.add(CardType.STRAIGHT);
        }
        if (keyRanks.SMALLER_PAIR != 0) {
            card_type_list.add(CardType.ONE_PAIR);
        }
        if (keyRanks.BIGGER_PAIR != 0) {
            card_type_list.add(CardType.TWO_PAIR);
        }
        if (keyRanks.THREE_OF_A_KIND != 0) {
            if (keyRanks.SMALLER_PAIR != 0) {
                card_type_list.add(CardType.FULL_HOUSE);
            } else {
                card_type_list.add(CardType.THREE_OF_A_KIND);
            }
        }
        if (keyRanks.FOUR_OF_A_KIND != 0) {
            card_type_list.add(CardType.FOUR_OF_A_KIND);
        }
        card_type_list.add(CardType.HIGH_CARD);

        //sorted the enumerate list by definition order.
        Collections.sort(card_type_list);


        // return biggest(first) one in the list
        return card_type_list.get(0);
    }




    //-------------------  N of a kind  ----------------------

    /**
     * recording duplicated ranks and assign KeyRanks
     * @param sorted_ranks
     * @return KeyRanks
     */

    private KeyRanks nOfAKind(int[] sorted_ranks) {

        int i = 0;
        int runlength;
        KeyRanks key_ranks = new KeyRanks();
        int[] ranks = sorted_ranks;

        /*calculation duplicated ranks:
        the pointer(runlength) will continuously move backward until the different rank appeared.
        so that the length of pointer is the times of duplication
         */
        while (i < ranks.length) {
            runlength = 1;
            while (i + runlength < ranks.length && ranks[i + runlength] == ranks[i]) {
                runlength++;
            }
            int n_of_a_kind = runlength;
            int current_index = i + runlength - 1;
            int current_rank = ranks[current_index];

            // classification depending on length of pointer(ie.if len(pointer)=2,means that is a pair)
            switch (n_of_a_kind) {
                case (2)://2 times of duplication
                    if (key_ranks.SMALLER_PAIR == 0) {
                        key_ranks.SMALLER_PAIR = current_rank;
                    } else {
                        key_ranks.BIGGER_PAIR = current_rank;
                    }
                    break;
                case (3)://3 times of duplication
                    key_ranks.THREE_OF_A_KIND = current_rank;
                    break;
                case (4)://4 times of duplication
                    key_ranks.FOUR_OF_A_KIND = current_rank;
                    break;
            }
            i = i + runlength;
        }
        key_ranks.HIGHEST_RANK = ranks[ranks.length-1];

        return key_ranks;
    }


    //------------------  boolean isFlush  ----------------

    private boolean isFlush() {
        return this.suits[0] == this.suits[1] && this.suits[1] == this.suits[2] &&
                this.suits[2] == this.suits[3] && this.suits[3] == this.suits[4];
    }
    //----------------- boolean isString()   --------------

    private boolean isStraight() {
        return this.ranks[0] + 1 == this.ranks[1] && this.ranks[1] + 1 == this.ranks[2] &&
                this.ranks[2] + 1 == this.ranks[3] && this.ranks[3] + 1 == this.ranks[4];
    }

    //------------- decode  ranks ---------------

    /**
     * this method change the ranks from 2 3...J Q K A into 2 3 4 ... 11 12 13 14.
     * In addition, it is also an illegal input filter.
     * @param inputs
     * @sorted ranks
     */
    private int[] decodeAndSortRanks(String[] inputs) {
        //decoding and sorting ranks as int array.
        int[] ranks =  new int[inputs.length];
        for(int i = 0; i<inputs.length;i++) {
            ranks[i]=Character.getNumericValue(inputs[i].charAt(0)) ;
        }

        for(int i = 0; i< inputs.length;i++){
            final int A = 10;
            final int T = 29;
            final int J = 19;
            final int Q = 26;
            final int K = 20;
            // illegal input filter
            if(ranks[i]<0){
                System.out.println("Error: wrong number of arguments; must be a multiple of 5");
                System.exit(1);
            }else{
                switch(ranks[i]){
                    case(A): ranks[i] = 14; break;
                    case(T): ranks[i] = 10; break;
                    case(J): ranks[i] = 11; break;
                    case(Q): ranks[i] = 12; break;
                    case(K): ranks[i] = 13; break;
                    case(2):
                    case(3):
                    case(4):
                    case(5):
                    case(6):
                    case(7):
                    case(8):
                    case(9):break;
                    default:
                        System.out.println("Error: invalid card name "+"'"+inputs[i]+"'");
                        System.exit(0);
                }
            }
        }
        Arrays.sort(ranks);
        return ranks;
    }



    //----------- encode ranks -----------

    /**
     * changing the ranks from 10 11 12 13 14 into T J Q K
     * @param rank
     * @return
     */
     private String encoder(int rank){
        String result;
         switch(rank){
             case(14): result = "Ace"; break;
             case(10): result = "10"; break;
             case(11): result = "Jack"; break;
             case(12): result = "Queen"; break;
             case(13): result = "King"; break;
             default: result = ""+rank;//changing number to String

         }
         return result;
     }


    //---------- setSuitArray -----------

    /**
     * get the suit array from letter to enum.
     * it is also a filter.
     * @param inputs
     * @return
     */
    public Suits[] setSuitsArray(String[] inputs){
        //loading suits container
        Suits [] suits = new Suits[inputs.length];
        for(int i=0; i<suits.length; i++){
            int suit_num = Character.getNumericValue(inputs[i].charAt(1));
            final int C = 12;
            final int D = 13;
            final int H = 17;
            final int S = 28;

            switch (suit_num){
                case(C):
                case(D):
                case(H):
                case(S):break;
                default:System.out.println("Error: invalid card name "+"'"+inputs[i]+"'");
                        System.exit(0);
            }
            suits[i] = Player.Suits.valueOf(String.valueOf(inputs[i].charAt(1)).toUpperCase());
        }
        return suits;
    }


    //----------- accessor ----------
    public KeyRanks getKey_ranks(){
        return this.key_ranks;
    }
    public CardType getCardtype(){
        return this.cardtype;
    }
    public Suits[] getSuits(){
        return this.suits;
    }
    public int[] getRanks(){
        return this.ranks;
    }

    public String getPlayer_name() {
        return player_name;
    }

    //------ (override) toString --------

    /**
     * using override to print the player's card type
     * @return
     */
    @Override
    public String toString() {
        switch (this.cardtype){
            case STRAIGHT_FLASH:
                return ": "+encoder(key_ranks.HIGHEST_RANK)+"-high straight flush";
            case FOUR_OF_A_KIND:
                return": "+"Four "+encoder(key_ranks.FOUR_OF_A_KIND) +"s";
            case FULL_HOUSE:
                return ": "+encoder(key_ranks.THREE_OF_A_KIND) +"s full of "
                            +encoder(key_ranks.SMALLER_PAIR) +"s";
            case FLUSH:
                return ": "+encoder(key_ranks.HIGHEST_RANK)+"-high flush";
            case STRAIGHT:
                return ": "+encoder(key_ranks.HIGHEST_RANK)+"-high straight";
            case THREE_OF_A_KIND:
                return ": "+"Three "+encoder(key_ranks.THREE_OF_A_KIND) +"s";
            case TWO_PAIR:
                return ": "+ encoder(key_ranks.BIGGER_PAIR) +"s over "
                            +encoder(key_ranks.SMALLER_PAIR) +"s";
            case ONE_PAIR:
                return ": "+ "Pair of "+encoder(key_ranks.SMALLER_PAIR) +"s";
            case HIGH_CARD:
                return ": "+ encoder(key_ranks.HIGHEST_RANK)+"-high";
            default:
                return "Error";
        }
    }
}

