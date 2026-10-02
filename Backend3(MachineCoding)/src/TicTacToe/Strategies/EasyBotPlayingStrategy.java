package TicTacToe.Strategies;

import TicTacToe.models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, BotPlayer player) {
        // If I make a move at the next empty available cell
        for( List<Cell> row : board.getGrid())
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    Cell moveCell = new Cell(cell.getRow(), cell.getCol());
                    return new Move(moveCell, player);
                }
            }
        return null;
    }
}
