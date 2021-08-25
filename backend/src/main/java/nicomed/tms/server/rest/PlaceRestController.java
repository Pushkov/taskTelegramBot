package nicomed.tms.server.rest;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.server.form.PlaceForm;
import nicomed.tms.server.model.Place;
import nicomed.tms.server.service.IDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequestMapping("/tms/api")
public class PlaceRestController {

    private final IDataService service;

    public PlaceRestController(IDataService service) {
        this.service = service;
    }

    @GetMapping("/place")
    public List<PlaceForm> getAllPlaces() {
        log.info("places all");
        return service.findAllPlaces()
                .stream()
                .map(PlaceForm::from)
                .collect(toList());
    }
}
