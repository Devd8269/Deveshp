package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromProperties(String key) throws IOException {
FileInputStream fis= new FileInputStream("./ConfigAppData/CommonDataFromPropertis.txt");
Properties prop = new Properties();
prop.load(fis);
String data= prop.getProperty(key);
return data;

}
}
