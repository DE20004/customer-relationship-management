import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\n";
    }
}

class CRM {
    private ArrayList<Customer> customers;

    public CRM() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

public class CRMApp {
    public static void main(String[] args) {
        CRM crm = new CRM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCRM Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Find Customer by Name");
            System.out.println("3. Display All Customers");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String phone = scanner.nextLine();
                    Customer newCustomer = new Customer(name, email, phone);
                    crm.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    System.out.print("Enter customer name to search: ");
                    String searchName = scanner.nextLine();
                    Customer foundCustomer = crm.findCustomerByName(searchName);
                    if (foundCustomer != null) {
                        System.out.println("Customer found:\n" + foundCustomer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    crm.displayAllCustomers();
                    break;
                case 4:
                    System.out.println("Exiting CRM.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

