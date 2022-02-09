package main.java.org.balramjot.capacitometer.controllers;

import java.util.HashMap;

import org.json.simple.JSONArray;

public abstract class ParseJsonObjectFactory {

	public abstract HashMap<Integer, ?> parseJsonObjectMap(JSONArray arr);	// any class member
	
	public abstract <T> T parseJsonObject(JSONArray arr);
}
