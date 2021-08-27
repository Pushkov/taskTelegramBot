package nicomed.tms.bot.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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
        String goodPrefix = " - Рекомендуем к посещению:\n";
        String badPrefix = " - Не заслуживает внимания:\n";
        String suffix = ".\n";
        String good = getStringByGrade("GOOD");
        String bad = getStringByGrade("BAD");
        if (!good.isEmpty()) {
            good = goodPrefix + good + suffix;
        }
        if (!bad.isEmpty()) {
            bad = badPrefix + bad + suffix;
        }
        return capitalize(name) + suffix + good + bad;
    }

    private String getStringByGrade(String grade) {
        return places.stream()
                .filter(placeForm -> placeForm.getGrade().equalsIgnoreCase(grade))
                .map(PlaceForm::getName)
                .collect(Collectors.joining(",\n"));
    }
}
