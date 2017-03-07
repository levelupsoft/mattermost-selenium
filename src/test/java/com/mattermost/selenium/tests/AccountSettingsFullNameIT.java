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
        // Full Name
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Account Settings".equals(driver.findElement(By.xpath("//body/div[2]/div/div[2]/div/div/div/h4/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.btn.btn-sm > span")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("Added");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Last Name".equals(driver.findElement(By.xpath("//div[2]/label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//input[@value='LastName']")).clear();
        driver.findElement(By.xpath("//input[@value='LastName']")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='LastName']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Added Name".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("Edited");
        driver.findElement(By.xpath("(//input[@value='Name'])")).clear();
        driver.findElement(By.xpath("(//input[@value='Name'])")).sendKeys("");
        driver.findElement(By.xpath("(//input[@value='Name'])")).sendKeys("LastName");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edited LastName".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

   }
}
