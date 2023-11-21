package com.example.sdp_project2;

class WebMoneyPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using WebMoney.");
    }
}
