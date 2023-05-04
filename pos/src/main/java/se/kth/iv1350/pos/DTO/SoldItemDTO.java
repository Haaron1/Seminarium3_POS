/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.pos.DTO;
import se.kth.iv1350.pos.DTO.ItemDTO;

/**
 *
 * @author Haron Osman
 */
public class SoldItemDTO {
    private int itemId;
    private double price;
    private String name;
    private double runningTotal;
    private double taxRate;
    
    public SoldItemDTO(ItemDTO foundItem, double runningTotal){
        this.price = foundItem.getPrice();
        this.itemId = foundItem.getItemId();
        this.name = foundItem.getName();
        this.runningTotal = runningTotal;
        this.taxRate = foundItem.getTaxRate();
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getRunningTotal(){
        return runningTotal;
    }

    public int getItemId() {
        return itemId;
    }
    
    public double getTaxRate() {
        return taxRate;
    }
}
