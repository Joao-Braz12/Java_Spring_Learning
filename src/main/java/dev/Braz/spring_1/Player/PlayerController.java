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
    public PlayerModel CreatePlayer(@RequestBody PlayerModel playerModel){
        return playerService.CreatePlayer(playerModel);
    }

    @GetMapping("/list/{id}")
    public PlayerModel ListById(@PathVariable Long id) {
        return playerService.listPlayerById(id);
    }

    @PutMapping("/update")
    public String UpdatePlayerId(){
        return("Player Updated by Id");
    }

    @DeleteMapping("/delete")
    public String DeletedPlayerId(){
        return("Player Deletd by Id");
    }
}
