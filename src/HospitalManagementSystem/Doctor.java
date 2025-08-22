package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {

    private Connection connection;
    public Doctor(Connection connection, Scanner scanner) {
        this.connection = connection;
        
    } 
    
    // Method to view Doctor details
    public void viewDoctors() {
        // Logic to view doctor details
        String query = "SELECT * FROM doctors";

        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(query);
            // You can add code here to execute the query and process the results
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Doctors: "); 
            System.out.println("+-----------------+-------------------------+---------------------------------+");
            System.out.println("| Doctor ID       | Name                    | Specialization                  |");
            System.out.println("+-----------------+-------------------------+---------------------------------+");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-15d | %-23s | %-31s |\n", id, name, specialization);
                System.out.println("+-----------------+-------------------------+--------------+------------------+");
            
            }

        } catch (SQLException e) {
            e.printStackTrace();    
        }
    }

    // Method to check Doctor details

    public boolean getDoctorById(int Id) {
        

        String query = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true; // Doctor found
            } else {
                
                return false; // Doctor not found
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false; // Error occurred
        }
    }

}
