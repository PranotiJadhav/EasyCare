package tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorServiceTest {


    private DoctorService service;

    @BeforeEach
    void setUp() {
        service = new DoctorService();

        // Add one doctor before each test
        List<String> slots = Arrays.asList("10AM", "11AM");
        service.addDoctor("Dr Sharma", "General", new ArrayList<>(slots));
    }

    // Test 1: Add Doctor
    @Test
    void testAddDoctor() {
        service.addDoctor("Dr Patel", "Cardiology",
                new ArrayList<>(Arrays.asList("12PM")));

        assertEquals(2, service.getDoctors().size());
    }

    // Test 2: Successful Appointment
    @Test
    void testAssignDoctorSuccess() {
        boolean result = service.assignDoctor("P101", 1, "10AM");

        assertTrue(result);
        assertEquals(1, service.getAppointments().size());
    }

    // Test 3: Slot Conflict (same slot booked twice)
    @Test
    void testSlotAlreadyBooked() {
        service.assignDoctor("P101", 1, "10AM");
        boolean result = service.assignDoctor("P102", 1, "10AM");

        assertFalse(result);
        assertEquals(1, service.getAppointments().size());
    }

    // Test 4: Invalid Doctor ID
    @Test
    void testInvalidDoctorId() {
        boolean result = service.assignDoctor("P101", 99, "10AM");

        assertFalse(result);
    }

    // Test 5: Slot Not Available
    @Test
    void testSlotNotAvailable() {
        boolean result = service.assignDoctor("P101", 1, "5PM");

        assertFalse(result);
    }

    // Test 6: Get Appointments by Patient
    @Test
    void testGetAppointmentsByPatient() {
        service.assignDoctor("P101", 1, "10AM");

        List<Appointment> list = service.getAppointmentsByPatient("P101");

        assertEquals(1, list.size());
        assertEquals("P101", list.get(0).patientId);
    }

    // Test 7: No Appointments for Patient
    @Test
    
    void testNoAppointmentsForPatient() {
        List<Appointment> list = service.getAppointmentsByPatient("P999");

        assertTrue(list.isEmpty());
    }
}
