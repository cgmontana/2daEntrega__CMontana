package uy.com.coolsoft.coderhouse.salesapp5.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    public Collection<Customer> getOrderNumber() {
        return customers;
    }

    public Object getOrderDate() {
        return orderDate;
    }

    public Object getOrderStatus() {
        return orderStatus;
    }

    public Collection<Customer> getPaymentMethod() {
        return customers;
    }

    public Object getPaymentStatus() {
        return paymentStatus;
    }

    public void setId(Long id) {
    }

    public Object getShippingMethod() {
        return shippingMethod;
    }

    public Object getShippingStatus() {
        return shippingStatus;
    }

    public Object getNotes() {
        return notes;
    }

    public Collection<Customer> isActive() {
        return customers;
    }

    public Collection<Customer> getOrderNumber(Object orderDate) {
        return customers;

    }

    public void getClass(Object notes) {
    }

    public void getPaymentStatus(Object shippingStatus) {
    }

    public Collection<Customer> getPaymentMethod(Object shippingMethod) {
        return customers;
    }

    public void getOrderStatus(Object paymentStatus) {
    }

    public Object getOrderDate(Object orderStatus) {
        return orderStatus;
    }
}
