package com.common;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import common.Constraints;
import common.ReadExcel;

public class StartDriver extends Constraints {
protected WebDriver driver;
protected WebElement element;
	
	
@BeforeClass
@Parameters({"Testsheetpath"})
public WebDriver initilizeDriver(String Testsheetpath) {
	ReadExcel Config=new ReadExcel();
 HashMap<String,List<String>> dataconfig=new HashMap<String,List<String>>();
 dataconfig= Config.readConfigFIleFromExcel(Testsheetpath, "Config");
 if(dataconfig.isEmpty()) {
	 
	 System.out.println("There is no data in Confog class");
 }
 else {
	 Constraints.driverName=dataconfig.get("WebDriver").get(0);
	 System.out.println("Driver Name="+Constraints.driverName);
	 
 } 
 
 
	
	
	
	return driver;
}

@AfterClass
public void ScriptOutput() {
	System.out.println("done");
	
}

}
