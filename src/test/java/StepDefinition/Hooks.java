package StepDefinition;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks  {

    @Before
    public void beforeScenario(){

        System.out.println("This will run before the Scenario");

    }

   @After("@HelloFresh")
   public void afterScenario(Scenario scenario){
       System.out.println("This will run after the Scenario");
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        //BaseTest.driver.close();
        BaseTest.driver.quit();
    }
}