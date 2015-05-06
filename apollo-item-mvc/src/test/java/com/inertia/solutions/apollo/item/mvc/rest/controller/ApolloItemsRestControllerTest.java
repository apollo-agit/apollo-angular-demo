package com.inertia.solutions.apollo.item.mvc.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.GsonBuilder;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService;
import com.inertia.solutions.apollo.item.mvc.test.util.MockApplicationContext;
import com.inertia.solutions.apollo.item.mvc.web.config.WebContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebContext.class,
		MockApplicationContext.class })
@WebAppConfiguration
@DirtiesContext
public class ApolloItemsRestControllerTest {

	@Autowired
	WebApplicationContext dirtiedWebContext;

	@Autowired
	ApolloItemService mockItemService;
	
	@Autowired
	ApolloItemHistoryService mockHistoryService;

	MockMvc mockMvc;

	List<ApolloItem> listExpectation = new ArrayList<ApolloItem>();
	
	ApolloItem itemExpectation = new ApolloItem();
	
	ApolloItemHistory historyExpectation = new ApolloItemHistory();
	
	List<ApolloItemHistory> listHistoryExpectation = new ArrayList<ApolloItemHistory>();

	@Before
	public void setup() {		
		mockMvc = MockMvcBuilders.webAppContextSetup(this.dirtiedWebContext).build();

		listExpectation.add(itemExpectation);
		Mockito.when(mockItemService.findAllApolloItems()).thenReturn(listExpectation);	
		Mockito.when(mockItemService.saveApolloItem(Mockito.any(ApolloItem.class))).thenReturn(itemExpectation);
		Mockito.doThrow(new IllegalStateException("Test Exception")).when(mockItemService).deleteApolloItem("throw-on-this-id");
		
		listHistoryExpectation.add(historyExpectation);
		Mockito.when(mockHistoryService.findAllApolloItemHistorysForItem(Mockito.anyString())).thenReturn(listHistoryExpectation);
		Mockito.when(mockHistoryService.saveApolloItemHistory(Mockito.any(ApolloItemHistory.class))).thenReturn(historyExpectation);
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(
				get("/service/apolloitems/item").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(mockItemService).findAllApolloItems();
	}

	@Test
	public void testDelete() throws Exception {
		String id = "123";
		mockMvc.perform(
				delete("/service/apolloitems/item").param("id",  id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		Mockito.verify(mockItemService).deleteApolloItem(id);
	}

	@Test
	public void testPut() throws Exception {
		String json = new GsonBuilder().create().toJson(new ApolloItem());
		mockMvc.perform(
				post("/service/apolloitems/item").content(json).contentType(MockApplicationContext.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(mockItemService).saveApolloItem(Mockito.any(ApolloItem.class));
		Mockito.verify(mockHistoryService).saveApolloItemHistory(Mockito.any(ApolloItemHistory.class));
		Mockito.verify(mockHistoryService, Mockito.atLeast(1)).saveApolloItemHistory(Mockito.any(ApolloItemHistory.class));
	}

	@Test()
	public void testHandleException() throws Exception {
		String id = "throw-on-this-id";
		mockMvc.perform(
				delete("/service/apolloitems/item").param("id",  id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testGetHistory() throws Exception {
		mockMvc.perform(
				get("/service/apolloitems/history").param("itemId", "123").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(mockHistoryService).findAllApolloItemHistorysForItem("123");
		
	}

	@Test
	public void testPutHistory() throws Exception {
		String json = new GsonBuilder().create().toJson(new ApolloItemHistory());
		mockMvc.perform(
				post("/service/apolloitems/history").content(json).contentType(MockApplicationContext.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		Mockito.verify(mockHistoryService, Mockito.atLeast(1)).saveApolloItemHistory(Mockito.any(ApolloItemHistory.class));
	}

	@Test
	public void testHead() throws Exception {
		mockMvc.perform(
				get("/service/apolloitems/item/metadata").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
