public class Rook extends Piece {
    public Rook(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // Pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "R" : "r";
    }

    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        // Case 1: Rook moves horizontally (same row) or vertically (same column)
        if (this.row != destRow && this.col != destCol) {
            return false;  // Rook must move in a straight line (either row or column must match)
        }

        // Case 2: Check for obstacles along the path (pieces in the way)
        // Horizontal move (same row)
        if (this.row == destRow) {
            int start = Math.min(this.col, destCol);
            int end = Math.max(this.col, destCol);
            for (int col = start + 1; col < end; col++) {
                if (board[this.row][col] != null) {
                    return false;  // There is a piece blocking the rook's path
                }
            }
        }
        // Vertical move (same column)
        else if (this.col == destCol) {
            int start = Math.min(this.row, destRow);
            int end = Math.max(this.row, destRow);
            for (int row = start + 1; row < end; row++) {
                if (board[row][this.col] != null) {
                    return false;  // There is a piece blocking the rook's path
                }
            }
        }

        // Case 3: Check if the destination has an opponent's piece (for capturing)
        Piece targetPiece = board[destRow][destCol];
        if (targetPiece != null && targetPiece.isUpperCase == this.isUpperCase) {
            return false;  // Cannot capture a piece of the same color
        }

        return true;  // If all conditions are met, the move is valid
    }

}

