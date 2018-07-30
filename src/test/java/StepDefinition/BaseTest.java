package StepDefinition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest
{


    public static WebDriver driver;
    public static WebDriverWait wait;


    public  BaseTest()
    {
        String browser = System.getProperty("BROWSER");
        String OS=System.getProperty("os.name").toLowerCase();
        if(browser.equals("chrome") || browser.equals("")) {
            if(OS.contains("windows")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            }
            if(OS.contains("mac")){
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            }
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox"))
        {
            if(OS.contains("windows")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            }

            if(OS.contains("mac")) {
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            }

            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 100);
        driver.get(System.getProperty("base.url"));

    }



}