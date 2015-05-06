package com.inertia.solutions.apollo.item.mvc.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;


/**
 * Using JRE 1.7.0_75
 * 
 * The Interface ApolloItemRepositoryImpl which is interesting since it wires into
 * a class since it is scanned by the mongo context. This is why I have used the
 * "impl" postfix. This will provide all "overriden" implementation functions. Plus 
 * a couple of other function abstractions.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public interface ApolloItemRepositoryImpl extends MongoRepository<ApolloItem, String> {

	
}
