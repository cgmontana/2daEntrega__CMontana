package uy.com.coolsoft.coderhouse.salesapp5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uy.com.coolsoft.coderhouse.salesapp5.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
