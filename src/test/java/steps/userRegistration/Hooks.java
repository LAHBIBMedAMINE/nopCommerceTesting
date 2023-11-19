package steps.userRegistration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import steps.TestBase;
import utility.Helper;

public class Hooks extends TestBase{
	
	
	@Before
	public void setup() {
		startDriver(browserChoice);
		
		
		
        
    }
	
	private void screenShot(Scenario scenario) {
    	if(scenario.isFailed()) {
    		System.out.println("(-----------------Failed Scenario we are Taking ScreenShot----------------)");
    		System.out.println("(-----------------"+scenario.getName()+"----------------)");
    		Helper.captureScreenShot(TestBase.driver,scenario.getName() );
    	}
  
	}
    

    @After
    public void teardown(Scenario scenario) {
    	screenShot(scenario);
    	teardown();
    	
    }
    
    

}

