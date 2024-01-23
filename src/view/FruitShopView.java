package view;

import controller.Validation;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import model.Fruit;

public class FruitShopView {
    
    Validation vl = new Validation();
    private Scanner scanner;

    public FruitShopView() {
        scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
        return scanner.nextInt();
    }

    public Fruit createFruit() {
        System.out.print("Enter Fruit ID: ");
        String fruitId = scanner.next();
        System.out.print("Enter Fruit Name: ");
        String fruitName = scanner.next();
        System.out.print("Enter Price: ");
        double price = vl.validateDoubleInput();
        System.out.print("Enter Quantity: ");
        int quantity = vl.validateIntegerInput();
        System.out.print("Enter Origin: ");
        String origin = scanner.next();
        return new Fruit(fruitId, fruitName, price, quantity, origin);
    }

    public void displayFruits(List<Fruit> fruits) {
        System.out.println("List of Fruits:");
        System.out.println("+----------+----------------+-------------+-----------+----------+");
        System.out.println("| Item     | Fruit Name     | Origin      | Price     | Quantity |");
        System.out.println("+----------+----------------+-------------+-----------+----------+");

        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            System.out.printf("| %8d | %14s | %11s | %9.2f$ | %8d |\n", (i + 1), fruit.getFruitName(), fruit.getOrigin(),
                    fruit.getPrice(), fruit.getQuantity());
        }

        System.out.println("+----------+----------------+-------------+-----------+----------+");
    }

    public int selectFruit() {
        System.out.print("Select Fruit Item: ");
        return (int) vl.validateDoubleInput();
    }

    public int enterQuantity() {
        System.out.print("Please input quantity: ");
        return vl.validateIntegerInput();
    }

    public boolean confirmOrder() {
        System.out.print("Do you want to order now (Y/N)? ");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("Y");
    }

    public String enterCustomerName() {
        System.out.print("Input your name: ");
        return scanner.next();
    }

    public void displayOrderSummary(List<Fruit> fruits, double total) {
        System.out.println("Product | Quantity | Price | Amount");
        for (Fruit fruit : fruits) {
            System.out.printf("%8s %10d %8.2f$ %8.2f$\n", fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(),
                    fruit.getQuantity() * fruit.getPrice());
        }
        System.out.println("Total: " + total + "$");
    }

    public void displayOrders(Hashtable<String, List<Fruit>> orders) {
        System.out.println("View Orders");
        System.out.println("+----------+----------------+-------------+-----------+----------+------------+");
        System.out.println("| Customer | Fruit Name     | Origin      | Price     | Quantity | Total ($)  |");
        System.out.println("+----------+----------------+-------------+-----------+----------+------------+");

        for (String customer : orders.keySet()) {
            List<Fruit> fruits = orders.get(customer);
            double total = 0.0;
            for (Fruit fruit : fruits) {
                double totalPrice = fruit.getPrice() * fruit.getQuantity();
                total += totalPrice;
                System.out.printf("| %8s | %14s | %11s | %8.2f$ | %8d | %9.2f$ |\n", customer, fruit.getFruitName(), fruit.getOrigin(),
                        fruit.getPrice(), fruit.getQuantity(), totalPrice);
            }
            System.out.println("+----------+----------------+-------------+-----------+----------+------------+");
        }
    }
    public String next() {
        return scanner.next();
    }
}
