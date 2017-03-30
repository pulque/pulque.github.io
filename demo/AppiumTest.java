package appiumtest.appiumid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTestInspirus {

	public static String root = "//android.widget.ImageButton[@resource-id='com.ggeye.kaoshi.gwy:id/doques']";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// com.ggeye.kaoshi.gwy:id/question
		// com.ggeye.kaoshi.gwy/.MainActivity

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "com.ggeye.kaoshi.gwy.1607091457.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "T8DDU15303001806");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.ggeye.kaoshi.gwy");
		capabilities.setCapability("appActivity", ".Page_Index");

		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		AndroidDriver driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		System.out.println("App is launched.");

		Thread.sleep(6000);
		System.out.println("1");
		driver.swipe(800, 1000, 100, 1000, 1000);
		Thread.sleep(3000);
		System.out.println("2");
		driver.swipe(800, 1000, 100, 1000, 1000);
		Thread.sleep(3000);
		System.out.println("3");
		driver.swipe(800, 1000, 100, 1000, 1000);
		Thread.sleep(3000);

		for (int j = 0; j < 3; j++) {
			try {
				WebElement el_kaishi = driver.findElementById("com.ggeye.kaoshi.gwy:id/kaishi");
				el_kaishi.click();
				break;
			} catch (Exception e) {
				driver.swipe(800, 1000, 100, 1000, 1000);
				Thread.sleep(5000);
			}
		}

		one1(driver, 0, 2210);
		// one1(driver,1,3249);
		// one1(driver,2,558);
		// one1(driver,3,745);

		driver.quit();
	}

	/**
	 * <4
	 * 
	 * @param driver
	 * @param index
	 * @throws InterruptedException
	 */
	private static void one1(AndroidDriver driver, int index, int count) throws InterruptedException {
		driver.findElementById("com.ggeye.kaoshi.gwy:id/img_expand").click();

		// driver.findElementById("com.ggeye.kaoshi.gwy:id/doques").click();

		List list = driver.findElementsByXPath(root);
		System.out.println("size===" + list.size());
		((WebElement) list.get(index)).click();

		Thread.sleep(6000);
		driver.findElementById("com.ggeye.kaoshi.gwy:id/imageview_answer").click();

		for (int i = 0; i < count; i++) {
			WebElement el = driver.findElementById("com.ggeye.kaoshi.gwy:id/question");
			System.out.println(el.getText());
			System.out.println("==");
			WebElement ela = driver.findElementById("com.ggeye.kaoshi.gwy:id/radioButtonA");
			System.out.println("A."+ela.getText());

			WebElement elb = driver.findElementById("com.ggeye.kaoshi.gwy:id/radioButtonB");
			System.out.println("B."+elb.getText());

			WebElement elc = driver.findElementById("com.ggeye.kaoshi.gwy:id/radioButtonC");
			System.out.println("C."+elc.getText());

			WebElement eld = driver.findElementById("com.ggeye.kaoshi.gwy:id/radioButtonD");
			System.out.println("D."+eld.getText());
			System.out.println("==");
			Thread.sleep(1000);
			driver.swipe(500, 1300, 500, 500, 1000);
			Thread.sleep(1000);
			WebElement ele = driver.findElementById("com.ggeye.kaoshi.gwy:id/explan");
			
			String explan = ele.getText();
			String[] es = explan.split("\n");
			System.out.println(es[0].replace("答案：", ""));
			System.out.println("==");
			System.out.println(explan.replace(es[0], "").replaceFirst("\n", ""));

			driver.findElementById("com.ggeye.kaoshi.gwy:id/btn_next").click();
			Thread.sleep(1000);

			System.out.println("============");
		}
	}
}
