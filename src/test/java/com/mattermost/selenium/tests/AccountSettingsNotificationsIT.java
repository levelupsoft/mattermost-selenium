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
    public void testAccountSettingsNotificationsIT() throws Exception {        // LOG IN
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
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.linkText("Notifications"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Notifications")).click();
        // Desktop notification
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Desktop_notificationsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Send desktop notifications".equals(driver.findElement(By.cssSelector("label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Send desktop notifications".equals(driver.findElement(By.cssSelector("label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationMentions"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationMentions")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For mentions and direct messages, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationNever"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (!driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationNever")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Off".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.id("desktopNotificationAllActivity")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration3"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration3")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown for 3 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration10"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration10")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown for 10 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.id("soundDurationUnlimited")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown indefinitely".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Desktop_notificationsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration5"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration5")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("For all activity, shown for 5 seconds".equals(driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Mobile push notifications
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Disabled by System Administrator".equals(driver.findElement(By.cssSelector("#Mobile_push_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Mobile_push_notificationsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Mobile_push_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Push notifications for mobile devices have been disabled by your System Administrator.".equals(driver.findElement(By.cssSelector("div.padding-top > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Mobile_push_notificationsCancel > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Mobile_push_notificationsCancel > span")).click();
        // Words that trigger mentions
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsDesc"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Words_that_trigger_mentionsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Words_that_trigger_mentionsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Words_that_trigger_mentionsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#Words_that_trigger_mentionsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.findElement(By.id("notificationTriggerShouts")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Words_that_trigger_mentionsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Words_that_trigger_mentionsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustom"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustom")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustomText")).sendKeys("custom");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"custom\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Words_that_trigger_mentionsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Words_that_trigger_mentionsEdit > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("notificationTriggerCustom")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerShouts")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Reply notification
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Reply_notificationsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.findElement(By.id("notificationCommentsAny")).click();
        driver.findElement(By.cssSelector("#Reply_notificationsCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Reply_notificationsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsAny")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Reply_notificationsDesc > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Trigger notifications on messages in reply threads that I start or participate in".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("notificationCommentsRoot")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Trigger notifications on messages in threads that I start".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Reply_notificationsEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Reply_notificationsEdit > span")).click();
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.id("notificationCommentsNever")).click();
        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("In addition to notifications for when you're mentioned, select if you would like to receive notifications on reply threads.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
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

        for (int second = 0;; second++) {
        	if (second >= 2) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

    }
}
