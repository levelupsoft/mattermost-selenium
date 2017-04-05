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
    public void testAccountSettingsFullNameIT() throws Exception {        // LOG IN
        driver.get(baseUrl + "/login");
        disableAnimations();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.sidebar-header-dropdown__toggle")).click();
        // General Settings
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#accountSettings > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        // Full Name
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Full_NameEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        String fullNameDesc = driver.findElement(By.id("Full_NameDesc")).getText();
        driver.findElement(By.xpath("//a[@id='Full_NameEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (fullNameDesc.equals(driver.findElement(By.id("Full_NameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Full_NameEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("");
        driver.findElement(By.id("firstName")).sendKeys("Added");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("Full_NameDesc")).getText().matches("^Added[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.xpath("//a[@id='Full_NameEdit']/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Full_NameEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("First Name".equals(driver.findElement(By.cssSelector("label.col-sm-5.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("");
        driver.findElement(By.id("firstName")).sendKeys("This Change");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("Will Be Canceled");
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Full_NameCancel > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Full_NameCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("Full_NameDesc")).getText().matches("^Added[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.xpath("//a[@id='Full_NameEdit']/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Full_NameEdit']/span")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("");
        driver.findElement(By.id("firstName")).sendKeys("This Is a Very Long Name");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("");
        driver.findElement(By.id("lastName")).sendKeys("That Should Truncate");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("This Is a Very Long Name That Should Truncate".equals(driver.findElement(By.id("Full_NameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // LOG OUT
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.linkText("Town Square"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.sidebar-header-dropdown__toggle")).click();
        driver.findElement(By.cssSelector("#logout > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
