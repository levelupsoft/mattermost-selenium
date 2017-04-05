package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsPositionIT extends DriverBase {

    @Test
    public void testAccountSettingsPositionIT() throws Exception {        driver.get(baseUrl + "/login");
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("loginButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.cssSelector("a.sidebar-header-dropdown__toggle")).click();
        // General Settings
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Click 'Edit' to add your job title / position".equals(driver.findElement(By.cssSelector("#PositionDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#PositionEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#PositionEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("position"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("position")).sendKeys("Tester");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Tester".equals(driver.findElement(By.id("PositionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#PositionEdit > span")).click();
        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("position")).sendKeys("Edited Tester");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited Tester".equals(driver.findElement(By.id("PositionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#PositionEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("position"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("position")).sendKeys("Temp");
        driver.findElement(By.cssSelector("#PositionCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited Tester".equals(driver.findElement(By.id("PositionDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#PositionEdit > span")).click();
        driver.findElement(By.id("position")).clear();
        driver.findElement(By.id("position")).sendKeys("");
        driver.findElement(By.id("position")).sendKeys("*" + Keys.BACK_SPACE);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Click 'Edit' to add your job title / position".equals(driver.findElement(By.cssSelector("#PositionDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.cssSelector("a.sidebar-header-dropdown__toggle")).click();
        driver.findElement(By.cssSelector("#logout > span")).click();
    }
}
