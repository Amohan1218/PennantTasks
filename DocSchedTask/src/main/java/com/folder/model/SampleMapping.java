package com.folder.model;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class SampleMapping {

	public static void Convertdata(String s){
		HashMap<String, String> DSlot = new HashMap<>();

		JSONObject jsonObject = new JSONObject(s);
		
		for (String doctorKey : jsonObject.keySet()) {
            System.out.println("Doctor: " + doctorKey);
            
            JSONObject dayAvailability = jsonObject.getJSONObject(doctorKey);
            for (String dayKey : dayAvailability.keySet()) {
            	
                JSONArray timeSlots = dayAvailability.getJSONArray(dayKey);
                for (int i = 0; i < timeSlots.length(); i++) {
                	
                    String timeSlot = timeSlots.getString(i);
                    
                    if(DSlot.containsKey(timeSlot)) {
                    	String str = DSlot.get("timeSlot");
                    	DSlot.put(timeSlot, str+dayKey);
                    }else {
                    	DSlot.put(timeSlot, dayKey);
                    	System.out.println(timeSlot + "--" + dayKey);
                    }
                }System.out.println("\n");
            }
        }
		DSlot.forEach((slot, schedule) -> {
            System.out.println(slot + ": " + schedule);
        });

	}
	
	public static void main(String[] args) {
		String availabilityDataJSON = "{'101':{'2':['09:00 - 12:00','13:00 - 18:00'],'4':['09:00 - 12:00']}}";
		Convertdata(availabilityDataJSON);
	}
}
