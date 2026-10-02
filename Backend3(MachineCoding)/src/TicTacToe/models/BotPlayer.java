package TicTacToe.models;

import TicTacToe.Factory.BotPlayingStrategyFactory;
import TicTacToe.Strategies.BotPlayingStrategy;

public class BotPlayer extends  Player{
    private BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Making move for " + this.getName());
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getInstance(this.botDifficultyLevel);
        return strategy.makeMove(board, this);
    }
}
