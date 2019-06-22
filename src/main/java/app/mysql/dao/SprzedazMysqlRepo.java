package app.mysql.dao;

import app.mysql.dao.entity.SprzedazMysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprzedazMysqlRepo extends CrudRepository<SprzedazMysql, Long> {
}
