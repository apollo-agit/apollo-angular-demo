/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;



/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ApolloItemHistoryRepositoryImpl which is interesting since it wires into
 * a class since it is scanned by the mongo context. This is why I have used the
 * "impl" postfix. This will provide all "overriden" implementation functions. Plus 
 * a couple of other function abstractions.
 * 
 * Notice the "wired" service function with the @Query annotation, certainly a runtime aspect 
 * to allow the non-implemented interface approach.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ApolloItemHistoryRepositoryImpl  extends MongoRepository<ApolloItemHistory, String> {

	@Query("{apolloItemId : ?0}")
	public List<ApolloItemHistory> findHistoryByItemId(String itemId);
}
