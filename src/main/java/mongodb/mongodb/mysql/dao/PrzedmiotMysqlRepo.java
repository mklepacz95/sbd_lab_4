package mongodb.mongodb.mysql.dao;

import mongodb.mongodb.mysql.dao.entity.PrzedmiotMysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzedmiotMysqlRepo extends CrudRepository<PrzedmiotMysql, Long> {
}
