# EmployeeApplication
This is a school project for learning mysql,user will be able to add,update, 
retrieve and delete information in MySQL database through javaApplication.

### Technical information

**Built with** [Intellij](https://www.jetbrains.com/idea/),
[MySQL dabase](https://www.mysql.com/)

**Documentation** 
For documentation I have used google document.


#### Code samples

public class MenuDisplay {

    Employees employees = new Employees();
    Scanner ch = new Scanner(System.in);

    void showMenu() {
        char option='\0';

            System.out.println("\n\n-------------Main Menu for Employee-------------\n");
            System.out.println("A. Add employee details");
            System.out.println("B. Update employee details");
            System.out.println("C. Delete employee details");
            System.out.println("D. Display all employee details");
            System.out.println("E. Exit");

        do {
            System.out.print("\n Enter your choice : ");
           char option1=ch.next().charAt(0);
           option=Character.toUpperCase(option1);

            switch (option) {

                case 'A':
                    System.out.println("\n----------Adding employee details-------------\n");
                    try {
                        employees.addEmployee();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

##### ScreenShots/Image


[Image 1](https://drive.google.com/file/d/1cl5t6zkii_W1YgUrc1l771RO3jUmFGYD/view?usp=sharing)