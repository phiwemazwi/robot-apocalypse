package tech.ioco.robot.apocalypse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ioco.robot.apocalypse.Entity.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    int countByReportedId(Long reportedId);
}
