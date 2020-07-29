package getRequest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssignmentFlipkart {

    @Test
    public void TestFlipkartSearch() {

        Reporter.log("TC to test Flipkart Search functioanlity started", true);
        String  s_search_string = "Camera";
        String url = "https://www.flipkart.com";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devina\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(url);
        Reporter.log("Chrome Invoked and navigated to URL: " + url + "<br>", true);

        //Checking page is navigated with the expected title
        String actual = driver.getTitle();
        String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        Assert.assertEquals(actual, expected);
        Reporter.log("Page Navigated." + "<br>", true);

        //Clicking on Cross button
        WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
        sign_in_cross.click();
        Reporter.log("Sign In Window Closed." + "<br>", true);

        //Check Search Box is Displayed
        WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
        Assert.assertEquals(searchbx.isDisplayed(), true);
        Reporter.log("Search Box is displayed." + "<br>", true);

        //Enter Camera in Search text box
        searchbx.sendKeys(s_search_string);

        //Clicked on Search button
        driver.findElement(By.xpath("//button[@class='vh79eN']")).click();

        //Check if search Results is displayed-VALIDATION 1
        WebElement txtbx_search_result_text = driver.findElement(By.xpath("//span[contains(text(),'Showing 1 – 24 of 1,600 results for ')]"));
        Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);

        //Check if search Results is displayed-VALIDATION 2
        String exp_search_title = s_search_string;
        String actual_search_title = driver.getTitle();
        if(actual_search_title.toLowerCase().contains(exp_search_title.toLowerCase())) {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
        Reporter.log("Search Box set with value :" + s_search_string + " and search results displayed" + "<br>", true);

    }

}