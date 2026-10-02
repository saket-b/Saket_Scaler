package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.BotPlayer;
import TicTacToe.models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board, BotPlayer player);
}
