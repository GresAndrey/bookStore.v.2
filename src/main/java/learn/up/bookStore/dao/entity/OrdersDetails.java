package learn.up.bookStore.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrdersDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column
    private int count;

    @Column
    private int price;

    @OneToOne
    @JoinColumn
    private Orders orders;

    @OneToOne
    @JoinColumn
    private Book book;


}
