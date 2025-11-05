package dev.Braz.spring_1.Player;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/wellcome")
    public String WellCome(){
        return  "Boas Vindas";
    }

    @GetMapping("/list")
    public List<PlayerModel> ListPlayers(){
        return playerService.listPlayers();
    }

    @PostMapping("/create")
    public PlayerDTO CreatePlayer(@RequestBody PlayerDTO player){
        return playerService.CreatePlayer(player);
    }

    @GetMapping("/list/{id}")
    public PlayerModel ListById(@PathVariable Long id) {
        return playerService.listPlayerById(id);
    }

    @PutMapping("/update/{id}")
    public PlayerModel UpdatePlayerById(@PathVariable Long id, @RequestBody PlayerModel updated){
        return playerService.UpdatePlayerById(id, updated);
    }

    @DeleteMapping("/delete/{id}")
    public void DeletedPlayerById(@PathVariable Long id){
        playerService.DeletePlayerById(id);
    }
}
