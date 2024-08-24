package com.marketplace.marketplaceApp.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Entity
@Table(name = "products", schema = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private long price;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Image is required")
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
