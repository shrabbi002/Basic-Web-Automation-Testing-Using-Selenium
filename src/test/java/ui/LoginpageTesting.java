package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginpageTesting {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\Testing02\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Login Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        // Wait for the page to load and check for a successful login indicator
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        
        // Verify the presence of a known element after login
        WebElement dashboardHeader = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        Assert.assertNotNull(dashboardHeader, "Login not successful");
        
        

        // Print success message
        System.out.println("Login successfully done");
        
        
     
        // Optionally, you can wait for search results or verify something in the search results
        // e.g., wait for the presence of a user in the search result table
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']")));
    }
    }
    
    
    
    
    
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	
	



