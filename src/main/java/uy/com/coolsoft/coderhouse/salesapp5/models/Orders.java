package uy.com.coolsoft.coderhouse.salesapp5.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "orders")

public class Orders {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String orderDate;
    private String orderStatus;
    private String paymentMethod;
    private String paymentStatus;
    private String shippingMethod;
    private String shippingStatus;
    private String created;
    private String updated;
    private String createdBy;
    private String updatedBy;
    private String notes;
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    private List<Product> products;
    @ManyToMany
    private Collection<Customer> customers;

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
