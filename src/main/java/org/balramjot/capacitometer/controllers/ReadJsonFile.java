package main.java.org.balramjot.capacitometer.controllers;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * This method reads Json File
 * @author saini
 * reference: // https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
 */
public class ReadJsonFile {	
	public static JSONArray readInputJsonFile(String path) {
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();
	    try (FileReader fileReader = new FileReader(path)) {
	       Object object = jsonParser.parse(fileReader);    
	       jsonArray = (JSONArray) object;
	    } catch(Exception e) {
	       e.printStackTrace();
	    }
	    return jsonArray;
	}
}