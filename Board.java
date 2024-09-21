public class Board {
    private static Piece[][] board = new Piece[8][8];

    public Board() {
        // Initialize the board with null values
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

        // Initialize pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, false); // Black pawns (lowercase) on row 1
            board[6][i] = new Pawn(6, i, true);  // White pawns (uppercase) on row 6
        }

        // Initialize black pieces (top of the board)
        board[0][0] = new Rook(0, 0, false);
        board[0][1] = new Knight(0, 1, false);
        board[0][2] = new Bishop(0, 2, false);
        board[0][3] = new Queen(0, 3, false);
        board[0][4] = new King(0, 4, false);
        board[0][5] = new Bishop(0, 5, false);
        board[0][6] = new Knight(0, 6, false);
        board[0][7] = new Rook(0, 7, false);

        // Initialize white pieces (bottom of the board)
        board[7][0] = new Rook(7, 0, true);
        board[7][1] = new Knight(7, 1, true);
        board[7][2] = new Bishop(7, 2, true);
        board[7][3] = new Queen(7, 3, true);
        board[7][4] = new King(7, 4, true);
        board[7][5] = new Bishop(7, 5, true);
        board[7][6] = new Knight(7, 6, true);
        board[7][7] = new Rook(7, 7, true);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int j = 0; j < 8; j++) {
            System.out.print((char) ('a' + j) + " ");
        }
        System.out.println();
    }

    public static Piece getPiece(String inputPiece) {
        // Mapping of input strings to board indices
        char col = inputPiece.charAt(0);
        int row = 8 - Character.getNumericValue(inputPiece.charAt(1));

        // Get the piece from the board based on inputPiece
        return board[row][col - 'a'];
    }
}

// what to work on tomorrow:    seems like it is not actually updating the board

