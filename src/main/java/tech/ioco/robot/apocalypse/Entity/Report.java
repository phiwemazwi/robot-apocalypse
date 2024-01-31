package tech.ioco.robot.apocalypse.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporterId")
    private Survivor reporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportedId")
    private  Survivor reported;

    private LocalDateTime reportTimestamp;
}
