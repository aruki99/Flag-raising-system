package Flag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("Flag.lesson01")
public class FlagApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlagApplication.class, args);
    }

}
