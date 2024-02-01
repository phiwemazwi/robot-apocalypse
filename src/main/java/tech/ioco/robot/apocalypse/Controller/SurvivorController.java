package tech.ioco.robot.apocalypse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Service.SurvivorService;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}/location")
    public ResponseEntity<Survivor> updateSurvivorLocation(@PathVariable Long id, @RequestParam double latitude, @RequestParam double longitude){
        Survivor updatedSurvivor = survivorService.updateSurvivorLocation(id,latitude,longitude);
        return ResponseEntity.ok(updatedSurvivor);
    }






    @GetMapping("/infected-percentage")
    public ResponseEntity<Double> getInfectedPercentage(){
        return ResponseEntity.ok(survivorService.getInfectedPercentage());
    }
    @GetMapping("/non-infected-percentage")
    public ResponseEntity<Double> getNonInfectedPercentage(){
        return  ResponseEntity.ok(survivorService.getNonInfectedPercentage());
    }
    @GetMapping("/infected-list")
    public ResponseEntity<List<Survivor>> getInfected(){
        return ResponseEntity.ok(survivorService.getInfected());
    }
    @GetMapping("/non-infected-list")
    public ResponseEntity<List<Survivor>> getNoneInfected(){
        return ResponseEntity.ok(survivorService.getNoneInfected());
    }
}
