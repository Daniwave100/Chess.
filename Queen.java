public class Queen extends Piece {
    public Queen(int row, int col, boolean isUpperCase) {
        super(row, col, isUpperCase);  // pass row, col, and isUpperCase to the Piece constructor
    }

    @Override
    public String getSymbol() {
        return isUpperCase ? "Q" : "q";
    }

    @Override
    public boolean isValidMove(int destRow, int destCol, Piece[][] board) {
        // Calculate the differences in rows and columns
        int rowDiff = Math.abs(destRow - this.row);
        int colDiff = Math.abs(destCol - this.col);

        // Case 1: check if the Queen is moving horizontally, vertically, or diagonally
        if (this.row != destRow && this.col != destCol && rowDiff != colDiff) {
            return false;  // The Queen must move in a straight line (row, col) or diagonally (rowDiff == colDiff)
        }

        // Case 2: checks for other pieces along the path
        // Horizontal move (same row)
        if (this.row == destRow) {
            int start = Math.min(this.col, destCol);
            int end = Math.max(this.col, destCol);
            for (int col = start + 1; col < end; col++) {
                if (board[this.row][col] != null) {
                    return false;  // There is a piece blocking the path
                }
            }
        }
        // checks the vertical move (same column)
        else if (this.col == destCol) {
            int start = Math.min(this.row, destRow);
            int end = Math.max(this.row, destRow);
            for (int row = start + 1; row < end; row++) {
                if (board[row][this.col] != null) {
                    return false;  // There is a piece blocking the path
                }
            }
        }
        // checks the diagonal move
        else if (rowDiff == colDiff) {
            int rowDirection = (destRow > this.row) ? 1 : -1;  // Determine the row direction
            int colDirection = (destCol > this.col) ? 1 : -1;  // Determine the column direction

            int row = this.row + rowDirection;
            int col = this.col + colDirection;
            while (row != destRow && col != destCol) {
                if (board[row][col] != null) {
                    return false;  // if there is a piece blocking the path
                }
                row += rowDirection;
                col += colDirection;
            }
        }

        // Case 3: checks if the destination coordinate has a piece of the same color
        Piece targetPiece = board[destRow][destCol];
        if (targetPiece != null && targetPiece.isUpperCase == this.isUpperCase) {
            return false;
        }

        return true;  // move is valid
    }
}
