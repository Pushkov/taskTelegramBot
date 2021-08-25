package nicomed.tms.server.repository;

import nicomed.tms.server.model.City;
import nicomed.tms.server.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByCity(City city);
    Optional<Place> findPlaceByName(String name);
}
