package dev.Braz.spring_1.Player;


import dev.Braz.spring_1.Tournaments.TournamentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_players")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long            id;
    private String          name;
    private String          email;
    private String          deck;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private TournamentModel tournament;

}
