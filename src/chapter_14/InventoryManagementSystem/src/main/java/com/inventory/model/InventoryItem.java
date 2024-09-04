package chapter_14.InventoryManagementSystem.src.main.java.com.inventory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {
    private int itemId;
    private String name;
    private String category;
    private int quantity;
    private BigDecimal price;
    private LocalDate dateAdded;

}
