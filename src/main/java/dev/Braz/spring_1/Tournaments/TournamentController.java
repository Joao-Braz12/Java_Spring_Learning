package dev.Braz.spring_1.Tournaments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private TournamentService t_Service;

    public TournamentController(TournamentService t_Service) {
        this.t_Service = t_Service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TournamentDTO>> List(){
        List<TournamentDTO> t_List = t_Service.listtournaments();
        return ResponseEntity.ok(t_List);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> ListbyID(@PathVariable Long id){
        TournamentDTO tournament = t_Service.listTournamentById(id);
        if(tournament != null)
            return ResponseEntity.ok(tournament);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id "+id + " was not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateTournament(@RequestBody TournamentDTO t_DTO){
        TournamentDTO t_new = t_Service.CreateTournament(t_DTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The tournament was created! \nId: "+ t_new.getId() + "\tName: " + t_new.getName());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateTournament(@PathVariable Long id, @RequestBody TournamentDTO t_new){
        TournamentDTO t_updated = t_Service.UpdateTournamentById(id, t_new);
        if(t_updated != null)
            return ResponseEntity.ok(t_updated);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The tournament id: "+id+" was not found.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteTournament(@PathVariable Long id){
        if(t_Service.listTournamentById(id) != null){
            t_Service.DeleteTournamentById(id);
            return ResponseEntity.ok("The tournament id: "+ id+" was deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The id:" + id + " was not found.");
    }
}
