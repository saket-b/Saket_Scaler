package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.models.*;

import java.util.List;
import java.util.Scanner;

public class Client {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        Player player1 = new HumanPlayer("Akash", new Symbol('X'), PlayerType.HUMAN);
        Player player2 = new BotPlayer("Rohit", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY);

        // Game id
        Game game = gameController.startGame(3, List.of(player1, player2), List.of(WinningStrategyType.ROW, WinningStrategyType.COL));
        gameController.displayboard(game);
        //API gamecontroller
        while( gameController.checkGameState(game).equals(GameState.IN_PROGRESS))
        {
            try{
                  gameController.makeMove(game);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }

            gameController.displayboard(game);
            System.out.println("Do you want to undo you move?[Y/N]");
            String undo =  sc.nextLine();
            if( undo.equalsIgnoreCase("Y"))
                gameController.undo(game);
        }

    }
}
