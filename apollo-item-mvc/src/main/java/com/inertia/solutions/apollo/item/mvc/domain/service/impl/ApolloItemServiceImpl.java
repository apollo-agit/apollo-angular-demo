/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;
import com.inertia.solutions.apollo.item.mvc.domain.repository.ApolloItemRepositoryImpl;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService;


/**
 * Using JRE 1.7.0_75
 * 
 * The Class ApolloItemServiceImpl is the implementation for the basic service 
 * that updates items. Notice the injection of the repository dependency. This is 
 * important since this will provide the abstraction layer between all items, though
 * for this exercise it is thin.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Service
public class ApolloItemServiceImpl implements ApolloItemService {

	@Autowired
	ApolloItemRepositoryImpl apolloItemRepository;
	
	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService#findAllApolloItems()
	 */
	@Override
	public List<ApolloItem> findAllApolloItems() {
		return apolloItemRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService#saveApolloItem(com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem)
	 */
	@Override
	public ApolloItem saveApolloItem(ApolloItem apolloItem) {
		return apolloItemRepository.save(apolloItem);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService#deleteApolloItem(com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem)
	 */
	@Override
	public void deleteApolloItem(ApolloItem apolloItem) {
		apolloItemRepository.delete(apolloItem);
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService#deleteApolloItem(java.lang.String)
	 */
	@Override
	public void deleteApolloItem(String id) {
		apolloItemRepository.delete(id);		
	}

}
