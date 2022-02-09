package main.java.org.balramjot.capacitometer.controllers;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.org.balramjot.capacitometer.models.MaxGymCapacity;

/**
 * This class gets the max gym capacity
 * from json file
 * @author saini
 *
 */
public class GetMaxGymCapacity extends ParseJsonObjectFactory {
	
	private static MaxGymCapacity mgc = new MaxGymCapacity();
	
	@SuppressWarnings("unchecked")
	@Override
	public MaxGymCapacity parseJsonObject(JSONArray arr) {
		arr.forEach(g -> {
			JSONObject obj = (JSONObject) g;
			JSONObject jsonObject = (JSONObject) obj.get("GymCapacity");			
			mgc.setId(Integer.parseInt(jsonObject.get("id").toString()));
			mgc.setCapacity(Integer.parseInt(jsonObject.get("capacity").toString()));
		});
		return mgc;
	}

	@Override
	public HashMap<Integer, ?> parseJsonObjectMap(JSONArray arr) {
		// TODO Auto-generated method stub
		return null;
	}

}
