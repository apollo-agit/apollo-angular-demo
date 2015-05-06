package com.inertia.solutions.apollo.item.mvc.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


/**
 * This class is a basic Spring IOC Container config
 * which does a @Component @Services scan on the base package name,
 * and also allows the AspectJ Style proxy generation.
 * 
 * This also enables mongo repository context loading. This is interesting, because 
 * it does as scan for any implemented (extended) "interfaces". If a class implementation
 * is scanned is does NOT wire that into the context. NOTE: DO NOT use the standard JPA @repository annotation, in
 * fact in the mongo data code the base interface is marked with @norepository.
 * 
 * This does a component scan for the domain directory
 * 
 * Loads the database properties file, can be "diretied" during unit testing.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 * 
 */
@Configuration
@EnableMongoRepositories(basePackages="com.inertia.solutions.apollo.item.mvc.domain.repository")
@ComponentScan(basePackages = {"com.inertia.solutions.apollo.item.mvc.domain",
		"com.inertia.solutions.apollo.item.mvc.aspect"})
@PropertySource(value="classpath:database.properties")
@EnableAspectJAutoProxy
public class SpringApplicationContext extends AbstractMongoConfiguration  {

	@Autowired
	private Environment env;
	
	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
	 */
	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		List<MongoCredential> credsList = new ArrayList<MongoCredential>();
		credsList.add(MongoCredential.createCredential(env.getProperty("mongo.username"), env.getProperty("mongo.database"), 
				env.getProperty("mongo.password").toCharArray()));
		return new MongoClient(new ServerAddress(env.getProperty("mongo.host"), new Integer(env.getProperty("mongo.port"))), credsList);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongoDbFactory()
	 */
	@Override
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), env.getProperty("mongo.database"));
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongoTemplate()
	 */
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		return env.getProperty("mongo.database");
	}
	
}
