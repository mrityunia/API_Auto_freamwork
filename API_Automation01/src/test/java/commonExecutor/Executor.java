package commonExecutor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.StartDriver;

public class Executor extends StartDriver {
	
	
@Test
public void scriptExecutor(String Testsheetpath) {
	System.out.println("exeuotr path is "+Testsheetpath);
}

}
