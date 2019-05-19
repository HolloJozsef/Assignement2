package ro.utcn.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.utcn.springbootdemo.entities.Order;
import ro.utcn.springbootdemo.repository.OrderRepository;
import ro.utcn.springbootdemo.service.CsvFileWriter;

import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);

	}

}

