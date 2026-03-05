package firstmaven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import firstmaven.LabReport;
import firstmaven.LabReportNotFoundException;
import firstmaven.LabReportRepository;
import firstmaven.LabReportService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabReportServiceTest {

    private LabReportService service;
    private LabReportRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LabReportRepository();
        service = new LabReportService(repository);
    }

    //  Test report creation
    @Test
    void shouldCreateReportSuccessfully() {
        LabReport report = new LabReport(
                "R101",
                "Apurva",
                "Blood Test",
                "Normal",
                LocalDate.now(),
                "PENDING"
        );

        service.createReport(report);

        LabReport savedReport = service.getReport("R101");
        assertEquals("Blood Test", savedReport.getTestType());
        assertEquals("Apurva", savedReport.getPatientName());
    }

    //  Test invalid report ID
    @Test
    void shouldThrowExceptionWhenReportIdIsEmpty() {
        LabReport report = new LabReport(
                "",
                "Rahul",
                "X-Ray",
                "Clear",
                LocalDate.now(),
                "PENDING"
        );

        assertThrows(IllegalArgumentException.class,
                () -> service.createReport(report));
    }

    //  Test fetching non-existing report
    @Test
    void shouldThrowExceptionWhenReportNotFound() {
        assertThrows(LabReportNotFoundException.class,
                () -> service.getReport("INVALID_ID"));
    }

    // Test mark report as completed
    @Test
    void shouldMarkReportAsCompleted() {
        LabReport report = new LabReport(
                "R102",
                "Sneha",
                "MRI",
                "Normal",
                LocalDate.now(),
                "PENDING"
        );

        service.createReport(report);
        service.markAsCompleted("R102");

        LabReport updated = service.getReport("R102");
        assertEquals("COMPLETED", updated.getStatus());
    }

    //  Test delete report
    @Test
    void shouldDeleteReportSuccessfully() {
        LabReport report = new LabReport(
                "R103",
                "Amit",
                "CT Scan",
                "Normal",
                LocalDate.now(),
                "PENDING"
        );

        service.createReport(report);
        service.deleteReport("R103");

        assertThrows(LabReportNotFoundException.class,
                () -> service.getReport("R103"));
    }

    //  Test delete non-existing report
    @Test
    void shouldThrowExceptionWhenDeletingNonExistingReport() {
        assertThrows(LabReportNotFoundException.class,
                () -> service.deleteReport("UNKNOWN"));
    }
}

