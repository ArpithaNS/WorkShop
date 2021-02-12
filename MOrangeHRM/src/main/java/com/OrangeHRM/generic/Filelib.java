package com.OrangeHRM.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib {
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

public String getExcelValue(String sheetname,int row,int cell) throws EncryptedDocumentException,IOException, InvalidFormatException{
	FileInputStream fis=new FileInputStream("./src/test/resources/data/testscriptorange.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	String value =wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;

}
}
