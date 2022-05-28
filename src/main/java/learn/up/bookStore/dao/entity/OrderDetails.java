package learn.up.bookStore.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orderDetails")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderDetails {

    @Id
    private Long id;

    @OneToOne
    private Order order;

    @OneToMany
    private List<Book> books;

    @Column
    private Long count_purchase;

    @Column
    private Long price;
}
