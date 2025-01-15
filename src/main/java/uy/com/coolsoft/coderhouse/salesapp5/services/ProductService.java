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
            return getProduct(productDetails, product);
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
    @Transactional
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
    @Transactional
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    @Transactional
    public Product updateProductById(Long id, Product product){
        Product productToUpdate = productRepository.findById(id).get();
        return getProduct(product, productToUpdate);
    }

    private Product getProduct(Product product, Product productToUpdate) {
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setCreated(product.getCreated());
        productToUpdate.setUpdated(product.getUpdated());
        productToUpdate.setCreatedBy(product.getCreatedBy());
        productToUpdate.setUpdatedBy(product.getUpdatedBy());
        productToUpdate.setActive(product.isActive());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setSubCategory(product.getSubCategory());
        productToUpdate.setBrand(product.getBrand());
        productToUpdate.setModel(product.getModel());
        productToUpdate.setSerialNumber(product.getSerialNumber());
        productToUpdate.setSku(product.getSku());
        return productRepository.save(productToUpdate);
    }
}