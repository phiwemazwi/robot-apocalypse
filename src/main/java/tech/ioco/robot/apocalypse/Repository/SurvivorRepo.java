package tech.ioco.robot.apocalypse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ioco.robot.apocalypse.Entity.Survivor;

import java.util.List;

@Repository
public interface SurvivorRepo extends JpaRepository<Survivor, Long> {
    long countByInfectionStatus(boolean infectionStatus);
    List<Survivor> findByInfectionStatus(boolean infectionStatus);
}
