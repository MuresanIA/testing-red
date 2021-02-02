import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login-dev.redplatform.com/auth/realms/red_platform_dev/protocol/openid-connect/auth?client_id=nxredcrowdfunding&redirect_uri=https%3A%2F%2Fvlec-dev.redplatform.com%2F&state=34c587eb-f439-4b86-8658-34048dfab86d&response_mode=fragment&response_type=code&scope=openid&nonce=2385d9cb-c01f-4bcb-bed3-b2123df6a11c");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("kc-login"));

        username.sendKeys("muresan.alexandru933@gmail.com");
        password.sendKeys("Test123!");
        loginButton.click();
        System.out.println("Login successful!");

        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("canvas")));

        List<WebElement> burger = driver.findElements(By.xpath("//*[@id=\"client-area-content\"]/red-platform-client-area-home/ion-header/ion-toolbar/ion-buttons/ion-menu-button//button"));

        if (burger.size() > 0) {
            burger.get(0).click();
        }

        WebElement supplierButton = driver.findElement(By.id("testing_SupplierButton"));
        supplierButton.click();

        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testing_RoleInfoImg")));

        WebElement becomeASupplierButton = driver.findElement(By.xpath("//*[@id=\"client-area-content\"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button"));
//                                                                       //*[@id="client-area-content"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button//button

        becomeASupplierButton.click();

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"client-area-content\"]/red-platform-create-supplier/ion-content/red-platform-create-supplier-component/form")));

        WebElement empoweredFullNameTextField = driver.findElement(By.xpath("//*[@id=\"testing_SupplierEmpoweredFullName\"]/div[2]/input"));
        empoweredFullNameTextField.sendKeys("Does it work?");
    }
}
