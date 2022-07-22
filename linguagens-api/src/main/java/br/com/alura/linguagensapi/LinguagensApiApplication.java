package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LinguagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinguagensApiApplication.class, args);
	}

	@Bean
	public List<Linguagem> returnLinguagens() {
		String urlJava = "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png";
		String urlPhp = "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png";

		Linguagem java = new Linguagem("Java", urlJava, 1);
		Linguagem php = new Linguagem("PHP", urlPhp, 2);
		return List.of(java, php);
	}

}
