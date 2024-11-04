package com.emp.model;

import java.util.List;

public class Prd_CatalogService {

	private Prd_CatalogDAO_interface dao;

	public Prd_CatalogService() {
		dao = new Prd_CatalogJDBCDAO();
	}

	public Prd_CatalogVO addPrd_Catalog(String name){  
			 

		Prd_CatalogVO prd_CatalogVO = new Prd_CatalogVO();

		prd_CatalogVO.setName(name);
		dao.insert(prd_CatalogVO);

		return prd_CatalogVO;
	}

	public Prd_CatalogVO updatePrd_Catalog(Integer id, String name){

		Prd_CatalogVO prd_CatalogVO = new Prd_CatalogVO();

		prd_CatalogVO.setId(id);
		prd_CatalogVO.setName(name);
		
		dao.update(prd_CatalogVO);

		return prd_CatalogVO;
	}

	public void deletePrd_Catalog(Integer id) {
		dao.delete(id);
	}

	public Prd_CatalogVO getOnePrd_Catalog(Integer id) {
		return dao.findByPrimaryKey(id);
	}

	public List<Prd_CatalogVO> getAll() {
		return dao.getAll();
	}
}
