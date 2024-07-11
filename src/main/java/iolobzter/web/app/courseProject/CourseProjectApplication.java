package iolobzter.web.app.courseProject;

import iolobzter.web.app.courseProject.entity.Book;
import iolobzter.web.app.courseProject.entity.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseProjectApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CourseProjectApplication.class, args);
	}
}
