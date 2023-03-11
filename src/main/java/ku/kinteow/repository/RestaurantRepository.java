package ku.kinteow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ku.kinteow.model.Restaurant;

import java.util.UUID;
@Repository
public interface RestaurantRepository extends
        JpaRepository<Restaurant,UUID> {
}
