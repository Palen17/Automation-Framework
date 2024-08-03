package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public Logger logger; //Log4j

    @BeforeClass
    public void setup(){

        logger = LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomNumber(){
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomAlphaNumeric(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return (generatedString+"@"+generatedNumber);
    }
}
