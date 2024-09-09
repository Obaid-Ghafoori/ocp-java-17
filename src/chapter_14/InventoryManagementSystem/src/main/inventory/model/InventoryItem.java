package chapter_14.InventoryManagementSystem.src.main.inventory.model;

import lombok.*;

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
