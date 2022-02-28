package com.spring.demospring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.demospring.entity.UserEntity;
import com.spring.demospring.repository.UserRepository;

@ComponentScan(basePackages = "com.spring.demospring,com.spring.demospring.repository")
@EnableJpaRepositories
@SpringBootApplication
public class DemoSpringApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
		return () -> {

			UserEntity userExample = new UserEntity();
			//(1, 'Sara', 'Cifola', 'sara.cifola@gmail.com', 'demo', 'via Milano'), 
			userExample.setId(Long.valueOf(1));
			userExample.setName("Sara");
			userExample.setSurname("Cifola");
			userExample.setEmail("sara.cifola@gmail.com");
			userExample.setAddress("via Milano");
			userExample.setPassword("demo");
			userRepository.save(userExample);
			//(2, 'Valentina', 'Rossi', 'valentina.rossi@gmail.com', 'demo', 'via Padova'), 
			userExample.setId(Long.valueOf(2));
			userExample.setName("Valentina");
			userExample.setSurname("Rossi");
			userExample.setEmail("valentina.rossi@gmail.com");
			userExample.setAddress("via Padova");
			userExample.setPassword("demo");
			userRepository.save(userExample);
			//(3, 'Marco', 'Bianchi', 'marco.bianchi@gmail.com', 'demo', 'via Roma'), 
			userExample.setId(Long.valueOf(3));
			userExample.setName("Marco");
			userExample.setSurname("Bianchi");
			userExample.setEmail("marco.bianchi@gmail.com");
			userExample.setAddress("via Roma");
			userExample.setPassword("demo");
			userRepository.save(userExample);
			//(4, 'Andrea', 'Rossi', 'andrea.rossi@gmail.com', 'demo', 'via Ancona'), 
			userExample.setId(Long.valueOf(4));
			userExample.setName("Andrea");
			userExample.setSurname("Rossi");
			userExample.setEmail("andrea.rossi@gmail.com");
			userExample.setAddress("via Ancona");
			userExample.setPassword("demo");
			userRepository.save(userExample);
			//(5, 'Elena', 'Neri', 'elena.neri@gmail.com', 'demo', 'via Bologna'), 
			userExample.setId(Long.valueOf(5));
			userExample.setName("Elena");
			userExample.setSurname("Neri");
			userExample.setEmail("elena.neri@gmail.com");
			userExample.setAddress("via Bologna");
			userExample.setPassword("demo");
			userRepository.save(userExample);
			//(6, 'Sara', 'Bosco', 'sara.bosco@email.com', 'demo', 'via Roma');
			userExample.setId(Long.valueOf(6));
			userExample.setName("Sara");
			userExample.setSurname("Bosco");
			userExample.setEmail("sara.bosco@email.com");
			userExample.setAddress("via Roma");
			userExample.setPassword("demo");
			userRepository.save(userExample);			

		};
	}

}