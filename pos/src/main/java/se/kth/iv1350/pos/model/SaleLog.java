package se.kth.iv1350.pos.model;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
/**
 *
 * The Sale Log of the program
 */
public class SaleLog {
    private List<Sale> saleLog = new ArrayList<>();
    private InventorySystem invSys;
    private AccountingSystem accSys;
    private Sale recentSale;
    
    /**
     * Creates a new instance
     * @param invSys reference to the inventory system
     * @param accSys reference to the accounting system
     */
    public SaleLog(InventorySystem invSys, AccountingSystem accSys){
        this.invSys = invSys;
        this.accSys = accSys;
    }
    
    /**
     * Program logs the completed sale in a list which contains
     * all information about each sale. The {@link Sale} object gives access to 
     * all available information about the sale. 
     * @param sale the Sale object gives access to all available 
     * information about the sale.
     */
    public void logCompletedSale(Sale sale){
        saleLog.add(sale);
        recentSale = sale;
        updateExternalSystems();
    }
    
    private void updateExternalSystems(){
        invSys.sendSaleInformation(recentSale);
        accSys.sendSaleInformation(recentSale);
    }
}
