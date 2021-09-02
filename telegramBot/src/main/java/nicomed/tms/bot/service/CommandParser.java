package nicomed.tms.bot.service;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.bot.util.Constants;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class CommandParser {

    private String getCommandFullText(String text) {
        return text.strip().split(" ")[0].substring(1);
    }

    public String getCommand(String text) {
        return getCommandFullText(text).split(Constants.COMMAND_DELIMETR)[0].toUpperCase();
    }


}
