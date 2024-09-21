public class Knight extends Piece {
    public Knight(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // Pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "N" : "n";
    }

    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        // Calculate the differences in rows and columns
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);

        // Case 1: Ensure the knight moves in an "L" shape
        if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2))) {
            return false;  // The move is not an "L" shape
        }

        // Case 2: Check if the destination square has a piece of the same color
        Piece targetPiece = board[destRow][destCol];
        if (targetPiece != null && targetPiece.isUpperCase == this.isUpperCase) {
            return false;  // The Knight cannot capture a piece of the same color
        }

        return true;  // The move is valid
    }

}
