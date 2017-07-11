package com.fbn.hashmap.utils;

import com.fbn.hashmap.model.Plan;


public class PlanTestUtil {
	
	 public static Plan createDTO(String id, String name, String desc) {
		 Plan model = new Plan();

		 model.setId("p1");
		 model.setName("Plan 1");
		 model.setDescription("Plan 1 Desc");
	        return model;
	 }
}
