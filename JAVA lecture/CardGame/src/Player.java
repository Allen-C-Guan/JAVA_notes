public class Player {

    public int []RankArray;
    public String []SuitArray;


    Player(){}

    Player(int []RankArray, String []SuitArray ){
        this.RankArray=RankArray;
        this.SuitArray=SuitArray;
        CardClassificationOutput(this.RankArray,this.SuitArray);

    }




    //------------确定牌型------------------------------------------------------------------------
    public int CardClassification(int []RankArray,String []SuitArray) {
        if (IsStraightFlush(RankArray,SuitArray)) {
            return 1;
        }
        else if (IsFourOfAKind(RankArray)) {
            return 2;
        }
        else if (IsFullHouse(RankArray)) {
            return 3;
        }
        else if (IsFlush(SuitArray)) {
            return 4;
        }
        else if (IsStraight(RankArray)) {
            return 5;
        }
        else if (IsThreeOfAKind(RankArray)) {
            return 6;
        }
        else if (IsTwoPair(RankArray)) {
            //System.out.println("Two pairs");
            return 7;
        }
        else if (IsOnePair(RankArray)) {
            //System.out.println("One pair");
            return 8;
        }
        else {
            //System.out.println("High card");
            return 9;
        }

    }

    //-------------------输出牌型--------------------------------
    public void CardClassificationOutput(int []RankArray,String []SuitArray) {
        String[] RankArrayCoder = RankCoder(RankArray);
        switch (CardClassification(RankArray, SuitArray)) {
            case 1:
                System.out.printf("%s-high straight flush", RankArrayCoder[4]);
                break;
            case 2:
                if (RankArray[0] == RankArray[3]) {
                    System.out.printf("Four %ss", RankArrayCoder[0]);
                } else {
                    System.out.printf("Four %ss", RankArrayCoder[4]);
                }
                break;
            case 3:
                if (RankArray[0] == RankArray[2]) {
                    System.out.printf("%ss full of %ss", RankArrayCoder[0], RankArrayCoder[4]);
                } else {
                    System.out.printf("%ss full of %ss", RankArrayCoder[4], RankArrayCoder[0]);
                }
                break;
            case 4:
                System.out.printf("%s-high flush", RankArrayCoder[4]);
                break;
            case 5:
                System.out.printf("%s-high straight", RankArrayCoder[4]);
                break;
            case 6:
                if (RankArray[0] == RankArray[2]) {
                    System.out.printf("Three %ss", RankArrayCoder[0]);
                } else if (RankArray[2] == RankArray[4]) {
                    System.out.printf("Three %ss", RankArrayCoder[4]);
                } else {
                    System.out.printf("Three %ss", RankArrayCoder[2]);
                }
                break;
            case 7:
                if(RankArray[0]==RankArray[1]){
                    if(RankArray[2]==RankArray[3]){
                        System.out.printf("%ss over %ss",RankArrayCoder[2],RankArray[0]);
                    }
                    else{
                        System.out.printf("%ss over %ss",RankArrayCoder[3],RankArray[0]);
                    }
                }
                else{
                    System.out.printf("%ss over %ss",RankArrayCoder[3],RankArray[1]);
                }
                break;
            case 8:
                for(int index=0;index<4;index++){
                    int index_next=index+1;
                    if(RankArray[index]==RankArray[index_next]){
                        System.out.printf("Pair of %ss",RankArrayCoder[index]);
                        break;
                    }
                }
                break;
            case 9:
                System.out.printf("%s-high",RankArrayCoder[4]);
                break;
        }
    }

    //--------------RankDecoder-----------------------
    public int RankDecoder ( char rank){
        int rank_decoder = 0;

        if (!Character.isDigit(rank)) {
            char rank_upcase = Character.toUpperCase(rank);  //char 用单引号，且用 == 比较，String用双引号，且用equals（）比较!!!
            if (rank_upcase == 'T') {
                rank_decoder = 10;
            } else if (rank_upcase == 'J') {
                rank_decoder = 11;
            } else if (rank_upcase == 'Q') {
                rank_decoder = 12;
            } else if (rank_upcase == 'K') {
                rank_decoder = 13;
            } else if (rank_upcase == 'A') {
                rank_decoder = 14;
            }
            return rank_decoder;
        } else {
            rank_decoder = Integer.parseInt(String.valueOf(rank));
        }
        return rank_decoder;
    }
    //----------------RankCoder-----------------------------
    public String[] RankCoder ( int[] RankArray){
        String[] RankArrayCoder = new String[5];
        for (int index = 0; index < 5; index++) {
            if (RankArray[index] < 11) {
                RankArrayCoder[index] = String.valueOf(RankArray[index]);
            }
            else if (RankArray[index] == 11) {
                RankArrayCoder[index] = "Jack";
            }
            else if (RankArray[index] == 12) {
                RankArrayCoder[index] = "Queen";
            }
            else if (RankArray[index] == 13) {
                RankArrayCoder[index] = "King";
            }
            else if (RankArray[index] == 14) {
                RankArrayCoder[index] = "Ace";
            }
        }
        return RankArrayCoder;
    }

    //------------------判断suit array------------------------------
    public String IsSuitCorrect(String []SuitArray){
        int index=0;
        for(;index<5;index++){
            if(!(SuitArray[index].equals("C")||SuitArray[index].equals("D")||SuitArray[index].equals("H")||SuitArray[index].equals("S"))){
                break;
            }
        }
        if(index==5){ return "0"; }
        else {return SuitArray[index];}
    }
    //---------------判断rank array--------------------------------
    public String IsRankCorrect(int []RankArray){
        int index=0;
        for(;index<5;index++){
            if(!(RankArray[index]>1&&RankArray[index]<15)){
                break;
            }
        }
        if(index==5){ return "0"; }
        else {return String.valueOf(RankArray[index]);}
    }



    //-------------------IsStraightFlush---------------------
    public boolean IsStraightFlush ( int[] RankArray, String[] SuitArray){
        if (IsStraight(RankArray) && IsFlush(SuitArray)) {
            return true;
        } else {
            return false;
        }
    }
    //-------------------------------Is Four of kind--------------------------------
    public boolean IsFourOfAKind ( int[] RankArray){
        if ((RankArray[0] == RankArray[3]) || (RankArray[1] == RankArray[4])) {
            return true;
        } else {
            return false;
        }
    }
    //--------------------Is Full House---------------------------------------------
    public boolean IsFullHouse ( int[] RankArray){
        if ((RankArray[0] == RankArray[2] && RankArray[3] == RankArray[4]) || (RankArray[0] == RankArray[1] && RankArray[2] == RankArray[4]) && (!IsStraight(RankArray))) {
            return true;
        } else {
            return false;
        }
    }
    //----------------------IsFlush----------------------------------------------
    public boolean IsFlush (String[]SuitArray){
        if (SuitArray[0].equals(SuitArray[4])) {
            return true;
        } else {
            return false;
        }
    }
    //---------------------Is Straight----------------------------------------
    public boolean IsStraight ( int[] RankArray){
        int index = 0;
        for (; index < 4; index++) {
            int index_next = index + 1;
            if (!(RankPlusOne(RankArray[index]) == RankArray[index_next])) {
                break;
            }
        }
        if (index == 4) {
            return true;
        } else {
            return false;
        }
    }
    //--------------------Is three of a kind------------------------------------
    public boolean IsThreeOfAKind ( int[] RankArray){
        int index = 0;
        for (; index < 3; index++) {
            int index_next = index + 2;
            if (RankArray[index] == RankArray[index_next]) {
                break;
            }
        }
        if (index == 3) {
            return false;
        } else {
            return true;
        }
    }
    //--------------------------Is two pairs---------------------------------------
    public boolean IsTwoPair ( int[] RankArray){
        if (((RankArray[0] == RankArray[1]) && (RankArray[2] == RankArray[3])) || ((RankArray[1] == RankArray[2]) && (RankArray[2] == RankArray[4]))) {
            return true;
        } else {
            return false;
        }
    }
    //----------------------------Is one pair------------------------------------
    public boolean IsOnePair ( int[] RankArray){
        int index = 0;
        for (; index < 4; index++) {
            int index_next = index + 1;
            if (RankArray[index] == RankArray[index_next]) {
                break;
            }
        }
        if (index == 4) {
            return false;
        } else {
            return true;
        }
    }


    //-------------------------tool-----------------------------
    public int RankPlusOne ( int Rank){
        return Rank + 1;
    }



}


