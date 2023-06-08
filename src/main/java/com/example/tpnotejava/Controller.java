package com.example.tpnotejava;

import DAO.PizzaDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNom.setCellValueFactory(new PropertyValueFactory<Pizza, String>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Pizza, Integer>("prix"));
        colNb.setCellValueFactory(new PropertyValueFactory<Pizza, Integer>("nbIngredients"));
        var p = PizzaDAO.getPizzas();
        for (int i = 0; i < p.size(); i++) {
            ajouter(p.get(i).getNom(), p.get(i).getPrix(), p.get(i).getNbIngredients());
        }
    }


    public void ajouter(String nom, int prix, int nb) {
        Pizza pizza = new Pizza(nom, prix, nb);
        ObservableList<Pizza> pizzas = tableau.getItems();
        pizzas.add(pizza);
        tableau.setItems(pizzas);
    }

    @FXML
    private void ajout() {
        if (edtNom.getText().equals("") || edtPrix.getText().equals("") || edtNb.getText().equals("")) {
            return;
        }
        int pr = Integer.parseInt(edtPrix.getText());
        if (pr <= 0) {
            labPrix.setText("Saisie Incorrecte");
            return;
        }
        int n =pr = Integer.parseInt(edtNb.getText());
        if (n<=0){
            labNb.setText("Saisie Incorrecte");
            return;
        }


        String nom = edtNom.getText();
        int prix = Integer.parseInt(edtPrix.getText());
        int nb = Integer.parseInt(edtNb.getText());
        ajouter(nom, prix, nb);
        PizzaDAO.addPizza(new Pizza(nom, prix, nb));
        edtPrix.setText("");
        edtNom.setText("");
        edtNb.setText("");
        labNb.setText("");
        labNom.setText("");
        labPrix.setText("");

    }

    @FXML
    private void viderTableau() {
        tableau.getItems().clear();
        PizzaDAO.viderTable();
    }

    @FXML
    private void supprimer() {
        Pizza pizza = (Pizza) tableau.getSelectionModel().getSelectedItem();
        PizzaDAO.deletePizzaByNom(pizza.getNom().toString());


        ObservableList<Pizza> pizzas = tableau.getItems();
        pizzas.remove(tableau.getSelectionModel().getSelectedItem());


    }


    @FXML
    private TableView tableau;
    @FXML
    private TableColumn colNom;
    @FXML
    private TableColumn colPrix;
    @FXML
    private TableColumn colNb;
    @FXML
    private TextField edtNom;
    @FXML
    private TextField edtPrix;
    @FXML
    private TextField edtNb;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnVider;
    @FXML
    private Button btnSup;
    @FXML
    private Label labNom;
    @FXML
    private Label labPrix;
    @FXML
    private Label labNb;


}