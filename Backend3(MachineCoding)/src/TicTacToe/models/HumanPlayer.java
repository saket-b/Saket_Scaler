package TicTacToe.models;

import java.util.Scanner;

public class HumanPlayer extends  Player{

    Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, Symbol symbol, PlayerType playerType) {
        super(name, symbol, playerType);
    }

    @Override
    public Move makeMove(Board board) {

        System.out.println("Its's " + this.getName() + "'s move");
        System.out.println("Please enter the row number of the move:");
        int row = scanner.nextInt();
        System.out.println("Pleas enter the column number of your move: ");
        int column = scanner.nextInt();
        Cell cell = new Cell(row, column);
        return new Move(cell, this);
    }
}
