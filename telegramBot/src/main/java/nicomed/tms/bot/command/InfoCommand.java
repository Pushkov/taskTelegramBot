package nicomed.tms.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import nicomed.tms.bot.datamodel.CityForm;
import nicomed.tms.bot.datamodel.PlaceForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static nicomed.tms.bot.util.Constants.REST_TEMPLATE;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InfoCommand extends BaseBotCommand {

    public InfoCommand() {
        super("info", "информация о приложении\n");
    }

    @Override
    public String getMessageText() {
        String url = "http://localhost:8080/tms/api/city";

        ResponseEntity<CityForm[]> responseEntity =
        REST_TEMPLATE.getForEntity(
                url,
                CityForm[].class );
        List<CityForm> list = Arrays.asList(requireNonNull(responseEntity.getBody()));

        return "Список доступных городов\n"
                + list.stream()
                .map(CityForm::getName)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(",\n"));
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
