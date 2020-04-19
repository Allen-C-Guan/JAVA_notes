public class Knight extends ChessPiece {
    public Knight(int row, int column){
        super(row,column);
    }

    public boolean validMove(int toRow, int toColumn){
        if(super.validMove(toRow,toColumn)&&
                (Math.abs(toRow-row)==2 && Math.abs(toColumn-column)==1)||
                (Math.abs(toRow-row)==1 && Math.abs(toColumn-column)==2)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Knight at "+super.toString();
    }

}
