import java.io.*;

class FileManager {

    public static void saveOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("OrderID:" + order.getOrderId() + ",Customer:" + order.getCustomer().getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateReceipt(Order order) {
        String fileName = "receipt_" + order.getOrderId() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("==== Coffee Shop Receipt ====\n");
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            writer.write("Order ID: " + order.getOrderId() + "\n");

            for (Coffee c : order.getItems()) {
                writer.write(c.getName() + " - $" + c.getPrice() + "\n");
            }

            writer.write("Total: $" + order.calculateTotal() + "\n");
            writer.write("Thank you for your order!\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}