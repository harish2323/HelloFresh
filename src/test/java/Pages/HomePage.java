package Pages;


import StepDefinition.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage()
    {

        PageFactory.initElements(BaseTest.driver, this);
    }

    @FindBy(how= How.CLASS_NAME, using="login")
    public static WebElement LINK_SIGN_IN;

    @FindBy(how= How.LINK_TEXT, using="Women")
    public static WebElement LINK_WOMEN;




}
