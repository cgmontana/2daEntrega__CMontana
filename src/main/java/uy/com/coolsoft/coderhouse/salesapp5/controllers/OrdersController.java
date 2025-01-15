package uy.com.coolsoft.coderhouse.salesapp5.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.com.coolsoft.coderhouse.salesapp5.models.Orders;
import uy.com.coolsoft.coderhouse.salesapp5.repositories.OrdersRepository;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        return ordersRepository.findById(id)
                .map(order -> ResponseEntity.ok().body(order))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }
}