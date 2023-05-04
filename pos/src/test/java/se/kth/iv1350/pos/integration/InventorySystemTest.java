/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.model.Sale;

/**
 *
 * @author Haron Osman
 */
public class InventorySystemTest {
    
    public InventorySystemTest() {
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
    public void testFindItemTheItemIsfound() {
        int itemId = 1;
        InventorySystem instance = new InventorySystem();
        String expResult = "Apple";
        ItemDTO result = instance.findItem(itemId);
        assertEquals(expResult, result.getName());
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testFindItemTheItemIsNotfound() {
        int itemId = 6;
        InventorySystem instance = new InventorySystem();
        ItemDTO expResult = null;
        ItemDTO result = instance.findItem(itemId);
        assertEquals(expResult, result);
    }
    
}
