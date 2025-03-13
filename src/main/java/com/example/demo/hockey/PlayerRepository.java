package com.example.demo.hockey;


import com.example.demo.hockey.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
