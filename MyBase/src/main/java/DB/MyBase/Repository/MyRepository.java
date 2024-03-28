package DB.MyBase.Repository;

import DB.MyBase.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyRepository {

    @Autowired
    private final JdbcTemplate jdbc;

    MyRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }

    public List<Person> showData(){

        String sql="select * from person";

        RowMapper<Person> personRowMapper=(r,i)->{
            Person rowPerson=new Person();
            rowPerson.setId(r.getInt("id"));
            rowPerson.setName(r.getString("name"));
            rowPerson.setBalance(r.getInt("balance"));
            return rowPerson;
        };

        return jdbc.query(sql, personRowMapper);
    }


}
