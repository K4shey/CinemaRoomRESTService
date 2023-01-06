package cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class PurchasedTicket {
    @JsonProperty("token")
    private String token;
    @JsonProperty("ticket")
    private Seat seat;

    public PurchasedTicket() {
    }

    public PurchasedTicket(String token, Seat seat) {
        this.token = token;
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public Seat getSeat() {
        return seat;
    }
}
