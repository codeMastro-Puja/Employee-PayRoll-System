import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private final String name;
    private final int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ",id=" + id + ", salary=" + calculateSalary() + "j";
    }

    public String getEmployeeId() {
        return "employeeId";
    }
}


class FulltimeEmployee extends Employee{       //inheritence
    private final double monthlySalary;

    public FulltimeEmployee(String name, int id, double monthlySalary, double bonus){
            super(name,id);
            this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
           return monthlySalary;
    }
}


class PartTimeEmployee extends Employee{
    private final int hoursWorked;
    private final double hourlyRate;

    public PartTimeEmployee(String name ,int id, int hoursWorked,double hourlyRate){
        super (name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

        @Override
        public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private final ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public  void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

//    public class Main {
//    public static void main(String[] args) {
//        PayrollSystem payrollSystem = new PayrollSystem();
//        FulltimeEmployee emp1 = new FulltimeEmployee("Puja" ,1,70000 );
//        PartTimeEmployee emp2 = new PartTimeEmployee("Alexa",2,40,100);
//
//        payrollSystem.addEmployee(emp1);
//        payrollSystem.addEmployee(emp2);
//        System.out.println("Initial Employee Details:");
//        payrollSystem.displayEmployee();
//        System.out.println("Removing Employees");
//        payrollSystem.removeEmployee(2);
//        System.out.println("Remaining Employee Details:");
//        payrollSystem.displayEmployee();
//        }
//    }





public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = sc.nextLine();
                    System.out.print("Enter employee ID: ");
                    int ftId = sc.nextInt();
                    System.out.print("Enter base salary: ");
                    double baseSalary = sc.nextDouble();
                    System.out.print("Enter bonus: ");
                    double bonus = sc.nextDouble();
                    sc.nextLine(); // clear newline

                    Employee ftEmployee = new FulltimeEmployee(ftName, ftId, baseSalary, bonus);
                    employeeList.add(ftEmployee);
                    System.out.println("Full-Time Employee added.\n");
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String ptName = sc.nextLine();
                    System.out.print("Enter employee ID: ");
                    int ptId = sc.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double rate = sc.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int hours = sc.nextInt();
                    sc.nextLine(); // clear newline

                    Employee ptEmployee = new PartTimeEmployee(ptName, hours, ptId, rate);
                    employeeList.add(ptEmployee);
                    System.out.println("Part-Time Employee added.\n");
                    break;

                case 3:
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("\n--- Employee Details ---");
                        for (Employee e : employeeList) {
                            System.out.println("ID: " + e.getEmployeeId());
                            System.out.println("Name: " + e.getName());
                            System.out.println("Salary: ₹" + e.calculateSalary());
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
