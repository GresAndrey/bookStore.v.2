package learn.up.bookStore.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "orders")
@Getter
@Setter
@RequiredArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Client client;

    @Column
    private Long sum_price;
}
