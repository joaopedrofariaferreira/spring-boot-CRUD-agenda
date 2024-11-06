package crud.springbootexpert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootExpertApplication {

    @Autowired
    @Qualifier("apllicationName")
    private String apllicationName;

    @GetMapping("/heloo")
    public String helloWorld(){
        return apllicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExpertApplication.class, args);
    }

}
