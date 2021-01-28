package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.HashMap;

@Repository
public class LangDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HashMap<String, String > getTranslations(int langId, String page){
    return jdbcTemplate.query("SELECT key, translation FROM translations WHERE lang_id = ? AND page = ? or lang_id = ? AND page = 'all'",
            (ResultSet resultSet) -> {
                 HashMap<String, String > result = new HashMap<>();

                  while(resultSet.next()){
            result.put(resultSet.getString("key"), resultSet.getString("translation"));
        }

             return result;
        }, langId, page, langId); //sql, chto mi delaem s rezultatom (kostrukcija ljamdi) , parametr
    }




}
