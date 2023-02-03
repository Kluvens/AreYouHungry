package main.dish;

import java.time.LocalDateTime;

public class Dish {
    private int id;
    private String name;
    private double price;
    private String description;
    private boolean isOnStock;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Dish(int id, String name, double price, String description, boolean isOnStock, LocalDateTime createTime,
            LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isOnStock = isOnStock;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnStock() {
        return isOnStock;
    }

    public void setOnStock(boolean isOnStock) {
        this.isOnStock = isOnStock;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
