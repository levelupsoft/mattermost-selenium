package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class BasicFailIT extends DriverBase {

    @Test
    public void testBasicFail() throws Exception {
        driver.get(baseUrl + "/login");
        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password11");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 5) fail("timeout");
        	try { if ("Your password is incorrect NOT.".equals(driver.findElement(By.cssSelector("label.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
