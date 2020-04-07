package stepDefinition;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class StepDefinition
{
    @After
            public void closeBrowser(){
      driver.quit();
    }

    WebDriver driver;
    @Given("i am on waltz home page")
    public void i_am_on_waltz_home_page() {
    System.out.println("launch waltz");
    System.setProperty("webdriver.chrome.driver","D:\\git\\waltz-testscripts\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://ec2-34-208-125-3.us-west-2.compute.amazonaws.com:8081/waltz-web/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("i want to search application {string}")
    public void i_want_to_search_application(String string) {
        System.out.println("Search Application");
        driver.findElement(By.xpath("//a[text()=' Search ']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
        driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]")).click();
        //driver.findElement(By.xpath("//a[contains(text(),'View')]")).click();
    }

    @Then("application details should be displayed")
    public void application_details_should_be_displayed() {
        System.out.println("results displayed");
    }

    @Then("view the {string} associated wth it")
    public void view_the_associated_wth_it(String string) {
        System.out.println("view "+string);
        driver.findElement(By.xpath("//span[text()='"+string+"']")).click();
    }


    @And("create a tag")
    public void createATag() {
    System.out.println("tag created");
    }

    @When("i want to search {string}")
    public void iWantToSearch(String arg0) {
    }

    @Then("person details should be displayed")
    public void personDetailsShouldBeDisplayed() {
    }

    @And("create a tag {string}")
    public void createATag(String strTag) {
        driver.findElement(By.xpath("//i[contains(text(),'tags')]/a[contains(text(),'add one')]")).click();
        driver.findElement(By.xpath("//input[@class='input ng-pristine ng-untouched ng-valid ng-empty']")).sendKeys(strTag);
        driver.findElement(By.xpath("//button[@class='btn btn-xs']")).click();

    }

    @And("remove tag {string}")
    public void removeTag(String strRemove) {

        driver.findElement(By.xpath("//a[contains(text(),'update')]")).click();
        driver.findElement(By.xpath("//a[@class='remove-button']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-xs']")).click();
    }
}
