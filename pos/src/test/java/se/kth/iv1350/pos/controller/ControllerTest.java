/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.pos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.model.SoldItem;

/**
 *
 * @author Haron Osman
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    

    @Test
    public void testSearchMatchingItem() {
        System.out.println("searchMatchingItem");
        int itemId = 1;
        Controller instance = new Controller();
        instance.startSale();
   
        SoldItem result = instance.searchMatchingItem(itemId);
        assertNotNull(result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchMatchingItem2() {
        int itemId = 0;
        Controller instance = new Controller();
        instance.startSale();
        
        SoldItem result = instance.searchMatchingItem(itemId);
        assertNull(result);
        //fail("The test case is a prototype.");
    }
    
    public void testSearchMatchingItem3() {
        int itemId = 1;
        Controller instance = new Controller();
        instance.startSale();
        
        SoldItem result = instance.searchMatchingItem(itemId);
        assertTrue(result.getQuantity() == 1);
        
        SoldItem anotherResult = instance.searchMatchingItem(itemId);
        assertEquals(result, anotherResult);
        assertTrue(result.getQuantity()== 2);
    }
    
    
    /*@Disabled
    public void testEndSale() {
        System.out.println("endSale");
        Controller instance = new Controller();
        double expResult = 0.0;
        double result = instance.endSale();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }*/
    
    /*@Disabled
    public void testPay() {
        System.out.println("pay");
        double amount = 0.0;
        double totalPrice = 0.0;
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.pay(amount, totalPrice);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }*/
    
}
