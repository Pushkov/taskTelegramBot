package nicomed.tms.server.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.tms.server.model.City;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityForm {
    private Long id;
    private String name;
    private List<PlaceForm> places;

    public static CityForm from(City city) {
        return CityForm.builder()
                .id(city.getId())
                .name(city.getName())
                .places(city.getPlaces().stream()
                        .map(PlaceForm::from)
                        .collect(Collectors.toList()))
                .build();
    }

}
