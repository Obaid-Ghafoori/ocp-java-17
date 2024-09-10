package chapter_14.InventoryManagementSystem.src.main.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    private int itemId;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private LocalDate dateAdded;

}
