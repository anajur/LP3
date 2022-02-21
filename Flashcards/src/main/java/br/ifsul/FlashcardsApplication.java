package br.ifsul;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.ifsul.repositories.CategoriaRepository;
import br.ifsul.repositories.FlashcardRepository;
import br.ifsul.ui.UICategoria;
import br.ifsul.ui.UIFlashcard;

@SpringBootApplication
public class FlashcardsApplication {

	@Autowired
	private FlashcardRepository flashcard;
	@Autowired
	CategoriaRepository categoria;

	public static void main(String[] args) {

		SpringApplicationBuilder sab = new SpringApplicationBuilder(FlashcardsApplication.class);
		sab.headless(false);
		ConfigurableApplicationContext cac = sab.run(args);

		FlashcardsApplication app = (FlashcardsApplication) cac.getBean("flashcardsApplication");

		//UIFlashcard ui = new UIFlashcard(app.categoria, app.flashcard);
		UICategoria x = new UICategoria();
		x.setVisible(true);
		/*
		 * SpringApplicationBuilder sab = new
		 * SpringApplicationBuilder(FlashcardsApplication.class); sab.headless(false);
		 * ConfigurableApplicationContext cac = sab.run(args);
		 * 
		 * FlashcardsApplication app = (FlashcardsApplication)
		 * cac.getBean("flashcardsApplication");
		 * 
		 * UITeste ui1 = new UITeste(); ui1.setVisible(true);
		 */
	}

}
