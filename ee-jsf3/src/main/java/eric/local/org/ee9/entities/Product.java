package eric.local.org.ee9.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotEmpty(message = "Sku can not be empty")
    @Size(min = 2, max = 10)
    private String sku;
    @NotNull(message = "Price need between 1 and 100000")
    @Min(1)
    @Max(100000)
    private int price;
    @NotNull(message = "You need select a category")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @NotNull(message = "You need insert a date from created")
    @Column(name = "created_at")
    private LocalDate createdAt;

    public Product() {}

    public Product(Long id, String name, String type, int price) {
        this.id = id;
        this.name = name;
        this.price = price;

        Category category = new Category();
        category.setName(type);
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
