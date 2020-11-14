package com.app.dao;

import com.app.model.Registration;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired //avtomaticeski podtjagivaet object
    private JdbcTemplate jdbsTemplate;

    public void storeUser(Registration reg) {   //metod poluchaet objekt registration
        jdbsTemplate.update("INSERT INTO users (first_name, last_name, password, phone, card_nr, birth_date, email) VALUES(?, ?, ?, ?, ?, ?, ?)",    //update-proizvodit dejstvija s sql, zapolnjaem user i passw, ?-mi ewe ne znaem, chto tak budet vvoditsja
                reg.getFirstName(), reg.getLastName(), reg.getPassword(), reg.getPhone(), reg.getCardNr(), reg.getBirthDate(), reg.getEmail());
        //    reg.getFirstName(),reg.getLast_name(),reg.getPassword(), reg.getPhone(), reg.getCard_nr(),reg.getBirth_date());   //ukazivaem chto poluchaem, parametri
    }

    public List<User> getUsers() {
        RowMapper<User> rowMapper = (resultSet, rowNumber) -> mapUser(resultSet);
        return jdbsTemplate.query("SELECT * FROM users", rowMapper);
    }


    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setPassword(resultSet.getString("password"));
        user.setBirthDate(resultSet.getDate("birth_date"));
        user.setLastName(resultSet.getString("last_name"));
        user.setPhone(resultSet.getString("phone"));
        user.setCardNr(resultSet.getString("card_nr"));

        return user;
    }

    public List<User> getUsersByFirstName(String firstName) {
        RowMapper<User> rowMapper = (rs, rowNumber) -> mapUser(rs);  //rs-result set

        return jdbsTemplate.query("SELECT * FROM users WHERE email = ?", rowMapper, firstName);

    }

}
