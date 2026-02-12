import java.util.*;

class Doctor 
{
    int doctorId;
    String name;
    String specialization;
    List<String> availableSlots;

    Doctor(int id, String name, String specialization, List<String> slots) {
        this.doctorId = id;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new ArrayList<>(slots);
    }
}

class Appointment {
    int appointmentId;
    String patientId;
    int doctorId;
    String doctorName;
    String slot;

    Appointment(int id, String patientId, int doctorId, String doctorName, String slot) {
        this.appointmentId = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.slot = slot;
    }
}

public class doctorScheduling 
{

    static Scanner sc = new Scanner(System.in);
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();

    static int doctorCounter = 1;
    static int appointmentCounter = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Doctor Scheduling Module ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Assign Doctor to Patient");
            System.out.println("4. View All Appointments");
            System.out.println("5. Search Appointment by Patient ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewDoctors(); break;
                case 3: assignDoctor(); break;
                case 4: viewAppointments(); break;
                case 5: searchByPatient(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }

    // Add Doctor
    static void addDoctor() {
        System.out.print("Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Number of available slots: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> slots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter slot (e.g., 10AM-11AM): ");
            slots.add(sc.nextLine());
        }

        doctors.add(new Doctor(doctorCounter++, name, specialization, slots));
        System.out.println("Doctor added successfully!");
    }

    // View Doctors
    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println("\nDoctor ID: " + d.doctorId);
            System.out.println("Name: " + d.name);
            System.out.println("Specialization: " + d.specialization);
            System.out.println("Available Slots: " + d.availableSlots);
        }
    }

    // Assign Doctor to Patient
    static void assignDoctor() {
        System.out.print("Enter Patient ID (from Patient Module): ");
        String patientId = sc.nextLine();

        System.out.print("Enter Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();

        Doctor selectedDoctor = null;

        for (Doctor d : doctors) {
            if (d.doctorId == docId) {
                selectedDoctor = d;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.println("Available Slots: " + selectedDoctor.availableSlots);
        System.out.print("Choose slot: ");
        String slot = sc.nextLine();

        if (!selectedDoctor.availableSlots.contains(slot)) {
            System.out.println("Slot not available!");
            return;
        }

        // Book appointment
        selectedDoctor.availableSlots.remove(slot);

        appointments.add(new Appointment(
                appointmentCounter++,
                patientId,
                docId,
                selectedDoctor.name,
                slot
        ));

        System.out.println("Doctor assigned successfully!");
    }

    // View All Appointments
    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println("\nAppointment ID: " + a.appointmentId);
            System.out.println("Patient ID: " + a.patientId);
            System.out.println("Doctor: " + a.doctorName + " (ID: " + a.doctorId + ")");
            System.out.println("Slot: " + a.slot);
        }
    }

    // Search by Patient ID
    static void searchByPatient() {
        System.out.print("Enter Patient ID: ");
        String pid = sc.nextLine();

        boolean found = false;

        for (Appointment a : appointments) {
            if (a.patientId.equals(pid)) {
                System.out.println("\nDoctor: " + a.doctorName);
                System.out.println("Slot: " + a.slot);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment found for this patient.");
        }
    }
}
