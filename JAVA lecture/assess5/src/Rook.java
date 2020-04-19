public class Rook extends ChessPiece {

    public Rook(int row, int column) {
        super(row, column);
    }

    public boolean validMove(int toRow, int toColumn){
        if(super.validMove(toRow,toColumn)&&(toRow == this.row || toColumn == this.column)){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Rook at "+super.toString();
    }
}
