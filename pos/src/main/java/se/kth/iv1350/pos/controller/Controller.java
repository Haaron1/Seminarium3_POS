package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.DiscountRegister;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SoldItem;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.model.SaleLog;


/**
 * The controller of the program, all calls model to goes through
 * here and only view can call the controller.
 */
public class Controller {
    private Sale currentSale;
    private AccountingSystem accSys;
    private InventorySystem invSys;
    private DiscountRegister discReg;
    private Printer printer;
    private CashRegister cashReg;
    private SaleLog saleLog;
    
    /**
     * Creates a new instance for controller, has reference to external systems 
     * the cash register and the saleLog.
     */
    public Controller(){
        accSys = new AccountingSystem();
        invSys = new InventorySystem();
        discReg = new DiscountRegister();
        printer = new Printer();
        cashReg = new CashRegister();
        saleLog = new SaleLog(invSys, accSys);
    }
    /**
     * Starts a new sale by creating an object for the current sale.
     */
    public void startSale(){
        currentSale = new Sale();
    }
    
    /**
     * Searches for matching item in the sale, returns the sold item if found
     * Searches for matching item in the inventory system and returns an
     * <code>ItemDTO</code> object if item is found or null if not found
     * If foundItem is null then the method returns null otherwise a 
     * <code>SoldItem</code> object is returned after adding the item to cart.
     * @param itemId The item identifier of an item
     * @return The soldItem that has been found, or null if 
     * no item has been found
     */
    public SoldItem searchMatchingItem(int itemId){
        SoldItem soldItem = itemAlreadyInSale(itemId);
        if(soldItem != null){
            
            return soldItem;
        }
        ItemDTO foundItem = invSys.findItem(itemId);
        if(foundItem == null){
            return null; 
        }
        soldItem = currentSale.itemToCart(foundItem);
        return soldItem; 
    }
    
    private SoldItem itemAlreadyInSale(int itemId){
        return currentSale.findListedItem(itemId);
    }
    
    /**
     * Ends the sale.
     * 
     * @return The calculated total price including tax.
     */
    public double endSale(){
        return currentSale.calculateTotalSum();
    }
    
    /**
     * Creates pay a <code>CashPayment</code> object, Increases the cash in
     * the register, returns a <code>Receipt</code> object called receipt 
     * through getSaleInfo method from the <code>Sale</code> currentSale object, 
     * returns a string representing the receipt after sending the receipt 
     * to printer.
     * @param amount The paid amount
     * @param totalPrice The total price of the sale
     * @return The string representing the receipt
     */
    public String pay(double amount, double totalPrice){
        CashPayment payment = new CashPayment(amount, totalPrice);
        increaseCashInRegister(payment);
        Receipt receipt = currentSale.getSaleInfo(payment);
        String receiptPaper = sendReceiptToPrinter(receipt);
        saleLog.logCompletedSale(currentSale);
        return receiptPaper;
    }
    
    private void increaseCashInRegister(CashPayment payment){
        cashReg.addPayment(payment);
    }
    
    private String sendReceiptToPrinter(Receipt receipt){
        return printer.printReceipt(receipt);
    }
    
}
