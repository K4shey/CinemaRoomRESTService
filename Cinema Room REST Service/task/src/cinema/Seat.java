package cinema;

public class Seat {
    private int row;
    private int column;

    public Seat(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
