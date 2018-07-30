package StepDefinition;

import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Object;

import java.security.SecureRandom;
import java.util.Date;

//import static com.sun.tools.doclint.Entity.amp;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import Pages.HomePage;


/**
 * Created by Harish19 on 28/07/2018.
 */
public class HelloFreshSteps extends BaseTest{


    private LoginPage loginPage;
    private HomePage homePage;
    private SignupPage signupPage;
    private CartPage cartPage;


    public HelloFreshSteps() {
    super();


    }

    @Before("@HelloFresh")
    public void startup()
    {
        loginPage=new LoginPage();
        homePage=new HomePage();
        signupPage= new SignupPage();
        cartPage=new CartPage();
    }





    @Given("^I load the home page$")
    public void I_load_the_home_page() throws Throwable
    {
        // navigate to the url based on the environment specified from command line
        driver.get(System.getProperty("base.url"));
    }
    @And("^I click the sign in link$")
    public void I_click_the_sign_in_link() throws Throwable{
        homePage.LINK_SIGN_IN.click();
    }

    @And("^I enter email and click the create account button$")
    public void I_enter_email() throws Throwable {
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        //driver.findElement(By.id(LoginPage.EDIT_EMAIL)).sendKeys(email);
        loginPage.REGISTER_EMAIL_ADDRESS.sendKeys(email);
        loginPage.BUTTON_CREATE.click();
    }

    @And("^I enter personal details (.*?),(.*?),(.*?),(.*?),(.*?),(.*?),(.*?)$")
    public void I_enter_personal_details(String salutation,String firstname,String lastname,String password,String day, String month,String year) throws Throwable {
        //Select salutation
        wait.until(ExpectedConditions.visibilityOf(signupPage.SALUTATION_MR));
        if(salutation.equals("Mr.")){
          signupPage.SALUTATION_MR.click();
        }

        if(salutation.equals("Mrs.")){
          signupPage.SALUTATION_MRS.click();
        }

        // Enter first name and last name
        signupPage.EDIT_FIRSTNAME.sendKeys(firstname);
        signupPage.EDIT_LASTNAME.sendKeys(lastname);

        //Enter password -  generate a random number to be appended to the end of the password string
        password=password+Integer.toString((int)(Math.random() * 50 + 1));
        signupPage.EDIT_PASSWORD.sendKeys(password);
        //Enter date of birth
        new Select(signupPage.SELECT_DAY).selectByValue(day);

        new Select(signupPage.SELECT_MONTH).selectByVisibleText(month+" ");
        new Select(signupPage.SELECT_YEAR).selectByValue(year);

    }

