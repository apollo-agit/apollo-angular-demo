package com.inertia.solutions.apollo.item.mvc.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;

/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ApolloItemHistoryService is the service interface abstraction for 
 * any data integration with the data repository provided by the base input point such
 * as a controller.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ApolloItemHistoryService {

	/**
	 * Find all apollo item historys for item.
	 *
	 * @param itemId the item id
	 * @return the list
	 */
	public List<ApolloItemHistory> findAllApolloItemHistorysForItem(String itemId);
	
	
	/**
	 * Save apollo item history.
	 *
	 * @param apolloItemHistory the apollo item history
	 * @return the persisted apollo item history record
	 */
	public ApolloItemHistory saveApolloItemHistory(ApolloItemHistory apolloItemHistory);
	
}
