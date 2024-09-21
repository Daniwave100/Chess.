import java.util.ArrayList;
import java.util.Random;

public class Bot {

    private boolean isLowerCase;  // Bot will play as lowercase
    private Random rand = new Random();

    // Constructor to initialize the bot's piece case (lowercase or uppercase)
    public Bot(boolean isLowerCase) {
        this.isLowerCase = isLowerCase;  // Set bot's piece case (lowercase = true, uppercase = false)
    }

    // Method for bot to make a random valid move
    public void makeMove(Board board) {
        ArrayList<Piece> botPieces = getBotPieces(board.getBoard());

        // Keep trying random moves until a valid one is found
        while (true) {
            // Select a random piece
            Piece botPiece = botPieces.get(rand.nextInt(botPieces.size()));

            // Generate a random destination
            int destRow = rand.nextInt(8);  // Generate a row between 0 and 7
            int destCol = rand.nextInt(8);  // Generate a column between 0 and 7

            // Log the generated move for debugging
            System.out.println("Bot trying to move " + botPiece.getSymbol() + " from (" + botPiece.getCurrentRow() + "," + botPiece.getCurrentCol() + ") to (" + destRow + "," + destCol + ")");

            // Check if the move is within bounds and valid for the selected piece
            if (destRow >= 0 && destRow < 8 && destCol >= 0 && destCol < 8) {
                if (botPiece.isValidMove(destRow, destCol, board.getBoard())) {
                    // Move the piece to the valid destination
                    botPiece.move(board.getBoard(), destRow, destCol);
                    board.printBoard();
                    System.out.println("Bot moved " + botPiece.getSymbol() + " to " + (char) (destCol + 'a') + (8 - destRow));
                    break;  // Exit the loop once a valid move is made
                }
            } else {
                System.out.println("Invalid move generated: (" + destRow + "," + destCol + ")");
            }
        }
    }


    // Helper method to get all pieces belonging to the bot
    private ArrayList<Piece> getBotPieces(Piece[][] board) {
        ArrayList<Piece> botPieces = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.isUpperCase != this.isLowerCase) {  // Check piece case based on bot's setting
                    botPieces.add(piece);
                }
            }
        }
        return botPieces;
    }
}
