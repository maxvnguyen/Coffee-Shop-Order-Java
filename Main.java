import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        Customer customer;

        while (true) {
    System.out.println("Select customer type:");
    System.out.println("1. Regular Customer");
    System.out.println("2. Premium Customer");

    String input = sc.nextLine();

    if (!input.matches("[12]")) {
        System.out.println("Invalid choice. Please enter 1 or 2.");
        continue;
    }

        int type = Integer.parseInt(input);

        if (type == 1) {
            customer = new PremiumCustomer(name, "email@test.com", "123456");
        } else {
            customer = new RegularCustomer(name, "email@test.com", "123456");
        }

        Order order = new Order(customer);

        while (true) {
            System.out.println("\n1. Add Espresso");
            System.out.println("2. Add Filtered Coffee");
            System.out.println("3. View Order");
            System.out.println("4. Prepare Order");
            System.out.println("5. Generate Receipt");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    order.addItem(new Espresso());
                    break;
                case 2:
                    order.addItem(new FilteredCoffee());
                    break;
                case 3:
                    order.displayOrder();
                    break;
                case 4:
                    order.prepareOrder();
                    break;
                case 5:
                    FileManager.generateReceipt(order);
                    FileManager.saveOrder(order);
                    System.out.println("Receipt generated!");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice, please enter 1-6");
                
            }
        }
    }
}
}