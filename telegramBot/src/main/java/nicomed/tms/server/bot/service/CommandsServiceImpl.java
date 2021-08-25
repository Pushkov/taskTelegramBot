package nicomed.tms.server.bot.service;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.server.bot.command.BadCommand;
import nicomed.tms.server.bot.command.BaseBotCommand;
import nicomed.tms.server.bot.util.Constants;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CommandsServiceImpl implements ICommandsService {

    private final Set<BaseBotCommand> commands;
    private final CommandParser parser;
    private BaseBotCommand defaultCommand;

    public CommandsServiceImpl() {
        this.parser = new CommandParser();
        commands = new HashSet<>();
        defaultCommand = null;
    }

    @Override
    public void register(BaseBotCommand command) {
        commands.add(command);
    }

    @Override
    public void remove(BaseBotCommand command) {
        commands.remove(command);
    }

    @Override
    public boolean isCommand(String text) {
        return text.stripLeading().startsWith(Constants.COMMAND_PREFIX);
    }

    @Override
    public BaseBotCommand get(String text) {
        if (isCommand(text)) {
            String commandString = parser.getCommand(text);
            return commands.stream()
                    .filter(c -> c.getCommand().equalsIgnoreCase(commandString))
                    .findFirst().orElse(new BadCommand());
        }
        return defaultCommand;
    }

    @Override
    public Set<String> info() {
        return commands.stream()
                .map(BotCommand::getCommand)
                .collect(Collectors.toSet());
    }

    @Override
    public void setDefaultCommand(BaseBotCommand command) {
        defaultCommand = command;
    }

    @Override
    public BaseBotCommand getDefaultCommand() {
        return defaultCommand;
    }
}
