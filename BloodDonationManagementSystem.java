package project_acp;

import java.io.*;
import java.util.*;

public class BloodDonationManagementSystem {
    private static final String FILE_NAME = "donors.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new donor");
            System.out.println("2. View all donors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addDonor(scanner);
                    break;
                case 2:
                    viewDonors();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDonor(Scanner scanner) {
        try {
            System.out.print("Enter donor name: ");
            String name = scanner.nextLine();
            System.out.print("Enter donor age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter donor blood type: ");
            String bloodType = scanner.nextLine();

            BloodDonor donor = new BloodDonor(name, age, bloodType);
            writeDonorToFile(donor);
            System.out.println("Donor added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding donor: " + e.getMessage());
        }
    }

    private static void writeDonorToFile(BloodDonor donor) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(donor.toString());
            writer.newLine();
        }
    }

    private static void viewDonors() {
        try {
            List<BloodDonor> donors = readDonorsFromFile();
            if (donors.isEmpty()) {
                System.out.println("No donors found.");
            } else {
                for (BloodDonor donor : donors) {
                    System.out.println(donor.getName() + " - Age: " + donor.getAge() + ", Blood Type: " + donor.getBloodType());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading donors: " + e.getMessage());
        }
    }

    private static List<BloodDonor> readDonorsFromFile() throws IOException {
        List<BloodDonor> donors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                donors.add(BloodDonor.fromString(line));
            }
        }
        return donors;
    }
}
