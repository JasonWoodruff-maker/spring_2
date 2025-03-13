package com.example.demo.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HockeyController {

    @Autowired
    private HockeyService hockeyService;
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    @Autowired
    private GameRepository gameRepository;

    @PostMapping
    public Game createHockey(@RequestBody Game game) {
        return gameRepository.save(game);
    }
    @PutMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    /// //////////////////////////////////////////

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

    /// ///////////////////////////////////////////////

    @GetMapping("/{id}")
    public Player GetPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Your mom"));
    }

    @GetMapping("/{id}")
    public Team GetTeamById(@PathVariable Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Your mom"));
    }

    /// ///////////////////////////////////

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

    /// ////////////////////////////////////////////

    @DeleteMapping
    public void deleteTeam(@RequestBody Team team) {teamRepository.delete(team);}

    @DeleteMapping
    public void deletePlayer(@RequestBody Player player) {playerRepository.delete(player);}

    /// //////////////////////////////////////////

}
