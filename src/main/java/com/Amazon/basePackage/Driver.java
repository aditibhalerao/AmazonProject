package com.Amazon.basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Amazon.constants.ConstantValues;
import com.Amazon.pageClasses.HomePage;

public class Driver {
	
	public static WebDriver d =null;
	private static Properties prop;
	private File src;
	private FileInputStream fis;
	
	public Driver() throws IOException {
		
	src =new File(ConstantValues.PROPERTIESFILE);
	fis= new FileInputStream(src);
	prop = new Properties();
	prop.load(fis);
		
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ConstantValues.CHROMEDRIVER);
		d = new ChromeDriver();
	}else {
		System.out.println("This framework works on Chrome. "
				+ "Kindly provide Chrome browser in properties file");
	}
		
	}
	
	public static HomePage startDriver() {
		d.get(prop.getProperty("url"));
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return new HomePage();
	}
	
	

}
