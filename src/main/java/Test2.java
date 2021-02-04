import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
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
        System.out.println("Test: Identifying Web Element Canvas successful!");
        List<WebElement> burger = driver.findElements(By.xpath("//*[@id=\"client-area-content\"]/red-platform-client-area-home/ion-header/ion-toolbar/ion-buttons/ion-menu-button//button"));

        if (burger.size() > 0) {
            burger.get(0).click();
        }

        System.out.println("Test: Identifying Burger menu successful!");
        WebElement supplierButton = driver.findElement(By.id("testing_SupplierButton"));
        supplierButton.click();
        System.out.println("Test: Click On Supplier Button Successful!");
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("testing_RoleInfoImg")));
        System.out.println("Test: Expected Conditions: Element RoleInfoImg Located Successful!");
        WebElement becomeASupplierButton = driver.findElement(By.xpath("//*[@id=\"client-area-content\"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button"));
                                                                       //*[@id="client-area-content"]/red-platform-supplier/ion-content/ion-grid/ion-row/ion-col/red-platform-role-info/div/div/div[3]/ion-button//button

        becomeASupplierButton.click();
        System.out.println("Test: Click on Become A Supplier Button Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"client-area-content\"]/red-platform-create-supplier/ion-content/red-platform-create-supplier-component/form")));
        System.out.println("Test: Expected Conditions: Client Area Content Successful!");
        WebElement empoweredFullNameTextField = driver.findElement(By.xpath("//*[@id=\"testing_SupplierEmpoweredFullName\"]/div[2]/input"));
        empoweredFullNameTextField.sendKeys("Test Empowered Full Name");
        System.out.println("Test: Sending Keys to Empowered Full Name Successful!");

        WebElement companyName = driver.findElement(By.xpath("//*[@id=\"testing_SupplierCompanyName\"]/div[2]/input"));
        companyName.sendKeys("Test Company Name");
        System.out.println("Test: Sending Keys to Company Name Successful!");

        WebElement identificationNUmber = driver.findElement(By.xpath("//*[@id=\"testing_SupplierCompanyIdentificationNumber\"]/div[2]/input"));
        identificationNUmber.sendKeys("Test Identification Number");
        System.out.println("Test: Sending Keys to Identification Number Successful!");

        WebElement vatCode = driver.findElement(By.xpath("//*[@id=\"testing_SupplierVatCode\"]/div[2]/input"));
        vatCode.sendKeys("Test VAT Code");
        System.out.println("Test: Sending Keys to VAT Code Successful!");

        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"testing_autocompleteForm\"]"));
        selectCountry.click();
        System.out.println("Test: Click On Country Search Bar Element Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_search\"]/div/input")));
        WebElement searchBarSelectCountry = driver.findElement(By.xpath("//*[@id=\"testing_search\"]/div/input"));
        searchBarSelectCountry.sendKeys("Romania");
        System.out.println("Test: Sending Keys to Search Bar Select Country Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_search_results\"]/ion-item[1]/ion-label/ion-text/h3")));
        WebElement selectRomaniaAsCountry = driver.findElement(By.xpath("//*[@id=\"testing_search_results\"]/ion-item[1]/ion-label/ion-text/h3"));
        selectRomaniaAsCountry.click();
        System.out.println("Test: Selecting Romania As Country Successful!");

        wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"client-area-content\"]/red-platform-create-supplier/ion-content/red-platform-create-supplier-component/form")));
        WebElement cityElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierCity\"]/div[2]/input"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", cityElement);
        cityElement.sendKeys("Test City Element");
        System.out.println("Test: Sending keys to City Element Successful!");

        WebElement streetAddressElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierStreet\"]/div[2]/input"));
        streetAddressElement.sendKeys("Test Street Address");
        System.out.println("Test: Sending Keys to Street Address Successful!");

        WebElement numberElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierHouseNumber\"]/div[2]/input"));
        numberElement.sendKeys("Test Number Element");
        System.out.println("Test: Sending Keys to Number Element Successful!");

        WebElement postalCodeElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierPostalCode\"]/div[2]/input"));
        postalCodeElement.sendKeys("Test Postal Code");
        System.out.println("Test: Sending Keys to Postal Code Element Successful!");

        WebElement phoneNumberElement = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", phoneNumberElement);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phone\"]")));
        phoneNumberElement.sendKeys("40211234567");
        System.out.println("Test: Sending Keys to Phone Number Element Successful!");

        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierEmail\"]/div[2]/input"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", emailElement);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_SupplierEmail\"]/div[2]/input")));
        emailElement.sendKeys("test@gmail.com");
        System.out.println("Test: Sending Keys to Email Element Successful!");

        WebElement bankNameElement = driver.findElement(By.xpath("//*[@id=\"testing_BankName\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", bankNameElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_BankName\"]")));
        bankNameElement.sendKeys("Test Bank Name");
        System.out.println("Test: Sending Keys to Bank Name Element Successful!");

        WebElement bankAddressElement = driver.findElement(By.xpath("//*[@id=\"testing_BankAddress\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", bankAddressElement);
        bankAddressElement.sendKeys("Test Bank Address");
        System.out.println("Test: Sending Keys to Bank Address Element Successful!");

        WebElement IBANElement = driver.findElement(By.xpath("//*[@id=\"testing_BankIban\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", IBANElement);
        IBANElement.sendKeys("Test IBAN Element");
        System.out.println("Test: Sending Keys to IBAN Element Successful!");


        WebElement licenseTypeElement = driver.findElement(By.xpath("//*[@id=\"testing_supplierLicenseType\"]"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", licenseTypeElement);
        licenseTypeElement.click();
        System.out.println("Test: Click On License Plate Element Successful!");

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ion-overlay-2\"]/div[2]")));
        WebElement checkBoxElectricity = driver.findElement(By.xpath("//*[@id=\"alert-input-2-0\"]"));
        checkBoxElectricity.click();
        System.out.println("Test: Click On Check Box Electricity Element Successful!");

        WebElement checkBoxSelectButton = driver.findElement(By.xpath("//*[@id=\"ion-overlay-2\"]/div[2]/div[4]/button[2]"));
        checkBoxSelectButton.click();
        System.out.println("Test: Click On Select Button from CheckBox Element Successful!");

        WebElement licensePlateElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierLicenceNumber\"]/div[2]/input"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", licensePlateElement);
        licensePlateElement.sendKeys("Test License Plate");
        System.out.println("Test: Sending Keys to License Plate Successful!");

        WebElement expireOnElement = driver.findElement(By.xpath("//*[@id=\"testing_SupplierLicenceExpire\"]/red-platform-datepicker-control"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", expireOnElement);
        expireOnElement.click();
        System.out.println("Test: Click On Expire On Element Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/div/mat-month-view/table/tbody/tr[1]/td")));
        WebElement chooseMonthAndYearElement = driver.findElement(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/mat-calendar-header/div/div/button[1]/span"));
        chooseMonthAndYearElement.click();
        System.out.println("Test: Click On Choose Month And Year Element Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/div/mat-multi-year-view/table/tbody/tr[2]/td[3]/div")));
        WebElement selectYear2022 = driver.findElement(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/div/mat-multi-year-view/table/tbody/tr[2]/td[3]/div"));
        selectYear2022.click();
        System.out.println("Test: Select Year 2022 Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]")));
        System.out.println("Test: Expected conditions Date Picker Successful!");
        WebElement selectMonthJune = driver.findElement(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/div/mat-year-view/table/tbody/tr[3]/td[2]/div"));
        selectMonthJune.click();
        System.out.println("Test: Select Month June Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[1]")));
        System.out.println("Test: Expected conditions Select Date Header Successful!");
        WebElement selectDateJun23 = driver.findElement(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[2]/red-platform-calendar/mat-calendar/div/mat-month-view/table/tbody/tr[4]/td[5]/div"));
        selectDateJun23.click();
        System.out.println("Test: Click On Jun 23 Successful!");

        WebElement clickOnSelectButton = driver.findElement(By.xpath("//*[@id=\"ion-overlay-3\"]/div[2]/red-platform-detepicker-modal/section[3]/ion-grid/ion-row/ion-col[1]/ion-button"));
        clickOnSelectButton.click();
        System.out.println("Test: Click On Select Button Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_SupplierLicenceExpire\"]/red-platform-datepicker-control")));
        System.out.println("Test: Expected Conditions Testing Supplier Licence Expire Successful!");
        WebElement agreeSupplierCheckBox = driver.findElement(By.xpath("//*[@id=\"testing_SupplierAcceptTnc\"]/ion-checkbox"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", agreeSupplierCheckBox);
        agreeSupplierCheckBox.click();
        System.out.println("Test: Click On Agree To The Terms CheckBox Successful!");

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"testing_SupplierAcceptGdpr\"]/ion-checkbox")));
        System.out.println("Test: Expected Conditions Testing Supplier CheckBox Successful!");
        WebElement dataPrivacyPolicy = driver.findElement(By.xpath("//*[@id=\"testing_SupplierAcceptGdpr\"]/ion-checkbox"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", dataPrivacyPolicy);
        dataPrivacyPolicy.click();
        System.out.println("Test: Click On Data Privacy Policy CheckBox Successful!");

//        wait = new WebDriverWait(driver, 20);
//        driver.close();

    }
}
