package lk.easycar.rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.PropertySource;
>>>>>>> 73bbd27... SiginUp
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.easycar.rental")
@EnableWebMvc
<<<<<<< HEAD
=======
@PropertySource("classpath:app.properties")
>>>>>>> 73bbd27... SiginUp
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
