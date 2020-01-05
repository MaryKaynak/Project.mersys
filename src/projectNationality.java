import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class  projectNationality{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilal\\TechnoStudy\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        // to select "Setup"
        driver.findElement(By.cssSelector(".group-items > :nth-child(1)")).click();
        // to select "Parameters"
        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1)")).click();
        // to select "Nationalities"
        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1) .children > :nth-child(4)")).click();
        // click on the plus button
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();

        WebElement nametext = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME'] > input"));
        String myUniquename = "Hilal";
        nametext.sendKeys(myUniquename);

        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon='save'] "));
        saveIcon.click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Nationality successfully created'")));
            System.out.println("Creation Success!");
        } catch (Exception e) {
            System.out.println("CreationFailure!");
        }

        WebElement mynametr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" +myUniquename+"']")));
        driver.findElement(By.cssSelector("tbody > tr:first-child ms-edit-button")).click();
        WebElement editTextbox = driver.findElement( By.cssSelector( "mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input" ) );
        editTextbox.sendKeys( "1" );

        WebElement editSaveButton = driver.findElement( By.cssSelector( "mat-dialog-container [data-icon=\"save\"]" ) );
        editSaveButton.click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Nationality successfully updated']" ) ) );
            System.out.println("Updated success!");
        } catch( Exception e) {
            System.out.println("Updated failure!");
        }


        wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[text()='" + myUniquename + "1" + "']" ) ) );
        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();

        driver.findElement( By.cssSelector( "mat-dialog-container button[type=\"submit\"]" ) ).click();

        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Nationality successfully deleted']" ) ) );
            System.out.println("Deleted success!");
        } catch( Exception e) {
            System.out.println("Deleted failure!");
        }
    }
}







