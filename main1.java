import java.util.*;
   class Patient {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;

    public Patient(String name, int age, String gender, String email) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

 class Doctor {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String specialization;
    private String email;

    public Doctor(String name, String specialization, String email) {
        this.id = idCounter++;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' + 
                '}';
    }
}

 class Appointment {
    private static int idCounter = 1;
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.id = idCounter++;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
        "id=" + id +
        ", patient=" + patient +
        ", doctor=" + doctor +
        ", date='" + date + '\'' +
        ", time='" + time + '\'' +
        '}';
    }
}

public class main1 {
   
                private static List<Patient> Patients = new ArrayList<>();
                private static List<Doctor> Doctors = new ArrayList<>();
                private static List<Appointment> Appointments = new ArrayList<>();
            
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        System.out.println("1. Register Patient");
                        System.out.println("2. Register Doctor");
                        System.out.println("3. Book Appointment");
                        System.out.println("4. View Appointments");
                        System.out.println("5. Exit");
                        System.out.print("Choose an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
            
                        switch (choice) {
                            case 1:
                                registerPatient(scanner);
                                break;
                            case 2:
                                registerDoctor(scanner);
                                break;
                            case 3:
                                bookAppointment(scanner);
                                break;
                            case 4:
                                viewAppointments();
                                break;
                            case 5:
                                System.exit(0);
                                break;
                            default:
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }
                }
            
                private static void registerPatient(Scanner scanner) {
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Patient Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Patient Email: ");
                    String email = scanner.nextLine();
                    
                    Patient patient = new Patient(name, age, gender, email);
                    Patients.add(patient);
                    System.out.println("Patient registered successfully!");
                }
            
                private static void registerDoctor(Scanner scanner) {
                    System.out.print("Enter Doctor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Doctor Specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Enter Doctor Email: ");
                    String email = scanner.nextLine();
                    
                    Doctor doctor = new Doctor(name, specialization, email);
                    Doctors.add(doctor);
                    System.out.println("Doctor registered successfully!");
                }
            
                private static void bookAppointment(Scanner scanner) {
                    System.out.print("Enter Patient Email: ");
                    String patientEmail = scanner.nextLine();
                    System.out.print("Enter Doctor Email: ");
                    String doctorEmail = scanner.nextLine();
                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Appointment Time (HH:MM): ");
                    String time = scanner.nextLine();
            
                    Patient patient = findPatientByEmail(patientEmail);
                    Doctor doctor = findDoctorByEmail(doctorEmail);
                    
                    if (patient != null && doctor != null) {
                        Appointment appointment = new Appointment(patient, doctor, date, time);
                        Appointments.add(appointment);
                        System.out.println("Appointment booked successfully!");
                    } else {
                        System.out.println("Invalid patient or doctor email.");
                    }
                }
            
                private static void viewAppointments() {
                    for (Appointment appointment : Appointments) {
                        System.out.println(appointment);
                    }
                }
            
                private static Patient findPatientByEmail(String email) {
                    String lowercaseEmail = email.toLowerCase();
                    for (Patient patient : Patients) {
                        if (patient.getEmail().toLowerCase().equals(lowercaseEmail) {
                            return patient;
                        }
                    }
                    return null;
                }
            
                private static Doctor findDoctorByEmail(String email) {
                    String lowercaseEmail = email.toLowerCase();
                    for (Doctor doctor : Doctors) {
                        if (doctor.getEmail().toLowerCase().equals(lowercaseEmail)) {
                            return doctor;
                        }
                    }
                    return null;
                  
                }
        }
                                    

