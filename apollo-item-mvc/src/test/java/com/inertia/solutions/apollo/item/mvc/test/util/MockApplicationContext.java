/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.test.util;

import java.nio.charset.Charset;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService;

/**
 * @author ihamilto
 *
 */
@Configuration
public class MockApplicationContext {

	public static final MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype());
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Bean
	public ApolloItemService apolloItemService() {
		return Mockito.mock(ApolloItemService.class);
	}
	
	@Bean
	public ApolloItemHistoryService apolloItemHistoryService() {
		return Mockito.mock(ApolloItemHistoryService.class);
	}
}
