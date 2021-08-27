package nicomed.tms.server.service;

import nicomed.tms.server.model.City;
import nicomed.tms.server.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {
    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City findCityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City findCityByName(String name) {
        return repository.findCityByName(name).orElse(null);
    }

    @Override
    public List<City> findAllCities() {
        return repository.findAll();
    }

    @Override
    public boolean createCity(City city) {
        repository.save(city);
        return true;
    }

    @Override
    public boolean updateCity(City city) {
        repository.save(city);
        return true;
    }

    @Override
    public boolean removeCity(City city) {
        repository.delete(city);
        return true;
    }

    @Override
    public boolean removeCity(Long id) {
        repository.deleteById(id);
        return true;
    }
}
