package tech.ioco.robot.apocalypse.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
    private double latitude;
    private double longitude;
    private boolean infectionStatus;

    @OneToMany(mappedBy = "survivor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Resource> resources = new HashSet<>();

    @OneToMany(mappedBy = "reported", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Report> reports = new HashSet<>();
}
