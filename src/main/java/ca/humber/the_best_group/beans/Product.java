package ca.humber.the_best_group.beans;

public class Product {
    private Long id;
    private String sku;
    private String name;
    private int quantity;
    private String location;

    public Product() {}

    public Product(Long id, String sku, String name, int quantity, String location) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}