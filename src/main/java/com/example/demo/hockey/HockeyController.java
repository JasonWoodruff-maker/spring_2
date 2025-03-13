package com.example.demo.hockey;

import com.example.demo.hockey.Game;
import com.example.demo.hockey.Player;
import com.example.demo.hockey.Team;
import com.example.demo.hockey.HockeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HockeyController {

    @Autowired
    private HockeyService hockeyService;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return hockeyService.getAllTeams();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return hockeyService.getAllPlayers();
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return hockeyService.getAllGames();
    }

    @PostMapping("/teams")
    public Team saveTeam(@RequestBody Team team) {
        return hockeyService.saveTeam(team);
    }

    @PostMapping("/players")
    public Player savePlayer(@RequestBody Player player) {
        return hockeyService.savePlayer(player);
    }

    @PostMapping("/games")
    public Game saveGame(@RequestBody Game game) {
        return hockeyService.saveGame(game);
    }
}
