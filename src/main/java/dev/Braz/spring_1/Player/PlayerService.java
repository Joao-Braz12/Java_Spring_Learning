package dev.Braz.spring_1.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerModel> listPlayers() {
        return playerRepository.findAll();
    }

    public PlayerModel listPlayerById(Long id) {
        Optional<PlayerModel> playerModel = playerRepository.findById(id);
        return playerModel.orElse(null);
    }

    public PlayerModel CreatePlayer(PlayerModel player) {
        return playerRepository.save(player);
    }

    public void DeletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
