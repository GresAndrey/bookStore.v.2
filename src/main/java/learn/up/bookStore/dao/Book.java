package learn.up.bookStore.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Long id;
    private String book;
    private String author;
    private int price;
}
