import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SaveinLibrary {
    WebDriver driver;

    @BeforeMethod
    public void login_beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void saveSong(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Login Process
            System.out.println("Logging in...");
            driver.get("https://open.spotify.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='login-button']"))).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")))
                    .sendKeys("enter valid email");
            driver.findElement(By.xpath("//input[@id='login-password']"))
                    .sendKeys("enter valid password");
            driver.findElement(By.xpath("//button[@id='login-button']")).click();

            // Confirm login success
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='encore-text encore-text-body-small-bold LKfKy7bXKmlkMEANVJMS']")));
            System.out.println("Login successful!");

            //  Save Login State (Cookies)
            Set<Cookie> cookies = driver.manage().getCookies();


            System.out.println("Navigating to Home page...");
            driver.get("https://open.spotify.com/");
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }

            Thread.sleep(3000);
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='What do you want to play?']")));


            searchBar.click();
            searchBar.clear();
            searchBar.sendKeys("perfect");
            Thread.sleep(3000);
            searchBar.sendKeys(Keys.ENTER);


            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Songs')]")));
            System.out.println("Song search completed!");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ouEZqTcvcvMfvezimm_J']"))).click();
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save to Your Library']//span[@class='IconWrapper__Wrapper-sc-16usrgb-0 hYdsxw']//*[name()='svg']"))).click();





        } catch (Exception e) {
            e.printStackTrace();


        }

    }
    }

