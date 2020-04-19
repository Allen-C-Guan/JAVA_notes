import java.util.Arrays;


public class Poker {


    public static void main(String[] args) {


        if(args.length%5!=0||args.length==0){
            System.out.println("stupid");
            System.exit(1);
        }


        for(int i=0; i<args.length;i++){
            int rank = Character.getNumericValue(args[i].charAt(0));

            int suit = Character.getNumericValue(args[i].charAt(0));
            final int A = 10;
            final int T = 29;
            final int J = 19;
            final int Q = 26;
            final int K = 20;

            switch (rank){
                case(A):
                case(T):
                case(J):
                case(Q):
                case(K):
                case(2):
                case(3):
                case(4):
                case(5):
                case(6):
                case(7):
                case(8):
                case(9):break;
                default:System.out.println("error input "+args[i]);System.exit(1);
            }
        }







        Player card_copy=new Player();
        int RankArray[]=new int[5];
        String SuitArray[] = new String[5];


        //处理数据
        for(int i=0;i<5;i++){
            String card=args[i];
            char[] ch=card.toCharArray();

            //确定rank array
            RankArray[i]=card_copy.RankDecoder(ch[0]); //将rank decoder成数字

            //确定suit array
            SuitArray[i]=String.valueOf(ch[1]).toUpperCase();

        }
        Arrays.sort(RankArray);
        Arrays.sort(SuitArray);


//        //判断输入
//        String suit_error=card_copy.IsSuitCorrect(SuitArray);
//        String rank_error=card_copy.IsRankCorrect(RankArray);
//        if(!(args.length==5)){
//            System.out.println("Error: wrong number of arguments;must be a multiple of 5");
//            System.exit(0);
//        }
//        else if(!(suit_error.equals("0"))){
//            System.out.printf("Error: invalid card name '%s'",suit_error);
//            System.exit(0);
//        }
//        else if(!(rank_error.equals("0"))){
//            System.out.printf("Error: invalid card name '%s'",rank_error);
//            System.exit(0);
//        }

        //得到牌型判断结果
        Player poker=new Player(RankArray,SuitArray);


//
////--------------test-------------------------------------------------------------------
//        for(int j=0;j<5;j++){
//            System.out.println(RankArray[j]);
//            System.out.println(SuitArray[j]);
//
//        }

    }



}














