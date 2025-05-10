/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techcompanyapp;

/**
 *
 * @author youness
 */
// Employee model class implementing Comparable for sorting by name

class Employee implements Comparable<Employee> {
    private String name;
    private ManagerType managerType;
    private DepartmentType department;

    public Employee(String name, ManagerType managerType, DepartmentType department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    // Compare employees alphabetically by name
    @Override
    public int compareTo(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + " | " + managerType + " | " + department;
    }
}

