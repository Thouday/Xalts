package Assessment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Main {

    private WebDriver driver;
    private WebDriverWait wait;
    private static WebElements webElements;
    private Alert alert;

    @BeforeTest
    public void BeforeTest() {
        webElements = new WebElements();
    }

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://xaltsocnportal.web.app/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, webElements);
    }

    public void Credentials() {
        webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
        webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
    }

    public void Already_Account() {
        WebElement Already_Account = driver.findElement(By.xpath("//button[text()='Already have an account? Click here to sign in.']"));
        Already_Account.click();
    }

    public void DoNotHave_Account() {
        WebElement DoNotHave_Account = driver.findElement(By.xpath("//button[text()=\"Don't have an account? Click here to sign up.\"]"));
        wait.until(visibilityOf(DoNotHave_Account)).click();
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyser.class)
    public void SignIn() {
        webElements.getSignIn().click();
        webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
        webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
        webElements.getCredentialsFields().get(2).sendKeys("Pavan@24");
        if (webElements.getSignUp().isDisplayed()) {
            webElements.getSignUp().click();
            try {
                if (webElements.getSignOut().isDisplayed()) {
                    webElements.getSignOut().click();
                }
            } catch (Exception e) {
                System.out.println("Sign Out button not displayed, so Skipping...");
            }
            try {
                alert = wait.until(ExpectedConditions.alertIsPresent());
                alert = driver.switchTo().alert();
                System.out.println(alert.getText());
                alert.accept();
            } catch (Exception e) {
                System.out.println("Alert is not present, so Skipping...");
            }
        }
        Already_Account();
        webElements.getSignIn().click();
    }  // Run this method Seperately for new user SignIn through SignIn btn with new mail

    @Test // Currently disabled this Test Method
    public void GetStarted() {
        if (webElements.getGetStarted().isDisplayed()) {
            webElements.getGetStarted().click();
            webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
            webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
            webElements.getCredentialsFields().get(2).sendKeys("Pavan@24");
            if (webElements.getSignUp().isDisplayed()) {
                webElements.getSignUp().click();
                try {
                    if (webElements.getSignOut().isDisplayed()) {
                        webElements.getSignOut().click();
                    }
                } catch (Exception e) {
                    System.out.println("Sign Out button not displayed, so Skipping...");
                }
                try {
                    alert = wait.until(ExpectedConditions.alertIsPresent());
                    alert = driver.switchTo().alert();
                    System.out.println(alert.getText());
                    alert.accept();
                } catch (Exception e) {
                    System.out.println("Alert is not present, so Skipping...");
                }
            }
            Already_Account();
            try {
                webElements.getSignIn().click();
                webElements.getSignOut().click();
            } catch (Exception e) {
                System.out.println("Did not Signed In");
            }
        }
    }   // Run this method Seperately for new user SignIn through GetStarted btn with new mail

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void New_user_SignIn_By_DoNotHave_Account() throws Exception{
        try {
            wait.until(visibilityOf(webElements.getGetStarted())).click();
        }catch (Exception e){
            System.out.println("Get Started element not found, so skipping...");
        }
        Already_Account();
        wait.until(visibilityOf(webElements.getCredentialsFields().getFirst())).sendKeys("thouday.pavan12@gmail.com");
        wait.until(visibilityOf(webElements.getCredentialsFields().get(1))).sendKeys("Pavan@24");
        wait.until(visibilityOf(webElements.getSignIn())).click();
        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("Alert is not Present, so skipping...");
        }
        Thread.sleep(1000);
        DoNotHave_Account();
        Thread.sleep(3000);
        wait.until(visibilityOf(webElements.getCredentialsFields().get(2))).sendKeys("Pavan@24");
    }

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void old_user_SignIn_By_Sign_btn() throws Exception {
        if (webElements.getGetStarted().isDisplayed()) {
            webElements.getGetStarted().click();
        }
        Already_Account();
        webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
        webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
        webElements.getSignIn().click();
        Thread.sleep(3000);
        webElements.getSignOut().click();
    }

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void old_user_SignIn_By_GetStarted_btn() throws Exception {
        if (webElements.getGetStarted().isDisplayed()) {
            webElements.getGetStarted().click();
        }
        Already_Account();
        webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
        webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
        webElements.getSignIn().click();
        Thread.sleep(2000);
        webElements.getSignOut().click();
    }

    @Test
    public void test() throws Exception {
        wait.until(visibilityOf(webElements.getGetStarted())).click();
        wait.until(visibilityOf(webElements.getAlreadyAccount())).click();
        Thread.sleep(1000);
        Credentials();
        wait.until(visibilityOf(webElements.getSignIn())).click();
        Thread.sleep(4000);
        wait.until(visibilityOf(webElements.getGetStarted())).click();
        Thread.sleep(1000);
        wait.until(visibilityOf(webElements.getOnboard())).click();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(2000);
            webElements.getOCNNodeIDCredentials().getFirst().sendKeys("NodeID-" + i);
            webElements.getOCNNodeIDCredentials().get(1).sendKeys("193.16.1." + i);
            if (i == 0) {
                webElements.getAddNode().click();
            } else if (i == 1) {
                webElements.getValidator().click();
                webElements.getSelect().get(1).click();
                webElements.getAddNode().click();
            } else if (i==2) {
                webElements.getAddNode().click();
            }
        }
        Thread.sleep(2000);
        wait.until(visibilityOf(webElements.getNodes().getLast())).click();
        wait.until(visibilityOf(driver.findElement(By.xpath("//button[text()='Remove Selected Nodes']")))).click();
        for (int i = 0; i < 2; i++) {
            webElements.getNext().click();
            Thread.sleep(1000);
        }
        webElements.getSubmit().click();
    }

    @Test
    public void test1() throws Exception{
        wait.until(visibilityOf(webElements.getGetStarted())).click();
        wait.until(visibilityOf(webElements.getAlreadyAccount())).click();
        Thread.sleep(1000);
        Credentials();
        wait.until(visibilityOf(webElements.getSignIn())).click();
        Thread.sleep(4000);
        wait.until(visibilityOf(webElements.getGetStarted())).click();
        Thread.sleep(1000);
        wait.until(visibilityOf(webElements.getLaunchOCN())).click();
        Thread.sleep(1000);
        wait.until(visibilityOf(webElements.getOCNNodeIDCredentials().getFirst())).sendKeys("Pavan");
        wait.until(visibilityOf(webElements.getOCNNodeIDCredentials().get(1))).sendKeys("0x32Be343B94f860124dC4fEe278FDCBD38C102D88");
        wait.until(visibilityOf(webElements.getNext())).click();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(2000);
            wait.until(visibilityOf(webElements.getOCNNodeIDCredentials().getFirst())).sendKeys("NodeID-" + i);
            wait.until(visibilityOf(webElements.getOCNNodeIDCredentials().get(1))).sendKeys("193.16.1." + i);

            wait.until(visibilityOf(webElements.getAddNode())).click();
        }
        wait.until(visibilityOf(webElements.getNext())).click();
        wait.until(visibilityOf(webElements.getSubmit())).click();
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
