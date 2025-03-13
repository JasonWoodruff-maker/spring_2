package com.example.demo.hockey;



import com.example.demo.hockey.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
