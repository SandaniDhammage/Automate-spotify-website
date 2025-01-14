import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class CreateNewPlaylist {
    WebDriver driver;

    @BeforeMethod
    public void login_beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void create() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Login Process
            System.out.println("Logging in...");
            driver.get("https://open.spotify.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='login-button']"))).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")))
                    .sendKeys("sandanid01@gmail.com");
            driver.findElement(By.xpath("//input[@id='login-password']"))
                    .sendKeys("Dasunika@01");
            driver.findElement(By.xpath("//button[@id='login-button']")).click();

            // Confirm login success
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='encore-text encore-text-body-small-bold LKfKy7bXKmlkMEANVJMS']")));
            System.out.println("Login successful!");

            //  Save Login State (Cookies)
            Set<Cookie> cookies = driver.manage().getCookies();

            //  Search and Add Product to Cart
            System.out.println("Navigating to Home page...");
            driver.get("https://open.spotify.com/");
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie); // Reapply cookies for login state
            }
            // driver.navigate().refresh(); // Refresh to apply login state
            Thread.sleep(3000);
            WebElement library = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Create playlist or folder']//span[@class='IconWrapper__Wrapper-sc-16usrgb-0 hYdsxw']//*[name()='svg']")));
            library.click();
            WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Create a new playlist']")));
            newPlaylist.click();

        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
