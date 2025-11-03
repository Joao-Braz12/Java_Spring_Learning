package dev.Braz.spring_1.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<PlayerModel, Long> {
}
