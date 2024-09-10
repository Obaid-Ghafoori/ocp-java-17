package chapter_14.InventoryManagementSystem.src.main.inventory.dao;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InventoryItemDAOImpl implements InventoryItemDAO {
    private String url;
    private String user;
    private String password;

    public InventoryItemDAOImpl() {
        loadDBProperties();
    }

    public void addItem(InventoryItem item) {
        String sql = "INSERT INTO Inventory (name, category, quantity, price, date_added) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getQuantity());
            stmt.setDouble(4, item.getPrice());
            stmt.setDate(5, java.sql.Date.valueOf(item.getDateAdded()));

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Item added successfully!");
            } else {
                System.out.println("Failed to add item.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        String sql = "SELECT * FROM Inventory WHERE item_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new InventoryItem(
                        rs.getInt("item_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDate("date_added").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Retrieves all inventory items.
     *
     * @return A list of all inventory items.
     */
    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> items = new ArrayList<>();
        String sql = "SELECT * FROM Inventory";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                items.add(new InventoryItem(
                        rs.getInt("item_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDate("date_added").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    /**
     * Updates the details of an existing inventory item.
     *
     * @param item The item to update.
     */
    @Override
    public void updateItem(InventoryItem item) {
        String sql = "UPDATE Inventory SET name = ?, category = ?, quantity = ?, price = ?, date_added = ? WHERE item_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getQuantity());
            stmt.setDouble(4, item.getPrice());
            stmt.setDate(5, Date.valueOf(item.getDateAdded()));
            stmt.setInt(6, item.getItemId());


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Item updated successfully!");
            } else {
                System.out.println("Failed to update item.");
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an inventory item by its ID.
     *
     * @param itemId The ID of the item to delete.
     */
    @Override
    public void deleteItem(int itemId) {
        String sql = "DELETE FROM inventory WHERE item_Id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,itemId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *  checks the database for the item, if it already exists
     * @param name of the item
     * @param category category to which item belongs to
     * @return true if the item already exist
     */
    @Override
    public boolean itemExists(String name, String category) {
            String sql = "SELECT COUNT(*) FROM Inventory WHERE name = ? AND category = ?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, name);
                stmt.setString(2, category);

                ResultSet rs = stmt.executeQuery();
                rs.next(); // Move to the first row
                return rs.getInt(1) > 0; // If count > 0, item exists
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
    }

    private void loadDBProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }
            prop.load(input);
            this.url = prop.getProperty("db.url");
            this.user = prop.getProperty("db.user");
            this.password = prop.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
