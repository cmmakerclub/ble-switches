package com.nat.ble.hm10.utilities;

public class CsvWriterHelper {
	private static final String QUOTE = "\"";
	public static String addStuff(Integer text){
		return QUOTE + text + QUOTE + ","; 
	}

	public static String addStuff(Long text){
		return QUOTE + text + QUOTE + ","; 
	}

	public static String addStuff(boolean value){
		return QUOTE + value + QUOTE + ","; 
	}
	
	public static String addStuff(String text){
		if(text == null){text = "<blank>";}
		text = text.replace(QUOTE, "'");

		return QUOTE + text.trim() + QUOTE + ","; 
	}
}
