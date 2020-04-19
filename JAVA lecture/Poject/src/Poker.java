public class Poker {
    public static void main(String[] args) {


        //loading the ranks and suits information

        //getting the ranks array
        int [] ranks = Tools.getSortedRanks(args);

        //getting the suits array
        Classify.Suits [] suits_type = Tools.getSuits(args);

        // classification
        System.out.println(Classify.Classification(ranks,suits_type));



        //












        ////------------- testing  ------------
//        //test ranks
//        for(int temp:ranks){
//            System.out.println(temp);
//        }
//
//        //test suits
//        for(Classify.Suits temp:suits){
//            System.out.println(temp.getName());
//        }
//
//        //test isFlush
//        System.out.println(Classify.isFlush(suits));
//
//        //test isStraight
//        System.out.println(Classify.isStraight(ranks));

//        //test nOfAKind
//        System.out.println(Classify.nOfAKind(ranks).ranks_of_pairs2);
//        Classify.nOfAKind(ranks);







    }


}
