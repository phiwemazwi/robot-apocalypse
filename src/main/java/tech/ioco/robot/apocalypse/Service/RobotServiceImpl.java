package tech.ioco.robot.apocalypse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ioco.robot.apocalypse.Entity.Robot;
import tech.ioco.robot.apocalypse.Repository.RobotRepo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotServiceImpl implements RobotService{


    private final RestTemplate restTemplate;
    private final RobotRepo robotRepo;
    @Autowired
    public RobotServiceImpl(RestTemplate restTemplate, RobotRepo robotRepo){
        this.restTemplate = restTemplate;
        this.robotRepo = robotRepo;

    }

    @Override
    public List<Robot> fetchAndSortRobots(){
        String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        Robot[] robots = restTemplate.getForObject(url, Robot[].class);

        List<Robot> sortedRobots = Arrays.stream(robots)
                .sorted((r1,r2) -> r1.getCategory().compareToIgnoreCase(r2.getCategory()))
                .collect(Collectors.toList());

        for (Robot robot : sortedRobots){
            robotRepo.save(robot);
        }

        return sortedRobots;

    }
}
