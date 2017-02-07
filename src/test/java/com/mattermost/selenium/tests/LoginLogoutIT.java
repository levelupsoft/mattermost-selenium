package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class LoginLogoutIT extends DriverBase {

    @Test
    public void testLoginLogoutIT() throws Exception {        driver.get(baseUrl + "/login");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Sign in".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
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

        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='sidebar-menu']/div[2]/ul/li[17]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Sign in".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
