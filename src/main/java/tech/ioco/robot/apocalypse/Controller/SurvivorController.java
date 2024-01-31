package tech.ioco.robot.apocalypse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Service.SurvivorService;

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
}
