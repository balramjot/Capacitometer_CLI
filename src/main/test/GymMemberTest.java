package main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import main.java.org.balramjot.capacitometer.controllers.GetGymMemberList;
import main.java.org.balramjot.capacitometer.controllers.ReadJsonFile;
import main.java.org.balramjot.capacitometer.models.GymMember;

class GymMemberTest {

	@Test
	public void testGymMemberJsonList() {
		HashMap<Integer, GymMember> gymMemberMap = new HashMap<>();
		JSONArray gymJsonArray = ReadJsonFile.readInputJsonFile("src/main/resources/ioFiles/gymMember.json");
		GetGymMemberList getGymMemberList = new GetGymMemberList();
		gymMemberMap = getGymMemberList.parseJsonObjectMap(gymJsonArray);
		assertTrue(1 < gymMemberMap.size());
	}

}
