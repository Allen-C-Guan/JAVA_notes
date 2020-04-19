/*
this classifier could classify the card type of a hand
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Classifier {

    //----------constructor---

    int[] ranks;
    Suits[] suits;
    public Classifier(int[] ranks, Suits[] suits){
        this.ranks = ranks;
        this.suits = suits;
    }



    //------------- card type enum    ---------
    private enum CardType {
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

        public String toString() {
            return name;
        }
    }

    //----------- public method ---------

    public CardType Classification() {
        RanksTracking n = nOfAKind();

        List<CardType> card_type_list = new ArrayList<CardType>();


        if (isFlush()) {

            if (isStraight()) {
                card_type_list.add(CardType.STRAIGHT_FLASH);
            } else {
                card_type_list.add(CardType.FLUSH);
            }
        }

        if (isStraight()) {
            card_type_list.add(CardType.STRAIGHT);
        }
        if (n.first_pairs != 0) {
            card_type_list.add(CardType.ONE_PAIR);
        }
        if (n.second_pairs != 0) {
            card_type_list.add(CardType.TWO_PAIR);
        }
        if (n.three_of_a_kind != 0) {
            if (n.first_pairs != 0) {
                card_type_list.add(CardType.FULL_HOUSE);
            } else {
                card_type_list.add(CardType.THREE_OF_A_KIND);
            }
        }
        if (n.four_of_a_kind != 0) {
            card_type_list.add(CardType.FOUR_OF_A_KIND);
        }
        card_type_list.add(CardType.HIGH_CARD);

        //sorted the enumerate list by definition order.
        Collections.sort(card_type_list);

        //return the biggest(first) one in the list
        return card_type_list.get(0);
    }




    //------------- private method -----------

    //----------------------  N of a kind  ----------------------

    private RanksTracking nOfAKind() {

        //initial variables
        int i = 0;
        int runlength;
        RanksTracking rank_tracking = new RanksTracking();
        int[] ranks = this.ranks;

        //classification
        while (i < ranks.length) {
            runlength = 1;

            while (i + runlength < ranks.length && ranks[i + runlength] == ranks[i]) {
                runlength++;
            }
            int n_of_a_kind = runlength;
            int current_rank = ranks[i + runlength - 1];

            switch (n_of_a_kind) {
                case (2):
                    if (rank_tracking.first_pairs == 0) {
                        rank_tracking.first_pairs = current_rank;
                    } else {
                        rank_tracking.second_pairs = current_rank;
                    }
                    break;
                case (3):
                    rank_tracking.three_of_a_kind = current_rank;
                    break;
                case (4):
                    rank_tracking.four_of_a_kind = current_rank;
                    break;
            }
            i = i + runlength;
        }
        return rank_tracking;
    }

    private static class RanksTracking {
        private int first_pairs = 0;
        private int second_pairs = 0;
        private int three_of_a_kind = 0;
        private int four_of_a_kind = 0;
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
}

