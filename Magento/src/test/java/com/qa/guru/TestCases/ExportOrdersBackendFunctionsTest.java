package com.qa.guru.TestCases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//Export all Orders in csv file and display these information in console and 
// you are able to send this file to another email id as attachment 

// Note: Access to backend of the site. UserId "user01" and pw "guru99com"
public class ExportOrdersBackendFunctionsTest {
		public WebDriver driver;
		File folder;
	
	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws Exception {
		
//		folder = new File(UUID.randomUUID().toString());
//		folder.mkdir(); // make the random file inside the package
//		
//		
//		//chrome:
//		//System.setProperty("webdriver.chrome.driver","C:\\eclipse_workspace\\Magento\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("profile.default_content_settings.popups",0); // disable any window popup 
//		prefs.put("download.defalt_directory", folder.getAbsolutePath());// get the path of randmly created directory
//		
//		options.setExperimentalOption("prefs", prefs);
//		
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability(ChromeOptions.CAPABILITY, options);
//		
//		driver = new ChromeDriver(cap);
		
		driver= new ChromeDriver();
	  
		driver.get("http://live.demoguru99.com/index.php/backendlogin/");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }
	
	@Test
	public void ExportOrdersBackendFunctions() {
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		try {Thread.sleep(5000);}catch(Exception e){};
		
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
	    // click the Sales tab 
	    driver.findElement(By.linkText("Sales")).click(); 
	   
	    try {Thread.sleep(5000);}catch(Exception e){};
	    
	    // click the Orders sub tab
	    
	    driver.findElement(By.linkText("Orders")).click();                                    
	    
	    try {Thread.sleep(5000);}catch(Exception e){};
		
	    for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 
	    
	    try {Thread.sleep(5000);}catch(Exception e){};			
		
		// Select 'CSV' in Export To dropdown and click Export button.		
		
		driver.findElement(By.xpath("//button[@title = 'Export']")).click();
		
		
		try { Thread.sleep(5000); } catch (InterruptedException e2) { e2.printStackTrace(); }
		
		// make sure the directory is not empty
//		File listOfFiles[] = folder.listFiles();
//		Assert.assertTrue(listOfFiles.length>0);  
//		
//		// make sure the downloaded file is not empty
//		for(File file : listOfFiles) {
//			Assert.assertTrue(file.length()>0); 
//		}
		
		// get the file path of downloaded file 
		String filePath = System.getProperty("user.home")+"/Downloads/orders.csv";
		
		
		// Read downloaded file and display the Heading and all the Order details in the console windows
					File f = new File(filePath);
					try {
						FileReader fr = new FileReader(f);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						while(line!=null){
							System.out.println(line);
							line = br.readLine();
						}
						fr.close();
						br.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	 }
	@AfterMethod
	public void tearDown() {
		driver.quit();
//		for(File file: folder.listFiles()) {
//			file.delete();
//		}
//		folder.delete();
	}
	
	
}
