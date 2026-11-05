import java.util.*;

class Order {
    private static int counter = 1;
    private int orderId;
    private Customer customer;
    private List<Coffee> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.orderId = counter++;
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Coffee> getItems() { return items; }

    public void addItem(Coffee coffee) {
        items.add(coffee);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Coffee c : items) {
            total += c.getPrice();
        }
        return customer.payCoffee(total);
    }

    public void prepareOrder() {
        if(items.isEmpty()) {
            System.out.println("Nothing to prepare");
        }
        for (Coffee c : items) {
            c.prepare();
        }
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        for (Coffee c : items) {
            System.out.println("- " + c.getName() + " $" + c.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}