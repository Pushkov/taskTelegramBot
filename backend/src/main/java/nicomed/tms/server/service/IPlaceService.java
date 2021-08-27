package nicomed.tms.server.service;

import nicomed.tms.server.enums.Grade;
import nicomed.tms.server.model.City;
import nicomed.tms.server.model.Place;

import java.util.List;

public interface IPlaceService {
    Place findPlaceById(Long id);

    Place findPlaceByName(String name);

    List<Place> findAllPlaces();
    List<Place> findAllPlacesByCity(City city);
    boolean createPlace(Place place);
    boolean updatePlace(Place place);
    boolean removePlace(Long id);
}
