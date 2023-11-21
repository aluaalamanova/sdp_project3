package com.example.sdp_project2;

import java.util.List;

public class Facade {
    private ShoppingCart cart;
    private OrderHistory orderHistory;
    private OrderStateContext orderStateContext;

    public Facade() {
        this.cart = ShoppingCart.getInstance();
        this.orderHistory = new OrderHistory("order_history.txt");
        this.orderStateContext = new OrderStateContext();
        this.orderStateContext.setOrderStatusObserver(new OrderStatus());
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public void processPayment(PaymentStrategy paymentStrategy, List<ProductDecorator> decoratedProducts) {
        double totalPrice = 0;
        for (ProductDecorator product : decoratedProducts) {
            totalPrice += product.getPrice();
        }
        paymentStrategy.pay(totalPrice);
        orderHistory.saveOrder(cart);
    }

    public void displayOrderHistory() {
        ShoppingCartMemento lastOrder = orderHistory.getLastOrder();
        if (lastOrder != null) {
            System.out.println("Last Order:");
            for (Product product : lastOrder.getProducts()) {
                System.out.println(product.name + " - $" + product.price);
            }
        } else {
            System.out.println("No order history available.");
        }
    }
}