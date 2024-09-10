package chapter_14.InventoryManagementSystem.src.main.inventory;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;
import chapter_14.InventoryManagementSystem.src.main.inventory.service.InventoryService;
import chapter_14.InventoryManagementSystem.src.main.inventory.service.InventoryServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class InventoryManagementSystem {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        InventoryService service = new InventoryServiceImpl();

        // Create a sample InventoryItem
        InventoryItem newItem = new InventoryItem(1, "Smartphone", "Wearables", 10, new BigDecimal("299.99"), LocalDate.now());

        // Add the item to the database
        service.addItem(newItem);

        InventoryItem itemById = service.getItemById(newItem.getItemId());
        System.out.println(itemById.getItemId());

        //print all inventory items
        service.getAllItems().forEach(System.out::println);
    }

}
