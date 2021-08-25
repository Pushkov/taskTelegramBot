package nicomed.tms.bot.datamodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityForm {
    private Long id;
    private String name;
    private List<PlaceForm> places;

    @Override
    public String toString() {
        String good = places.stream()
                .filter(placeForm -> placeForm.getGrade().equalsIgnoreCase("good"))
                .map(PlaceForm::getName)
        .collect(Collectors.joining(",\n"));
        String bad = places.stream()
                .filter(placeForm -> placeForm.getGrade().equalsIgnoreCase("bad"))
                .map(PlaceForm::getName)
                .collect(Collectors.joining(",\n"));
        return capitalize(name) + ".\n Рекомендуем к посещению:\n" + good + ".\n Не заслуживают внимания:\n" + bad + ".";
    }
}
