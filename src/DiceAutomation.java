import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DiceAutomation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/amineileri/Documents/broweserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dice.com/");
        driver.manage().window().maximize();

        WebElement typeaheadInput = driver.findElement(By.id("typeaheadInput"));

        typeaheadInput.click();
        typeaheadInput.sendKeys("SDET");

        driver.findElement(By.id("google-location-search")).sendKeys("WashingtonDC");
        WebElement element1 = driver.findElement((By.id("submitSearch-button")));
        element1.click();

        Thread.sleep(2000);

        List<WebElement> elements =driver.findElements(By.xpath("//a[data-cy='card-title-link']"));
        Assert.assertEquals(20,elements.size());

        for (WebElement element : elements){
            Assert.assertTrue(element.getText().contains("SDET"));

        }

        Thread.sleep(3000);

        elements.get(elements.size()-1).click();

        Assert.assertTrue(driver.getTitle().contains("SDET"));

        driver.quit();


    }
}
