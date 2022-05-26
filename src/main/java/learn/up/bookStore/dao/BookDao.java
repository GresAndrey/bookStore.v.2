package learn.up.bookStore.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookDao {
    private static final String FIND_BY_ID = "select * from books.books where id = :id";

    private static final String SAVE = "insert into books.books (name, price, author_id) " +
            "values(:name, :price, :author_id)";

    private static final String DELETE = "delete from books.books customer WHERE id = :id";

    private final NamedParameterJdbcTemplate template;

    public BookDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Book book) {
        template.update(
                SAVE,
                new MapSqlParameterSource()
                        .addValue("name", book.getName())
                        .addValue("price", book.getPrice())
                        .addValue("author_id", book.getAuthor_id())
        );
    }

    public Optional<Book> findById(long id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Book.builder()
                                .id(rs.getLong("id"))
                                .name(rs.getString("name"))
                                .price(rs.getInt("price"))
                                .author_id(rs.getInt("author_id"))
                                .build()
                ).stream()
                .findAny();
    }

    public void delete(Book book) {
        long id = book.getAuthor_id();
        template.update(DELETE, new MapSqlParameterSource("id", id));
    }
}
