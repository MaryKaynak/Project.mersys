import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class fee {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilal\\TechnoStudy\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(" https://test-basqar.mersys.io/");
        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        // to select "Setup"
        driver.findElement(By.cssSelector(".group-items > :nth-child(1)")).click();
        // to select "Parameters"
        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1)")).click();

        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1) .children > :nth-child(7)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();

        WebElement nametext = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME'] > input"));
        String mylabname = "Lab Fees";
        nametext.sendKeys(mylabname);

        WebElement labcode = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.CODE'] > input"));
        String mylabcode = "Lab code";
        labcode.sendKeys(mylabcode);

        WebElement integrationcode = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.INTEGRATION_CODE'] > input"));
        String myintegrationcode = "12345";
        integrationcode.sendKeys(myintegrationcode);

        WebElement priority = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.PRIORITY'] > input"));
        String mypriority = "0";
        priority.sendKeys(mypriority);


        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon='save'] "));
        saveIcon.click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Fee Type successfully created'")));
            System.out.println("Creation Success!");
        } catch (Exception e) {
            System.out.println("Creation Failure!");
        }

        WebElement mynewlabname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + mylabname + "']")));
        driver.findElement(By.cssSelector("tbody > tr:first-child ms-edit-button")).click();

        WebElement editname = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input"));
        editname.sendKeys("4");

        WebElement editlabcode = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.CODE'] > input"));
        editlabcode.sendKeys("4");

        WebElement editintegrationcode = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.INTEGRATION_CODE'] > input"));
        editintegrationcode.sendKeys("4");

        WebElement editpriority = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.PRIORITY'] > input"));
        editpriority.sendKeys("1");

        WebElement editSaveButton = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        editSaveButton.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Fee Type successfully updated']")));
            System.out.println("Updated success!");
        } catch (Exception e) {
            System.out.println("Updated failure!");
        }

        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + mylabname + "4" + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();

        driver.findElement( By.cssSelector( "mat-dialog-container button[type=\"submit\"]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Fee Type successfully deleted']" ) ) );
            System.out.println("Deleted success!");
        } catch( Exception e) {
            System.out.println("Deleted failure!");
        }
         driver.quit();
    }
}

