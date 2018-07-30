package Pages;

import StepDefinition.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage()
    {

        PageFactory.initElements(BaseTest.driver, this);
    }
    //Add to cart
    @FindBy(how= How.NAME, using="Submit")
    public static WebElement BUTTON_ADD_TO_CART;
    //Proceed to checkout
    @FindBy(how=How.XPATH, using="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    public static WebElement BUTTON_PROCEED_TO_CHECKOUT;
    //Proceed to checkout - summary section
    @FindBy(how=How.XPATH, using="//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    public static WebElement BUTTON_PROCEED_TO_CHECKOUT_SUMMARY;

    // Proceed to checkout - Address section
    @FindBy(how= How.NAME, using="processAddress")
    public static WebElement BUTTON_PROCEED_ADDRESS;

    //Terms and conditions check box
    @FindBy(how= How.ID, using="uniform-cgv")
    public static WebElement CHECKBOX_TERMS;

    // Proceed to checkout - Shipping section
    @FindBy(how= How.NAME, using="processCarrier")
    public static WebElement BUTTON_PROCEED_SHIPPING;

    // Bankwire button
    @FindBy(how= How.CLASS_NAME, using="bankwire")
    public static WebElement BUTTON_BANKWIRE;

    //Confirm Order
    @FindBy(how=How.XPATH, using="//*[@id='cart_navigation']/button")
    public static WebElement BUTTON_CONFIRM_ORDER;

    // Order confirmation title
    @FindBy(how= How.CSS, using="h1")
    public static WebElement TITLE_ORDER_CONFIRMATION;

    // Order completion text
    @FindBy(how= How.XPATH, using="//*[@class='cheque-indent']/strong")
    public static WebElement TITLE_ORDER_COMPLETION;






}
