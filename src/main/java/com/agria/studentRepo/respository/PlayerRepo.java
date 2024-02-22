package com.agria.studentRepo.respository;

import com.agria.studentRepo.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo  extends JpaRepository<Player,Long> {

}
