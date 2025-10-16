package dev.Braz.spring_1.Tournaments;

import dev.Braz.spring_1.Player.PlayerModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_tournaments")
public class TournamentModel {

    private long    id;
    private String  name;
    private String  date;
    private Long    winner;

    @OneToMany(mappedBy = "tournament")
    private List<PlayerModel>   playersList;
}
