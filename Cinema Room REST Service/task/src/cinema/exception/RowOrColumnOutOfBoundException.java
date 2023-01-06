package cinema.exception;

public class RowOrColumnOutOfBoundException extends RuntimeException {

    public RowOrColumnOutOfBoundException() {
        super("The number of a row or a column is out of bounds!");
    }
}
