package dataDrivenTek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DDT {
public static void main(String[] args) throws IOException {
	FileInputStream fis =new  FileInputStream("C:\\Users\\deves\\OneDrive\\Desktop\\commondata.properties.txt\\");
Properties pobj= new Properties();
pobj.load(fis);
System.out.println(pobj.getProperty("browser"));
}
}
