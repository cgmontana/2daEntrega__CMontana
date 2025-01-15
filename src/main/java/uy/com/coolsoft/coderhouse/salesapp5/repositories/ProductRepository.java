package uy.com.coolsoft.coderhouse.salesapp5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.com.coolsoft.coderhouse.salesapp5.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
