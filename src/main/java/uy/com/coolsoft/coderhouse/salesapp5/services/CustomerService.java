

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.coolsoft.coderhouse.salesapp5.models.Customer;
import uy.com.coolsoft.coderhouse.salesapp5.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhoneNumber());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            customerDetails.setId(id);
            return customerRepository.save(customerDetails);
        });
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

