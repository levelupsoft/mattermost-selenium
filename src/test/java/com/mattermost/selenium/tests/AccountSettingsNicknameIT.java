package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsNicknameIT extends DriverBase {

    @Test
    public void testAccountSettingsNicknameIT() throws Exception {        driver.get(baseUrl + "/login");
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("span.sidebar-header-dropdown__icon"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("span.sidebar-header-dropdown__icon")).click();
        // General Settings
        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Account Settings".equals(driver.findElement(By.xpath("//body/div[2]/div/div[2]/div/div/div/h4/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertEquals("Click 'Edit' to add a nickname", driver.findElement(By.xpath("//ul[3]/li[3]/span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[3]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("Added Nick");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Added Nick".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[3]/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[3]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("Edited Nick");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited Nick".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[3]/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[3]/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited Nick".equals(driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.col-sm-7 > input.form-control"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys(Keys.BACK_SPACE);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("".equals(driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Click 'Edit' to add a nickname".equals(driver.findElement(By.xpath("//ul[3]/li[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li[4]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

   }
}
