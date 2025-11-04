package dev.Braz.spring_1.Player;

import dev.Braz.spring_1.Tournaments.TournamentModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private long            id;
    private String          name;
    private String          email;
    private String          deck;
    private TournamentModel tournament;

}
