
package firstmaven;
import java.util.List;

public class LabReportService {

    private LabReportRepository repository;

    public LabReportService(LabReportRepository repository) {
        this.repository = repository;
    }

    public void createReport(LabReport report) {
        if (report.getReportId() == null || report.getReportId().isEmpty()) {
            throw new IllegalArgumentException("Report ID cannot be empty");
        }
        repository.save(report);
    }

    public LabReport getReport(String reportId) {
        return repository.findById(reportId)
                .orElseThrow(() ->
                        new LabReportNotFoundException("Report not found"));
    }

    public List<LabReport> getAllReports() {
        return repository.findAll();
    }

    public void markAsCompleted(String reportId) {
        LabReport report = getReport(reportId);
        report.setStatus("COMPLETED");
    }

    public void deleteReport(String reportId) {
        if (!repository.findById(reportId).isPresent()) {
            throw new LabReportNotFoundException("Cannot delete. Report not found");
        }
        repository.delete(reportId);
    }
}