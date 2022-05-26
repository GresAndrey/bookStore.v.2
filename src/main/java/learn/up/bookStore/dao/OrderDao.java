package learn.up.bookStore.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class OrderDao {

    private ArrayList<Book> list = new ArrayList<>();

    public void putBookInBusket(Book book) {
        list.add(book);
        System.out.println("Вы положили в корзину книгу: " + book.getName());
    }

    public void lookInBusket() {
        System.out.println("В вашей корзине лежат следующие книги:" + "\n");
        for (Object book : list) {
            System.out.println(book);
        }
    }

    public  void buyBusket() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).getPrice();
        }
        Orders orders = Orders.builder()
                .count_book(list.size())
                .price(sum)
                .build();
        save(orders);
        System.out.println("Вы купили книги");
    }

    private static final String FIND_BY_ID = "select * from books.orders where id = :id";

    private static final String SAVE = "insert into books.orders (count_book, price) " +
            "values(:count_book, :price)";

    private static final String DELETE = "delete from books.orders customer WHERE id = :id";

    private final NamedParameterJdbcTemplate template;

    public OrderDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Orders order) {
        template.update(
                SAVE,
                new MapSqlParameterSource()
                        .addValue("count_book", order.getCount_book())
                        .addValue("price", order.getPrice())
        );
    }

    public Optional<Orders> findById(long id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Orders.builder()
                                .id(rs.getLong("id"))
                                .count_book(rs.getInt("count_book"))
                                .price(rs.getInt("price"))
                                .build()
                ).stream()
                .findAny();
    }

    public void delete(Orders order) {
        long id = order.getId();
        template.update(DELETE, new MapSqlParameterSource("id", id));
    }
}
