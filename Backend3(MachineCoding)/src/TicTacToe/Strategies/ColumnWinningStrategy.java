package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{

    HashMap<Integer, HashMap<Character, Integer>>colCountMap;
    public ColumnWinningStrategy(){
        colCountMap = new HashMap<>();
    }

    @Override
    public boolean check(Board board, Move move) {
        // update the row count
        Integer col = move.getCell().getCol();
        colCountMap.putIfAbsent(col, new HashMap<>());
        HashMap<Character, Integer>countMap = colCountMap.get(col);
        Character sym = move.getPlayer().getSymbol().getSym();
        countMap.putIfAbsent(sym, 0);
        countMap.put(sym, countMap.get(sym)+1);
        //check the count
        if( countMap.get(sym) == board.getSize())
            return true;

        return false;
    }

    @Override
    public void handleUndo(Move lastMove) {
        Integer col = lastMove.getCell().getCol();
        Character sym = lastMove.getPlayer().getSymbol().getSym();
        HashMap<Character, Integer> countMap = colCountMap.get(col);
        countMap.put(sym, countMap.get(sym) - 1);
    }
}
