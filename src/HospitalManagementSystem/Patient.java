package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    } 
    
    // Method to register a new patient

    public void addPatient() {

        // Logic to register a patient
        System.out.print("Enter Patient Name:");
        // Use connection and scanner as needed
        String name = scanner.next();

        System.out.print("Enter Patient Age:");
        int age = scanner.nextInt();
        
        System.out.print("Enter Patient Gender:");
        String gender = scanner.next();

        try {
            // Example SQL operation (pseudo-code)
            String query = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient registered successfully.");
            } else {
                System.out.println("Failed to register patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Method to view patient details

    public void viewPatients() {
        // Logic to view patient details
        String query = "SELECT * FROM patients";

        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            // You can add code here to execute the query and process the results
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Patients: "); 
            System.out.println("+-----------------+-------------------------+--------------+------------------+");
            System.out.println("| Patient ID      | Name                    | Age          | Gender           |");
            System.out.println("+-----------------+-------------------------+--------------+------------------+");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-15d6| %-23s | %-12d | %-16s |\n", id, name, age, gender);
                System.out.println("+-----------------+-------------------------+--------------+------------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    // Method to check patient details

    public boolean getPatientById(int patientId) {
        // Logic to check patient details
        // System.out.println("Enter Patient ID to check details:");

        String query = "SELECT * FROM patients WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, patientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true; // Patient found
            } else {
                
                return false; // Patient not found
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false; // Error occurred
        }
    }
}

   
