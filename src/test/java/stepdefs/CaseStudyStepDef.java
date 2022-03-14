package stepdefs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class CaseStudyStepDef {
	WebDriver driver;

	@Given("Login into App")
	public void login_into_app() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("loginusername")).sendKeys("Ravi271092");
		Thread.sleep(1000);
		driver.findElement(By.id("loginpassword")).sendKeys("ravi2710");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@When("Add an item to cart")
	public void add_an_item_to_cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
	}

	@Then("Items must be added to cart")
	public void items_must_be_added_to_cart() throws InterruptedException {
		Thread.sleep(2000);
		Alert myAlert = driver.switchTo().alert();
		String actualText = myAlert.getText();
		
		Thread.sleep(1000);
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Product added.");
		myAlert.accept();
		Thread.sleep(2000);
		driver.close();
	}

	@When("List of Items should be available in cart")
	public void list_of_items_should_be_available_in_cart() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cart")).click();
			
		}

	@Then("Delete an item from Cart")
	public void delete_an_item_from_cart() throws InterruptedException {
		Thread.sleep(1000);
		int cnt=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr")).size();
		System.out.println("ROW COUNT : "+cnt);
		if (cnt>1) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			System.out.println("Items is deleted from Cart");
		}
		else
		{
			System.out.println("Only one Items in Cart");
		}
		Thread.sleep(6000);
		driver.close();
	}

	@Given("Items should be available in Cart")
	public void items_should_be_available_in_cart() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Cart")).click();
	}

	@When("Place Order")
	public void place_order() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}

	@Then("Purchase Items")
	public void purchase_items() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Ravi");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Jaynagar");
		driver.findElement(By.id("card")).sendKeys("212121211");
		driver.findElement(By.id("month")).sendKeys("Oct");
		driver.findElement(By.id("year")).sendKeys("2024");
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
