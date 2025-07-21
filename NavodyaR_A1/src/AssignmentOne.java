import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentOne {
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Sample doctors (in real app, load from DB or file)
    static ArrayList<HealthProfessional> doctors = new ArrayList<>();

    public static void populateDoctors() {
        doctors.add(new GeneralPractitioner(1, "Dr. Alice Green", "Family Medicine", "MBBS"));
        doctors.add(new GeneralPractitioner(2, "Dr. Bob Martin", "Internal Medicine", "MBBS"));
        doctors.add(new GeneralPractitioner(3, "Dr. Charlie Yang", "Pediatrics", "MBBS"));
        doctors.add(new Dietitian(4, "Dr. Emma Brown", "Nutrition", "Weight Management"));
        doctors.add(new Dietitian(5, "Dr. Ivy Zhang", "Nutrition", "Children’s Diet"));
    }

    public static void createAppointment() {
        System.out.println("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Mobile Number: ");
        String phone = scanner.nextLine();

        System.out.println("Enter Preferred Time (e.g. 10:30): ");
        String time = scanner.nextLine();

        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.print((i + 1) + ". ");
            doctors.get(i).printDetails();
            System.out.println("--------------------------------");
        }

        System.out.println("Choose doctor (enter number): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice >= 1 && choice <= doctors.size()) {
            HealthProfessional doctor = doctors.get(choice - 1);
            Appointment appt = new Appointment(name, phone, time, doctor);
            appointments.add(appt);
            System.out.println("Appointment created successfully.");
        } else {
            System.out.println("Invalid doctor selection.");
        }
    }

    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment a : appointments) {
                a.printAppointment();
            }
        }
    }

    public static void cancelBooking() {
        System.out.println("Enter mobile number to cancel appointment:");
        String phone = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobilePhone().equals(phone)) {
                appointments.remove(i);
                System.out.println("Appointment canceled successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No appointment found with that number.");
        }
    }

    public static void searchAppointment() {
        System.out.println("Enter mobile number to search:");
        String phone = scanner.nextLine();

        boolean found = false;
        for (Appointment appt : appointments) {
            if (appt.getMobilePhone().equals(phone)) {
                appt.printAppointment();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment found with that number.");
        }
    }

    public static void showMenu() {
        System.out.println("\n===== Health Service Appointment System =====");
        System.out.println("1. Create Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Cancel Appointment");
        System.out.println("4. Search Appointment by Phone");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        populateDoctors();
        boolean exit = false;

        while (!exit) {
            showMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    createAppointment();
                    break;
                case "2":
                    printExistingAppointments();
                    break;
                case "3":
                    cancelBooking();
                    break;
                case "4":
                    searchAppointment();
                    break;
                case "5":
                    exit = true;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
