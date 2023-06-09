package th.ac.ku.kps.eng.cpe.soa.project.beautyspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("th.ac.ku.kps.eng.cpe.soa.project")
@EnableJpaRepositories("th.ac.ku.kps.eng.cpe.soa.project.repository")
public class BeautyspotApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BeautyspotApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return     builder.sources(BeautyspotApplication.class);
    }

}
