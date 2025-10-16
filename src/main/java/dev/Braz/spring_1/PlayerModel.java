package dev.Braz.spring_1;


import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_players")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;
    private String  name;
    private String  email;
    private String    deck;

    public PlayerModel(String name, String email, String deck) {
        this.name = name;
        this.email = email;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
