package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import model.Fruit;
import view.FruitShopView;

public class FruitShopController {

    private List<Fruit> fruits;
    private Hashtable<String, List<Fruit>> orders;
    private FruitShopView view;

    public FruitShopController() {
        fruits = new ArrayList<>();
        orders = new Hashtable<>();
        view = new FruitShopView();
    }

    public void start() {
        int choice;
        do {
            choice = view.showMainMenu();
            switch (choice) {
                case 1:
                    Fruit fruit = view.createFruit();
                    fruits.add(fruit);
                    System.out.print("Do you want to continue (Y/N)? ");
                    String continueChoice = view.next();
                    if (continueChoice.equalsIgnoreCase("N")) {
                        displayFruits();
                    }
                    break;
                case 2:
                    view.displayOrders(orders);
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    private void displayFruits() {
        view.displayFruits(fruits);
    }

    private void shopping() {
        displayFruits();
        int selectedItem = view.selectFruit();
        Fruit selectedFruit = fruits.get(selectedItem - 1);
        int quantity = view.enterQuantity();
        boolean orderConfirmed = view.confirmOrder();
        if (orderConfirmed) {
            String customerName = view.enterCustomerName();
            List<Fruit> orderedFruits = orders.getOrDefault(customerName, new ArrayList<>());

            if (selectedFruit.getQuantity() < quantity) {
                System.out.println("Not enough. Please choose again");
                return;
            }

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

            Fruit orderedFruit = new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(),
                    selectedFruit.getPrice(), quantity, selectedFruit.getOrigin());
            orderedFruits.add(orderedFruit);
            orders.put(customerName, orderedFruits);
            System.out.println("Order placed successfully!");
        } else {
            shopping();
        }
    }
}
