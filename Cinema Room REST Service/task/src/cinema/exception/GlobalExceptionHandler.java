package cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TicketAlreadyPurchasedException.class)
    public ResponseEntity<Response> handleTicketAlreadyPurchasedException(TicketAlreadyPurchasedException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RowOrColumnOutOfBoundException.class)
    public ResponseEntity<Response> handleRowOrColumnOutOfBoundExceptionException(RowOrColumnOutOfBoundException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
