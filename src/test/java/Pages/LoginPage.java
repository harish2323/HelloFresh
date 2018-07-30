package Pages;

import StepDefinition.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{


    public LoginPage()
    {

        PageFactory.initElements(BaseTest.driver, this);
    }


    @FindBy(how= How.ID, using="email_create")
    public static WebElement REGISTER_EMAIL_ADDRESS;

    @FindBy(how= How.ID, using="SubmitCreate")
    public static WebElement BUTTON_CREATE;

    @FindBy(how= How.ID, using="passwd")
    public static WebElement EDIT_PASSWORD;

    @FindBy(how= How.ID, using="email")
    public static WebElement EDIT_EMAIL_LOGIN;

    @FindBy(how= How.ID, using="SubmitLogin")
    public static WebElement BUTTON_SIGNIN;

    //LOGIN verification section





}
