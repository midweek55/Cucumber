package Steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	By element1 =  By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	By element2 =  By.name("email_create");
	By element3 = By.name("SubmitCreate");
	By ele4 = By.xpath("//*[@id=\"customer_firstname\"]");
	By ele5 = By.id("customer_lastname");
	By ele6 = By.id("passwd");
	By ele8 = By.id("company");
	By ele9 = By.id("address1");
	By ele10 = By.id("city");
	By ele11 = By.id("postcode");
	By ele12 = By.id("phone_mobile");
	By ele13 = By.id("alias");
	By ele14 = By.id("submitAccount");
	By ele15 = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
	WebDriver driver;
	 
	@Before
	public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();   
        driver.manage().window().maximize();
        
	}
	@Given("I want to access the page")
	public void Step1() {
		driver.navigate().to("http://automationpractice.com");
	}
	@Then("I select the button Sing In")
	public void Step2() {
		driver.findElement(element1).click();
	}
	@Then("I write")
	public void Step3(DataTable a) throws InterruptedException {
		driver.findElement(element2).sendKeys(a.cell(0, 1));
		driver.findElement(element3).click();
		Thread.sleep(3000);
		try {
		driver.findElement(ele4).sendKeys(a.cell(1, 1));
		}catch (Exception e) {
			assertEquals(true, driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText());
		}
		driver.findElement(ele5).sendKeys(a.cell(2, 1));
		driver.findElement(ele6).sendKeys(a.cell(3, 1));
		driver.findElement(ele8).sendKeys(a.cell(4, 1));
		driver.findElement(ele9).sendKeys(a.cell(5, 1));
		driver.findElement(ele10).sendKeys(a.cell(6, 1));
		Select x = new Select(driver.findElement(By.id("id_state")));
		x.selectByIndex(4);
		Select y = new Select(driver.findElement(By.id("id_country")));
		x.selectByIndex(4);
		driver.findElement(ele11).sendKeys(a.cell(7, 1));
		driver.findElement(ele12).sendKeys(a.cell(8, 1));
		driver.findElement(ele13).sendKeys(a.cell(9, 1));
		Thread.sleep(500);
		driver.findElement(ele14).click();
		Thread.sleep(8000);
		String user = a.cell(2, 1)+" "+a.cell(3, 1);
		assertEquals(false, driver.findElement(ele15).getText().equals(user));
	}
	@After
	public void Exit() {
		driver.quit();
	}
}
