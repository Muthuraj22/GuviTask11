package task11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String mainWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for (String handle : allWindowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		
		// Verify if "new Window" text is present in the page
		WebElement newElement = driver.findElement(By.className("example"));
		if (newElement.getText().contains("New Window")) {
		    System.out.println("Text 'New Window' is present on the page.");
		} else {
		    System.out.println("Text 'New Window' is NOT present on the page.");
		}
		
		driver.close();
		
		driver.switchTo().window(mainWindowHandle);
		
		// To verify the original window is active
		if (driver.getWindowHandle().equals(mainWindowHandle)) {
		    System.out.println("Original window is active with title: " + driver.getTitle());
		} else {
		    System.out.println("Failed to switch back to the original window.");
		}
		driver.quit();
		
	}

}
