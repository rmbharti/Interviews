package com.fbn.hashmap.fixture;

import com.fbn.hashmap.model.ServiceInstance;

public class ServiceInstanceFixture {
	public static ServiceInstance getServiceInstance() {
		return new ServiceInstance("service-instance-id", "service-definition-id", "plan-id",
				"org-guid", "space-guid", "http://dashboard.example.com");
	}
}
