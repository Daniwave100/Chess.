public class Bishop extends Piece {
    public Bishop(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // Pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "B" : "b";
    }

    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        // Ensure the destination is within bounds
        if (destRow < 0 || destRow >= 8 || destCol < 0 || destCol >= 8) {
            return false;  // Out-of-bounds move
        }

        // Calculate the differences in rows and columns
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);

        // Case 1: The move must be diagonal
        if (rowDiff != colDiff) {
            return false;  // Bishop must move diagonally
        }

        // Case 2: Check for obstacles along the diagonal path
        int rowDirection = (destRow > this.row) ? 1 : -1;
        int colDirection = (destCol > this.col) ? 1 : -1;

        int row = this.row + rowDirection;
        int col = this.col + colDirection;
        while (row != destRow && col != destCol) {
            if (board[row][col] != null) {
                return false;  // Piece is blocking the way
            }
            row += rowDirection;
            col += colDirection;
        }

        // Case 3: Check if the destination square has a piece of the same color
        Piece targetPiece = board[destRow][destCol];
        if (targetPiece != null && targetPiece.isUpperCase == this.isUpperCase) {
            return false;  // Cannot capture a piece of the same color
        }

        return true;  // If all conditions are met, the move is valid
    }

}
