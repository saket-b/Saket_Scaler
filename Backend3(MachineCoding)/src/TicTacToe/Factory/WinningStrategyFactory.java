package TicTacToe.Factory;

import TicTacToe.Strategies.ColumnWinningStrategy;
import TicTacToe.Strategies.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategy;
import TicTacToe.models.WinningStrategyType;

public class WinningStrategyFactory {
    public static WinningStrategy getInstance(WinningStrategyType type)
    {
        if( type.equals(WinningStrategyType.ROW))
            return new RowWinningStrategy();
        else if( type.equals(WinningStrategyType.COL))
            return  new ColumnWinningStrategy();
        else
            throw  new IllegalArgumentException("Invalid WinningStrategyType");
    }
}
