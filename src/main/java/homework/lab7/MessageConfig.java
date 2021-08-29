package homework.lab7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */

@Configuration
@PropertySource("classpath:channels.properties")
@ComponentScan(basePackages = "homework.lab7")
public class MessageConfig {

}
