package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Integer size;
    private List<List<Cell>>grid;

    public Board(Integer size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for( int i=0; i<size; i++)
        {
            List<Cell>row = new ArrayList<>();
            for (int j=0; j<size; j++)
            {
                row.add( new Cell(i,j));
            }
            this.grid.add(row);
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public void displayBoard(){
        for( int i=0; i<size;i++)
        {
            for( int j=0; j<size; j++)
            {
                grid.get(i).get(j).display();
            }
            System.out.println();

        }
    }
}
