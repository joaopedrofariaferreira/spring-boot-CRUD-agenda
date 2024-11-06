package crud.springbootexpert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfiguration {
    @Bean(name = "apllicationName")

    public String applicationName(){
        return "Sistema de vendas";
    }
}
