package LabReports_Module;
import java.util.*;

public class LabReportRepository {

    private Map<String, LabReport> reports = new HashMap<>();

    public void save(LabReport report) {
        reports.put(report.getReportId(), report);
    }

    public Optional<LabReport> findById(String reportId) {
        return Optional.ofNullable(reports.get(reportId));
    }

    public List<LabReport> findAll() {
        return new ArrayList<>(reports.values());
    }

    public void delete(String reportId) {
        reports.remove(reportId);
    }
}