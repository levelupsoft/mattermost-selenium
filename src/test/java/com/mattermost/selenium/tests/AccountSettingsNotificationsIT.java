package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsNotificationsIT extends DriverBase {

    @Test
    public void testAccountSettingsNotificationsIT() throws Exception {        driver.get(baseUrl + "/login");
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Notifications"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Notifications")).click();
        // Desktop notification
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Send desktop notifications".equals(driver.findElement(By.cssSelector("label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationAllActivity"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationAllActivity")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Send desktop notifications".equals(driver.findElement(By.cssSelector("label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationMentions"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("desktopNotificationMentions")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationMentions")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationMentions")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For mentions and direct messages, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationNever"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("desktopNotificationNever")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationNever")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationAllActivity"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("desktopNotificationAllActivity")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationAllActivity")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationAllActivity")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("soundDuration3")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration3"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration3")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("soundDuration3")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown for 3 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration10"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("soundDuration10")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration10")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("soundDuration10")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown for 10 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDurationUnlimited"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("soundDurationUnlimited")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDurationUnlimited")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("soundDurationUnlimited")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown indefinitely".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration5"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("soundDuration5")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration5")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("soundDuration5")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Email notifications
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Immediately".equals(driver.findElement(By.cssSelector("#Email_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Email_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("emailNotificationImmediately"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertEquals("on", driver.findElement(By.id("emailNotificationImmediately")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("#Email_notificationsCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Immediately".equals(driver.findElement(By.cssSelector("#Email_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Email_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("emailNotificationImmediately"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("emailNotificationNever")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("emailNotificationNever")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("emailNotificationNever")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Never".equals(driver.findElement(By.cssSelector("#Email_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Email_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("emailNotificationImmediately"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("emailNotificationImmediately")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("emailNotificationImmediately")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("emailNotificationImmediately")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Immediately".equals(driver.findElement(By.cssSelector("#Email_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Mobile push notifications
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Disabled by System Administrator".equals(driver.findElement(By.xpath("//li[@id='Mobile_push notificationsDesc']/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Mobile_push notificationsEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Push notifications for mobile devices have been disabled by your System Administrator.".equals(driver.findElement(By.cssSelector("div.padding-top > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Mobile_push notificationsCancel']/span")).click();
        // Words that trigger mentions
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that trigger mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Words_that trigger mentionsEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertEquals("on", driver.findElement(By.id("notificationTriggerUsername")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("notificationTriggerUsername")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("notificationTriggerUsername")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that trigger mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Words_that trigger mentionsEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("notificationTriggerShouts")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerShouts")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("notificationTriggerShouts")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\"".equals(driver.findElement(By.id("Words_that trigger mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Words_that trigger mentionsEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustom"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertEquals("off", driver.findElement(By.id("notificationTriggerCustom")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("notificationTriggerCustom")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationTriggerCustom")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustomText")).sendKeys("custom");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("custom".equals(driver.findElement(By.id("notificationTriggerCustomText")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"custom\"".equals(driver.findElement(By.id("Words_that trigger mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='Words_that trigger mentionsEdit']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustom"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("notificationTriggerCustom")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustom")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("notificationTriggerCustom")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("notificationTriggerShouts")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerShouts")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationTriggerShouts")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("notificationTriggerUsername")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationTriggerUsername")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that trigger mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Reply notification
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("notificationCommentsAny")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsAny")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationCommentsAny")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsCancel > span")).click();
        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("notificationCommentsAny")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsAny")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationCommentsAny")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Trigger notifications on messages in reply threads that I start or participate in".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsRoot"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("notificationCommentsRoot")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsRoot")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationCommentsRoot")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Trigger notifications on messages in threads that I start".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsNever"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("off".equals(driver.findElement(By.id("notificationCommentsNever")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsNever")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("notificationCommentsNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("In addition to notifications for when you're mentioned, select if you would like to receive notifications on reply threads.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Log out
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("sidebar-header-dropdown"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#logout > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}