package pl.kupczyk.covidclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kupczyk.covidclient.api.CovidService;

@SpringBootApplication
public class CovidClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidClientApplication.class, args);

		CovidService service = new CovidService();
		System.out.print(service.downloadData().getData().get(0).getConfirmed());
	}
}
