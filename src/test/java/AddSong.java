import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class AddSong {
    WebDriver driver;

    @BeforeMethod
    public void login_beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void addPlaylist() {
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

            //  Search and Add Product to Cart
            System.out.println("Navigating to Home page...");
            driver.get("https://open.spotify.com/");
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie); // Reapply cookies for login state
            }
            // driver.navigate().refresh(); // Refresh to apply login state
            Thread.sleep(3000);
            WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='NxEINIJHGytq4gF1r2N1 or84FBarW2zQhXfB9VFb odS2IW9wfNVHhkhc0l_X O0AN8Ty_Cxd4iLwyKATB XNjgtSbyhshr7YQcVvry vSC5QuwmzUhqUNWdMTJ5']//div[@role='button']")));

// Interact with the search bar
            playlist.click();
            WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search for songs or episodes']")));

            // Ensure the search bar is active
            searchbar.clear(); // Clear any pre-filled content
            searchbar.sendKeys("perfect");
            Thread.sleep(3000);// Enter the song name
            searchbar.sendKeys(Keys.ENTER); // Simulate pressing 'Enter' to search
            WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='presentation']//div[1]//div[1]//div[4]//button[1]")));
            add.click();


        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}