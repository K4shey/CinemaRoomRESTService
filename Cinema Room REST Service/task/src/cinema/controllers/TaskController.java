package cinema.controllers;

import cinema.entities.CinemaRoom;
import cinema.entities.PurchasedTicket;
import cinema.entities.Seat;
import cinema.exceptions.RowOrColumnOutOfBoundException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import cinema.exceptions.WrongTokenException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
public class TaskController {

    public final CinemaRoom cinemaRoom = new CinemaRoom();

    @GetMapping("/seats")
    public String returnOne() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cinemaRoom);
    }

    @PostMapping("/purchase")
    public String PurchaseSeatIfAvailable(@RequestBody Seat inSeat) {
        int row = inSeat.getRow();
        int column = inSeat.getColumn();
        if (row < 1 || row > cinemaRoom.COUNT_OF_ROWS || column < 1 || column > cinemaRoom.COUNT_OF_COLUMNS) {
            throw new RowOrColumnOutOfBoundException();
        }
        List<Seat> availableSeats = cinemaRoom.getSeats();
        List<PurchasedTicket> purchasedTickets = cinemaRoom.getPurchasedTickets();
        for (Seat seat : availableSeats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                PurchasedTicket newTicket = new PurchasedTicket(UUID.randomUUID().toString(), seat);
                purchasedTickets.add(newTicket);
                availableSeats.remove(seat);
                return getPurchasedTicketInfo(newTicket);
            }
        }
        throw new TicketAlreadyPurchasedException();
    }

    @PostMapping("/return")
    public String RefundTicketIfAvailable(@RequestBody PurchasedTicket inTicket) {
        String tokenToFind = inTicket.getToken();
        List<Seat> availableSeats = cinemaRoom.getSeats();
        List<PurchasedTicket> purchasedTickets = cinemaRoom.getPurchasedTickets();
        for (PurchasedTicket ticket : purchasedTickets) {
            if (ticket.getToken().equals(tokenToFind)) {
                availableSeats.add(ticket.getSeat());
                return getRefundedTicketInfo(ticket);
            }
        }
        throw new WrongTokenException();
    }

    private String getPurchasedTicketInfo(PurchasedTicket ticket) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(ticket);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRefundedTicketInfo(PurchasedTicket ticket) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        try {
            return objectMapper.writeValueAsString(ticket.getSeat());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
