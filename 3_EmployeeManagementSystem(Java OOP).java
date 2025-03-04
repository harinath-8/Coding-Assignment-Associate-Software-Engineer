import java.util.ArrayList;
import java.util.List;

/**
 * Employee class representing an employee in the system
 */
class Employee {
    private int id;
    private String name;
    private double salary;
    
    /**
     * Constructor to initialize employee details
     */
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    /**
     * Getters and setters for employee attributes
     */
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    /**
     * Method to display employee details
     */
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + String.format("%.2f", salary));
        System.out.println("------------------------");
    }
}

/**
 * Main class to run the Employee Management System
 */
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating a list to store employee objects
        List<Employee> employees = new ArrayList<>();
        
        // Creating employee objects
        Employee emp1 = new Employee(101, "John Smith", 75000.50);
        Employee emp2 = new Employee(102, "Emily Johnson", 82500.75);
        Employee emp3 = new Employee(103, "Michael Chen", 67800.25);
        Employee emp4 = new Employee(104, "Sarah Williams", 91200.00);
        
        // Adding employees to the list
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        
        // Displaying the employee details
        System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.println("Employee Count: " + employees.size());
        System.out.println("==========================");
        
        for (Employee emp : employees) {
            emp.displayDetails();
        }
        
        // Calculating and displaying average salary
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        
        double averageSalary = totalSalary / employees.size();
        System.out.println("Average Salary: $" + String.format("%.2f", averageSalary));
    }
}