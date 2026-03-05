package tutorial;

import java.util.*;

public class DoctorService {

    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private int doctorCounter = 1;
    private int appointmentCounter = 1;

    // Add doctor
    public Doctor addDoctor(String name, String specialization, List<String> slots) {
        Doctor doctor = new Doctor(doctorCounter++, name, specialization, slots);
        doctors.add(doctor);
        return doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    // Assign doctor
    public boolean assignDoctor(String patientId, int doctorId, String slot) {

        for (Doctor d : doctors) {
            if (d.doctorId == doctorId) {

                if (!d.availableSlots.contains(slot)) {
                    return false; // slot not available
                }

                d.availableSlots.remove(slot);

                appointments.add(new Appointment(
                        appointmentCounter++,
                        patientId,
                        doctorId,
                        d.name,
                        slot
                ));

                return true;
            }
        }
        return false; // doctor not found
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Appointment> getAppointmentsByPatient(String patientId) {
        List<Appointment> result = new ArrayList<>();

        for (Appointment a : appointments) {
            if (a.patientId.equals(patientId)) {
                result.add(a);
            }
        }
        return result;
    }
}
