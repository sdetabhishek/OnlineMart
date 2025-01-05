package com.onlinemart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class TestBase {

   public static Properties prop;
   public static WebDriver driver;


    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\1118a\\IdeaProjects\\onlinemart\\src\\main\\java\\com\\onlinemart\\config\\config.properties");
            prop.load(fileInputStream);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


    public static void launchBrowser() {

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\1118a\\IdeaProjects\\onlinemart\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            System.out.println("Chrome Launched");

        } else {
            System.out.println("Firefox Launched");
        }

        

    }
    
    

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
	   
	  //read json to string
		
	  String jsonContent = 	FileUtils.readFileToString(new File(filePath));
	
	  //String to HashMap- Jackson Databind
	
	  ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	

	}
    }

