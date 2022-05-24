package learn.up.bookStore;

import learn.up.bookStore.dao.Book;
import learn.up.bookStore.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BookStoreApplication.class, args);

		System.out.println("Hello world!");
		BookDao bean = context.getBean(BookDao.class);
		Optional<Book> war = bean.findById(1);
		log.info("{}", war);
		Book newBook = Book.builder()
				.book("Ебланы")
				.author("Хуесос")
				.price(20000)
				.build();
		bean.save(newBook);
		log.info("{}", bean.findById(2));

	}

}
