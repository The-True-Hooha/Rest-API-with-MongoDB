package com.TheTrueHooha.Rest.API.with.MongoDB;

import com.TheTrueHooha.Rest.API.with.MongoDB.Repository.StudentRepository;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Address;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Gender;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class RestApiWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWithMongoDbApplication.class, args);
	}


	@Bean
	CommandLineRunner runner (StudentRepository repository) {
		return args -> {
			Address address = new Address(
					"Warri",
					"Nigeria",
					"554500"
			);

			String email = "pg123@gmail.com";
			Student student = new Student(
					"Prince",
					"Goodluck",
					"pg123@gmail.com",
					Gender.MALE,
					address,
					List.of("Rice and Beans"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			//how to create new custom queries
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));


			repository.insert(student);
		};
	}
}
