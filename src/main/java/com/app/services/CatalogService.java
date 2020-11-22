package com.app.services;

import com.app.dao.CatalogDao;
import com.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.Catalog;
import java.util.List;

@Service
public class CatalogService {
    public List<Product> getAllProduct(){return catalogDao.getProduct(); }

    @Autowired
    private CatalogDao catalogDao;

    public List<Product> getProduct(){
    return catalogDao.getProduct();


    }
}
