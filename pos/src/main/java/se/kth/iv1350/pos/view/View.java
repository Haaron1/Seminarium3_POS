package se.kth.iv1350.pos.view;
import java.text.DecimalFormat;
import se.kth.iv1350.pos.controller.Controller; 
import se.kth.iv1350.pos.model.SoldItem; 
import se.kth.iv1350.pos.model.Receipt; 
/**
 *This class is a placeholder for the user interface
 *
 */
public class View {
    private Controller contr;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Simulates a presentation of an item that 
     * has been added to sale for the sample execution.
     * 
     * @param foundItem The item that has been found and added to sale.
     */
    public void samplePresentItem(SoldItem foundItem){
        System.out.println(foundItem.getName() 
                + "\nPrice:         " 
                + foundItem.getQuantity() + " x " 
                + foundItem.getUnitPrice() 
                + "     " + foundItem.getPrice()
                + "\nRunning total: " 
                + foundItem.getQuantity() + " x " 
                + df.format(foundItem.getUnitRunningTotal())
                + "     " + df.format(foundItem.getRunningTotal())
                + "\nquantity: " + foundItem.getQuantity());
    }
    /**
    * Simulates user inputs of the system operations.
    */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");
        
        SoldItem foundItem = contr.searchMatchingItem(1);
        System.out.println("Item has been found: ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(1);
        System.out.println("Item already in sale (increased quantity): ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(4);
        System.out.println("Item has been found: ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(4);
        System.out.println("Item already in sale (increased quantity): ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(3);
        System.out.println("Item has been found: ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(2);
        System.out.println("Item has been found: ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(2);
        System.out.println("Item already in sale (increased quantity): ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(5);
        System.out.println("Item has been found: ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(5);
        System.out.println("Item already in sale (increased quantity): ");
        samplePresentItem(foundItem);
        System.out.println();
        
        foundItem = contr.searchMatchingItem(7);
        System.out.println("Invalid item identifier (item id 7): " + foundItem);
        System.out.println();
        
        
        double totalPrice = contr.endSale();
        
        System.out.println("Sale has ended \nYour total price is: " 
                + df.format(totalPrice));
        
        System.out.println();
        
        System.out.println("You pay 200\n");
        String receiptPaper = contr.pay(200, totalPrice);
        System.out.println("*Receipt gets printed*\n");
        System.out.println(receiptPaper);
        
        System.out.println("\nInventory system has been updated\n");
        System.out.println("Accounting system has been updated\n");
        
    }
}
