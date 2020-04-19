public class Bishop extends ChessPiece {
    public Bishop(int row, int column){
        super(row, column);
    }

    public boolean validMove(int toRow, int toColumn){
        if(super.validMove(toRow,toColumn)&&(Math.abs(toRow-row) == Math.abs(toColumn-column))){
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Bishop at "+super.toString();
    }
}
