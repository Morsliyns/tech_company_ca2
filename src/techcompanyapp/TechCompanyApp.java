/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package techcompanyapp;
import java.util.*;
import java.io.*;
/**
 *
 * @author youness
 */

public class TechCompanyApp {

    /**
     * @param args the command line arguments
     */
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        while (true) {
            // Show menu options dynamically from ENUM MenuOption
            System.out.println("\nSelect an option:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println((option.ordinal() + 1) + ". " + option.name().replace("_", " "));
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (MenuOption.values()[choice - 1]) {
                case ADD_EMPLOYEE -> {
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    ManagerType managerType = selectEnum(ManagerType.values(), "Manager Type");
                    DepartmentType department = selectEnum(DepartmentType.values(), "Department");
                    manager.addEmployee(name, managerType, department);
                    System.out.println("\"" + name + "\" has been added as \"" + managerType + "\" to \"" + department + "\" successfully!");
                }
                case GENERATE_RANDOM_EMPLOYEE -> manager.generateRandomEmployee();
                case SORT_EMPLOYEES -> manager.sortEmployees();
                case SEARCH_EMPLOYEE -> {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    manager.searchEmployee(name);
                }
                case SHOW_ALL_EMPLOYEES -> manager.showAllEmployees();
                case UPDATE_EMPLOYEE -> {
                    System.out.print("Enter name to update: ");
                    String name = scanner.nextLine();
                    ManagerType newManager = selectEnum(ManagerType.values(), "New Manager Type");
                    DepartmentType newDept = selectEnum(DepartmentType.values(), "New Department");
                    manager.updateEmployee(name, newManager, newDept);
                }
                case DELETE_EMPLOYEE -> {
                    System.out.print("Enter name to delete: ");
                    String name = scanner.nextLine();
                    manager.deleteEmployee(name);
                }
                case LOAD_EMPLOYEES_FROM_FILE -> {
                    System.out.print("Enter file path: ");
                    String file = scanner.nextLine();
                    manager.loadEmployeesFromFile(file);
                }
                case EXIT_SYSTEM -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }
    }

    // Generic menu selection handler for ENUMs
    private static <T extends Enum<T>> T selectEnum(T[] values, String label) {
        System.out.println("Choose " + label + ":");
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= values.length) break;
            System.out.print("Invalid input. Try again: ");
        }
        scanner.nextLine(); // clear newline
        return values[choice - 1];
    }
}