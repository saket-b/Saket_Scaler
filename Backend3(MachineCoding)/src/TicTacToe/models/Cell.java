package TicTacToe.models;

public class Cell {
    private Integer row;
    private Integer col;
    private Symbol symbol;
    private CellState cellState;

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Cell(int i, int j) {
        this.row = i;
        this.col = j;
        this.cellState = CellState.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void display() {
        if( cellState.equals(CellState.EMPTY))
        {
            System.out.print("| |");
        }
        else
        {
            System.out.print("|"+ this.getSymbol().getSym() + "|");
        }
    }
}
