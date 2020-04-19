/*


this class for calculating the card value by changing the card ranks into Hexadecimal number.
attention this value only meaningful for comparing players with same card type.

algorithm:
type 1: Keep the correspondence and convert the ranks from high to low into hexadecimal numbers
Scope of application: straight， high_card， flush and straight flash

type 2: take value of n_of_a_kind as highest bit, rest of ranks be calculated in type 1 method.

so that we get the relative value of card type

ps:
of course you do not need to divide algorithm into 2 type by just adding max value of previous level
so that you could get the absolute value instead of relative value.

but the value will be so large that it consumes a lot of memory and the amount of calculation is too large
 */


public class ValueCalculator {

    //--------  constructor   -------
    private String name;
    private int[] ranks;
    private double CARD_VALUE = 0;
    private Player.CardType cardType;
    private Player.KeyRanks key_ranks;


    /**
     * all step will be finished in constructor.
     * @param player
     */
    public ValueCalculator(Player player){
        this.name = player.getPlayer_name();
        this.ranks = player.getRanks();
        this.cardType = player.getCardtype();
        this.key_ranks = player.getKey_ranks();
        Run_Calculator();
    }

    //-------- method  -----------
    private void Run_Calculator(){
        switch (this.cardType){

            //type 1
            case STRAIGHT:
            case HIGH_CARD:
            case FLUSH:
            case STRAIGHT_FLASH:
                this.CARD_VALUE = HighCardCalculator(this.ranks);
                break;

            /**
             * CARD_VALUE = pair * 16^3 + single card value
             * combine all single card as High Card type
             */
            case ONE_PAIR:
                //create a new array only include single cards
                int new_array_len_1pair = this.ranks.length-2;
                int[] single_ranks_1pair = new int[new_array_len_1pair];
                int single_pair = this.key_ranks.getSMALLER_PAIR();
                int index_1pair = 0;
                for(int element:this.ranks){
                    if(element!=single_pair){
                        single_ranks_1pair[index_1pair] = element;
                        index_1pair++;
                    }
                }
                //pair value(largest weighted) + rest of value
                this.CARD_VALUE = HighCardCalculator(single_ranks_1pair)+single_pair*Math.pow(16,new_array_len_1pair);
                break;

            /**
             * CARD_VALUE = bigger pair * 16^2 + small pair * 16 + single card
             */
            case TWO_PAIR:

                int bigger_pair = key_ranks.getBIGGER_PAIR();
                int smaller_pair = key_ranks.getSMALLER_PAIR();

                for(int element:this.ranks){
                    if(element!=bigger_pair && element!=smaller_pair){
                        this.CARD_VALUE = element;
                    }
                }
                this.CARD_VALUE = bigger_pair*Math.pow(16,2)+smaller_pair*Math.pow(16,1)+this.CARD_VALUE;
                break;

            /**
             * CARD_VALUE = three of a kind * 16^2 + single ranks value(deal them as high card)
             */
            case THREE_OF_A_KIND:
                //create a new array only include single cards
                int[] new_array_3ofkind = new int[2];
                int three_of_a_kind = key_ranks.getTHREE_OF_A_KIND();
                int index_3ofkind = 0;

                for(int element:this.ranks){
                    if(element!=three_of_a_kind){
                        new_array_3ofkind[index_3ofkind] = element;
                        index_3ofkind++;
                    }
                }
                this.CARD_VALUE = three_of_a_kind * Math.pow(16,2)+HighCardCalculator(new_array_3ofkind);
                break;

            /**
             * full house = 3 of a kind * 16 + a pair
             */
            case FULL_HOUSE:
                this.CARD_VALUE = key_ranks.getTHREE_OF_A_KIND()*16+ key_ranks.getSMALLER_PAIR();
                break;

            case FOUR_OF_A_KIND:
                for(int element:this.ranks){
                    if(element!= key_ranks.getFOUR_OF_A_KIND()){
                        this.CARD_VALUE = element;
                    }
                }
                this.CARD_VALUE = key_ranks.getFOUR_OF_A_KIND()*16+CARD_VALUE;
                break;
        }
    }


    /**
     * HighCardCalculation
     * change ranks as Hexadecimal
     * @param ranks
     * @reture
     */
    private double HighCardCalculator(int[] ranks){
        double card_value = 0;
        for (int i=0; i<ranks.length;i++){
            card_value = card_value+ranks[i]*Math.pow(16,i);
        }
        return card_value;
    }

    //--------- accessor ---------
    public double getCARD_VALUE() {
        return CARD_VALUE;
    }

    public String getName() {
        return name;
    }
}
