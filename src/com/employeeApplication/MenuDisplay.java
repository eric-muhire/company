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

            S.o("\nWelcome to, " +muhireAb.getCompanyName()+"!\n" +muhireAb.getCity()
                    +"\n"+muhireAb.getAddress()+"\n"+muhireAb.getTelephoneNumber());
            S.o("\n\n-------------Main Menu for MuhireAB-------------\n");
            S.o("A. Add employee details");
            S.o("B. Update employee details");
            S.o("C. Delete employee details");
            S.o("D. Display all employee details");
            S.o("E. Exit");

        do {
            // Ber användaren att välja alternativ
            S.o("\n Enter your choice : ");
           char option1=ch.next().charAt(0);
           option=Character.toUpperCase(option1);

            // Skapar switch-satsen
            switch (option) {

                //Case 'A' låter användaren lägga till ny anställd
                case 'A':
                    S.o("\n----------Adding employee details-------------\n");
                    try {
                        employees.addEmployee();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                    //Case 'B' låter användare uppdatera en del information för anställda.
                case 'B':
                   S.o("\n----------Updating employee details-------------\n");
                    employees.updateEmployee();
                    break;

                    //Case 'C' låter användaren ta bort en anställd
                case 'C':
                    S.o("\n----------Deleting employee details-------------\n");
                    employees.deleteEmployee();
                    break;

                //Case 'D' låter användaren hämta alla anställda från databas
                case 'D':
                    S.o("\n----------Retrieve employees details-------------\n");
                    employees.retrieveEmployeesInformation();
                break;

                //Case 'E' låter användare lämna stänga programmet
                case 'E':
                    S.o("\n" +"Thank you!");
                break;

                //Default visar när användare skriver in fel val (case)
                default:
                    S.o("Error : Choice " + option + " Does not exist.");
                    S.o("Please enter A,B,C,D or E");
            }
        }while (option !='E');
        S.o("\nDatabase connection terminated...");
    }
}

