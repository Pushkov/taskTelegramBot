package nicomed.tms.server.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.tms.server.model.City;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;

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

    public static City create(CityForm form) {
        return City.builder()
                .name(capitalize(form.getName()))
                .places(new ArrayList<>())
                .build();
    }

}
