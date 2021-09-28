import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.shohrab.service")

public class RootConfig {
	@Bean
	public com.shohrab.config.HibernateConfig hibernateConfig() {
		return new com.shohrab.config.HibernateConfig();
	}
}
