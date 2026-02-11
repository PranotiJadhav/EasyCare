import java.time.LocalDate;

public class LabReport {

    private String reportId;
    private String patientName;
    private String testType;
    private String result;
    private LocalDate reportDate;
    private String status; // PENDING, COMPLETED

    public LabReport(String reportId, String patientName, String testType,
                     String result, LocalDate reportDate, String status) {
        this.reportId = reportId;
        this.patientName = patientName;
        this.testType = testType;
        this.result = result;
        this.reportDate = reportDate;
        this.status = status;
    }

    public String getReportId() { return reportId; }
    public String getPatientName() { return patientName; }
    public String getTestType() { return testType; }
    public String getResult() { return result; }
    public LocalDate getReportDate() { return reportDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}