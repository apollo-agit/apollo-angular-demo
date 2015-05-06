package com.inertia.solutions.apollo.item.mvc.domain.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inertia.solutions.apollo.item.mvc.app.config.SpringApplicationContext;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;

/**
 * @author ihamilto
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:database.test.properties")
@ContextConfiguration(classes = { SpringApplicationContext.class }, loader = AnnotationConfigContextLoader.class)
public class ApolloItemHistoryRepositoryImplIT {

	@Autowired
	ApolloItemHistoryRepositoryImpl repoUnderTest;

	@Test
	public void testSave() {
		ApolloItemHistory apolloItemHistory = new ApolloItemHistory();
		apolloItemHistory.setApolloItemId("123");
		apolloItemHistory.setItemUpdateBy("ihamilto");
		apolloItemHistory.setItemUpdateDate(new Date());
		apolloItemHistory.setItemUpdateNote("test note");

		try {
			repoUnderTest.save(apolloItemHistory);

		} finally {
			//repoUnderTest.delete(apolloItemHistory);
		}
	}

}
