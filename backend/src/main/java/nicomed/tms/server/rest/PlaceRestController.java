package nicomed.tms.server.rest;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.server.form.PlaceForm;
import nicomed.tms.server.model.City;
import nicomed.tms.server.model.Place;
import nicomed.tms.server.service.ICityService;
import nicomed.tms.server.service.IPlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static nicomed.tms.server.enums.Grade.valueOf;

@Slf4j
@RestController
@RequestMapping("/tms/api")
public class PlaceRestController {

    private final IPlaceService service;
    private final ICityService cityService;

    public PlaceRestController(IPlaceService service, ICityService cityService) {
        this.service = service;
        this.cityService = cityService;
    }

    @GetMapping("/place")
    public List<PlaceForm> getAllPlaces() {
        log.info("places all");
        return service.findAllPlaces()
                .stream()
                .map(PlaceForm::from)
                .collect(toList());
    }

    @GetMapping("/place/{name}")
    public ResponseEntity<?> getPlaceByName(@PathVariable("name") String name) {
        Place place = service.findPlaceByName(name);
        if (place == null) {
            return new ResponseEntity<>("место не найден", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(PlaceForm.from(place), HttpStatus.OK);
    }

    @PostMapping(("/place"))
    public ResponseEntity<?> createPlace(@RequestBody PlaceForm form) {
        City city = cityService.findCityByName(form.getCity());
        if (city != null) {
            Place place = Place.builder()
                    .city(city)
                    .name(form.getName())
                    .grade(valueOf(form.getGrade()))
                    .build();
            if (service.createPlace(place)) {
                return new ResponseEntity<>("place created", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("place creation failed", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/place/{id}")
    public ResponseEntity<?> updatePlace(@RequestBody PlaceForm form, @PathVariable("id") Long id) {
        City city = cityService.findCityByName(form.getCity());
        Place place = service.findPlaceById(id);
        if ( place != null && city != null) {
             place.setCity(city);
             place.setName(form.getName());
             place.setGrade(valueOf(form.getGrade()));
            if (service.createPlace(place)) {
                return new ResponseEntity<>("place updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("place update failed", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        if (service.removePlace(id)) {
            return new ResponseEntity<>("place removed", HttpStatus.OK);
        }
        return new ResponseEntity<>("place removing failed", HttpStatus.BAD_REQUEST);
    }

}
