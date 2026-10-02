package TicTacToe.models;

import TicTacToe.Factory.WinningStrategyFactory;
import TicTacToe.Strategies.WinningStrategy;
import TicTacToe.Validations.ValidateMove;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private  Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private List<Move>moves;
    private Integer nextPlayeIndex; // o, 1, 2, 3, 4, 5
    private List<WinningStrategy> winningStrategies;

    public void disPlayboard(){
        this.board.displayBoard();
        System.out.println("Game state: " + gameState);
        if( gameState.equals(GameState.WIN))
            System.out.println(winner.getName() + " has won the game");
    }

    private Game(Builder builder)
    {
        this.board = new Board(builder.getSize());
        this.players = builder.getPlayers();
        // winningStrategies
        this.winningStrategies = new ArrayList<>();
        for( WinningStrategyType type: builder.getWinningStrategyTypes())
        {
            this.winningStrategies.add(WinningStrategyFactory.getInstance(type));

        }
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.nextPlayeIndex = 0;

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Integer getNextPlayeIndex() {
        return nextPlayeIndex;
    }

    public void setNextPlayeIndex(Integer nextPlayeIndex) {
        this.nextPlayeIndex = nextPlayeIndex;
    }

    public void makeMove(){
        // fetch the current player
        Player currentPlayer = players.get(nextPlayeIndex);
        //get the move from the player human/bot
        Move move  = currentPlayer.makeMove(this.board);
        //validate the move
        ValidateMove.validate(move, board);
        // update nextPlayerIndex
        nextPlayeIndex = (nextPlayeIndex+1)% players.size();
        // update  the cell in the board
        Cell moveCell = move.getCell();
        Cell boardCell = board.getGrid().get(moveCell.getRow()).get(moveCell.getCol());
        boardCell.setSymbol(currentPlayer.getSymbol());
        boardCell.setCellState(CellState.FILLED);
        // add move in the move list
        this.moves.add(move);

        // check and update Gamestate
        this.checkAndUpdateGameState();

    }


    public void  undoMove(){

        //remove the last move from moves list
        Move lastMove = moves.getLast();
        //Reverse update the board according to the last move
        Cell moveCell = lastMove.getCell();
        Cell boardCell = board.getGrid().get(moveCell.getRow()).get(moveCell.getCol());
        boardCell.setSymbol(null);
        boardCell.setCellState(CellState.EMPTY);
        // RollBack to previous Player
        nextPlayeIndex = (nextPlayeIndex-1 + players.size()) % players.size();

        this.winner = null;
        this.setGameState(GameState.IN_PROGRESS);
        for (WinningStrategy winningStrategy : winningStrategies)
        {
            winningStrategy.handleUndo(lastMove);
        }

    }

    private void checkAndUpdateGameState(){
        if( checkWinner())
        {
            this.gameState = GameState.WIN;
            this.winner = this.moves.getLast().getPlayer();
        }
        else if( this.moves.size() == board.getSize()*board.getSize())
        {
            this.gameState = GameState.DRAW;
        }
    }

    public boolean checkWinner(){
        for (WinningStrategy strategy : winningStrategies)
        {
            if( strategy.check( board, this.moves.getLast())){
                return true;
            }
        }
        return false;
    }
    public static  Builder getBuilder(){
        return new Builder();
    }





    public  static  class Builder{

        Integer size;
        List<Player>players;
        List<WinningStrategyType>winningStrategyTypes;

        public Integer getSize() {
            return size;
        }

        public Builder setSize(Integer size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategyType> getWinningStrategyTypes() {
            return winningStrategyTypes;
        }

        public Builder setWinningStrategyTypes(List<WinningStrategyType> winningStrategyTypes) {
            this.winningStrategyTypes = winningStrategyTypes;
            return this;
        }
        public  Game build(){
            return new Game(this);
        }

    }
}
