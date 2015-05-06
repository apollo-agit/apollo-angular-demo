package com.inertia.solutions.apollo.item.mvc.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;
import com.inertia.solutions.apollo.item.mvc.domain.repository.ApolloItemHistoryRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ApolloItemHistoryServiceImplTest {
	
	@Mock
	ApolloItemHistoryRepositoryImpl mockRepo;
	
	@InjectMocks
	ApolloItemHistoryServiceImpl serviceUnderTest;
	
	ApolloItemHistory historyExpectation = new ApolloItemHistory();
	
	List<ApolloItemHistory> listHistoryExpectation = new ArrayList<ApolloItemHistory>();
	
	@Before
	public void setup() {
		Mockito.when(mockRepo.findHistoryByItemId("123")).thenReturn(listHistoryExpectation);
		Mockito.when(mockRepo.save(historyExpectation)).thenReturn(historyExpectation);
	}

	@Test
	public void testFindAllApolloItemHistorysForItem() throws Exception {
		List<ApolloItemHistory> result = serviceUnderTest.findAllApolloItemHistorysForItem("123");
		Assert.assertSame("Return list is was not the same as expectation", listHistoryExpectation, result);
		Mockito.verify(mockRepo).findHistoryByItemId("123");
	}

	@Test
	public void testSaveApolloItemHistory() throws Exception {
		ApolloItemHistory result = serviceUnderTest.saveApolloItemHistory(historyExpectation);
		Assert.assertSame("Item does equal expectation", historyExpectation, result);
		Mockito.verify(mockRepo).save(historyExpectation);
	}
	
}
