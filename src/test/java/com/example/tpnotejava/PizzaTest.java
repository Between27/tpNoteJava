package com.example.tpnotejava;

import modele.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    Pizza pizza = new Pizza("Reine",15,3);




    @BeforeEach
    void instance(){
        pizza.setNom("Reine");
        pizza.setPrix(15);
        pizza.setNbIngredients(3);
    }



    @Test
    void getNom() {
        assertEquals("Reine",pizza.getNom());
        assertNotEquals("Margarita",pizza.getNom());
    }



    @Test
    void setPrix() {
        pizza.setPrix(99);
        assertNotEquals(15,pizza.getPrix());
        assertEquals(99,pizza.getPrix());

    }

}