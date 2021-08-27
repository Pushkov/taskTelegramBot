package nicomed.tms.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import nicomed.tms.bot.datamodel.CityForm;
import nicomed.tms.bot.util.Constants;
import org.springframework.web.client.RestTemplate;

import static java.util.stream.Collectors.partitioningBy;
import static nicomed.tms.bot.util.Constants.REST_TEMPLATE;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class NonCommand extends BaseBotCommand {

    public NonCommand() {
        super("data", "получение информации о городе\n");
    }

    @Override
    public String getMessageText() {
        return "Ну не знаю такого города";
    }

    @Override
    public String getMessageText(String text) {
        String url = "http://localhost:8080/tms/api/city/" + text;
        CityForm result = REST_TEMPLATE.getForObject(url, CityForm.class);
        return result.toString();
    }
}
