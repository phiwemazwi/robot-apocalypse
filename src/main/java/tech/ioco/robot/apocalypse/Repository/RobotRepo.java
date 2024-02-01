package tech.ioco.robot.apocalypse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ioco.robot.apocalypse.Entity.Robot;

@Repository
public interface RobotRepo extends JpaRepository<Robot,Long> {
}
