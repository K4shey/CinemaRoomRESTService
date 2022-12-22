package cinema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;



@RestController
public class TaskController {

    public final CinemaRoom cinemaRoom  = new CinemaRoom();

    @GetMapping("/seats")
    public String returnOne() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Writer writer = new StringWriter();
        String result = objectMapper.writeValueAsString(cinemaRoom);

        return result;
    }
}
