package com.emp.model;

import java.util.*;

public interface Prd_CatalogDAO_interface {
          public void insert(Prd_CatalogVO prd_CatalogVO);
          public void update(Prd_CatalogVO prd_CatalogVO);
          public void delete(Integer id);
          public Prd_CatalogVO findByPrimaryKey(Integer id);
          public List<Prd_CatalogVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
