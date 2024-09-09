package chapter_14.InventoryManagementSystem.src.main.inventory.service;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;

import java.util.List;


/**
 * Interface for inventory service operations.
 */
public interface InventoryService {
    /**
     * Adds a new inventory item.
     *
     * @param item The item to be added.
     */
    void addItem(InventoryItem item);

    /**
     * Retrieves an inventory item by its ID.
     *
     * @param itemId The ID of the item to retrieve.
     * @return The retrieved inventory item, or null if not found.
     */
    InventoryItem getItemById(int itemId);

    /**
     * Retrieves all inventory items.
     *
     * @return A list of all inventory items.
     */
    List<InventoryItem> getAllItems();

    /**
     * Updates the details of an existing inventory item.
     *
     * @param item The item to update.
     */
    void updateItem(InventoryItem item);

    /**
     * Deletes an inventory item by its ID.
     *
     * @param itemId The ID of the item to delete.
     */
    void deleteItem(int itemId);
}

