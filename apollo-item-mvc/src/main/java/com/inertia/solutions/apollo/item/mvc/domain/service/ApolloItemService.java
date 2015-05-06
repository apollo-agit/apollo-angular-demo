/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.service;

import java.util.List;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;

/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ApolloItemService. This service is an abstraction between the data
 * repository and the end front end (probably controller).
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ApolloItemService {
	
	/**
	 * Find all items.
	 *
	 * @return the list of Items returned
	 */
	public List<ApolloItem> findAllApolloItems();
	
	/**
	 * Save apollo item.
	 *
	 * @param apolloItem the apollo item
	 * @return the persisted apollo item
	 */
	public ApolloItem saveApolloItem(ApolloItem apolloItem);
	
	/**
	 * Delete apollo item.
	 *
	 * @param apolloItem the apollo item
	 */
	public void deleteApolloItem(ApolloItem apolloItem);
	
	/**
	 * Delete apollo item.
	 *
	 * @param id the id
	 */
	public void deleteApolloItem(String id);

}
