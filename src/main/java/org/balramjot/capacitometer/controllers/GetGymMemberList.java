package main.java.org.balramjot.capacitometer.controllers;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.org.balramjot.capacitometer.models.GymMember;

public class GetGymMemberList extends ParseJsonObjectFactory{

	private static HashMap<Integer, GymMember> gmMap = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<Integer, GymMember> parseJsonObjectMap(JSONArray arr) {
		arr.forEach(g -> {
			JSONObject obj = (JSONObject) g;
			JSONObject jsonObject = (JSONObject) obj.get("GymMembers");
			GymMember gm = new GymMember();
			
			gm.setId(Integer.parseInt(jsonObject.get("id").toString()));
			gm.setFirstName((String) jsonObject.get("firstName"));
			gm.setLastName((String) jsonObject.get("lastName"));
			gm.setStatus(Integer.parseInt(jsonObject.get("status").toString()));
			gmMap.put(gm.getId(), gm);
	    });
			
		
		return gmMap;
	}
	
	public void displayGymMembersList(HashMap<Integer, GymMember> map, Display display) {
		display.output("Welcome to the gym !!!");
		
		display.printBlankLine();
		display.output("Please select gym member from following list:");
		display.printBlankLine();
		
		if(!map.isEmpty() || map.size() > 0 || map != null) {	
			// filtering the output so that only activated gym members are shown (status == 1)
			map.entrySet().stream().filter(i -> i.getValue().getStatus() == 1).forEach(i -> {
				display.output(i.getValue().getStringValueOfId(), " ", i.getValue().getFirstName(), " ", i.getValue().getLastName());
				display.printBlankLine();
			});	
		}
	}

	@Override
	public <T> T parseJsonObject(JSONArray arr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
