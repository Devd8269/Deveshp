package com.comcast.crm.genericfileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtility {
public String getDataFromJsonFile(String key) throws IOException, ParseException {
	FileReader filer= new FileReader("C:\\Users\\deves\\eclipse-workspace\\SyleniumTekCrm\\ConfigAppData\\CommonDataFromJson.txt");
JSONParser parser= new JSONParser();
Object obj=parser.parse(filer);
JSONObject jsnobj= (JSONObject)obj;
String data=(String) jsnobj.get(key);
return data;
}
}
