package dev.Braz.spring_1.Player;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @GetMapping("/wellcome")
    public String WellCome(){
        return  "Boas Vindas";
    }

    @GetMapping("/list")
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

    @PutMapping("/update")
    public String UpdatePlayerId(){
        return("Player Updated by Id");
    }

    @DeleteMapping("/delete")
    public String DeletedPlayerId(){
        return("Player Deletd by Id");
    }
}
