import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class SpotifyLogin {
    WebDriver driver;

    @BeforeMethod
    public void login_beforeMethod(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://open.spotify.com/");
    }

    @Test
    //valid username and password
    public void loginPage(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement linkLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-button']")));
            linkLogin.click();


            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
            username.sendKeys("sandanid01@gmail.com");


            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
            password.sendKeys("Dasunika@01");


            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']")));
            loginButton.click();
        }

        @Test
        //invalid username

    public void invalidDetails(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement linkLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-button']")));
            linkLogin.click();


            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
            username.sendKeys("sandanid01gmail.com");


            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
            password.sendKeys("Dasunika@01");


            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']")));
            loginButton.click();

            WebElement errormsg= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='Message-sc-15vkh7g-0 kGDZJw']")));
            String errorMessageText=errormsg.getText();
            System.out.println(errorMessageText);



        }

        @Test
        //invalid password
    public void invalidPassword(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement linkLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-button']")));
            linkLogin.click();


            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
            username.sendKeys("sandanid01@gmail.com");


            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
            password.sendKeys("Dasunika01");


            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']")));
            loginButton.click();

            WebElement errormsg= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='Message-sc-15vkh7g-0 kGDZJw']")));
            String errorMessageText=errormsg.getText();
            System.out.println(errorMessageText);




        }

        @Test
    //empty values

    public void emptyValues(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            WebElement linkLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-button']")));
            linkLogin.click();


            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
            username.sendKeys("");


            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
            password.sendKeys("");


            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']")));
            loginButton.click();

            WebElement errormsg= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='Message-sc-15vkh7g-0 kGDZJw']")));
            String errorMessageText=errormsg.getText();
            System.out.println(errorMessageText);

           boolean isScreenDisplayed= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-gJhJTp sc-fQpRED jIWbvU jTGUSl']"))).isDisplayed();
           if(isScreenDisplayed){
               System.out.println("Test passed: Login modal remains open for empty credentials.");

           }else{
               System.out.println("Test fail: Login modal closed unexpectedly for empty credentials.");
           }


        }

    }

