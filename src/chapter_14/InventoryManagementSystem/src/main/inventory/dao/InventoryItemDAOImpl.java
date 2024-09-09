package chapter_14.InventoryManagementSystem.src.main.inventory.dao;

import chapter_14.InventoryManagementSystem.src.main.inventory.model.InventoryItem;

import java.io.InputStream;
import java.sql.*;
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
            stmt.setBigDecimal(4, item.getPrice());
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
                        rs.getBigDecimal("price"),
                        rs.getDate("date_added").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return null;
    }

    @Override
    public void updateItem(InventoryItem item) {

    }

    @Override
    public void deleteItem(int itemId) {

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
