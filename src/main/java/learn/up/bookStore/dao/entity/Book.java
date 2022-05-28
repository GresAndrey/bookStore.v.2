package learn.up.bookStore.dao.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "book")
@Getter
@Setter
@ToString(exclude = {"author"})
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name_book;

    @Column
    private LocalDate release;

    @Column
    private Long book_pages;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    private Author author;

    @OneToOne(optional = false)
    private BookWarehouse bookWarehouse;

    public BookWarehouse getBookWarehouse() {
        return bookWarehouse;
    }

    public void setBookWarehouse(BookWarehouse bookWarehouse) {
        this.bookWarehouse = bookWarehouse;
    }
}
