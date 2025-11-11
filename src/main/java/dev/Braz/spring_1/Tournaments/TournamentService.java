package dev.Braz.spring_1.Tournaments;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private  TournamentRepository t_Repository;
    private TournamentMapper t_Mapper;

    public TournamentService(TournamentRepository t_Repository, TournamentMapper t_mapper) {
        this.t_Repository = t_Repository;
        this.t_Mapper = t_mapper;
    }

    public List<TournamentDTO> listtournaments() {
        List<TournamentModel> tournaments = t_Repository.findAll();
        return tournaments.stream()
                .map(t_Mapper::map)
                .collect(Collectors.toList());
    }

    public TournamentDTO listTournamentById(Long id) {
        Optional<TournamentModel> tournamentModel = t_Repository.findById(id);
        return tournamentModel.map(t_Mapper::map).orElse(null);
    }

    public TournamentDTO CreateTournament(TournamentDTO t_DTO) {
        TournamentModel t_Model = t_Mapper.map(t_DTO);
        t_Model = t_Repository.save(t_Model);
        return t_Mapper.map(t_Model);
    }

    public void DeleteTournamentById(Long id) {
        t_Repository.deleteById(id);
    }

    public TournamentDTO UpdateTournamentById(Long id, TournamentDTO updated) {
        Optional<TournamentModel> t_Model= t_Repository.findById(id);
        if(t_Model.isPresent()){
            TournamentModel updatedModel = t_Mapper.map(updated);
            updatedModel.setId(id);
            return  t_Mapper.map(t_Repository.save(updatedModel));
        }
        return null;
    }
}
