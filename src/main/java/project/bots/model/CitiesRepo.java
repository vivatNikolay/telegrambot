package project.bots.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitiesRepo extends CrudRepository<Cities, Integer> {
    Optional<Cities> findByCity(@Param("city") String city);
}
