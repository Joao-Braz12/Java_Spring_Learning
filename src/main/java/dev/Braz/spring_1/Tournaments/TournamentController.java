package dev.Braz.spring_1.Tournaments;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @GetMapping("/List")
    public String List(){
        return ("Tournament Listed");
    }

    @PostMapping("/create")
    public String CreateTournament(){
        return ("Tournament created");
    }

    @PutMapping("/update")
    public String UpdateTournament(){
        return ("Tournament Updated");
    }

    @DeleteMapping("/delete")
    public String DeleteTournament(){
        return ("Tournament Deleted");
    }
}
