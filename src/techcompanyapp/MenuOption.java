/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techcompanyapp;

/**
 *
 * @author youness
 */
public enum MenuOption {
    ADD_EMPLOYEE(1, "Add Employee"),
    GENERATE_RANDOM_EMPLOYEE(2, "Generate Random Employee"),
    SORT_EMPLOYEES(3, "Sort Employees"),
    SEARCH_EMPLOYEE(4, "Search Employee"),
    LOAD_EMPLOYEES_FROM_FILE(5, "Load Employees from File"),
    EXIT_SYSTEM(6, "Exit System");

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
