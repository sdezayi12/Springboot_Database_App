package co2103.hw2.repo;

import co2103.hw2.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public List<Customer> findByOrders(int orders);
    public List<Customer> findCustomersByIdentifier(int id);
}
