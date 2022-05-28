package learn.up.bookStore.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "order")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Client client;

    @Column
    private Long sum_price;
}
