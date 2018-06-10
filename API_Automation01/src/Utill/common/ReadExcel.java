package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public HashMap<String,List<String>> readConfigFIleFromExcel(String path, String SheetName){
	try {	
	HashMap<String,List<String>> configdata=new HashMap<String,List<String>>();
	
     InputStream file = new FileInputStream(path);
     XSSFWorkbook book = new XSSFWorkbook(file);
     XSSFSheet sheet= book.getSheet("Config");
     int lastRow=sheet.getLastRowNum();
     
     for(int i=1;i<lastRow;i++) {
    	 Row r=sheet.getRow(i);
    	 if(r.getCell(1)==null||r.getCell(1).getStringCellValue().trim().isEmpty()) {
    		 
    		 break;
    	 }
    	 else {
    		 
    		 String Keyvalue=r.getCell(1).getStringCellValue().trim();
    		 List<String> data = new ArrayList<String>();
    		 int lastCell=r.getLastCellNum();
    		 for (int j=2;j<lastCell;j++) {
    			 Cell c= r.getCell(j);
    			 
    			 if(c.getStringCellValue().trim().isEmpty()||
    					 
    					 "##".equals(c.getStringCellValue().trim())) {
    			    break;
    			   }
    			  else {
    				data.add(c.getStringCellValue().trim());
    			   }
    			 
    		 }
    		 configdata.put(Keyvalue, data);
    	 }
 
    	   }
     return configdata;
     }
	catch(FileNotFoundException a) {
	System.out.println("Your Intial Excell Sheet is missing");
	
	return null;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.getMessage();
		
	System.err.println("Some error uccured at readConfigFIleFromExcel"+e.getMessage());
		return null;
	}
	
	}
	

}
