package co2103.hw2.repo;

import co2103.hw2.model.Cafe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CafeRepository extends CrudRepository<Cafe, Integer> {
    public List<Cafe> findByAddress(String address);
    public List<Cafe> findByBest_Location(String location);

}
