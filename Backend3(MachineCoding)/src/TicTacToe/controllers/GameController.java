package TicTacToe.controllers;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.models.WinningStrategyType;

import java.util.List;

public class GameController {
    //API Path/Route ->Controller Function
    //Start game
    public Game startGame(Integer size, List<Player>players, List<WinningStrategyType>winningStrategyTypes)
    {
        Game game = Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .setWinningStrategyTypes(winningStrategyTypes)
                .build();
        return game;
    }
    //DisplayBoard
    public void displayboard(Game game)
    {
        game.disPlayboard();
    }

    // make a move
    public void makeMove(Game game)
    {
        game.makeMove();
    }

    // undo move
    public GameState checkGameState(Game game)
    {
        return game.getGameState();
    }

    public void undo(Game game)
    {
        game.undoMove();
    }
}
