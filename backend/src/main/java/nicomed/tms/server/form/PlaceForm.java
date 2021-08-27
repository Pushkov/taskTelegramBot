package nicomed.tms.server.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.tms.server.model.Place;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceForm {
    private Long id;
    private String name;
    private String city;
    private String grade;

    public static PlaceForm from(Place place) {
        return PlaceForm.builder()
                .id(place.getId())
                .name(place.getName())
                .city(capitalize(place.getCity().getName()))
                .grade(place.getGrade().name())
                .build();
    }
}
