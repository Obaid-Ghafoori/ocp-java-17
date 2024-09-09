package chapter_14.InventoryManagementSystem.src.main.inventory.dao;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;

import java.util.List;


/**
 * InventoryItemDAO is an interface that defines the data access operations
 * for handling {@link InventoryItem} entities. It provides methods to add,
 * retrieve, update, and delete inventory items from the underlying data store.
 */
public interface InventoryItemDAO {

    /**
     * Adds a new inventory item to the data store.
     *
     * @param item the {@link InventoryItem} to be added
     */
    void addItem(InventoryItem item) throws ClassNotFoundException;

    /**
     * Retrieves an inventory item by its unique identifier.
     *
     * @param itemId the unique identifier of the inventory item to retrieve
     * @return the {@link InventoryItem} with the specified itemId, or {@code null} if not found
     */
    InventoryItem getItemById(int itemId);

    /**
     * Retrieves all inventory items from the data store.
     *
     * @return a {@link List} of all {@link InventoryItem} objects in the data store
     */
    List<InventoryItem> getAllItems();

    /**
     * Updates the details of an existing inventory item in the data store.
     *
     * @param item the {@link InventoryItem} containing updated information
     */
    void updateItem(InventoryItem item);

    /**
     * Deletes an inventory item from the data store based on its unique identifier.
     *
     * @param itemId the unique identifier of the inventory item to delete
     */
    void deleteItem(int itemId);
}

