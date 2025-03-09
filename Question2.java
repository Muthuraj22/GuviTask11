package task11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Switch to top frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		
		//Get the frame count
		int frameCount = driver.findElements(By.cssSelector("frame")).size();
		
		//Verify if the count is 3
		if(frameCount == 3) {
			System.out.println("The page contains exactly 3 frames");
		} else {
			System.out.println("3 frames are Exepcted but found: "+frameCount);
		}
		
		//Switch to left frame
		WebElement leftEle = driver.findElement(By.cssSelector("frame[name='frame-left']"));
		driver.switchTo().frame(leftEle);
		
		//Verify the left frame has the text 'Left'	
		WebElement leftBody = driver.findElement(By.tagName("body"));
		if (leftBody.getText().contains("LEFT")) {
			System.out.println("The left frame has the text LEFT");
		} else {
			System.out.println("The left frame doen't have the text LEFT");
		}
		
		//Switch back to the top frame
		driver.switchTo().parentFrame();
		
		//Switch to middle frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		//Verify the middle frame has the text 'MIDDLE'	
		WebElement middleBody = driver.findElement(By.tagName("body"));
		if (middleBody.getText().contains("MIDDLE")) {
			System.out.println("The middle frame has the text MIDDLE");
		} else {
			System.out.println("The middle frame doen't have the text MIDDLE");
		}
		
		//Switch back to the top frame
		driver.switchTo().parentFrame();
		
		//Switch to right frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));
		
		//Verify the right frame has the text 'RIGHT'	
		WebElement rightBody = driver.findElement(By.tagName("body"));
		if (rightBody.getText().contains("RIGHT")) {
			System.out.println("The right frame has the text RIGHT");
		} else {
			System.out.println("The right frame doen't have the text RIGHT");
		}				
		
		//Switch back to the top frame
		driver.switchTo().defaultContent();
		
		//Switch to the bottom frame
		WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomFrame);
		
		//Verify the bottom frame has the text 'BOTTOM'	
		WebElement bottomBody = driver.findElement(By.tagName("body"));
		if (bottomBody.getText().contains("BOTTOM")) {
			System.out.println("The bottom frame has the text BOTTOM");
		} else {
			System.out.println("The bottom frame doen't have the text BOTTOM");
		}				
		
		//Switch back to the top frame
		driver.switchTo().defaultContent();	
		
		Thread.sleep(2000);
		//Verify the page title is "Frames"
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is: " +pageTitle);
	
		if(pageTitle == "Frames") {
			System.out.println("The title of the page is: "+pageTitle);
		} else {
			System.out.println("The title of the page is not Frames. It is: "+pageTitle);
		}
		
		
	}

}
