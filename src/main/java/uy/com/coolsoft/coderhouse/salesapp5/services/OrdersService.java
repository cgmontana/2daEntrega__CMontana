package uy.com.coolsoft.coderhouse.salesapp5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.coolsoft.coderhouse.salesapp5.models.Orders;
import uy.com.coolsoft.coderhouse.salesapp5.repositories.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public Orders updateOrder(Long id, Orders orderDetails) {
        return ordersRepository.findById(id).map(order -> {
            order.setCustomers(orderDetails.getOrderNumber());
            order.getOrderNumber(orderDetails.getOrderDate());
            order.getOrderDate(orderDetails.getOrderStatus());
            order.setCustomers(orderDetails.getPaymentMethod());
            order.getOrderStatus(orderDetails.getPaymentStatus());
            order.getPaymentMethod(orderDetails.getShippingMethod());
            order.getPaymentStatus(orderDetails.getShippingStatus());
            order.getClass(orderDetails.getNotes());
            order.setCustomers(orderDetails.isActive());
            return ordersRepository.save(order);
        }).orElseGet(() -> {
            orderDetails.setId(id);
            return ordersRepository.save(orderDetails);
        });
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}