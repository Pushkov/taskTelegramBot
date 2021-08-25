package nicomed.tms.bot.service;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.bot.util.Constants;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class CommandParser {

    @Value("${bot.name}")
    private String NAME;

    public boolean isCommand(String text) {
        return text.strip().startsWith(Constants.COMMAND_PREFIX);
    }

    private String getCommandFullText(String text) {
        return text.strip().split(" ")[0].substring(1);
    }

    public boolean isCommandForMe(String text, String chatType) {
        String commandText = getCommandFullText(text);
        if (commandText.contains(Constants.COMMAND_DELIMETR)) {
            String nameFromCommand = commandText.substring(commandText.indexOf(Constants.COMMAND_DELIMETR) + 1);
            return NAME.equalsIgnoreCase(nameFromCommand);
        } else {
            return "private".equalsIgnoreCase(chatType);
        }
    }

    public String getCommand(String text) {
        return getCommandFullText(text).split(Constants.COMMAND_DELIMETR)[0].toUpperCase();
    }


}
