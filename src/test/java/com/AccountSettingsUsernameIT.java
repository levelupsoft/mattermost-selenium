package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsUsernameIT extends DriverBase {

    @Test
    public void testAccountSettingsUsernameIT() throws Exception {        driver.get(baseUrl + "/login");
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

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.cssSelector("label.col-sm-12.has-error")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.btn.btn-sm > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("edited");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("edited".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("***");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.cssSelector("label.col-sm-12.has-error")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.btn.btn-sm > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("hi");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.cssSelector("label.col-sm-12.has-error")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.btn.btn-sm > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[2]/a/span")).click();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul[2]/li[3]")).getText())) break; } catch (Exception e) {}
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
