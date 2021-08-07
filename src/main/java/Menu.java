import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeModel employeeModel = new EmployeeModel();
    public void generateMainMenu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("--------------------");
            System.out.println("1. Register.");
            System.out.println("2. Login.");
            System.out.println("3. Exit.");
            System.out.println("--------------------");
            System.out.println("Please enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerMenu();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    System.out.println("Bye bye");
                    break;
                default:
                    break;
            }
            if (choice == 3) {
                break;
            }
            scanner.nextLine();
        }
    }

    private void loginMenu() {
        System.out.println("Account name: ");
        String account = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        Employee employee = employeeModel.login(account, password);
        if (employee == null) {
            System.err.println("Wrong passwordd/account name!!!");
        } else {
            System.out.println("Login successfully! Your account information: ");
            employee.printInfo();
        }
    }

    private void registerMenu() {
        System.out.println("Please enter your account name:");
        String account = scanner.nextLine();
        while (employeeModel.checkExistAccount(account)) {
            System.err.println("Account name has been taken! Please enter another one: ");
            account = scanner.nextLine();
        }
        Employee employee = new Employee();
        employee.setAccount(account);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        employee.setName(name);
        System.out.println("Please enter your address: ");
        String address = scanner.nextLine();
        employee.setAddress(address);
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        employee.setEmail(email);
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        employee.setPassword(password);
        System.out.println("Your account has been created!");
        employee.printInfo();
        employeeModel.register(employee);
    }
}
