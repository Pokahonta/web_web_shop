package com.app.dao;

import com.app.model.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CatalogDao {

 @Autowired
 private JdbcTemplate jdbcTemplate;

 public List<CatalogItem> getItems(){
     RowMapper<CatalogItem> rowMapper = (resultSet, rowNumber) -> mapCatalogItem(resultSet);
     return jdbcTemplate.query("SELECT catalog.id AS cat_id, sub_type.type_id AS type_id, catalog.sub_type_id AS sub_type_id," +
             "sub_type.name AS sub_type_name, catalog.name AS name, type.name AS type_name, catalog.description, catalog.price FROM catalog " +
             "INNER JOIN sub_type ON catalog.sub_type_id = sub_type.id " +
             "INNER JOIN type ON sub_type.type_id = type.id", rowMapper);


 }

    private CatalogItem mapCatalogItem(ResultSet resultSet) throws SQLException {
        CatalogItem item = new CatalogItem();
        item.setId(resultSet.getInt("cat_id"));
        item.setTypeId(resultSet.getInt("type_id"));
        item.setSubTypeId(resultSet.getInt("sub_type_id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setTypeName(resultSet.getString("type_name"));
        item.setSubTypeName(resultSet.getString("sub_type_name"));
        item.setPrice(resultSet.getDouble("price"));
        return item;

    }



// public List<Product> getProduct(){
 //    RowMapper<Product> rowMapper = (resultSet, rowNumber) -> mapCatalog(resultSet);
//    return jdbcTemplate.query("SELECT catalog.id, catalog.name, catalog.description, catalog.sub_type_id, " +
 //           "catalog.manufacturer_id, catalog.price " +
 //           "FROM catalog " +
 //           "LEFT JOIN sub_type ON catalog.sub_type_id = sub_type.id " +
//            "LEFT JOIN manufacturers ON manufacturers.id = catalog.manufacturer_id", rowMapper);
//    }

 //   private Product mapCatalog(ResultSet resultSet) throws SQLException {
 //       Product catalog = new Product();

   //     catalog.setId(resultSet.getInt("id"));
     //   catalog.setName(resultSet.getString("name"));
    //    catalog.setDescription(resultSet.getString("description"));
      //  catalog.setManufacturerId(resultSet.getInt("manufacturer_id"));
     //   catalog.setSubTypeId(resultSet.getInt("sub_type_id"));
     //   catalog.setPrice(resultSet.getDouble("price"));

      //  return catalog;
  //  }

}
