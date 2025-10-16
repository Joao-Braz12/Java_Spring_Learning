package dev.Braz.spring_1.Player;


import dev.Braz.spring_1.Tournaments.TournamentModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_players")
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

    public PlayerModel(String name, String email, String deck) {
        this.name = name;
        this.email = email;
        this.deck = deck;
    }
}
