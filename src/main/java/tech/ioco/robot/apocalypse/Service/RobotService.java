package tech.ioco.robot.apocalypse.Service;

import tech.ioco.robot.apocalypse.Entity.Robot;

import java.util.List;

public interface RobotService {
    List<Robot> fetchAndSortRobots();
}
