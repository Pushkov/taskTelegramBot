package nicomed.tms.server.bot.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BadCommand extends BaseBotCommand {

    public BadCommand() {
        super("bad", "ошибка распознавания команды\n");
    }

    @Override
    public String getMessageText() {
        return "Команда не распознана";
    }

    @Override
    public String getMessageText(String text) {
        return getMessageText();
    }


}
