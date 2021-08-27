package nicomed.tms.server.service;

import nicomed.tms.server.enums.Grade;
import nicomed.tms.server.model.City;
import nicomed.tms.server.model.Place;
import nicomed.tms.server.repository.CityRepository;
import nicomed.tms.server.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements IPlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place findPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public Place findPlaceByName(String name) {
        return placeRepository.findPlaceByName(name).orElse(null);
    }

    @Override
    public List<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> findAllPlacesByCity(City city) {
        return placeRepository.findAllByCity(city);
    }

    @Override
    public boolean createPlace(Place place) {
        placeRepository.save(place);
        return true;
    }

    @Override
    public boolean updatePlace(Place place) {
        placeRepository.save(place);
        return true;
    }

    @Override
    public boolean removePlace(Long id) {
        placeRepository.deleteById(id);
        return true;
    }
}
