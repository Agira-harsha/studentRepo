package com.agria.studentRepo.controllers;

import com.agria.studentRepo.exceptions.StudentNotFoundException;
import com.agria.studentRepo.models.Player;
import com.agria.studentRepo.respository.PlayerRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private PlayerRepo playerRepo;

    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @GetMapping("/data")
    public List<Player> getPLayers() {
        return playerRepo.findAll();
    }

    @PostMapping("/store")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player save = playerRepo.save(player);
        return  new ResponseEntity<>(save, HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping("{id}")
    public ResponseEntity<Player> getPLayerByID(@PathVariable long id) {
        Optional<Player> player = Optional.ofNullable(playerRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("player not found" + id)));
        return ok(player.get());
    }

    @SneakyThrows
    @PutMapping("{id}")
    public ResponseEntity<Optional<Player>> updatePlayerById(@PathVariable long id, @RequestBody Player players) {
        Optional<Player> player = Optional.ofNullable(playerRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("player not found " + id)));
        boolean present = player.isPresent();
        if (present == true) {
            Player player1 = player.get();
            player1.setPlayerName(players.getPlayerName());
            player1.setAge(players.getAge());
            player1.setScore(players.getScore());
            playerRepo.save(player1);
        }
        return ok(player);
    }

    @SneakyThrows
    @DeleteMapping("{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable long id){
        Player player = playerRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("player not found.."));
        playerRepo.delete(player);
        return ResponseEntity.ok(player);
    }
}
