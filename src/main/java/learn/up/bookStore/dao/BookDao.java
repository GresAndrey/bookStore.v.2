package learn.up.bookStore.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookDao {

    private static final String FIND_BY_ID = "select * from books.books where id = :id";

    private static final String SAVE = "" +
            "insert into books.books (book, author, price) " +
            "values(:book, :author, :price)";

    private final NamedParameterJdbcTemplate template;

    public BookDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Book book) {
        template.update(
                SAVE,
                new MapSqlParameterSource()
                        .addValue("book", book.getBook())
                        .addValue("author", book.getAuthor())
                        .addValue("price", book.getPrice())
        );
    }

    public Optional<Book> findById(long id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Book.builder()
                                .id(rs.getLong("id"))
                                .book(rs.getString("book"))
                                .author(rs.getString("author"))
                                .price(rs.getInt("price"))
                                .build()
                ).stream()
                .findAny();
    }

}
