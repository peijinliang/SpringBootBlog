package com.blog.service;

import java.util.List;

import com.blog.domain.Catalog;
import com.blog.domain.User;

/**
 * Catalog 服务接口.
 * 
 * @since 1.0.0 2017年4月10日
 * @author Marlon
 */
public interface CatalogService {

	/**
	 * 保存Catalog
	 * @param catalog
	 * @return
	 */
	Catalog saveCatalog(Catalog catalog);
	
	/**
	 * 删除Catalog
	 * @param id
	 * @return
	 */
	void removeCatalog(Long id);

	/**
	 * 根据id获取Catalog
	 * @param id
	 * @return
	 */
	Catalog getCatalogById(Long id);
	
	/**
	 * 获取Catalog列表
	 * @return
	 */
	List<Catalog> listCatalogs(User user);

}
