package com.inertia.solutions.apollo.item.mvc.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.inertia.solutions.apollo.item.mvc.test.util.MockApplicationContext;
import com.inertia.solutions.apollo.item.mvc.web.config.WebContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebContext.class,
		MockApplicationContext.class })
@WebAppConfiguration
@DirtiesContext
public class HomeControllerTest {


	@Autowired 
	WebApplicationContext dirtiedWebContext; 
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.dirtiedWebContext).build();
	}
	
	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/maintenance"))
			.andExpect(status().isOk())
				.andExpect(view().name("maintenance/data-maintenance"))
					.andExpect(forwardedUrl("/WEB-INF/jsp/maintenance/data-maintenance.jsp"));
	}

}