    @And("^I enter address details (.*?),(.*?),(.*?),(.*?)$")
    public void I_enter_address_details(String company,String city,String state,String postcode) throws Throwable {
        //company
        signupPage.EDIT_COMPANY.sendKeys(company);

        //Address - enter a random string and end it with a  random number
        String address1= generateRandomString(7);
        signupPage.EDIT_ADDRESS1.sendKeys(address1+" "+Integer.toString((int)(Math.random() * 50 + 1)));
        String address2= generateRandomString(5);
        signupPage.EDIT_ADDRESS2.sendKeys(address2);

        //city and state
        signupPage.EDIT_CITY.sendKeys(city);
        new Select(signupPage.SELECT_STATE).selectByVisibleText(state);

        //postcode
        signupPage.EDIT_POSTCODE.sendKeys(postcode);

        //additional information -  generate random string for additional information
        String information= generateRandomString(10);
        signupPage.EDIT_OTHER.sendKeys(information);

        //phone and mobile -  generate random phone numbers of 10 digits
        String phone=Long.toString((long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
        signupPage.EDIT_PHONE.sendKeys(phone);
        String mobile=Long.toString((long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
        signupPage.EDIT_MOBILE.sendKeys(mobile);

        //generate random string for alias
        signupPage.EDIT_ALIAS.sendKeys(generateRandomString(5));
    }
    @And("^I click the register button$")
    public void I_click_the_register_button() throws Throwable{
        signupPage.BUTTON_SUBMIT.click();

    }
    @Then("^I verify registration is successful (.*?),(.*?)$")
    public void I_verify_registratioin_is_successful(String firstname,String lastname) throws Throwable {

       assertEquals(signupPage.TITLE_MYACCOUNT.getText(), "MY ACCOUNT");
        assertEquals(signupPage.TEXT_CUSTOMERNAME.getText(), firstname + " " + lastname);
        assertTrue(signupPage.TEXT_WELCOME_TO_ACCOUNT.getText().contains("Welcome to your account."));
        assertTrue(signupPage.LINK_LOGOUT.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }
    @Then("^I login with (.*?),(.*?)$")
    public void I_login_with_email_password(String email,String password)
    {
        wait.until(ExpectedConditions.visibilityOf( loginPage.EDIT_EMAIL_LOGIN)).sendKeys(email);
        loginPage.EDIT_PASSWORD.sendKeys(password);
        loginPage.BUTTON_SIGNIN.click();
    }

    @Then("^I verify login is successful (.*?)$")
    public void I_verify_login_successful(String name)
    {


        Assert.assertEquals("MY ACCOUNT", signupPage.TITLE_MYACCOUNT.getText());
        Assert.assertEquals(name, signupPage.TEXT_CUSTOMERNAME.getText());
        assertTrue(signupPage.TEXT_WELCOME_TO_ACCOUNT.getText().contains("Welcome to your account."));
        assertTrue(signupPage.LINK_LOGOUT.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    @And("^I click the women tab$")
    public void I_click_the_women_tab() throws Throwable{
     homePage.LINK_WOMEN.click();

    }

    @And("^I select the product (.*?)$")
    public void I_select_the_product(String product) throws Throwable{
        driver.findElement(By.xpath("//a[@title='"+product+"']/ancestor::li")).click();
        driver.findElement(By.xpath("//a[@title='"+product+"']/ancestor::li")).click();


    }
    @And("^I click add to cart$")
    public void I_click_add_to_cart() throws Throwable{
        cartPage.BUTTON_ADD_TO_CART.click();

    }
    @And("^I click proceed to checkout$")
    public void I_click_proceed_to_checkout() throws Throwable
    {

        wait.until(ExpectedConditions.visibilityOf(cartPage.BUTTON_PROCEED_TO_CHECKOUT));
        cartPage.BUTTON_PROCEED_TO_CHECKOUT.click();
        cartPage.BUTTON_PROCEED_TO_CHECKOUT_SUMMARY.click();
        cartPage.BUTTON_PROCEED_ADDRESS.click();
        //click on the terms of service agreement check box
        wait.until(ExpectedConditions.visibilityOf(cartPage.CHECKBOX_TERMS));
        cartPage.CHECKBOX_TERMS.click();
        cartPage.BUTTON_PROCEED_SHIPPING.click();
    }
    @And("^I click pay by wire$")
    public void I_click_pay_by_wire() throws Throwable{
        wait.until(ExpectedConditions.visibilityOf(cartPage.BUTTON_BANKWIRE)).click();

    }

    @And("^I click confirm order$")
    public void I_click_confirm_order() throws Throwable{
        wait.until(ExpectedConditions.visibilityOf(cartPage.BUTTON_CONFIRM_ORDER)).click();

    }

    @Then("^I verify order is successful$")
    public void I_verify_order_successful() throws Throwable
    {


        Assert.assertEquals("ORDER CONFIRMATION", cartPage.TITLE_ORDER_CONFIRMATION.getText());
        assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
        assertTrue(cartPage.TITLE_ORDER_COMPLETION.getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
    }


    //*****Utility functions **********//

    // generate a random string with given number of characters.
    public  String generateRandomString(int count) {
          final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
          final SecureRandom RANDOM = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

}
