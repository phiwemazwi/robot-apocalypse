package tech.ioco.robot.apocalypse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ioco.robot.apocalypse.Entity.Robot;
import tech.ioco.robot.apocalypse.Service.RobotService;

import java.util.List;

@RestController
@RequestMapping("/api/robots")
public class RobotController {

    private final RobotService robotService;
    @Autowired
    public RobotController(RobotService robotService){
        this.robotService = robotService;
    }

    @GetMapping("/fetchAndSort")
    public ResponseEntity<List<Robot>> fetchAndSortRobots(){
        List<Robot> robots = robotService.fetchAndSortRobots();
        return  ResponseEntity.ok(robots);
    }
}
