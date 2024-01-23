import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class AdminTest 
{
	WebDriver wd = null;

	@BeforeTest
	public void intiate() 
	{
		//register the webdriver =>browser vendor 
		WebDriverManager.edgedriver().setup();

		//creating an object to the object
		wd = new EdgeDriver();

		//maximize the browser
		wd.manage().window().maximize();

	}

	@Test(priority = 1)
	public void OpenPage() throws InterruptedException {


		JavascriptExecutor js = (JavascriptExecutor) wd;

		//open link
		System.out.println("Open the link ");
		wd.get("http://localhost:4200/");

		//get page title
		String pageTitle = wd.getTitle();
		System.out.println("Page Title: " + pageTitle);
		Thread.sleep(2000);

	}


	@Test(priority = 2)
	public void AdminLogin() throws InterruptedException {

		//Go to admin login page
		wd.findElement(By.linkText("Admin")).click();	
		Thread.sleep(2000);

		//Enter admin credentials
		wd.findElement(By.id("username")).sendKeys("abi");
		wd.findElement(By.id("password")).sendKeys("123456");
		wd.findElement(By.cssSelector("#login > section > div > div > div > div > div > form > div:nth-child(3) > button")).click();	
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void AddMenu() throws InterruptedException {

		//Go to add menu page
		wd.findElement(By.linkText("Add Menu")).click();	
		Thread.sleep(2000);

		//Enter item details
		wd.findElement(By.cssSelector("#name")).sendKeys("French Toast");
		wd.findElement(By.cssSelector("#ItemPrice")).sendKeys("200");
		wd.findElement(By.cssSelector("#Description")).sendKeys("A delectable French toast savory dish featuring flavorful olive bread, sausage, and mushrooms.");
		wd.findElement(By.cssSelector("#Status")).sendKeys("Available");		
		wd.findElement(By.cssSelector("#add-menu > div > form > div.text-center > button")).click();	
		Thread.sleep(2000);

	}


	@Test(priority = 4)
	public void AddTable() throws InterruptedException {

		//Go to add table page
		wd.findElement(By.linkText("Add Tables")).click();	
		Thread.sleep(2000);

		//Enter table details
		wd.findElement(By.cssSelector("#tablerow")).sendKeys("1");
		wd.findElement(By.cssSelector("#tablenumber")).sendKeys("2");
		wd.findElement(By.cssSelector("#tablecapacity")).sendKeys("3");
		wd.findElement(By.cssSelector("#tabletype")).click();		
		wd.findElement(By.cssSelector("#tabletype > option:nth-child(1)")).click();	
		wd.findElement(By.cssSelector("#login > div > div > form > button")).click();	
		Thread.sleep(2000);
	}


	@Test(priority = 5)
	public void MenuPageUpdate() throws InterruptedException {

		//Go to menu page
		wd.findElement(By.linkText("Complete Menu")).click();	
		Thread.sleep(2000);

		//update item in menu
		
		wd.findElement(By.cssSelector("#menu-list > div.table-responsive > table > tbody > tr > td.text-center > button.btn.btn-warning")).click();
		wd.findElement(By.cssSelector("#name")).clear();
		wd.findElement(By.cssSelector("#name")).sendKeys("Classic French Toast");
		wd.findElement(By.cssSelector("#ItemPrice")).clear();
		wd.findElement(By.cssSelector("#ItemPrice")).sendKeys("180");
		wd.findElement(By.cssSelector("body > div > div.col-md-6.offset-md-3 > form > button")).click();
		wd.findElement(By.linkText("Complete Menu")).click();	
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void MenuPageDelete() throws InterruptedException {

		//Go to menu page
		wd.findElement(By.linkText("Complete Menu")).click();	
		Thread.sleep(2000);

		//delete item in menu

		wd.findElement(By.cssSelector("#menu-list > div > table > tbody > tr > td.text-center > button.btn.btn-danger.ml-2")).click();	
		Thread.sleep(2000);

	}


	@Test(priority = 7)
	public void ConfirmReservations() throws InterruptedException {

		//Go to Confirm Reservations page
		wd.findElement(By.linkText("Confirm Reservations")).click();
		Thread.sleep(2000);

		//confirm reservation
		//wd.findElement(By.xpath("//*[@id=\"content-area\"]/app-confirm-reservation/html/body/div/div[2]/table/tbody/tr/td[7]/button")).click();		
		wd.findElement(By.id("confirm-reservation")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void Logout() throws InterruptedException {

		//Click on logout
		wd.findElement(By.linkText("Logout")).click();	
		Thread.sleep(2000);

	}

	@AfterTest
	public void Close() throws InterruptedException 
	{

		Thread.sleep(2000);
		wd.close();

	}

}
