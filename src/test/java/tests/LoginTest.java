package tests;

import Pages.LoginPage;
import base.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    // Step 1: Create DataProvider
    @DataProvider(name = "loginData")
    public Object[][] getLoginData()
    {

        return new Object[][]

                {

                {"Raghu2", "pass123", "pass123"},

                {"Venkatesh3", "pass456", "pass456"},

                {"praveen4", "pass789", "pass789"},


        };
    }

    // Step 2: Connect DataProvider to Test
    @Test(dataProvider = "loginData")
    public void init(String username, String password, String confirmPassword) {

    // Create LoginPage object
    LoginPage loginPage = new LoginPage(driver);

    // Open Registration page
        loginPage.registration();

    // Scroll down

        loginPage.scrollTo();

        // Enter multiple sets of data
        loginPage.login(username, password, confirmPassword);

    }
}















