package com.example.demo.hockey;


import com.example.demo.hockey.Game;
import com.example.demo.hockey.Player;
import com.example.demo.hockey.Team;
import com.example.demo.hockey.GameRepository;
import com.example.demo.hockey.PlayerRepository;
import com.example.demo.hockey.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HockeyService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
}
