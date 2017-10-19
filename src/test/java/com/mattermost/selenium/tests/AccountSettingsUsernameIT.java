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
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        // General Settings
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("accountSettings"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("accountSettings")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("UsernameEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("UsernameEdit")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("*" + Keys.BACK_SPACE);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("UsernameCancel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("UsernameCancel")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.id("UsernameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("UsernameEdit")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("hi");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test2");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("This username is already taken. Please choose another.".equals(driver.findElement(By.id("serverError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test-1");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test-1".equals(driver.findElement(By.id("UsernameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li[3]/button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li[3]/button")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText().matches("^\"@test-1\"[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li/button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li/button")).click();
        driver.findElement(By.id("UsernameEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("username"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("_test");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Username must begin with a letter, and contain between 3 to 22 lowercase characters made up of numbers, letters, and the symbols '.', '-', and '_'.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("all");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("channel");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("here");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("matterbot");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("This username is reserved, please choose a new one.".equals(driver.findElement(By.id("clientError")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.id("UsernameDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Town Square"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
    }
}
