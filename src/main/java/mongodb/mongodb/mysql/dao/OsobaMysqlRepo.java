package mongodb.mongodb.mysql.dao;

import mongodb.mongodb.mysql.dao.entity.OsobaMysql;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OsobaMysqlRepo extends CrudRepository<OsobaMysql, Long> {

}