package co2103.hw2.repo;

import co2103.hw2.model.Customer;
import co2103.hw2.model.Seating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatingRepository extends CrudRepository<Seating, String> {
    public List<Seating> findByLocation(String location);

    List<Seating> findSeatingByReviewer(Customer reviewer);
}
