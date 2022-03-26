import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class AdviceSiteTest {

    @Test
    public void checkButtonIsDisplayed(){
        // tell the system where to find the chrome driver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        // create a new driver
        WebDriver driver = new ChromeDriver();

        // driver initialisation
        driver.get("http://127.0.0.1:5500/index.html");

        // identify button
        WebElement button = driver.findElement(By.xpath("//button[@id=\"btn\"]"));

        // click button
        assertTrue(button.isDisplayed());

        // close driver
        driver.quit();
    }

    @Test
    public void checkIfAdviceIsPopulated() throws InterruptedException {
        // tell the system where to find the chrome driver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        // create a new driver
        WebDriver driver = new ChromeDriver();

        // driver initialisation
        driver.get("http://127.0.0.1:5500/index.html");

        WebElement button = driver.findElement(By.xpath("//button[@id=\"btn\"]"));
        button.click();

        Thread.sleep(2000);

        WebElement advice = driver.findElement(By.xpath("//p[@id=\"advice\"]"));
        assertFalse(advice.getText().isEmpty());

        // close driver
        driver.quit();
    }
}