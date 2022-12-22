package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;



public class CinemaRoom {

    @JsonProperty("total_rows")
    public final int COUNT_OF_ROWS = 9;
    @JsonProperty("total_columns")
    public final int COUNT_OF_COLUMNS = 9;

    @JsonProperty("available_seats")
    private List<Seat> seats = new ArrayList<>();

    public CinemaRoom(){
        for (int i = 0; i < COUNT_OF_ROWS; i++) {
            for (int j = 0; j < COUNT_OF_COLUMNS; j++) {
                seats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
