package learn.up.bookStore.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "bookWarehouse")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book;

    @Column
    private Long count_book;

}
