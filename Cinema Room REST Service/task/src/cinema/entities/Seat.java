package cinema.entities;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "returned_ticket")
public class Seat {
    private int row;
    private int column;
    private int price;


    public Seat() {

    }

    public Seat(int row, int col, int price) {
        this.row = row;
        this.column = col;
        this.price = price;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }
}
