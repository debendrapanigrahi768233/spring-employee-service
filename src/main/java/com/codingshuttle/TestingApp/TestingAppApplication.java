package com.codingshuttle.TestingApp;

import com.codingshuttle.TestingApp.services.DataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@RequiredArgsConstructor
@SpringBootApplication
public class TestingAppApplication implements CommandLineRunner {
	@PostConstruct
	public void forceTimezone() {
		System.setProperty("user.timezone", "Asia/Kolkata");
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println("Timezone forced to Asia/Kolkata");
	}

//	private final DataService dataService;

	@Value("${my.variable}")
	private String myVariable;

	public static void main(String[] args) {
		SpringApplication.run(TestingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("my variable: "+myVariable);

//		System.out.println("The data is: "+dataService.getData());
	}
}
