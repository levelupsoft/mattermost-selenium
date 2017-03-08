package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsFullNameIT extends DriverBase {

    @Test
    public void testAccountSettingsFullNameIT() throws Exception {        driver.get(baseUrl + "/login");
        disableAnimations();
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("sidebar-header-dropdown"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        // General Settings
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        // Full Name
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Account Settings".equals(driver.findElement(By.xpath("//body/div[2]/div/div[2]/div/div/div/h4/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Full Name']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        driver.findElement(By.xpath("//a[@id='Full Name']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("");
        driver.findElement(By.id("firstName")).sendKeys("Added");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("Name");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Added Name".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Full Name']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("");
        driver.findElement(By.id("firstName")).sendKeys("Edited");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("LastName");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited LastName".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
   }
}
