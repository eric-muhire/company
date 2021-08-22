package com.employeeApplication;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuDisplay {
    Company muhireAb = new Company("MuhireAB","Göteborg","Odinsgatan5","0737108823");
    Employees employees = new Employees();
    //Skapar ett scanner objekt
    Scanner ch = new Scanner(System.in);

    //metod för menu
    void showMenu() throws SQLException {
        char option='\0';

            System.out.println("\nWelcome to, " +muhireAb.getCompanyName()+"!\n" +muhireAb.getCity()
                    +"\n"+muhireAb.getAddress()+"\n"+muhireAb.getTelephoneNumber());
            System.out.println("\n\n-------------Main Menu for Employee-------------\n");
            System.out.println("A. Add employee details");
            System.out.println("B. Update employee details");
            System.out.println("C. Delete employee details");
            System.out.println("D. Display all employee details");
            System.out.println("E. Exit");

        do {
            // Ber användaren att välja alternativ
            System.out.print("\n Enter your choice : ");
           char option1=ch.next().charAt(0);
           option=Character.toUpperCase(option1);

            // Skapar switch-satsen
            switch (option) {

                //Case 'A' låter användaren lägga till ny anställd
                case 'A':
                    System.out.println("\n----------Adding employee details-------------\n");
                    try {
                        employees.addEmployee();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                    //Case 'B' låter användare uppdatera en del information för anställda.
                case 'B':
                    System.out.println("\n----------Updating employee details-------------\n");
                    employees.updateEmployee();
                    break;

                    //Case 'C' låter användaren ta bort en anställd
                case 'C':
                    System.out.println("\n----------Deleting employee details-------------\n");
                    employees.deleteEmployee();
                    break;

                //Case 'D' låter användaren hämta alla anställda från databas
                case 'D':
                    System.out.println("\n----------Retrieve employees details-------------\n");
                    employees.retrieveEmployeesInformation();
                break;

                //Case 'E' låter användare lämna stänga programmet
                case 'E':
                    System.out.println("\n" +"Thank you!");
                break;

                //Default visar när användare skriver in fel val (case)
                default:
                    System.out.println("Error : Choice " + option + " Does not exist.");
                    System.out.println("Please enter A,B,C,D or E");
            }
        }while (option !='E');
        System.out.println("\nDatabase connection terminated...");
    }
}

