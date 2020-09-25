package cafe24.wio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WonioneApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(WonioneApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WonioneApplication.class, args);
		
		log.info("info level");
		log.debug("debug level");
		log.error("error level");
		
	}

}
