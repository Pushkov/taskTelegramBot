package nicomed.tms.bot.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.client.RestTemplate;

@UtilityClass
public class Constants {
    public static final String COMMAND_PREFIX = "/";
    public static final String COMMAND_DELIMETR = "@";

     public  static  final RestTemplate REST_TEMPLATE = new RestTemplate();
}
