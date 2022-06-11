package baseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;

public class Reusable {

	public static AndroidDriver<AndroidElement> driver;
	public static String emualtor;
	public static String appPath;
	public static String deviceName;
	public static String appPackage;
	public static String appActivity;
	public static String udid;
	public static ArrayList<String> undefined;
	
	
	public static void loadConfig() {
		emualtor=Setup.pro.getProperty("emulator");
		appPath=Setup.pro.getProperty("appPath");
		deviceName=Setup.pro.getProperty("deviceName");
		appPackage=Setup.pro.getProperty("appPackage ");
		appActivity=Setup.pro.getProperty("emualtor");
		udid=Setup.pro.getProperty("emualtor");
	}
	public static AndroidDriver<AndroidElement> launchApp(String client) throws MalformedURLException{
		loadConfig();
		if(client.equals("emulator")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
			 driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(client.equals("Device")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.UDID,udid);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
			 driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> getDriver(){
		return driver;
	}
	
	public static void sendKeys(MobileBy element, String value) {
		getDriver().findElement(element).sendKeys(value);
	}
	
	public static void click(By element) {
		getDriver().findElement(element).click();
		
	}
	public static void clear(MobileBy element) {
		getDriver().findElement(element).clear();
	}
	public static String getText(MobileBy element) {
		String gettext =getDriver().findElement(element).getText();
		return gettext;
	}
	
	public static boolean isMessageValid(String actual, String expected) {
		if(actual.equalsIgnoreCase(expected)) {
			Setup.logger.info(actual+"is matched with"+expected);
			return true;
		}else {
			Setup.logger.info(actual+"is not matched with"+expected);
			return false;
		}
		
		
		
	}

	public static boolean isVisiable(MobileBy element) {
		return getDriver().findElement(element).isDisplayed();
	}
	public static List<AndroidElement> getMobileElement(MobileBy element){
		return getDriver().findElements(element);
		
	}
	
	public static void scrollTo(String str) {
		getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+str+"\"))"));
	}
	public static void scrollToHrz(String resourceid,String str) {
		getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+resourceid+"\")).setAsHorizontalList().scrollIntoView(text(\""+str+"\"))"));
	}
	
	public static void hideKeyboard() {
	
	}
	public static void back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public static void Tab() {
		driver.pressKey(new KeyEvent(AndroidKey.TAB));
	}
	
	//Tap screen sing touchaction
	@SuppressWarnings("rawtypes")
	public void tap(MobileBy elements) {
	 new TouchAction(getDriver()).tap(tapOptions().withElement(element(getDriver().findElement(elements)))).perform();
		
		
	}
	public void longpress(MobileBy elements) {
		 new TouchAction(getDriver()).longPress(longPressOptions().withElement(element(getDriver().findElement(elements))).withDuration(ofSeconds(2))).release().perform();
			
			
		}
	
	
	public void swipe(MobileBy elements, MobileBy destination) {
		 new TouchAction(getDriver()).longPress(longPressOptions().withElement(element(getDriver().findElement(elements))).withDuration(ofSeconds(2))).moveTo(element(getDriver().findElement(destination))).release().perform();
			
			
		}
	
	public static String getScreenshot(String ScreenShotName) throws IOException {
		String data = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		TakesScreenshot  tc= (TakesScreenshot) driver;
		File source =tc.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir"+"/ScreenShot/"+ScreenShotName+data+".png");
		File finalDestination =new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
