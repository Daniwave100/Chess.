
public abstract class Piece {
    protected int row;
    protected int col;
    protected boolean isUpperCase; // determines whether piece is upper or lowercase

    // Piece constructor
    public Piece(int row, int col, boolean isUpperCase) {
        this.row = row;
        this.col = col;
        this.isUpperCase = isUpperCase;
    }

    // Getter for the current row
    public int getCurrentRow() {
        return row;
    }

    // Getter for the current column
    public int getCurrentCol() {
        return col;
    }

    // Setter for the row (used when the piece moves)
    public void setRow(int row) {
        this.row = row;
    }

    // Setter for the column (used when the piece moves)
    public void setCol(int col) {
        this.col = col;
    }


    // Method to return the piece symbol, implemented in each specific piece subclass.
    public abstract String getSymbol();

    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        ;
        return false;
    }

    public void move(Piece[][] board, int destRow, int destCol) {
        // Clear the original position
        board[this.row][this.col] = null;

        // Move the piece to the destination
        board[destRow][destCol] = this;

        // Update the piece's internal position
        this.setRow(destRow);
        this.setCol(destCol);
    }
}


