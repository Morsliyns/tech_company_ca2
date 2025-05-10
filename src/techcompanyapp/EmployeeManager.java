/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techcompanyapp;
import java.util.*;
import java.io.*;

/**
 *
 * @author youness
 */
// Handles operations for managing employees (OOP encapsulation)
class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    // Adds a new employee to the list
    public void addEmployee(String name, ManagerType managerType, DepartmentType department) {
        employees.add(new Employee(name, managerType, department));
    }

    // Randomly generate and add a test employee to the list
    public void generateRandomEmployee() {
        String[] names = {"Alex Morgan", "Jamie Lee", "Sam Jordan", "Taylor Brooks", "Chris Avery"};
        Random rand = new Random();
        String name = names[rand.nextInt(names.length)];
        ManagerType managerType = ManagerType.values()[rand.nextInt(ManagerType.values().length)];
        DepartmentType department = DepartmentType.values()[rand.nextInt(DepartmentType.values().length)];
        addEmployee(name, managerType, department);
        System.out.println("Random employee added: " + name + " | " + managerType + " | " + department);
    }

    // Sort employees using Merge Sort and display first 20
    public void sortEmployees() {
        // Merge Sort was chosen due to its stable O(n log n) performance,
        // making it superior to Bubble or Insertion Sort for medium/large lists
        mergeSort(employees, 0, employees.size() - 1);
        employees.stream().limit(20).forEach(System.out::println);
    }

    // Search for employee using Binary Search
    public void searchEmployee(String name) {
        // Binary Search was chosen because the list is already sorted,
        // and it provides optimal performance (O(log n)) for read-heavy scenarios
        mergeSort(employees, 0, employees.size() - 1);
        int index = binarySearch(employees, name, 0, employees.size() - 1);
        if (index >= 0) {
            System.out.println("Employee Found: " + employees.get(index));
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Load employees from a CSV file with structure First name, Last name, ..., Department, Job Title
    public void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }
    // update employee
    public boolean updateEmployee(String name, ManagerType newManager, DepartmentType newDepartment) {
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                employees.set(employees.indexOf(e), new Employee(name, newManager, newDepartment));
                System.out.println("Updated employee: " + name);
                return true;
            }
        }
        System.out.println("Employee not found.");
        return false;
    }
    // delete employee
    public boolean deleteEmployee(String name) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee e = iterator.next();
            if (e.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Deleted employee: " + name);
                return true;
            }
        }
        System.out.println("Employee not found.");
        return false;
    }
    // load employees from file .txt
    public void loadEmployeesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String fullName = parts[0].trim() + " " + parts[1].trim();
                    String deptRaw = parts[5].toUpperCase().replace(" ", "_");
                    String managerRaw = parts[7].toUpperCase().replace(" ", "_");
                    try {
                        DepartmentType dept = DepartmentType.valueOf(deptRaw);
                        ManagerType manager = ManagerType.valueOf(managerRaw);
                        addEmployee(fullName, manager, dept);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Skipping invalid record: " + fullName);
                    }
                }
            }
            System.out.println("Employees loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + filename);
        }
    }

    // Recursive Merge Sort implementation for employee list
    private void mergeSort(List<Employee> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    // Merge step of merge sort
    private void merge(List<Employee> list, int left, int mid, int right) {
        List<Employee> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<Employee> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));
        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) list.set(k++, leftList.get(i++));
        while (j < rightList.size()) list.set(k++, rightList.get(j++));
    }

    // Binary Search to find employee by name (case-insensitive)
    private int binarySearch(List<Employee> list, String name, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int comp = list.get(mid).getName().compareToIgnoreCase(name);
        if (comp == 0) return mid;
        else if (comp > 0) return binarySearch(list, name, left, mid - 1);
        else return binarySearch(list, name, mid + 1, right);
    }
}
