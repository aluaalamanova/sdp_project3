package com.example.sdp_project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    ShoppingCart cart = ShoppingCart.getInstance();
    OrderHistory orderHistory = new OrderHistory("order_history.txt");
    List<Product> products = new ArrayList<>();
    OrderStatus orderStatus = new OrderStatus();
    OrderStateContext orderStateContext = new OrderStateContext();
    String ordstatus = "IN PROCESSING";

    public HelloController(){
        products.add(new Product("Chainsaw man Vol.12", 12));
        products.add(new Product("My Hero Academia Vol.35", 10));
        products.add(new Product("Spy X Family Vol.10", 16));
        orderStateContext.setOrderStatusObserver(orderStatus);
    }
    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button add3;

    @FXML
    private Button cart_btn;

    @FXML
    private Button catalog_btn;

    @FXML
    private Button confirm_btn;

    @FXML
    private Button history_btn;

    @FXML
    private Button payment_btn;

    @FXML
    private Button status_btn;

    @FXML
    private void handleAdd1ButtonAction() {
        Product selectedProduct = products.get(0);

        // Add product to cart using Singleton pattern
        cart.addProduct(selectedProduct);
        orderHistory.saveOrder(cart);
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product successfully added to cart");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }
    @FXML
    private void handleAdd2ButtonAction() {
        Product selectedProduct = products.get(1);

        // Add product to cart using Singleton pattern
        cart.addProduct(selectedProduct);
        orderHistory.saveOrder(cart);
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product successfully added to cart");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }
    @FXML
    private void handleAdd3ButtonAction() {
        Product selectedProduct = products.get(2);

        // Add product to cart using Singleton pattern
        cart.addProduct(selectedProduct);
        orderHistory.saveOrder(cart);
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product successfully added to cart");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    @FXML
    private void showOrderState() {
        String outOS = orderStateContext.updateOrderStatus(ordstatus);
        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Order status: " + outOS);
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

    @FXML
    private void navigateToCatalog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent secondPageParent = loader.load();
            Scene secondPageScene = new Scene(secondPageParent);
            Stage primaryStage = (Stage) cart_btn.getScene().getWindow(); // Получаем текущий Stage
            primaryStage.setScene(secondPageScene); // Устанавливаем новую сцену
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок загрузки FXML файла
        }
    }
    /*=========================CART==============================*/
    @FXML
    private Label selectedPrdouct;
    @FXML
    private Button add_disc;

    @FXML
    private Button add_expdel;

    @FXML
    private Button add_pack;


    @FXML
    private void navigateToCart() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            Parent secondPageParent = loader.load();
            Scene secondPageScene = new Scene(secondPageParent);
            Stage primaryStage = (Stage) cart_btn.getScene().getWindow(); // Получаем текущий Stage
            primaryStage.setScene(secondPageScene); // Устанавливаем новую сцену
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок загрузки FXML файла
        }
    }

    @FXML
    private void addPackaging() {

        // Создание нового модального окна
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.setTitle("Otaku Manga");

        // Создание содержимого модального окна
        Label label = new Label("Product successfully added to cart");
        StackPane modalLayout = new StackPane();
        modalLayout.getChildren().add(label);

        // Устанавливаем содержимое модального окна и показываем его
        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
    }

}


