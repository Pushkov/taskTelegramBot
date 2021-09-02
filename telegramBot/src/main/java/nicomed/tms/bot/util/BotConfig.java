package nicomed.tms.bot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class BotConfig {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String userName;
    @Value("${bot.name}")
    private String name;
    @Value("${backend.url_based}")
    private String url_base;
}
