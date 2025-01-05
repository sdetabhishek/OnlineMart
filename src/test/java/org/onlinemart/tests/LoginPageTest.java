package org.onlinemart.tests;

import com.onlinemart.base.TestBase;
import com.onlinemart.pages.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

	public LoginPageTest() {
		super();
	}

	@Test(dataProvider="getData")
	public void validateLogin(HashMap<String, String> input) {

		launchBrowser();
		LoginPage loginPage = new LoginPage();
		loginPage.loginApplication(input.get("username"), input.get("password"));

	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\1118a\\IdeaProjects\\onlinemart\\src\\main\\resources\\TestData.json");
		return new Object[][]  {{data.get(0)}};
		
	}

}
