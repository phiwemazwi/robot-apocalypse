package tech.ioco.robot.apocalypse.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ioco.robot.apocalypse.Entity.Report;
import tech.ioco.robot.apocalypse.Entity.Survivor;
import tech.ioco.robot.apocalypse.Repository.ReportRepo;
import tech.ioco.robot.apocalypse.Repository.SurvivorRepo;

import java.time.LocalDateTime;

@Service
public class ReportServiceImpl implements ReportService{
    private final ReportRepo reportRepo;
    private final SurvivorRepo survivorRepo;
    @Autowired
    public ReportServiceImpl(ReportRepo reportRepo, SurvivorRepo survivorRepo){
        this.reportRepo = reportRepo;
        this.survivorRepo = survivorRepo;
    }

    @Override
    public void reportInfection(Long reporterId, Long reportedId){

        Survivor reporter = survivorRepo.findById(reporterId).orElseThrow(
                ()-> new RuntimeException("The reporter was not found with id: "+ reporterId)
        );
        Survivor reported = survivorRepo.findById(reportedId).orElseThrow(
                () -> new RuntimeException("The reported survivor was not found with id: "+ reportedId)
        );

        Report report = new Report();
        report.setReporter(reporter);
        report.setReported(reported);
        report.setReportTimestamp(LocalDateTime.now());
        reportRepo.save(report);

        int reportCount = reportRepo.countByReportedId(reportedId);
        if (reportCount >= 3){
            reported.setInfectionStatus(true);
            survivorRepo.save(reported);
        }



    }
}
