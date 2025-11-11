package dev.Braz.spring_1.Tournaments;

import org.springframework.stereotype.Component;

@Component
public class TournamentMapper {

    public TournamentDTO map(TournamentModel t_Model)
    {
        TournamentDTO t_DTO = new TournamentDTO();
        t_DTO.setId(t_Model.getId());
        t_DTO.setDate(t_Model.getDate());
        t_DTO.setName(t_Model.getName());
        t_DTO.setWinner(t_Model.getWinner());
        t_DTO.setPlayerModelList(t_Model.getPlayersList());

        return t_DTO;
    }

    public TournamentModel map(TournamentDTO t_DTO)
    {
        TournamentModel t_Model = new TournamentModel();
        t_Model.setId(t_Model.getId());
        t_Model.setDate(t_DTO.getDate());
        t_Model.setName(t_DTO.getName());
        t_Model.setWinner(t_DTO.getWinner());
        t_Model.setPlayersList(t_DTO.getPlayerModelList());

        return t_Model;
    }
}

