import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserTest {
	  WebDriver wd=null;
		@BeforeTest
		public void intiate() {
			System.out.println("config intiated");
			//register the webdriver =>browser vendor 
					WebDriverManager.edgedriver().setup();
					//creating an object to the object
					 wd=new EdgeDriver();
					//maximize the browser
					wd.manage().window().maximize();
		}
		
		
		
		@Test
		public void test1() {
			System.out.println("test1 intiated");
			wd.get("http://localhost:4200");
			wd.findElement(By.xpath("//*[@id=\"left-sidebar\"]/ul/li[10]/a")).click();
			wd.findElement(By.id("name")).sendKeys("abcde");
			wd.findElement(By.id("email")).sendKeys("abcde@gmail.com");
			wd.findElement(By.id("mobile")).sendKeys("8712332111");
			wd.findElement(By.id("address")).sendKeys("Andhra Pradesh");
			wd.findElement(By.id("username")).sendKeys("abcde");
			wd.findElement(By.id("password")).sendKeys("4567");
			wd.findElement(By.xpath("//*[@id=\"content-area\"]/app-userregister/html/body/div/div[1]/form/button")).click();
		
			
			
			
			
		}
		@Test
		public void test2() throws InterruptedException {
			System.out.println("test2 intiated");
			wd.get("http://localhost:4200/userlogin");
			wd.findElement(By.xpath("//*[@id=\"left-sidebar\"]/ul/li[9]/a")).click();
			wd.findElement(By.id("username")).sendKeys("abcde");
			
			wd.findElement(By.id("password")).sendKeys("4567");
			
			wd.findElement(By.xpath("//*[@id=\"login-box\"]/form/div[3]/button")).click();
			wd.findElement(By.xpath("//*[@id=\"login-box\"]/form/div[3]/button")).click();
			//special items
			wd.findElement(By.xpath("//*[@id=\"left-sidebar\"]/ul/li[17]/a")).click();
			Thread.sleep(2000);
			//about us
			wd.findElement(By.xpath("//*[@id=\"left-sidebar\"]/ul/li[16]/a")).click();
			Thread.sleep(2000);
			//contacct us
			wd.findElement(By.xpath("//*[@id=\"left-sidebar\"]/ul/li[15]/a")).click();
			Thread.sleep(2000);
			
		}

		@Test(priority=3)
		public void test3() {
			System.out.println("test3 intiated");
			wd.get("http://localhost:4200/update-profile");
			wd.findElement(By.id("name")).sendKeys("ram");
			wd.findElement(By.id("email")).sendKeys("ram@12");
			wd.findElement(By.id("mobile")).sendKeys("58794511");
			wd.findElement(By.id("address")).sendKeys("delhi");
			wd.findElement(By.id("newPassword")).sendKeys("258");
		
			
			wd.findElement(By.xpath("//*[@id=\"content-area\"]/app-update-profile/html/body/div/div[1]/form/div[7]/button")).click();

			
			
		}

		
		@Test(priority=4)
		public void test4() {
			System.out.println("test4 intiated");
			wd.get("http://localhost:4200/searchtable");
			wd.findElement(By.id("username")).sendKeys("1");
			wd.findElement(By.xpath("//*[@id='login-box']/div[2]/button")).click();

						
			
		}

		@Test(priority=5)
		public void test5() {
			System.out.println("test5 intiated");
			wd.get("http://localhost:4200/user-menu-list");
			wd.findElement(By.cssSelector("#content-area > app-user-menu-list > div > input")).sendKeys("coffee");
			wd.findElement(By.xpath("//*[@id=\"content-area\"]/app-user-menu-list/div/button")).click();
		
			
			
		}
		

		
		
		
		@AfterTest
		public void  derefer() {
			System.out.println("wd closed");
			wd.close();
		}

}
