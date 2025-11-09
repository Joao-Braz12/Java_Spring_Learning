package dev.Braz.spring_1.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerDTO> listPlayers() {
        List<PlayerModel> players = playerRepository.findAll();
        return players.stream()
                .map(playerMapper::map)
                .collect(Collectors.toList());
    }

    public PlayerDTO listPlayerById(Long id) {
        Optional<PlayerModel> playerModel = playerRepository.findById(id);
        return playerModel.map(playerMapper::map).orElse(null);
    }

    public PlayerDTO CreatePlayer(PlayerDTO playerDTO) {
        PlayerModel player = playerMapper.map(playerDTO);
        player = playerRepository.save(player);
        return playerMapper.map(player);
    }

    public void DeletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerDTO UpdatePlayerById(Long id, PlayerDTO updated) {
        Optional<PlayerModel> player = playerRepository.findById(id);
        if(player.isPresent()){
            PlayerModel updatedModel = playerMapper.map(updated);
            updatedModel.setId(id);
            return  playerMapper.map(playerRepository.save(updatedModel));
        }
        return null;
    }
}
