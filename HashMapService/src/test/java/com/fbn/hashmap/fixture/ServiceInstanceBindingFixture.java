package com.fbn.hashmap.fixture;

import java.util.Collections;
import java.util.Map;

import com.fbn.hashmap.model.ServiceInstanceBinding;

public class ServiceInstanceBindingFixture {
	public static ServiceInstanceBinding getServiceInstanceBinding() {
		Map<String, Object> credentials = Collections.singletonMap("url", (Object) "mongo://example.com");
		return new ServiceInstanceBinding("binding-id", "service-instance-id", credentials, null, "app-guid");
	}
}
