package com.example.demo.hockey;



import com.example.demo.hockey.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
