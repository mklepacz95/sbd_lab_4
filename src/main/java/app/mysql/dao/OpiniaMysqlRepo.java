package app.mysql.dao;

import app.mysql.dao.entity.OpiniaMysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpiniaMysqlRepo extends CrudRepository<OpiniaMysql, Long> {
}
