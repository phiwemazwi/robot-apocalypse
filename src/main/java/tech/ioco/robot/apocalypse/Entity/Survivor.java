package tech.ioco.robot.apocalypse.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private int age;
    private double latitude;
    private double longitude;
    private boolean infectionStatus = false;

    @OneToMany(mappedBy = "survivor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Resource> resources = new HashSet<>();

    @OneToMany(mappedBy = "reported", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Report> reports = new HashSet<>();

    public void addResource(Resource resource){
        resources.add(resource);
        resource.setSurvivor(this);
    }
}
