public class Checker {
        boolean isRed;
        int row;
        int column;

        //--------------------  constructor  ------------------
        public Checker(boolean isRed){
            this.isRed = isRed;
            this.column = 1;
            this.row = 1;
        }

        public Checker(boolean isRed,int row, int column){
            this.isRed = isRed;
            if (validRange(row,column)){
                this.column = column;
                this.row = row;
            } else {
                this.column = 1;
                this.row = 1;
            }

        }

        //----------------------  method -----------------------

        //-----------------------  move  ----------------------
        public void move(int rows, int columns){
            if(validRange(rows+this.row,columns+this.column)&&(Math.abs(columns) == 1)) {
                if (this.isRed) {
                    if (rows == -1) {
                        stepMoving(rows,columns);
                    }
                } else {
                    if (rows == 1) {
                        stepMoving(rows,columns);
                    }
                }
            }
        }

        //-------------------- accessor ----------

        public int getRow(){
            return this.row;
        }

        public int getColumn(){
            return this.column;
        }
        public boolean isRed(){
            return this.isRed;
        }








        //---------------- private method ---------------
        private boolean validRange(int row, int column){
            if((1 <= row && row<=8)&&(1 <= column && column<=8)&&(row%2==column%2)){
                return true;
            }
            else{
                return false;
            }
        }

        private void stepMoving(int row_step, int column_step){
            this.row += row_step;
            this.column += column_step;
        }




}


