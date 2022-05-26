package learn.up.bookStore.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorDao {
    private static final String FIND_BY_ID = "select * from books.author where id = :id";

    private static final String SAVE = "insert into books.author (name, sureName) " +
            "values(:name, :sureName)";

    private static final String DELETE = "delete from books.author customer WHERE id = :id";

    private final NamedParameterJdbcTemplate template;

    public AuthorDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Author author) {
        template.update(
                SAVE,
                new MapSqlParameterSource()
                        .addValue("name", author.getName())
                        .addValue("sureName", author.getSureName())
        );
    }

    public Optional<Author> findById(long id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Author.builder()
                                .id(rs.getLong("id"))
                                .name(rs.getString("name"))
                                .sureName(rs.getString("sureName"))
                                .build()
                ).stream()
                .findAny();
    }

    public void delete(Author author) {
        long id = author.getId();
        template.update(DELETE, new MapSqlParameterSource("id", id));
    }
}
