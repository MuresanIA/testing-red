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
        System.out.println("Test: Login successful!");

        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("canvas")));
        System.out.println("Test: Wait for canvas successful!");
        List<WebElement> burger = driver.findElements(By.xpath("//*[@id=\"client-area-content\"]/red-platform-client-area-home/ion-header/ion-toolbar/ion-buttons/ion-menu-button//button"));

        if (burger.size() > 0) {
            burger.get(0).click();
        }

        System.out.println("Test: Burger menu successful!");
        WebElement supplierButton = driver.findElement(By.id("testing_SupplierButton"));
        supplierButton.click();
        System.out.println("Test: Supplier Button Successful!");
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testing_RoleInfoImg")));
        System.out.println("Test: Expected Conditions: Element RoleInfoImg Located Successful!");
        WebElement becomeASupplierButton = driver.findElement(By.xpath("//*[@id=\"client-area-content\"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button"));
//                                                                       //*[@id="client-area-content"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button//button

        becomeASupplierButton.click();
        System.out.println("Test: Click on Become A Supplier Button Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"client-area-content\"]/red-platform-create-supplier/ion-content/red-platform-create-supplier-component/form")));
        System.out.println("Test: Expected Conditions: Client Area Content Successful!");
        WebElement empoweredFullNameTextField = driver.findElement(By.xpath("//*[@id=\"testing_SupplierEmpoweredFullName\"]/div[2]/input"));
        empoweredFullNameTextField.sendKeys("Test Empowered Full Name");
        System.out.println("Test: Empowered Full Name Successful!");

        WebElement companyName = driver.findElement(By.xpath("//*[@id=\"testing_SupplierCompanyName\"]/div[2]/input"));
        companyName.sendKeys("Test Company Name");
        System.out.println("Test: Company Name Successful!");

        WebElement identificationNUmber = driver.findElement(By.xpath("//*[@id=\"testing_SupplierCompanyIdentificationNumber\"]/div[2]/input"));
        identificationNUmber.sendKeys("Test Identification Number");
        System.out.println("Test: Identification Number Successful!");

        WebElement vatCode = driver.findElement(By.xpath("//*[@id=\"testing_SupplierVatCode\"]/div[2]/input"));
        vatCode.sendKeys("Test VAT Code");
        System.out.println("Test: VAT Code Successful!");

        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"testing_autocompleteForm\"]"));
        selectCountry.click();
        System.out.println("Test: Click Country Search Bar Element Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_search\"]/div/input")));
        WebElement searchBarSelectCountry = driver.findElement(By.xpath("//*[@id=\"testing_search\"]/div/input"));
        searchBarSelectCountry.sendKeys("Romania");
        System.out.println("Test: Sending Keys to Search Bar Select Country Successful!");


        driver.close();

    }
}
