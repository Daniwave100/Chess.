public class King extends Piece {
    public King(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // Pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "K" : "k";
    }

    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        // Calculate the difference in rows and columns
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);

        // Case 1: The King can only move one square in any direction
        if (rowDiff > 1 || colDiff > 1) {
            return false;  // The move is more than one square away
        }

        // Case 2: Check if the destination square has a piece of the same color
        Piece targetPiece = board[destRow][destCol];
        if (targetPiece != null && targetPiece.isUpperCase == this.isUpperCase) {
            return false;  // The King cannot capture a piece of the same color
        }

        // If all conditions are met, the move is valid
        return true;
    }
}
