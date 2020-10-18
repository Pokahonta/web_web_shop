package com.app.dao;

import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CatalogDao {

    @Autowired
    private JdbcTemplate jdbsTemplate;

 public List<Product> getProduct(){
     RowMapper<Product> rowMapper = (resultSet, rowNumber) -> mapCatalog(resultSet);
    return jdbsTemplate.query("SELECT * FROM catalog", rowMapper);
    }

    private Product mapCatalog(ResultSet resultSet) throws SQLException {
        Product catalog = new Product();

        catalog.setId(resultSet.getInt("id"));
        catalog.setName(resultSet.getString("name"));
        catalog.setDescription(resultSet.getString("description"));
        catalog.setManufacturerId(resultSet.getInt("manufacture_id"));
        catalog.setSubTypeId(resultSet.getInt("sub_type_id"));
        catalog.setPrice(resultSet.getDouble("price"));

        return catalog;
    }

}
