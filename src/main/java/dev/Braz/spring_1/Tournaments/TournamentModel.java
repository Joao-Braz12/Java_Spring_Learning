package dev.Braz.spring_1.Tournaments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Braz.spring_1.Player.PlayerModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_tournaments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TournamentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long    id;

    @Column(name = "name")
    private String  name;

    @Column(name = "date")
    private String  date;

    @Column(name = "winner")
    private Long    winner;

    @OneToMany(mappedBy = "tournament")
    @JsonIgnore
    private List<PlayerModel>   playersList;
}
