package dev.Braz.spring_1.Tournaments;

import dev.Braz.spring_1.Player.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDTO {
    private Long                id;
    private String              name;
    private String              date;
    private Long                winner;
    private List<PlayerModel>   playerModelList;
}
