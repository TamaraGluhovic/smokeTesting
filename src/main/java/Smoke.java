import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Smoke {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamara\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();
    }

    @Test
    public void testDesktopTitle() {
        WebElement desktop = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktop.click();
        WebElement desktopSection = driver.findElement(By.id("desktop"));
        String expectedResult = "Desktop";
        String actualResult = desktopSection.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMobileTitle() {
        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobile.click();
        WebElement mobileSection = driver.findElement(By.id("mobile"));
        String expectedResult = "Mobile";
        String actualResult = mobileSection.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}



