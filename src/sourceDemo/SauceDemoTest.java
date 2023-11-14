package sourceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemoTest {
    static String baseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) throws InterruptedException {
       //Launch the chrome browser and open the URL in browser
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
         // Maximise the browser
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // Get Current URl
        System.out.println("The Current Url is " + driver.getCurrentUrl());

        // get page source
        System.out.println(driver.getPageSource());
        String loginUrl = "https://www.saucedemo.com/";
        driver.navigate().to(loginUrl);
        System.out.println("Get Current Url " + driver.getCurrentUrl());
        Thread.sleep(3000);

        // find email field element and type the email
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("abc123@gmail.com");
        Thread.sleep(3000);

        // password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("abc123");
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        login.click();

        // Get Current URL
        System.out.println("The Current URL is " + driver.getCurrentUrl());
        driver.navigate().to(baseUrl);

        // Refresh
        Thread.sleep(3000);
        driver.navigate().refresh();
        // close
        driver.quit();


    }
}