package main.java.org.balramjot.capacitometer.controllers;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

public class WriteJsonFile {
	
	public static void writeOutputJsonFile(JSONArray jsonArray, String path) {
		try {
			FileWriter file = new FileWriter(path);
			file.write(jsonArray.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
