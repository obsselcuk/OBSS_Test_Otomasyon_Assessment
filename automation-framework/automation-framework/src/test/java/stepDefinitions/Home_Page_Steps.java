package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Home_Page_Steps {

    private WebDriver driver;
    JavascriptExecutor jse;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    }
/*
    @After
    public void teardown(){
        driver.quit();
    }
*/
    @Given("I access the home Page")
    public void i_access_the_home_page() {
        driver.get(" https://obss.com.tr/");
        System.out.println("Test1");
    }
    @And("I click on the Cookie Acceptance")
    public void i_click_on_the_cookie_acceptance() throws Exception {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='cookieAcceptance']")).click();
        System.out.println("Test_Cookie");
        System.out.println("Test2");

    }

    @And("I click on the search button")
    public void i_click_on_the_search_button() throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//img[@id='search-icon']")).click();
        System.out.println("Test3");
    }
    @And("I write automation to search field")
    public void i_write_automation_to_search_field() throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='search-box']")).sendKeys("Automation " + "\n");
        System.out.println("Test4");
    }
    @And("I search results are listed on the page")
    public void i_search_results_are_listed_on_the_page() throws Exception {
        Thread.sleep(2000);
        WebElement automation_Search_Message = driver.findElement(By.xpath("/html/body/div[@class='search-form']/div[@class='container-fluid']//div[@class='col-lg-8 col-md-8 text-start']/article[1]//a[@href='https://obss.com.tr/en/yetkinlikler/yetenekler/yazilim-testi-otomasyonu/']"));
        System.out.println(automation_Search_Message.getText());
        Assert.assertEquals(automation_Search_Message.getText(), "Testing & Automation");
        System.out.println("Test 5");
    }
    @And("I click on the first of the results")
    public void i_click_on_the_first_of_the_results() throws Exception {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[@class='search-form']/div[@class='container-fluid']//div[@class='col-lg-8 col-md-8 text-start']/article[1]//a[@href='https://obss.com.tr/en/yetkinlikler/yetenekler/yazilim-testi-otomasyonu/']")).click();
        System.out.println("Test 6");
    }
    @And("I verify testing and automation page opened")
    public void i_verify_testing_and_automation_page_opened() throws Exception {
        Thread.sleep(2000);
        WebElement testAndAutomation_page_message= driver.findElement(By.xpath("/html//div[@id='intro-industries']//h1[.='Testing & Automation']"));
        System.out.println(testAndAutomation_page_message.getText());
        Assert.assertEquals(testAndAutomation_page_message.getText(),"Testing & Automation");
        System.out.println("Test 7");
    }
    @And("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() throws Exception {
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
      //jse.executeScript("window.scrollBy(0,5689);");
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println("Test 8");
    }
    @Then("I verify obss footer")
    public void i_verify_obss_footer() throws Exception {
        Thread.sleep(2000);
        System.out.println("Test 9");
        WebElement obssfooter_contactus_message=driver.findElement(By.cssSelector(".col-lg-3.col-md-4.col-sm-12.small-text-center > h2"));
        System.out.println(obssfooter_contactus_message.getText());
        Assert.assertEquals(obssfooter_contactus_message.getText(),"© 2021 OBSS Technology");
        WebElement obssfooter_ourofices_message=driver.findElement(By.cssSelector(".footer-contact.row > .col-lg-9.col-md-9 > a:nth-of-type(2)"));
        System.out.println(obssfooter_ourofices_message.getText());
        Assert.assertEquals(obssfooter_ourofices_message.getText(),"Ankara");
    }


}
