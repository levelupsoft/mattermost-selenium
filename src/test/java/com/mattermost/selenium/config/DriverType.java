package com.mattermost.selenium.config;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public enum DriverType implements DriverSetup {
    CHROME {
        public DesiredCapabilities getDesiredCapabilities(Proxy proxySettings) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("start-fullscreen");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
            HashMap<String, String> chromePreferences = new HashMap<String, String>();
            chromePreferences.put("profile.password_manager_enabled", "false");
            capabilities.setCapability("chrome.prefs", chromePreferences);
            return addProxySettings(capabilities, proxySettings);
        }

        public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            return new WaitChromeDriver(capabilities);
        }
    };

    protected DesiredCapabilities addProxySettings(DesiredCapabilities capabilities, Proxy proxySettings) {
        if (null != proxySettings) {
            capabilities.setCapability(PROXY, proxySettings);
        }

        return capabilities;
    }
}