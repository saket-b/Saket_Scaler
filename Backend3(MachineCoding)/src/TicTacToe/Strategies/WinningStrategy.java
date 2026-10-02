package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean check(Board board, Move move);
    void handleUndo(Move lastMove);
}
