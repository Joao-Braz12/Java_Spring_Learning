package dev.Braz.spring_1.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerModel> listPlayers() {
        return playerRepository.findAll();
    }

    public PlayerModel listPlayerById(Long id) {
        Optional<PlayerModel> playerModel = playerRepository.findById(id);
        return playerModel.orElse(null);
    }

    public PlayerDTO CreatePlayer(PlayerDTO playerDTO) {
        PlayerModel player = playerMapper.map(playerDTO);
        player = playerRepository.save(player);
        return playerMapper.map(player);
    }

    public void DeletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerModel UpdatePlayerById(Long id, PlayerModel updated) {
        if(playerRepository.existsById(id)){
            updated.setId(id);
            return playerRepository.save(updated);
        }
        return null;
    }
}
