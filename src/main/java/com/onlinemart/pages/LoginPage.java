package com.onlinemart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinemart.base.TestBase;

public class LoginPage extends TestBase {


    public LoginPage() {
        super();
     
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;


    public void loginApplication(String user, String pass) {

        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();


    }
}
