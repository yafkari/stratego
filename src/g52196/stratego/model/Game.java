package g52196.stratego.model;

import g52196.stratego.model.pieces.Flag;
import g52196.stratego.model.pieces.General;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 52196
 *
 * Represents the current game
 */
public class Game implements Model {

    private Board board;
    private Player current;
    private Player opponent;
    private Position selected;

    /**
     * Creates a game with a player and an opponent
     *
     * The player is red The opponent is blue
     */
    public Game() {
        current = new Player(PlayerColor.RED);
        opponent = new Player(PlayerColor.BLUE);
    }

    /**
     * Initialize the game board with one flag and a general for each player
     */
    @Override
    public void initialize() {
        board = new Board();

        Piece redFlag = new Flag(current.getColor());
        Piece blueFlag = new Flag(opponent.getColor());
        Piece redGeneral = new General(current.getColor());
        Piece blueGeneral = new General(opponent.getColor());

        board.put(redFlag, new Position(0, 1));
        board.put(blueFlag, new Position(4, 2));
        board.put(redGeneral, new Position(3, 2));
        board.put(blueGeneral, new Position(4, 1));

        current.addPiece(redFlag);
        current.addPiece(redGeneral);
        opponent.addPiece(blueFlag);
        opponent.addPiece(blueGeneral);
    }

    /**
     * Checks if a match can start.
     *
     * @throws IllegalStateException if the board is not set yet
     */
    @Override
    public void start() {
        if (board == null) {
            throw new IllegalStateException("The board is not set");
        }
    }

    /**
     * Declares if it's the end of the game.
     * <ul>
     * <li>The game is done if a player can't move</li>
     * <li>The game is done if a player has lost his flag</li>
     * </ul>
     *
     * @return true if it is the end of the game.
     */
    @Override
    public boolean isOver() {
        return !current.hasFlag() || !opponent.hasFlag()
                || !hasMoves(current) || !hasMoves(opponent);
    }

    /**
     * Returns the squares of the board
     *
     * @return the squares of the board
     */
    @Override
    public Square[][] getBoard() {
        return board.getSquares();
    }

    /**
     * Select a piece on the current board
     *
     * @param row the row of the desired piece
     * @param column the column of the desired piece
     * @throws IllegalArgumentException if the position is not on the board
     * @throws IllegalArgumentException if the square at the position is empty
     * @throws IllegalArgumentException if the square is not owned by the player
     */
    @Override
    public void select(int row, int column) {
        if (!board.isInside(new Position(row, column))) {
            throw new IllegalArgumentException(
                    "The position is not on the board");
        }
        if (board.getSquare(new Position(row, column)).isFree()) {
            throw new IllegalArgumentException(
                    "You are trying to select an empty square");
        }
        if (!board.isMyOwn(new Position(row, column), current.getColor())) {
            throw new IllegalArgumentException(
                    "You are trying to select an opponent piece");
        }

        selected = new Position(row, column);
    }

    /**
     * Returns the selected piece
     *
     * @return the selected piece
     * @throws NullPointerException if the selected piece is empty
     */
    @Override
    public Piece getSelected() {
        if (selected == null) {
            throw new NullPointerException("The selected piece is empty");
        }
        return board.getSquare(selected).getPiece();
    }

    /**
     * Returns the possible moves
     *
     * @return the possible moves
     */
    @Override
    public List<Move> getMoves() {
        if (selected == null) {
            throw new NullPointerException("The selected piece is empty");
        }

        List<Move> possibleMoves = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            Position nextPosition = selected.next(direction);
            if (board.isInside(nextPosition)) {
                if (board.isFree(nextPosition)
                        || !board.isMyOwn(nextPosition, current.getColor())) {

                    possibleMoves.add(new Move(
                            board.getSquare(selected).getPiece(),
                            new Position(selected.getRow(), selected.getColumn()),
                            nextPosition));
                }
            }
        }
        return possibleMoves;
    }

    /**
     *
     * Applies the move passed in parameter and carries out several operations
     *
     * <ul>
     * <li>Removes the piece at the starting position</li>
     * <li>if the end position is empty the piece is moved to the arrival</li>
     * <li>if the end position is not empty the two pieces begins a battle
     * <ul>
     * <li>
     * if the piece to move win the battle, the opponent piece is removed and it
     * is replaced by the piece to move
     * </li>
     * <li>if the two pieces have the same rank, both are removed</li>
     * <li>if the piece lose the battle, only the piece to move is removed</li>
     * </ul>
     * </li>
     * <li>the list of pieces of the two players are updated</li>
     * </ul>
     *
     * @param move
     * @throws NullPointerException if the move passed in parameter is null
     * @throws IllegalArgumentException if the move is not valid
     */
    @Override
    public void apply(Move move) {
        if (move == null) {
            throw new NullPointerException("the move can't be null");
        }

        Position end = move.getEnd();
        Piece piece = move.getPiece();

        if (board.isInside(end)
                || board.getSquare(move.getStart()).getPiece() == piece
                || board.getSquare(end).getPiece().getColor() != piece.getColor()) {

            board.remove(move.getStart());

            if (board.isFree(end)) {
                board.put(piece, end);
            } else {
                if (piece.isStronger(board.getSquare(end).getPiece())) {
                    board.remove(end);
                    board.put(piece, end);

                    opponent.getPieces().remove(board.getSquare(end).getPiece());
                } else if (piece.hasSameRank(board.getSquare(end).getPiece())) {
                    board.remove(end);
                    board.remove(move.getStart());

                    current
                            .getPieces()
                            .remove(board.getSquare(move.getStart()).getPiece());
                    opponent.getPieces().remove(board.getSquare(end).getPiece());

                }
            }
        }

        swapPlayers();
    }

    /**
     * Swaps the players
     */
    public void swapPlayers() {
        if (hasMoves(opponent)) {
            Player tmp = current;
            current = opponent;
            opponent = tmp;
        }
    }

    /**
     * Returns the current player
     *
     * @return the current player
     */
    public Player getCurrent() {
        return current;
    }

    /**
     * Checks if the player has piece that can move
     *
     * @param player the player to check if he has a piece he can move
     * @return true if the player can move a piece
     */
    public boolean hasMoves(Player player) {
        Position tmp = selected;
        for (Position position : board.getTakenSquare(player)) {
            selected = position;
            if (getMoves().size() < 0) {
                selected = tmp;
                return false;
            }
        }
        selected = tmp;
        return true;
    }

    /**
     * Returns the list of winners
     *
     * @return the list of winners
     * @throws IllegalStateException if the game is not over
     */
    public List<Player> getWinners() {
        if (!isOver()) {
            throw new IllegalStateException("The game is not over");
        }
        List<Player> winners = new ArrayList<>();

        if (current.hasFlag()) {
            winners.add(current);
        }
        if (opponent.hasFlag()) {
            winners.add(opponent);
        }

        return winners;
    }
}
