package app.mysql.dao;

import app.mysql.dao.entity.OsobaMysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaMysqlRepo extends CrudRepository<OsobaMysql, Long> {

}