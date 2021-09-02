package nicomed.tms.bot;

import lombok.extern.slf4j.Slf4j;
import nicomed.tms.bot.command.*;
import nicomed.tms.bot.service.CommandsServiceImpl;
import nicomed.tms.bot.service.ICommandsService;
import nicomed.tms.bot.util.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class NicomedLongPullingBot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final ICommandsService commandsService;

    public NicomedLongPullingBot(BotConfig config) {
        this.config = config;
        commandsService = new CommandsServiceImpl();
        initCommands();
    }

    private void initCommands() {
        commandsService.setDefaultCommand(new NonCommand(config));
        commandsService.register(new StartCommand());
        commandsService.register(new InfoCommand());
        commandsService.register(new HelpCommand(commandsService));
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            if (update.getMessage() != null && update.getMessage().hasText()) {
                Message receivedMessage = update.getMessage();
                String receivedText = receivedMessage.getText();
                String chatId = receivedMessage.getChatId().toString();
                log.info("received text: " + receivedText);
                BaseBotCommand command = commandsService.isCommand(receivedText) ? commandsService.get(receivedText) : commandsService.getDefaultCommand();
                log.info("command -" + command.getCommand());
                sendMessage(new SendMessage(
                        chatId,
                        command.getMessageText(receivedText)));
            }
        } else if (update.hasCallbackQuery()) {

        }
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
