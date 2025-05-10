/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techcompanyapp;

/**
 *
 * @author youness
 * 
 * Enum to represent all available menu options.
 * Each option is assigned a numeric code and a user-friendly description.
 */
public enum MenuOption {
    ADD_EMPLOYEE(1, "Add Employee"),
    GENERATE_RANDOM_EMPLOYEE(2, "Generate Random Employee"),
    SORT_EMPLOYEES(3, "Sort Employees"),
    SEARCH_EMPLOYEE(4, "Search Employee"),
    SHOW_ALL_EMPLOYEES(5, "Show All Employees"),
    UPDATE_EMPLOYEE(6, "Update Employee"),
    DELETE_EMPLOYEE(7, "Delete Employee"),
    LOAD_EMPLOYEES_FROM_FILE(8, "Load Employees from File"),
    EXIT_SYSTEM(9, "Exit System");

    private final int code;
    private final String description;

    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : MenuOption.values()) {
            if (option.code == code) {
                return option;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code + ". " + description;
    }

    
}
