public class ChessPiece {

    protected int row;
    protected int column;

    //---constructor ----
    public ChessPiece (int row, int column){
        if(row<9 && row>0 && column<9 && row>0){
            this.row = row;
            this.column = column;
        }else{
            System.exit(1);
        }
    }

    public boolean validMove(int toRow, int toColumn){
        return toRow <9 && toRow >0 && toColumn>0 && toColumn<9
                && (toRow!=this.row || toColumn !=this.column);
    }


    //----accessor ----


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }


    //---- override toString -----
    @Override
    public String toString() {
        return "("+this.row+","+this.column+")";
    }
}
