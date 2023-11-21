package com.example.sdp_project2;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<ShoppingCartMemento> orders = new ArrayList<>();
    private SaveOrderToTxtFile saveOrderCommand;

    public OrderHistory(String filename) {
        this.saveOrderCommand = new SaveOrderToTxtFile(filename);
    }

    public void saveOrder(ShoppingCart cart) {
        ShoppingCartMemento memento = new ShoppingCartMemento(cart.getProducts());
        orders.add(memento);

        // Save the order to a text file using the command
        saveOrderCommand.execute(memento.getProducts());
    }

    public ShoppingCartMemento getLastOrder() {
        if (orders.isEmpty()) {
            return null;
        }
        return orders.get(orders.size() - 1);
    }
}
