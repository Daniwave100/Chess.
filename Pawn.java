public class Pawn extends Piece {
    public Pawn(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // Pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "P" : "p";
    }

    // make isValidMove() method
    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        int rowDir = isUpperCase ? -1 : 1;  // White pawns move up (-1), black pawns move down (+1)

        // Case 1: Move forward by 1 square and capture only directly in front
        if (destCol == this.col && board[destRow][destCol] != null) {
            if (destRow == this.row + rowDir && board[destRow][destCol].isUpperCase != this.isUpperCase) {
                return true;  // Capture piece directly in front
            }
        }

        // Case 2: Move forward by 1 square without capturing (normal forward move)
        if (destCol == this.col && board[destRow][destCol] == null) {
            if (destRow == this.row + rowDir) {
                return true;
            }
        }

        // Invalid move if none of the conditions apply
        return false;
    }

}

