package Pages;

import StepDefinition.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {


    public SignupPage() {

        PageFactory.initElements(BaseTest.driver, this);
    }

    //Salutation options
    @FindBy(how= How.ID, using="uniform-id_gender1")
    public static WebElement SALUTATION_MR;

    @FindBy(how= How.ID, using="uniform-id_gender2")
    public static WebElement SALUTATION_MRS;

    //Personal details section

    //Firstname
    @FindBy(how= How.ID, using="customer_firstname")
    public static WebElement EDIT_FIRSTNAME;
    //Lastname
    @FindBy(how= How.ID, using="customer_lastname")
    public static WebElement EDIT_LASTNAME;
    //Password
    @FindBy(how= How.ID, using="passwd")
    public static WebElement EDIT_PASSWORD;
    // Date of birth - Day
    @FindBy(how= How.ID, using="days")
    public static WebElement SELECT_DAY;
    // Date of birth - Month
    @FindBy(how= How.ID, using="months")
    public static WebElement SELECT_MONTH;
    // Date of birth - Year
    @FindBy(how= How.ID, using="years")
    public static WebElement SELECT_YEAR;

    // Address details section

    //Company
    @FindBy(how= How.ID, using="company")
    public static WebElement EDIT_COMPANY;
    // Address1
    @FindBy(how= How.ID, using="address1")
    public static WebElement EDIT_ADDRESS1;
    //Address2
    @FindBy(how= How.ID, using="address2")
    public static WebElement EDIT_ADDRESS2;
    //City
    @FindBy(how= How.ID, using="city")
    public static WebElement EDIT_CITY;
    //State
    @FindBy(how= How.ID, using="id_state")
    public static WebElement SELECT_STATE;
    //Postcode
    @FindBy(how= How.ID, using="postcode")
    public static WebElement EDIT_POSTCODE;
    //Additional information
    @FindBy(how= How.ID, using="other")
    public static WebElement EDIT_OTHER;
    //Phone
    @FindBy(how= How.ID, using="phone")
    public static WebElement EDIT_PHONE;
    //Mobile
    @FindBy(how= How.ID, using="phone_mobile")
    public static WebElement EDIT_MOBILE;
    //Alias
    @FindBy(how= How.ID, using="alias")
    public static WebElement EDIT_ALIAS;

    //Register button
    @FindBy(how= How.ID, using="submitAccount")
    public static WebElement BUTTON_SUBMIT;


    // Signup completion page

    //MY ACCOUNT title
    @FindBy(how= How.CSS, using="h1")
    public static WebElement TITLE_MYACCOUNT;

    //Customer name text
    @FindBy(how= How.CLASS_NAME, using="account")
    public static WebElement TEXT_CUSTOMERNAME;
    // Welcome to account text
    @FindBy(how= How.CLASS_NAME, using="info-account")
    public static WebElement TEXT_WELCOME_TO_ACCOUNT;
    //Logout link
    @FindBy(how= How.CLASS_NAME, using="logout")
    public static WebElement LINK_LOGOUT;



}
