package com.employeeApplication;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employees {

    static Connection cn = null;
    static PreparedStatement pstat = null;
    static ResultSet resultSet = null;

    static final String DBAddress = "jdbc:mySql://localhost:3306/company";
    static final String user = "root";
    static final String pass = "12345";

    //Variabler
    private int employees_id;
    private String employees_name;
    private Date employment_date;
    private String employees_education;
    private double employees_salary;
    private String employees_gender;
    private Date employees_dateOfBirth;

    //Metod för att lägga till anställda.
    public void addEmployee() throws SQLException {
        int numbertries=2;
        while (numbertries != 0) {
        try {
            Scanner input = new Scanner(System.in);
            S.o("Enter employees name:");
            employees_name = input.nextLine();

                try {
                    S.o("Enter employees start date:");
                    employment_date = Date.valueOf(input.nextLine());

                } catch (IllegalArgumentException e) {
                    S.o("Wrong date format\nTry again!");
                    continue;
                }

                S.o("Enter employees education:");
                employees_education = input.nextLine();
                S.o("Enter employees salary:");
                employees_salary = Double.valueOf(input.nextLine());
                S.o("Enter employees gender:");
                employees_gender = input.nextLine();
                try{
                    S.o("Enter employees birth date:");
                    employees_dateOfBirth = Date.valueOf(input.nextLine());

                }catch(java.lang.IllegalArgumentException e){
                    S.o("Wrong date format\nTry again!");
                    continue;
                }


                //Startar uppkoppling till Databas
                cn = DriverManager.getConnection(DBAddress, user, pass);

                //Bygga upp SQL Commandot för tabellen employee
                //pstat = cn.prepareStatement("INSERT INTO employees(employees_name,employment_date,employees_education,employees_salary,employees_gender,employees_dateOfBirth) VALUES(?,?,?,?,?,?)");
                pstat = cn.prepareStatement("CALL addNewEmployee(?,?,?,?,?,?)");
                //Införa data till sql kommandot
                pstat.setString(1, employees_name);
                pstat.setDate(2, employment_date);
                pstat.setString(3, employees_education);
                pstat.setDouble(4, employees_salary);
                pstat.setString(5, employees_gender);
                pstat.setDate(6, employees_dateOfBirth);

                //Skicka Sql anropet till databasen
                pstat.executeUpdate();

                //Stänga anslutningen
                cn.close();
                System.out.println("\n----------A new employee has been added to the database-------------\n");

            } catch(
                    SQLException e)

            {
                System.out.println(e);
            }
        }
    }


        //Metoden för att uppdatera information för en anställd
        public void updateEmployee () {
            try {

                Scanner input = new Scanner(System.in);
                S.o("Enter employee Id to update information : ");
                employees_id = Integer.parseInt(input.nextLine());

                S.o("Enter employee`s education to be updated:");
                employees_education = input.nextLine();
                S.o("Enter employee`s salary to be updated:");
                employees_salary = Double.parseDouble(input.nextLine());

                cn = DriverManager.getConnection(DBAddress, user, pass);
                //Bygga upp SQL Commandot för att uppdatera employee
                // pstat= cn.prepareStatement("UPDATE employees SET employees_education=?,employees_salary=? WHERE employees_id=?");
                pstat = cn.prepareStatement("CALL updateEmployeeInformation(?,?,?)");

                pstat.setInt(1, employees_id);
                pstat.setString(2, employees_education);
                pstat.setDouble(3, employees_salary);

           pstat.executeUpdate();
           S.o("\n----------Information updated successfully-------------\n");
           cn.close();
        }
        catch(InputMismatchException | SQLException e) {
            S.o("SQLException: " + e.getMessage());
            S.o("The values entered do not match");
        }
    }
    //Metoden för att ta bort en anställd.
    public void deleteEmployee(){

            try {
                Scanner input = new Scanner(System.in);
                S.o("Enter employee Id to be deleted : ");
                employees_id = input.nextInt();
                cn = DriverManager.getConnection(DBAddress, user, pass);
                //pstat= cn.prepareStatement("DELETE FROM employees WHERE employees_id = ?");

                //Ta bort en anställd genom att kalla till stored procedure from MySqL
                pstat = cn.prepareStatement(" CALL deleteEmployee(?)");
                pstat.setInt(1, employees_id);
                pstat.executeUpdate();
                S.o("\n-------------Information has been deleted-------------\n");
                cn.close();
            } catch (SQLException e) {
                S.o(e);
            }
        }
        //Metoden för att hämta information om anställda.
        public void retrieveEmployeesInformation () {
            try {
                cn = DriverManager.getConnection(DBAddress, user, pass);

                //bygga upp SQL kommandot
                //pstat = cn.prepareStatement("SELECT * FROM employees");
                pstat = cn.prepareStatement("CALL getAllEmployees()");

                //Skicka Sql anropet till databaser
                resultSet = pstat.executeQuery();

                // Hämtar data från resultset
                S.o("\n-------------SQL DATA-------------\n");
                while (resultSet.next()) {

                    //Hämta informationen genom column
                    S.o("Id: " + resultSet.getInt("employees_id"));
                    S.o("\t" + "Name: " + resultSet.getString("employees_name"));
                    S.o("\t" + "Employment date: " + resultSet.getDate("employment_date"));
                    S.o("\t" + "Education: " + resultSet.getString("employees_education"));
                    S.o("\t" + "Salary: " + resultSet.getInt("employees_salary") + " kr");
                    S.o("\t" + "Gender: " + resultSet.getString("employees_gender"));
                    S.o("\t" + "Date of birth: " + resultSet.getDate("employees_dateOfBirth"));
                    S.o("\t" + "Department: " + resultSet.getString("departments_name"));
                    S.o("\t" + "Assignment: " + resultSet.getString("assignments_name"));
                    S.o("\t" + "Position: " + resultSet.getString("positions_name"));

                }
                //Stänga databasanslutningen.
                cn.close();
                S.o("\n-------------Information has been retrieved-------------\n");
                S.o("------------------END-----------------------------------");

            } catch (SQLException e) {
                // Hanterar fel meddelanden
                S.o("SQLException: " + e.getMessage());
                S.o("SQLState: " + e.getSQLState());
            }
        }
    }
