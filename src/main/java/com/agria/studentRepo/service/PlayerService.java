package com.agria.studentRepo.service;

import com.agria.studentRepo.models.Player;
import com.agria.studentRepo.respository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerService {


    private PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
    public Player getPlayer(long id){
        Optional<Player> playerOptional = playerRepo.findById(id);
        return playerOptional.orElse(null);
    }
    public List<Player> getPlayers(){
        return playerRepo.findAll();
    }
    public Player newPlayer(Player player){
        return playerRepo.save(player);
    }
    public Player modifyPlayer(Player player,long id){
        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if(!optionalPlayer.isPresent()) {
            return null;
        }
        Player newPlayer = optionalPlayer.get();
        newPlayer.setPlayerName(player.getPlayerName());
        newPlayer.setAge(player.getAge());
        newPlayer.setScore(player.getScore());
        return playerRepo.save(newPlayer);
    }

    public Player deletePlayer(long id){
        Optional<Player> playerOptional = playerRepo.findById(id);
        if(!playerOptional.isPresent()) {
            return null;
        }
        playerRepo.delete(playerOptional.get());
        return  playerOptional.get();
    }

}
