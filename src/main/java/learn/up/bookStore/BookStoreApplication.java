package learn.up.bookStore;

import learn.up.bookStore.dao.Book;
import learn.up.bookStore.dao.BookDao;
import learn.up.bookStore.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(BookStoreApplication.class, args);

		BookDao book = context.getBean(BookDao.class);
		OrderDao order = context.getBean(OrderDao.class);
		Book book1 = Book.builder()
				.name("Война и мудаки")
				.price(2000)
				.author_id(2)
				.build();
		Book book2 = Book.builder()
				.name("Война и мудаки")
				.price(2000)
				.author_id(2)
				.build();
		Book book3 = Book.builder()
				.name("Война и мудаки")
				.price(2000)
				.author_id(2)
				.build();
		Book book4 = Book.builder()
				.name("Война и мудаки")
				.price(2000)
				.author_id(2)
				.build();

		order.putBookInBusket(book1);
		order.putBookInBusket(book2);
		order.putBookInBusket(book3);
		order.putBookInBusket(book4);

		order.lookInBusket();

		order.buyBusket();

	}

}
