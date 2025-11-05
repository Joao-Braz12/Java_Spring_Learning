package dev.Braz.spring_1.Player;

import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerModel map(PlayerDTO playerDTO) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setId(playerDTO.getId());
        playerModel.setName(playerDTO.getName());
        playerModel.setEmail(playerDTO.getEmail());
        playerModel.setDeck(playerDTO.getDeck());
        playerModel.setTournament(playerDTO.getTournament());
        playerModel.setNumber(playerDTO.getNumber());

        return playerModel;
    }

    public PlayerDTO map(PlayerModel playerModel) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(playerModel.getId());
        playerDTO.setName(playerModel.getName());
        playerDTO.setEmail(playerModel.getEmail());
        playerDTO.setDeck(playerModel.getDeck());
        playerDTO.setTournament(playerModel.getTournament());
        playerDTO.setNumber(playerModel.getNumber());

        return playerDTO;
    }

}
