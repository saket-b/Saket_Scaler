package TicTacToe.Factory;

import TicTacToe.Strategies.BotPlayingStrategy;
import TicTacToe.Strategies.EasyBotPlayingStrategy;
import TicTacToe.Strategies.MediumBotPlayingStrategy;
import TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getInstance(BotDifficultyLevel botDifficultyLevel)
    {
        if( botDifficultyLevel == BotDifficultyLevel.EASY)
            return new EasyBotPlayingStrategy();
        else if( botDifficultyLevel == BotDifficultyLevel.MEDIUM)
            return new MediumBotPlayingStrategy();
        else
        {
            throw new IllegalArgumentException("Invalid difficulty Level");
        }
    }
}
