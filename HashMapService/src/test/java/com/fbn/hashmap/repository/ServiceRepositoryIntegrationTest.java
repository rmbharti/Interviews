package com.fbn.hashmap.repository;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fbn.hashmap.IntegrationTestBase;
import com.fbn.hashmap.controller.ServiceBrokerController;
import com.fbn.hashmap.model.Plan;
import com.fbn.hashmap.utils.ServiceTestUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRepositoryIntegrationTest  {
	
		@Autowired
		private ServiceBrokerController serviceBrokerController;

		@Autowired
	    private ServiceRepository serviceRepositoryMock;
	    
		@Before
	    public void setUp() {
	        serviceRepositoryMock = mock(ServiceRepository.class);
	        ///serviceBrokerController.setServiceRepository(serviceRepositoryMock);
	    }
	    
	    @Test
	    public void save() {
	    	
	    	Set<Plan> plans=new HashSet<>();
	    	
	    	Plan plan1=new Plan();
	    	plan1.setId("20");
	    	plan1.setName("Plan1");
	    	plan1.setDescription("Plan1Desc");
	    	
	    	Plan plan2=new Plan();
	    	plan2.setId("21");
	    	plan2.setName("Plan2");
	    	plan2.setDescription("Plan2Desc");
	    	
	    	plans.add(plan2);
	    	
	    	
	    	
	    	serviceRepositoryMock.save(ServiceTestUtil.createModelObject("1", "Service1", "Service1Desc", true, plans));
	    	
	    	assertTrue("Service Record creation succeeded", serviceRepositoryMock.exists("1"));
	    	
	    	
/*	        PersonDTO created = PersonTestUtil.createDTO(null, FIRST_NAME, LAST_NAME);
	        Person persisted = PersonTestUtil.createModelObject(PERSON_ID, FIRST_NAME, LAST_NAME);
	        
	        when(serviceRepositoryMock..save(any(Person.class))).thenReturn(persisted);
	        
	        Person returned = ServiceRepository.create(created);

	        ArgumentCaptor<Person> personArgument = ArgumentCaptor.forClass(Person.class);
	        verify(ServiceRepositoryMock, times(1)).save(personArgument.capture());
	        verifyNoMoreInteractions(ServiceRepositoryMock);

	        assertPerson(created, personArgument.getValue());
	        assertEquals(persisted, returned);
*/	    }


/*	private static final String COLLECTION = "serviceInstance";

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
	}*/
}