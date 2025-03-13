package com.example.demo.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HockeyController {

    @Autowired
    private HockeyService hockeyService;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/game")
    public Game createHockey(@RequestBody Game game) {
        return gameRepository.save(game);
    }
    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
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

    @GetMapping("/player/{id}")
    public Player GetPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Your mom"));
    }

    @GetMapping("/team/{id}")
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
    @PutMapping("/player/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestParam(required = false) String name, @RequestParam(required = false) int  age) {
        // Check if the person with the given id exists
        Player person = playerRepository.findById(id).orElse(null);
        if (person != null) {
            person.setName(name);
            person.setAge(age);
            return playerRepository.save(person);
        } else {
            return null;
        }
    }
    @PutMapping("/team/{id}")
    public Team updateTeam(@PathVariable Long id,@RequestParam(required = false) String name) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            team.setName(name);
            return teamRepository.save(team);

        }else {return null;}
    }



    @DeleteMapping("/team/{id}")
    public void deleteTeam(@PathVariable long id) {teamRepository.deleteById(id);}

    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable long id) {playerRepository.deleteById(id);}

    /// //////////////////////////////////////////

}
