/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.domain.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inertia.solutions.apollo.item.mvc.app.config.SpringApplicationContext;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;
import com.inertia.solutions.apollo.item.mvc.domain.repository.ApolloItemRepositoryImpl;

/**
 * @author ihamilto
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:database.test.properties")
@ContextConfiguration(classes={SpringApplicationContext.class}, loader=AnnotationConfigContextLoader.class)
public class ApolloItemRepositoryIT {
	
	@Autowired
	ApolloItemRepositoryImpl repoUnderTest;
	
	@Test
	public void testSaveApolloItem() {
		ApolloItem item = new ApolloItem();
		item.setApolloItemAmount(new Double(10));
		item.setApolloItemDesc("Test Desc");
		item.setApolloItemName("Test Name");
		
		try {
		repoUnderTest.save(item);
		
		} finally {
			repoUnderTest.delete(item);
		}
		
	}
	
}
