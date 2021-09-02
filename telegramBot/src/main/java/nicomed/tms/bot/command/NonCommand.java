package nicomed.tms.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import nicomed.tms.bot.datamodel.CityForm;
import nicomed.tms.bot.util.BotConfig;

import static java.util.Objects.requireNonNull;
import static nicomed.tms.bot.util.Constants.REST_TEMPLATE;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class NonCommand extends BaseBotCommand {
    private final String URL_COMMAND = "/api/city/";
    private final BotConfig config;

    public NonCommand(BotConfig config) {
        super("data", "получение информации о городе\n");
        this.config = config;
    }

    @Override
    public String getMessageText() {
        return "Ну не знаю такого города";
    }

    @Override
    public String getMessageText(String text) {
        String url = config.getUrl_base() + URL_COMMAND + text;
        String resultMessage;
        try {
            CityForm result = REST_TEMPLATE.getForObject(url, CityForm.class);
            resultMessage = requireNonNull(result).toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            resultMessage = getMessageText();
        }
        return resultMessage;
    }

}
