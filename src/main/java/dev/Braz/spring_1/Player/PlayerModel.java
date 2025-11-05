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
    @Column(name = "id")
    private long            id;

    @Column(name = "name")
    private String          name;

    @Column(unique = true, name = "Email")
    private String          email;

    @Column(name = "deck")
    private String          deck;

    @Column(name = "number")
    private String          number;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private TournamentModel tournament;

}
