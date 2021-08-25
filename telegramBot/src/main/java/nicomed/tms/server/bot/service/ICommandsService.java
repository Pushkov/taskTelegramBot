package nicomed.tms.server.bot.service;

import nicomed.tms.server.bot.command.BaseBotCommand;

import java.util.Set;

public interface ICommandsService {
    void register(BaseBotCommand command);

    void remove(BaseBotCommand command);

    boolean isCommand(String text);

    BaseBotCommand get(String command);

    Set<String> info();

    void setDefaultCommand(BaseBotCommand command);

    BaseBotCommand getDefaultCommand();
}
