package TicTacToe.Validations;

import TicTacToe.models.Board;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

public class ValidateMove {

    public static void validate(Move move, Board board)
    {
        Integer row = move.getCell().getRow();
        Integer col = move.getCell().getCol();
        if( row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize())
        {
            throw  new  IllegalArgumentException("Invalid move - cells are out of board");
        }
        if(board.getGrid().get(row).get(col).getCellState().equals(CellState.FILLED))
        {
            throw new IllegalArgumentException("Invalid move - cells are failed");
        }

    }
}
