package com.example.sdp_project2;

class OrderStatus implements OrderStatusObserver {
    private String status;

    @Override
    public void update(String status) {
        this.status = status;
        System.out.println("Order Status: " + status);
    }
}
