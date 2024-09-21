# Chess

## Background

This is a slightly modified chess game which is played in the console/terminal. I wanted to build something more complex than I have previously worked on, and also learn an object-oriented 
programming language in-depth, prior to taking a course taught in Java at my university. 

## How to play
1. Run the main class
2. Select and move a piece utilizing the grid coordinate system (i.e. e2, d1, a2)
3. The game ends when the player or bot captures the king piece

## Chess piece logic
- **Pawns**: Can only move and capture one square forward
- **Rooks**: Can move horizontally or vertically without jumping over pieces
- **Knights**: Can move in an L shape and also jump over pieces
- **Bishops**: Can move diagonally without jumping pieces
- **Queens**: Can move diagonally and horizontally without jumping pieces.
- **Kings**: Can move one square in any direction and triggers game end state when captured

## Future Improvements
- Implement chess bot engine
- Create a GUI for this project (JavaSwing)
- Account for more in-depth game logic such as checkmate, castling, pawn promotion, and en-passant
