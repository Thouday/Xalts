package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {

   private WebDriver driver;
   private WebDriverWait wait;
   private static WebElements webElements;

   @BeforeTest
   public void beforeclass(){
      webElements = new WebElements();
   }

   @BeforeClass
   public void before(){
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://xaltsocnportal.web.app/");
      wait = new WebDriverWait(driver, Duration.ofSeconds(5));

      PageFactory.initElements(driver,this);
      PageFactory.initElements(driver, webElements);
   }

   public void Credentials(){
      webElements.getCredentialsFields().getFirst().sendKeys("thouday.pavan99@gmail.com");
      webElements.getCredentialsFields().get(1).sendKeys("Pavan@24");
   }

   @Test
   public void test() throws Exception {
      webElements.getGetStarted().click();
      webElements.getAlreadyAccount().click();
      Thread.sleep(1000);
      Credentials();
      webElements.getSignIn().click();
      Thread.sleep(2000);
      webElements.getGetStarted().click();
      Thread.sleep(1000);
      webElements.getOnboard().click();
      for (int i = 0; i < 3; i++) {
         Thread.sleep(2000);
         webElements.getOCNNodeIDCredentials().getFirst().sendKeys("NodeID-" + i);
         webElements.getOCNNodeIDCredentials().get(1).sendKeys("193.16.1." + i);
         webElements.getAddNode().click();
      }
      for (int i = 0; i < 2; i++) {
         webElements.getNext().click();
         Thread.sleep(1000);
      }
      webElements.getSubmit().click();
   }

   @Test
   public void test1() throws Exception{
      webElements.getGetStarted().click();
      webElements.getAlreadyAccount().click();
      Thread.sleep(1000);
      Credentials();
      webElements.getSignIn().click();
      Thread.sleep(4000);
      webElements.getGetStarted().click();
      Thread.sleep(1000);
      webElements.getLaunchOCN().click();
      Thread.sleep(1000);
      webElements.getOCNNodeIDCredentials().getFirst().sendKeys("Pavan");
      webElements.getOCNNodeIDCredentials().get(1).sendKeys("0x32Be343B94f860124dC4fEe278FDCBD38C102D88");
      webElements.getNext().click();
      for (int i = 0; i < 3; i++) {
         Thread.sleep(2000);
         webElements.getOCNNodeIDCredentials().getFirst().sendKeys("NodeID-" + i);
         webElements.getOCNNodeIDCredentials().get(1).sendKeys("193.16.1." + i);
         webElements.getAddNode().click();
      }
      webElements.getNext().click();
      webElements.getSubmit().click();
   }

   @AfterMethod
   public void quit(){
      if(driver!=null){
//         driver.quit();
      }
   }

}
