package DAO;

import modele.Pizza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {

    public static void main(String[] args) {

    }

    public static List<Pizza> getPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_pizza", "mamaneib1u_appli", "32031496");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pizza");
            while (rs.next()) {
                pizzas.add(new Pizza(rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getString(1)));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return pizzas;
    }

    public static void addPizza(Pizza pizza) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_pizza", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("INSERT INTO pizza (nom, prix,nb_ing) VALUES (?, ?,?)");
            statement.setString(1,pizza.getNom());
            statement.setInt(2,pizza.getPrix());
            statement.setInt(3,pizza.getNbIngredients());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deletePizza(String id) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_pizza", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("Delete from pizza WHERE id = ?");
            statement.setString(1,id);
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deletePizzaByNom(String nom) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_pizza", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("Delete from pizza WHERE nom = ?");
            statement.setString(1,nom);
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viderTable() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_pizza", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("Delete from pizza");
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
