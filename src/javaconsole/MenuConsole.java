package javaconsole;

import java.util.Scanner;

public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();
    }

    public void createMenu() {
        loopMenu:
        for (;;) {
            System.out.println("----------Student---------");
            System.out.println("1. List Student.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Exit.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            Scanner scan = new Scanner(System.in);

            String strChoice = scan.nextLine();

            int choice;
            try {

                choice = Integer.parseInt(strChoice);
            } catch (java.lang.NumberFormatException e) {

                System.err.println("Please enter a number.");
                continue;
            }
            StudentController studentController = new StudentController();
            switch (choice) {
                case 1:
                    studentController.getList();
                    break;
                case 2:
                    studentController.addStudent();
                    break;
                case 3:
                    studentController.editStudent();
                    break;
                case 4:
                    studentController.deleteStudent();
                    break;
                case 5:
                    break loopMenu;
                default:
                    System.err.println("Please enter number from 1-5.");
                    break;
            }

        }
    }
}
