package nicomed.tms.server.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.partitioningBy;

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
        return "Не знаю такого города";
    }

    @Override
    public String getMessageText(String text) {
//        City city = service.findCityByName(text.toLowerCase());
//        log.info("dataCommand city -" + city);
//        if (city != null) {
//            return "\n" + getString(
//                    StringUtils.capitalize(text),
//                    service.findAllPlacesByCity(city).stream()
//                            .collect(partitioningBy(
//                                    v -> v.getGrade() == Grade.GOOD,
//                                    toList())));
//        }
        return "Не знаю такого города";
    }

}
