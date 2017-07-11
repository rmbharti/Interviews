package com.fbn.hashmap.utils;

import java.util.Set;

import com.fbn.hashmap.model.Plan;
import com.fbn.hashmap.model.Service;

public class ServiceTestUtil {
	 public static Service createModelObject(String id, String name, String desc,boolean isBindable, Set<Plan> plans) {
	        Service model = new Service();

	        model.setId(id);
	        model.setDescription(desc);;
	        model.setName(name);
	        model.setBindable(isBindable);
	        model.setPlans(plans);
	        return model;
	 }
	 
}
