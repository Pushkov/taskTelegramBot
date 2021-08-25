package nicomed.tms.server.rest;

import nicomed.tms.server.form.CityForm;
import nicomed.tms.server.model.City;
import nicomed.tms.server.service.IDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tms/api")
public class CityRestController {

    private final IDataService service;

    public CityRestController(IDataService service) {
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
        City city = service.findCityByName(name);
        if (city == null) {
            return new ResponseEntity<>("город не найден",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(CityForm.from(city), HttpStatus.OK);
    }

}
