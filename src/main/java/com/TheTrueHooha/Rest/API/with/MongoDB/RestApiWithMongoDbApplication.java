package com.TheTrueHooha.Rest.API.with.MongoDB;

import com.TheTrueHooha.Rest.API.with.MongoDB.Repository.StudentRepository;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Address;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Gender;
import com.TheTrueHooha.Rest.API.with.MongoDB.User.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
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
	CommandLineRunner runner (
			StudentRepository repository, MongoTemplate mongoTemplate) {
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


			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println(s + "already exists");

					}, () -> {
						System.out.println("inserting student, calm down abeg" + student);
						repository.insert(student);
					});

		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		//how to create new custom queries
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List <Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 1) {
			throw new IllegalStateException("email used by another user" + email);
		}

		if (students.isEmpty()) {

			System.out.println("inserting user" + student);
			repository.insert(student);
		} else {
			System.out.println(student + "already exist");
		}
	}
}
