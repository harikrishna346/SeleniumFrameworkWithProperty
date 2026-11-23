package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Register link
    @FindBy(xpath = "//a[text()='REGISTER']")
    WebElement registerLink;

    // Username
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;

    // Password
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    // Confirm Password
    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPwd;

    // Submit button
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submit;

    // Registration method
    public void registration() {

        registerLink.click();

        System.out.println("Registration Page opened successfully");
    }

    // Scroll method
    public void scrollTo() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500)");

        System.out.println("Page scrolled successfully");
    }



    public void login(String user, String pwd, String confirmPwdValue) {

        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pwd);

        confirmPwd.clear();
        confirmPwd.sendKeys(confirmPwdValue);

        submit.click();

        System.out.println("Registration submitted for: " + user);
    }

}









