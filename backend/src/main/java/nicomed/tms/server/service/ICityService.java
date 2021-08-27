package nicomed.tms.server.service;

import nicomed.tms.server.model.City;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICityService {
    City findCityById(Long id);
    City findCityByName(String name);
    List<City> findAllCities();
    boolean createCity(City city);
    boolean updateCity(City city);
    boolean removeCity(City city);
    boolean removeCity(Long id);
}
