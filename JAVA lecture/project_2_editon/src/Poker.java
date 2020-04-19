
/*



Poker is the main class
step1: Group args five into one, build up the array recording player's information

step2: print out all players' card type and finding the highest card type

step3: building a candidates list(the players all hold the highest card type)

step4: building a card value of candidates array by calculating candidates card value respectively

step5: finding the winner array depending on card value array

step6: print the game result
 */




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Poker {

    private static int num_players = 0;
    public static void main(String[] args) {
        //-------- illegal args length judgement -------

        if((args.length)%5 == 0 && args.length!=0){
            num_players = (args.length+1)/5;
        }else{
            System.out.println("Error: wrong number of arguments; must be a multiple of 5");
            System.exit(1);
        }

        //-----------------------  creating player array  ---------------------------
        Player[] player_array = new Player[num_players];  //create Player array

        //assign value
        for(int i=1;i<=num_players;i++ ){
            String [] single_player = Arrays.copyOfRange(args,(i-1)*5,i*5);
            player_array[i-1] = new Player(single_player,""+i);
        }

        //---------- print cards types and finding the highest category ------------
        Player.CardType highest_category = player_array[0].getCardtype();
        for(Player temp : player_array){
            System.out.println("Player "+temp.getPlayer_name()+temp);
            if(temp.getCardtype().compareTo(highest_category)<0){
                highest_category = temp.getCardtype();
            }
        }

        //------------- if only one player, no more games ,just exit -------
         if(num_players<=1) {
             System.exit(0);
         }

         //---------build candidates list (all of them holds the highest category) ---------
        List<Player> candidates = new ArrayList<>();
        for(Player temp:player_array){
            if(temp.getCardtype()==highest_category){
                candidates.add(temp);
            }
        }

        //----- calculate candidates' cards value and finding the highest score among candidates---------
        double highest_score = 0;
        ValueCalculator [] candidate_score_array = new ValueCalculator[candidates.size()];
        int i =0;
        for(Player temp:candidates){
            //building array
            double score;
            candidate_score_array[i] = new ValueCalculator(temp);
            score = candidate_score_array[i].getCARD_VALUE();
            //update highest score
            if (score > highest_score){
                highest_score = score;
            }
            i++;
        }



        //--------- building the winner_list from candidates array------------

        List<ValueCalculator> winner_list = new ArrayList<>();
        for(ValueCalculator temp:candidate_score_array){
            if(temp.getCARD_VALUE() == highest_score){
                winner_list.add(temp);
            }
        }

        //--------- print the result ( winner or draw) ------------
        if(winner_list.size()>1){
            System.out.print("Players ");
            int j =0;
            for(;j<winner_list.size()-2;j++){
                System.out.print(winner_list.get(j).getName()+", ");
            }
            System.out.print(winner_list.get(j).getName()+" and ");
            System.out.print(winner_list.get(j+1).getName()+" draw.\n");
        }else{
            System.out.println("Player "+winner_list.get(0).getName()+" wins.");
        }
    }
}
