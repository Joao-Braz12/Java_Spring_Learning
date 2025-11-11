package dev.Braz.spring_1.Player;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/wellcome")
    @Operation(summary="Wellcome Message",description="Gives user a wellcome message")
    public String WellCome(){
        return  "Boas Vindas";
    }

    @GetMapping("/list")
    public ResponseEntity<List<PlayerDTO>> ListPlayers(){
        List<PlayerDTO> playerList =  playerService.listPlayers();
        return ResponseEntity.ok(playerList);
    }

    @PostMapping("/create")
    @Operation(summary="Create a new player", description = "Route creates a new player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created"),
            @ApiResponse(responseCode = "400", description = "Error on player creation")
    })
    public ResponseEntity<?> CreatePlayer(@RequestBody PlayerDTO player){
        PlayerDTO NewPlayer = playerService.CreatePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The Player was created! \n" + NewPlayer);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> ListById(@PathVariable Long id) {
       PlayerDTO player = playerService.listPlayerById(id);
        if(player != null)
           return ResponseEntity.ok(player);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The id: " + id+ " was not found!" );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdatePlayerById(@PathVariable Long id, @RequestBody PlayerDTO updated){
        PlayerDTO updatedPlayer = playerService.UpdatePlayerById(id, updated);
        if(updatedPlayer != null)
            return ResponseEntity.ok(updatedPlayer);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The player with id: "+ id +  "was not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeletedPlayerById(@PathVariable Long id){
        if(playerService.listPlayerById(id) != null)
        {
            playerService.DeletePlayerById(id);
            return ResponseEntity.ok(" id: " + id +" Player deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The player with id: "+ id + " was not found");
    }
}
