package chapter_14.InventoryManagementSystem.src.main.inventory.service;

import chapter_14.InventoryManagementSystem.src.main.inventory.dao.InventoryItemDAOImpl;
import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
public class InventoryServiceImpl implements InventoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

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
        if (!itemDAO.itemExists(item.getName(), item.getCategory())) {
            itemDAO.addItem(item);
            LOGGER.info( "Item added successfully.");
        } else {
            LOGGER.error("Item already exists in the database.");
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
        return itemDAO.getItemById(itemId);
    }

    /**
     * Retrieves all inventory items.
     *
     * @return A list of all inventory items.
     */
    @Override
    public List<InventoryItem> getAllItems() {
        return itemDAO.getAllItems();
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
