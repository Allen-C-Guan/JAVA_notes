package Lab3;
//这个代码还没有解决高效的*的输出的问题，当然可以预先加个判断，每一次循环都判定一次，但这样效率太低！
public class printTable {
    private static int j= 0;

    public static void main(String[] args){

        for (int i=1; i<=21; i++){
            for( j=1; j<=65;j++){
                if(isNumRow(i)){
                    printNumRow(i,j);
                }else{
                    printFrame(j);
                }
            }
            System.out.print("\n");
        }
    }



//--------------- print the row with numbers ----------------

    private static void printNumRow(int row, int column){
        int num = calculateNum(row,column);
        if(isNumPos(column,num)){
            if(num!=0){
                System.out.print(num);
            }else{
                System.out.print("*");
            }

        }else if(isVerticalColumn(column)){
            System.out.print("|");
        }else{
            System.out.print(" ");
        }


    }

    private static int calculateNum(int i,int j){
        int row = i/2;
        int column = j/6;
        int var;
        if(row == 0){
            var = column;
        }else if(column == 0){
            var = row;
        }else{
            var = row*column;
        }
        return var;
    }


//------------------- print frame row   ----------------
    private static void printFrame(int column){
        if(isVerticalColumn(column)){
            System.out.print("+");
        }else{
            System.out.print("-");
        }
    }

//---------------------  is -----------------------
    private static boolean isNumRow(int row){
        return row%2==1;
    }


    private static boolean isNumPos(int column,int var){
        if(var<10&&var>0){
            return (column-4)%6==0;
        }else if (var>=100){
            return (column -2)%6==0;
        }else if (var==0){
            return (column-3)%6==0;
        }else{
            if((column-3)%6==0){
                j++;
                return true;
            }else {
                return false;
            }
        }
    }

    private static boolean isVerticalColumn(int column){
       return column%6==0;
    }
}
