package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements  WinningStrategy{

    HashMap<Integer, HashMap<Character, Integer>> rowCountMap;

    public RowWinningStrategy() {
        this.rowCountMap = new HashMap<>();
    }



    @Override
    public boolean check(Board board, Move move) {
        // Update the rowCountMap
        Integer row = move.getCell().getRow();
        rowCountMap.putIfAbsent(row, new HashMap<>());
        HashMap<Character, Integer> countMap = rowCountMap.get(row);
        Character sym = move.getPlayer().getSymbol().getSym();
        countMap.putIfAbsent(sym,0);
        countMap.put(sym, countMap.get(sym)+1);
        //check count
        if( countMap.get(sym) == board.getSize())
            return true;

        return false;
    }

    @Override
    public void handleUndo(Move lastMove) {

        Integer row = lastMove.getCell().getRow();
        Character sym = lastMove.getPlayer().getSymbol().getSym();
        HashMap<Character, Integer> countMap = rowCountMap.get(row);
        countMap.put(sym, countMap.get(sym)-1);
    }
}
