package com.inertia.solutions.apollo.item.mvc.domain.entity;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.outsideMyBox.testUtils.BeanLikeTester;
import org.outsideMyBox.testUtils.BeanLikeTester.PropertiesAndValues;


public class ApolloItemHistoryTest {

	PropertiesAndValues defaultValues = new PropertiesAndValues();
	PropertiesAndValues otherValues = new PropertiesAndValues();
	
	@Before
	public void setup() {
		defaultValues.put("id", null);
		defaultValues.put("apolloItemId", null);
		defaultValues.put("itemUpdateDate", null);
		defaultValues.put("itemUpdateBy", null);
		defaultValues.put("itemUpdateNote", null);
		
		otherValues.put("id", "123456");
		otherValues.put("apolloItemId", "test-id");
		otherValues.put("itemUpdateDate", new Date());
		otherValues.put("itemUpdateBy", "test-udpatedBy");
		otherValues.put("itemUpdateNote", "test-note");
	}
	
	@Test
	public void test() {
		BeanLikeTester beanLikeTester = new BeanLikeTester(ApolloItemHistory.class);
		
		beanLikeTester.testDefaultValues(defaultValues);
		beanLikeTester.testMutatorsAndAccessors(defaultValues, otherValues);
		beanLikeTester.testToString(defaultValues, otherValues);
	}
}
