package dev.Braz.spring_1.Player;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @GetMapping("/wellcome")
    public String WellCome(){
        return  "Boas Vindas";
    }

    @GetMapping("/allplayers")
    public String AllPlayer(){
        return("All Players");
    }

    @PostMapping("/create")
    public String CreatePLayer(){
        return("Player created");
    }

    @GetMapping("/allplayersid")
    public String AllPlayerId(){
        return("All Players Id");
    }

    @PutMapping("/updatebyid")
    public String UpdatePlayerId(){
        return("Player Updated by Id");
    }

    @DeleteMapping("/deletebyid")
    public String DeletedPlayerId(){
        return("Player Deletd by Id");
    }
}
