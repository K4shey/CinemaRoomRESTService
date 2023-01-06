package cinema;

import cinema.exception.RowOrColumnOutOfBoundException;
import cinema.exception.TicketAlreadyPurchasedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class TaskController {

    public final CinemaRoom cinemaRoom = new CinemaRoom();

    @GetMapping("/seats")
    public String returnOne() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cinemaRoom);
    }

    @PostMapping("/purchase")
    public String PurchaseSeatIfAvailable(@RequestBody Seat seat) {
        int row = seat.getRow();
        int column = seat.getColumn();
        if (row < 1 || row > cinemaRoom.COUNT_OF_ROWS || column < 1 || column > cinemaRoom.COUNT_OF_COLUMNS) {
            throw new RowOrColumnOutOfBoundException();
        }

        List<Seat> seats = cinemaRoom.getSeats();
        for (Seat nextSeat : seats) {
            if (nextSeat.getRow() == row && nextSeat.getColumn() == column) {
                seats.remove(nextSeat);
                return getSeatInfo(nextSeat);
            }
        }

        throw new TicketAlreadyPurchasedException();
    }

    private String getSeatInfo(Seat seat) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(seat);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
