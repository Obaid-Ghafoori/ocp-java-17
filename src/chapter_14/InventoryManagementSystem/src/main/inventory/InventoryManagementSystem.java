package chapter_14.InventoryManagementSystem.src.main.inventory;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;
import chapter_14.InventoryManagementSystem.src.main.inventory.service.InventoryService;
import chapter_14.InventoryManagementSystem.src.main.inventory.service.InventoryServiceImpl;

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
        InventoryItem newItem = new InventoryItem(4, "Samsung", "device", 10, 299.99, LocalDate.now());

        // Add the item to the database
      //  service.addItem(newItem);

        InventoryItem itemById = service.getItemById(newItem.getItemId());
        System.out.println(itemById.getItemId());

        //print all inventory items
        service.getAllItems().forEach(System.out::println);

        // delete item
//        service.deleteItem(newItem.getItemId());

        InventoryItem updatedItem = new InventoryItem();

        updatedItem.setItemId(7);
        updatedItem.setName("LG");
        updatedItem.setCategory("SmartTV");
        updatedItem.setQuantity(3);
        updatedItem.setPrice(399.33);
        updatedItem.setDateAdded(LocalDate.now());
               ;
        // update item
        service.updateItem(updatedItem);
    }

}
