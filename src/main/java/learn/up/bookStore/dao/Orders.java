package learn.up.bookStore.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Orders {
    private long id;
    private int count_book;
    private int price;
}
