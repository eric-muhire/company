package com.employeeApplication;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        //Meddelande för uppkopplingen till databas
        S.o("Uppkoppling till databas");
        //Object från MenuDisplay klass
        MenuDisplay menu=new MenuDisplay();
        menu.showMenu();


    }
}


