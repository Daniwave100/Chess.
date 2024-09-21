import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Board board = new Board();
                board.printBoard();

                Bot bot = new Bot(true);  // Bot plays as black (lowercase)

                Scanner scanner = new Scanner(System.in);

                String playGame;
                System.out.println("Would you like to play? (y or n): "); // would you like to play?
                playGame = scanner.nextLine();

                String playerPieceIndex;
                String playerMoveIndex;

                if (playGame.equals("y")) {

                        while (true) {
                                // Player's turn
                                while (true) {
                                        System.out.println("What piece would you like to move?");
                                        playerPieceIndex = scanner.nextLine();

                                        Piece userPiece = Board.getPiece(playerPieceIndex);
                                        if (userPiece == null) {
                                                System.out.println("No piece at the given position.");
                                                board.printBoard();
                                                continue;
                                        }

                                        System.out.println("Where would you like to move this piece?");
                                        playerMoveIndex = scanner.nextLine();

                                        // Convert the player's move to row/col indices for validation
                                        int destCol = playerMoveIndex.charAt(0) - 'a'; // e.g., 'e' becomes 4
                                        int destRow = 8 - Character.getNumericValue(playerMoveIndex.charAt(1));

                                        if (userPiece.isValidMove(destRow, destCol, board.getBoard())) {
                                                // Valid move: Execute the move and exit the player's loop
                                                userPiece.move(board.getBoard(), destRow, destCol);
                                                board.printBoard();
                                                break;  // Exit the player's move loop
                                        } else {
                                                // Invalid move: Ask for a valid move
                                                System.out.println("That is an invalid move!");
                                                board.printBoard();
                                        }
                                }

                                // Bot's turn after the player's valid move
                                bot.makeMove(board);
                        }
                }
        }
}

//