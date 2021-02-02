import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://landingpage-dev.redplatform.com/en/");
        driver.manage().window().maximize();

        String expectedTitle = "Green Certification for Companies - red";
        String actualTitle = "";

        WebElement greenCertification = driver.findElement(By.id("menu-item-214"));
        greenCertification.click();

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test passed! Green Certification for Companies - red is a valid title!");
        }else {
            System.out.println("Test failed!");
        }

        driver.close();
    }
}
