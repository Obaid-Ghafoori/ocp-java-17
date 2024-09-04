package chapter_14.InventoryManagementSystem.src.main.java.com.inventory.dao;

import chapter_14.InventoryManagementSystem.src.main.java.com.inventory.model.InventoryItem;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class InventoryItemDAOImpl implements InventoryItemDAO {
    private String url;
    private String user;
    private String password;


    public InventoryItemDAOImpl() {
        // Load properties from the db.properties file
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }
            // Load a properties file from classpath
            prop.load(input);
            // Get the property values
            this.url = prop.getProperty("db.url");
            this.user = prop.getProperty("db.user");
            this.password = prop.getProperty("db.password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addItem(InventoryItem item) {
        String sql = "INSERT INTO Inventory (name, category, quantity, price, date_added) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getQuantity());
            stmt.setBigDecimal(4, item.getPrice());
            stmt.setDate(5, Date.valueOf(item.getDateAdded()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InventoryItem getItemById(int itemId) {
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
}
