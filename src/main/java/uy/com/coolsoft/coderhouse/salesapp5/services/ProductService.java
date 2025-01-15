package uy.com.coolsoft.coderhouse.salesapp5.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.coolsoft.coderhouse.salesapp5.models.Product;
import uy.com.coolsoft.coderhouse.salesapp5.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setCreated(productDetails.getCreated());
            product.setUpdated(productDetails.getUpdated());
            product.setCreatedBy(productDetails.getCreatedBy());
            product.setUpdatedBy(productDetails.getUpdatedBy());
            product.setActive(productDetails.isActive());
            product.setCategory(productDetails.getCategory());
            product.setSubCategory(productDetails.getSubCategory());
            product.setBrand(productDetails.getBrand());
            product.setModel(productDetails.getModel());
            product.setSerialNumber(productDetails.getSerialNumber());
            product.setSku(productDetails.getSku());
            return productRepository.save(product);
        }).orElseGet(() -> {
            productDetails.setId(id);
            return productRepository.save(productDetails);
        });
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Transactional
    public  Product saveProduct(Product product){
        return productRepository.save(product);
    }
}