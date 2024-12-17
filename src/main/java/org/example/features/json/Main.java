package org.example.features.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		String json1 = "{\"name\":\"kevin\", \"lastName\":\"Paez\", \"age\": 23}";
		String json2 = "{\"name\":\"kevinn\", \"lastName\":\"Gallardo\", \"age\": 23}";

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node1 = mapper.readTree(json1);
			JsonNode node2 = mapper.readTree(json2);
			List<String> diffKeys = compareJsonNodes(node1, node2);
			System.out.println("Keys with differences: " + diffKeys);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static List<String> compareJsonNodes(JsonNode node1, JsonNode node2) {
		List<String> diffKeys = new ArrayList<>();

		Iterator<String> fieldNames = node1.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
//			System.out.println("node 1 ->" + node1.get(fieldName));
//			System.out.println("node 2 ->" + node2.get(fieldName));
//			System.out.println("->" + fieldName);
			if (!node2.has(fieldName) || !node1.get(fieldName).equals(node2.get(fieldName))) {
				diffKeys.add(fieldName);
			}
		}
		
		return diffKeys;
	}

}
