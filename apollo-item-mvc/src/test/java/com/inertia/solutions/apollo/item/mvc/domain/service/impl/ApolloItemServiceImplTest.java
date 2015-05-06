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

import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;
import com.inertia.solutions.apollo.item.mvc.domain.repository.ApolloItemRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ApolloItemServiceImplTest {

	@Mock
	ApolloItemRepositoryImpl mockApolloItemRepository;
	
	@InjectMocks
	ApolloItemServiceImpl serviceUnderTest;
	
	List<ApolloItem> listExpectation = new ArrayList<ApolloItem>();
	
	ApolloItem itemExpectation = new ApolloItem();
	
	@Before
	public void setupMocks() {		
		Mockito.when(mockApolloItemRepository.findAll()).thenReturn(listExpectation);
		Mockito.when(mockApolloItemRepository.save(Mockito.any(ApolloItem.class))).thenReturn(itemExpectation);
	}
	
	@Test
	public void testFindAllApolloItems() throws Exception {
		List<ApolloItem> result = serviceUnderTest.findAllApolloItems();
		Assert.assertSame("Apollo Item List is not the same list as expectation", listExpectation, result);
		Mockito.verify(mockApolloItemRepository).findAll();
	}

	@Test
	public void testSaveApolloItem() throws Exception {
		ApolloItem item = new ApolloItem();
		ApolloItem result = serviceUnderTest.saveApolloItem(item);
		Assert.assertSame("Apollo Item is not the same item as expected", itemExpectation, result);
		Mockito.verify(mockApolloItemRepository).save(item);
	}

	@Test
	public void testDeleteApolloItemApolloItem() throws Exception {
		ApolloItem item = new ApolloItem();
		serviceUnderTest.deleteApolloItem(item);
		Mockito.verify(mockApolloItemRepository).delete(item);
	}

	@Test
	public void testDeleteApolloItemString() throws Exception {
		String id = "123";
		serviceUnderTest.deleteApolloItem(id);
		Mockito.verify(mockApolloItemRepository).delete(id);
	}

	
}
