package learn.up.bookStore.dao.repository;

import learn.up.bookStore.dao.entity.BookWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {
}
