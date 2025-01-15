package uy.com.coolsoft.coderhouse.salesapp5.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category_table")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
    }

    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Object getDescription() {
        return null;
    }

    public void toString(Object description) {
    }

    public void setId(Long id) {

    }
}

