package tech.ioco.robot.apocalypse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Service.SurvivorService;

@RestController
@RequestMapping("/api/survivors")
public class SurvivorController {

    private final SurvivorService survivorService;
    @Autowired
    public SurvivorController(SurvivorService survivorService){
        this.survivorService = survivorService;
    }

    @PostMapping
    public ResponseEntity<Survivor> addSurvivor(@RequestBody Survivor survivor){
        Survivor newSurvivor = survivorService.addSurvivor(survivor);
        return  ResponseEntity.ok(newSurvivor);
    }
}
