package tech.ioco.robot.apocalypse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.ioco.robot.apocalypse.Service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;
    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @PostMapping("/reportInfection")
    public ResponseEntity<?> reportInfection(@RequestParam Long reporterId, @RequestParam Long reportedId){
        reportService.reportInfection(reporterId, reportedId);
        return  ResponseEntity.ok().build();
    }
}
