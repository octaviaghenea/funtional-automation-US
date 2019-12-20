package com.tools.customDriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.thucydides.core.webdriver.DriverSource;

public class CustomChromeDriver implements DriverSource {
	
	@Override
    public WebDriver newDriver() {
        return setCustomChrome();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    private WebDriver setCustomChrome() {
        System.out.println("Custom chrome driver instance is created now...");
    //    System.setProperty("webdriver.chrome.driver", Constants.WEB_DRIVERS_PATH + "chromedriverlinux240");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        options.addArguments("--no-proxy-server");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-software-rasterizer");
        
        return new ChromeDriver(options);
    }

}
