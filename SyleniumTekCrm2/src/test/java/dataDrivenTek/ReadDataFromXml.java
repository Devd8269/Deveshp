package dataDrivenTek;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXml {
@Test
public void sampleTest(XmlTest test) {
	System.out.println(test.getParameter("name1"));
	
}
}
