package dev.Braz.spring_1.Tournaments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<TournamentModel, Long> {

}
