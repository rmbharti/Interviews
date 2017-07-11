package com.fbn.hashmap.repository;

import com.fbn.hashmap.IntegrationTestBase;
import com.fbn.hashmap.fixture.ServiceInstanceFixture;
import com.fbn.hashmap.model.ServiceInstance;
import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.junit.Assert.assertEquals;

public class ServiceInstanceRepositoryIntegrationTest extends IntegrationTestBase {

	private static final String COLLECTION = "serviceInstance";

	@Autowired
	private MongoClient client;

	@Autowired
	private MongoServiceInstanceRepository repository;

	@Autowired
	private MongoOperations mongo;

	@Before
	public void setup() throws Exception {
		mongo.dropCollection(COLLECTION);
	}

	@After
	public void teardown() {
		mongo.dropCollection(COLLECTION);
		client.dropDatabase(DB_NAME);
	}

	@Test
	public void instanceInsertedSuccessfully() throws Exception {
		assertEquals(0, mongo.getCollection(COLLECTION).count());
		repository.save(ServiceInstanceFixture.getServiceInstance());
		assertEquals(1, mongo.getCollection(COLLECTION).count());
	}

	@Test
	public void instanceDeletedSuccessfully() throws Exception {
		ServiceInstance instance = ServiceInstanceFixture.getServiceInstance();

		assertEquals(0, mongo.getCollection(COLLECTION).count());
		repository.save(instance);
		assertEquals(1, mongo.getCollection(COLLECTION).count());
		repository.delete(instance.getServiceInstanceId());
		assertEquals(0, mongo.getCollection(COLLECTION).count());
	}
}