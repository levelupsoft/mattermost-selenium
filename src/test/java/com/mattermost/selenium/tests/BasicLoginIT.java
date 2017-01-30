package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class BasicLoginIT extends DriverBase {

    @Test
    public void testBasicLogin() throws Exception {
        driver.get(baseUrl + "/login");
        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd1");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Your password is incorrect.".equals(driver.findElement(By.cssSelector("label.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test1.com");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("We couldn't find an account matching your login credentials.".equals(driver.findElement(By.cssSelector("label.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("".equals(driver.findElement(By.id("post_textbox")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li[4]/a")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Sign in".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a > span")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Please check your inbox.".equals(driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/span[2]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertEquals("Please check your inbox.", driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/span[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/a/span[2]")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Sign in".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
