package in.co.tradebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages={"in.co.tradecart.entities"})
public class TradeBookApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TradeBookApplication.class, args);
	}

}
