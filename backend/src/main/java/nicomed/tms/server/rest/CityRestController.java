package nicomed.tms.server.rest;

import nicomed.tms.server.form.CityForm;
import nicomed.tms.server.model.City;
import nicomed.tms.server.service.ICityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;

@RestController
@RequestMapping("/tms/api")
public class CityRestController {

    private final ICityService service;

    public CityRestController(ICityService service) {
        this.service = service;
    }

    @GetMapping("/city")
    public List<CityForm> getAllCities() {
        return service.findAllCities().stream()
                .map(CityForm::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<?> getCityByName(@PathVariable("name") String name) {
        City city = service.findCityByName(capitalize(name));
        if (city == null) {
            return new ResponseEntity<>("город не найден", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(CityForm.from(city), HttpStatus.OK);
    }

    @PostMapping(("/city"))
    public ResponseEntity<?> createCity(@RequestBody CityForm form) {
        if (service.createCity(CityForm.create(form))) {
            return new ResponseEntity<>("city created", HttpStatus.OK);
        }
        return new ResponseEntity<>("city creation failed", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<?> updateCity(@RequestBody CityForm form, @PathVariable("id") Long id) {
        City city = service.findCityById(id);
        if (city != null) {
            city.setName(form.getName());
            if (service.updateCity(city)) {
                return new ResponseEntity<>("city rename success", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(" city rename failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        if (service.removeCity(id)) {
            return new ResponseEntity<>("city removed", HttpStatus.OK);
        }
        return new ResponseEntity<>("city removing failed", HttpStatus.BAD_REQUEST);
    }
}
