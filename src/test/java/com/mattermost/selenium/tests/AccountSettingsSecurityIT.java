package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsSecurityIT extends DriverBase {

    @Test
    public void testAccountSettingsSecurityIT() throws Exception {        driver.get(baseUrl + "/login");
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
        // Security
        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Account Settings".equals(driver.findElement(By.xpath("//body/div[2]/div/div[2]/div/div/div/h4/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Security")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Security Settings".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/h3/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Password
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.col-sm-7 > input.form-control"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("paaaaaaa");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwdd");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwdd");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("The \"Current Password\" you entered is incorrect. Please check that Caps Lock is off and try again.".equals(driver.findElement(By.cssSelector("label.col-sm-12.has-error")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("a.btn.btn-sm > span")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.col-sm-7 > input.form-control"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("passwd");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwdd");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwdd");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!isElementPresent(By.xpath("//input[@value='Save']"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("(//button[@type='button'])[11]"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li[4]/a"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li[4]/a")).click();
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwdd");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li/a/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Account Settings".equals(driver.findElement(By.xpath("//body/div[2]/div/div[2]/div/div/div/h4/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Security")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Security Settings".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/h3/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.col-sm-7 > input.form-control"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-7 > input.form-control")).sendKeys("passwdd");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwd");
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("passwd");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Password".equals(driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/ul/li/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Open Access History and Active Sessions Views
        driver.findElement(By.cssSelector("a.security-links.theme > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Timestamp".equals(driver.findElement(By.cssSelector("th > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.modal-lg.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.findElement(By.xpath("//div[2]/a[2]/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Sessions are created when you log in to a new browser on a device. Sessions let you use Mattermost without having to log in again for a time period specified by the System Admin. If you want to log out sooner, use the 'Logout' button below to end a session.".equals(driver.findElement(By.cssSelector("p.session-help-text > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.modal-lg.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.xpath("//div[@id='sidebar-left']/div/div[2]/ul/li[4]/a/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

   }
}
