package nicomed.tms.server.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class InfoCommand extends BaseBotCommand {

    public InfoCommand() {
        super("info", "информация о приложении\n");
    }

    @Override
    public String getMessageText() {
        return "Список доступных городов\n";
//                + service.findAllCities().stream()
//                .map(City::getName)
//                .map(StringUtils::capitalize)
//                .collect(Collectors.joining(",\n"));
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
