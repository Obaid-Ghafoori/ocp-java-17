package chapter_14.InventoryManagementSystem.src.main.inventory.service;

import chapter_14.InventoryManagementSystem.src.main.inventory.dao.InventoryItemDAOImpl;
import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    private final InventoryItemDAOImpl itemDAO;

    public InventoryServiceImpl() {
        this.itemDAO = new InventoryItemDAOImpl();
    }

    /**
     * Adds a new inventory item.
     *
     * @param item The item to be added.
     */
    @Override
    public void addItem(InventoryItem item) {
        boolean isItemExist = itemDAO.itemExists(item.getName(), item.getCategory());

        if (isItemExist) {
            System.out.println("Item already exists in the database.");
        } else {
            itemDAO.addItem(item);
        }

    }

    /**
     * Retrieves an inventory item by its ID.
     *
     * @param itemId The ID of the item to retrieve.
     * @return The retrieved inventory item, or null if not found.
     */
    @Override
    public InventoryItem getItemById(int itemId) {
        return null;
    }

    /**
     * Retrieves all inventory items.
     *
     * @return A list of all inventory items.
     */
    @Override
    public List<InventoryItem> getAllItems() {
        return null;
    }

    /**
     * Updates the details of an existing inventory item.
     *
     * @param item The item to update.
     */
    @Override
    public void updateItem(InventoryItem item) {

    }

    /**
     * Deletes an inventory item by its ID.
     *
     * @param itemId The ID of the item to delete.
     */
    @Override
    public void deleteItem(int itemId) {

    }
}
