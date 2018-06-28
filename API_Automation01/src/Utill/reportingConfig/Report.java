package reportingConfig;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import common.Constraints;

public class Report {
	 Logger  log = Logger.getLogger(Report.class); 
	  public static  ExtentReports Exreport;
	  public ExtentTest test;
	 public Report(){
		 loggerIntilization();
		 reportInitilazation();
	 }
	 public  void loggerIntilization() {
		 try {
			 Properties props = new Properties();
			 props.load(new FileInputStream((System.getProperty("user.dir").concat("/src/configuration/Configurationfile.properties"))));

			File logfile=new File (Constraints.loggerLocation);
			 if(logfile.exists()) {
				 
				 logfile.delete();
			 }		 
				 if(logfile.createNewFile()){
					 System.out.println("LOger report location"+Constraints.loggerLocation);
				 props.setProperty("log4j.appender.HTML.File",Constraints.loggerLocation);
				 LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				 }
				 else {
					 System.out.println("File is present already");
				 }
		 log.info("Logger is initiated");
		 
		 
		 }
		 catch(Exception e) {
			 System.err.println("Some error occured at Report Constructer"+e.getMessage());
			 
		 }		 
		 
	 }
	 
	 
	 public void reportInitilazation() {
		 try {
			 Date datea = new Date();  
		DateFormat format= new SimpleDateFormat("dd-mm-yyyy");
		
		
	String date=format.format(datea).toString();
		 String reportName="Execution_Result_"+date+".html";
		
		File file = new File (Constraints.ExtendReportLocation.concat("//".concat(reportName)));
		if(file.exists()) {
			file.delete();
			
		}
		if(file.createNewFile()) {
			log.info("Logger Location and name is "+reportName);
			Exreport= new ExtentReports(Constraints.ExtendReportLocation.concat("//".concat(reportName)),true);
			Exreport.addSystemInfo("Hostname", "Your System name");
			Exreport.addSystemInfo("Enviorement", "Enviorement name");
			Exreport.addSystemInfo("User Name is ", "Your  name");
			Exreport.loadConfig(new File(System.getProperty("user.dir")+"/src/configuration/extent-config.xml"));
			
		}
		else {
			System.out.println("Logger is already presnt can Show the results");
		}
		
		
		
		 }
		 catch(Exception e) {
			 System.err.println("Some Error occured at reportInitilazation methods"+e.getMessage());
			 
		 }
	 }
	
}
