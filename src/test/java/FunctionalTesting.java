/**
 * @author Ishita Shah
 * expedia.ca
 * The code or test cases should be reused or used in any form with written consent from the author only.
 */

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FunctionalTesting {

	public static void main(String[] args) throws InterruptedException {

		//Open Chrome Browser....
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");

		//create an object of Chromedriver...
		WebDriver driver=new ChromeDriver();

		//manage window and type url
		driver.manage().window().maximize();//maximize window....
		driver.manage().deleteAllCookies();//delete all the cookies from browser...
		driver.get("https://www.expedia.ca/");
		Thread.sleep(3000);

		// go to Sign in page
		driver.findElement(By.xpath("//div[@id='gc-custom-header-nav-bar-acct-menu']/button")).click();
		Thread.sleep(2000);
		WebElement SigninButtonOnPopup = driver.findElement(By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[1]"));


		Actions SignInAction=new Actions(driver);
		SignInAction.moveToElement(SigninButtonOnPopup).click().build().perform();
		Thread.sleep(2000);

		//type credentials and click on sign in
		driver.findElement(By.id("loginFormEmailInput")).sendKeys("ishitashah282@yahoo.com");
		driver.findElement(By.id("loginFormPasswordInput")).sendKeys("TestingTask@123");
		Thread.sleep(2000);
		driver.findElement(By.id("loginFormSubmitButton")).click();
		
		//click on flights tab in user account home page
		driver.findElement(By.xpath("//span[contains(text(),'Flights')]")).click();
		Thread.sleep(2000);

		//click on One-way
		driver.findElement(By.xpath("//span[contains(text(),'One-way')]")).click();

		//Type Leaving from value
		 Thread.sleep(2000);

		 driver.findElement(By.xpath("//button[@class=\"uitk-fake-input uitk-form-field-trigger\"]")).click();
		 Thread.sleep(3000);
		 Actions act=new Actions(driver);
		 act.moveToElement(driver.findElement(By.id("location-field-leg1-origin"))).sendKeys("Delhi").build().perform();
		 Thread.sleep(2000);
		
		 //Type Going to value
		 driver.findElement(By.xpath("//button[@class=\"uitk-fake-input uitk-form-field-trigger\"][2]")).click();
		 Thread.sleep(2000);
		 Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.id("location-field-leg1-destination"))).sendKeys("Toronto").build().perform();
		 Thread.sleep(5000);
		
		 //Selecting date 
		 driver.findElement(By.id("d1-btn")).click();
		 driver.findElement(By.xpath("//td/button[@data-day=\"27\"][1]")).click();// Jan 27,2022
		 driver.findElement(By.xpath("(//div/button[contains(text(),'Done')])[2]")).click();
		 Thread.sleep(2000);

		 //click/hit the search button
		 driver.findElement(By.xpath("//div/button[contains(text(),'Search')]")).click();
		 Thread.sleep(3000);
		 
		//Click on cheapest flight
		driver.findElement(By.xpath("//button[@class=\"uitk-card-link\"][1]")).click();
		Thread.sleep(2000);

		//select the flight
		driver.findElement(By.xpath("//button[@data-stid=\"select-button\"]")).click();
		Thread.sleep(2000);

		//Select 'No thanks' for promotions
		driver.findElement(By.xpath("//div/a[contains(text(),'No thanks')]")).click();
		Thread.sleep(2000);

		//switching to checkout window
		Set<String> handles = driver.getWindowHandles();
		String mainWindowHandle = driver.getWindowHandle();

		for(String tab : handles) {
			if(!tab.equals(mainWindowHandle)) {
				driver.switchTo().window(tab);

				//hit logout
				driver.findElement(By.xpath("//div[@class=\"uitk-text uitk-type-300 uitk-text-default-theme\"][4]")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//div[@class=\"uitk-text uitk-type-300\"][3]")).click();

			}
		}
		driver.quit();
	}
}
