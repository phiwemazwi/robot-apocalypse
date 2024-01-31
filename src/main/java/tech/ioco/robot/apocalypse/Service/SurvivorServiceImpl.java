package tech.ioco.robot.apocalypse.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Repository.SurvivorRepo;



import java.util.Optional;

@Service
public class SurvivorServiceImpl implements SurvivorService{

    private final SurvivorRepo survivorRepo;

    @Autowired
    public SurvivorServiceImpl(SurvivorRepo survivorRepo){
        this.survivorRepo = survivorRepo;
    }

    @Override
    public Survivor addSurvivor(Survivor survivor){
        return  survivorRepo.save(survivor);
    }

    @Override
    public  Survivor updateSurvivorLocation(Long id, double latitude, double longitude){
        Optional<Survivor> survivorOptional = survivorRepo.findById(id);
        if (!survivorOptional.isPresent()){
            throw new EntityNotFoundException("The survivor could not be found with id: "+id);
        }

        Survivor survivor = survivorOptional.get();
        survivor.setLatitude(latitude);
        survivor.setLongitude(longitude);
        return survivorRepo.save(survivor);
    }
}
