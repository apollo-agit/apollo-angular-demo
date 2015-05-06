package com.inertia.solutions.apollo.item.mvc.domain.entity;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.outsideMyBox.testUtils.BeanLikeTester;
import org.outsideMyBox.testUtils.BeanLikeTester.PropertiesAndValues;


public class ApolloItemTest {

	PropertiesAndValues defaultValues = new PropertiesAndValues();
	PropertiesAndValues otherValues = new PropertiesAndValues();
	
	@Before
	public void setup() {
		defaultValues.put("id", null);
		defaultValues.put("apolloItemName", null);
		defaultValues.put("apolloItemAmount", null);
		defaultValues.put("apolloItemDesc", null);
		defaultValues.put("itemHistorySet", null);
		
		otherValues.put("id", "123456");
		otherValues.put("apolloItemName", "test-name");
		otherValues.put("apolloItemAmount", 1000.01D);
		otherValues.put("apolloItemDesc", "test-desc");
		otherValues.put("itemHistorySet", new HashSet<ApolloItemHistory>());

	}
	
	@Test
	public void test() {
		BeanLikeTester beanLikeTester = new BeanLikeTester(ApolloItem.class);
		
		beanLikeTester.testDefaultValues(defaultValues);
		beanLikeTester.testMutatorsAndAccessors(defaultValues, otherValues);
		beanLikeTester.testToString(defaultValues, otherValues);
	}
}
