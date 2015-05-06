package com.inertia.solutions.apollo.item.mvc.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;
import com.inertia.solutions.apollo.item.mvc.domain.repository.ApolloItemHistoryRepositoryImpl;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService;

/**
 * Using JRE 1.7.0_75
 * 
 * The Class ApolloItemHistoryServiceImpl is the implementation for the basic service 
 * that updates items history graph. Notice the injection of the repository dependency. This is 
 * important since this will provide the abstraction layer between all items, though
 * for this exercise it is thin.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Service
public class ApolloItemHistoryServiceImpl implements ApolloItemHistoryService {

	@Autowired
	ApolloItemHistoryRepositoryImpl apolloItemHistoryRespository;

	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService#findAllApolloItemHistorysForItem(java.lang.String)
	 */
	@Override
	public List<ApolloItemHistory> findAllApolloItemHistorysForItem(String itemId) {
		return apolloItemHistoryRespository.findHistoryByItemId(itemId);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService#saveApolloItemHistory(com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory)
	 */
	@Override
	public ApolloItemHistory saveApolloItemHistory(ApolloItemHistory apolloItemHistory) {
		return apolloItemHistoryRespository.save(apolloItemHistory);
	}
	
	
}
