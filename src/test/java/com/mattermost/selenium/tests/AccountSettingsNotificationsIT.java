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
        driver.findElement(By.id("accountSettings")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li[3]/button"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div/div/ul/li[3]/button")).click();
        // Desktop notification
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Desktop_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Send desktop notifications".equals(driver.findElement(By.cssSelector("label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Sleep
        driver.findElement(By.id("desktopNotificationMentions")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText().matches("^For mentions and direct messages, [\\s\\S]*shown for 5 seconds$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("desktopNotificationNever"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!driver.findElement(By.id("desktopNotificationNever")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("desktopNotificationNever")).click();
        // Sleep
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

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        // Sleep
        driver.findElement(By.id("desktopNotificationAllActivity")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration3"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration3")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText().matches("^For all activity, [\\s\\S]*shown for 3 seconds$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration10"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration10")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText().matches("^For all activity, [\\s\\S]*shown for 10 seconds$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        // Sleep
        driver.findElement(By.id("soundDurationUnlimited")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText().matches("^For all activity, [\\s\\S]*shown indefinitely$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Desktop_notificationsEdit")).click();
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("soundDuration5"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("soundDuration5")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("#Desktop_notificationsDesc > span")).getText().matches("^For all activity, [\\s\\S]*shown for 5 seconds$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Mobile push notifications
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Disabled by System Administrator".equals(driver.findElement(By.cssSelector("#Mobile_push_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Mobile_push_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Mobile_push_notificationsEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Push notifications for mobile devices have been disabled by your System Administrator.".equals(driver.findElement(By.cssSelector("div.padding-top > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Mobile_push_notificationsCancel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Mobile_push_notificationsCancel")).click();
        // Words that trigger mentions
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsDesc"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Words_that_trigger_mentionsEdit")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("Words_that_trigger_mentionsEdit")).click();
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

        // Sleep
        driver.findElement(By.id("notificationTriggerShouts")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Words_that_trigger_mentionsEdit")).click();
        // Sleep
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

        driver.findElement(By.id("notificationTriggerCustom")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerCustomText"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerCustomText")).clear();
        driver.findElement(By.id("notificationTriggerCustomText")).sendKeys("custom");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"custom\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Words_that_trigger_mentionsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Words_that_trigger_mentionsEdit")).click();
        // Sleep
        driver.findElement(By.id("notificationTriggerCustom")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerShouts"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerShouts")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationTriggerUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationTriggerUsername")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("\"@test\", \"test\", \"@channel\", \"@all\", \"@here\"".equals(driver.findElement(By.id("Words_that_trigger_mentionsDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Reply notification
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Reply_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Reply_notificationsEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Reply_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Reply_notificationsEdit")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("notificationCommentsAny")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Reply_notificationsCancel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Reply_notificationsCancel")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Reply_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Reply_notificationsEdit")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("notificationCommentsAny"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("notificationCommentsAny")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Reply_notificationsDesc > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Trigger notifications on messages in reply threads that I start or participate in".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("Reply_notificationsEdit")).click();
        // Sleep
        driver.findElement(By.id("notificationCommentsRoot")).click();
        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Trigger notifications on messages in threads that I start".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("Reply_notificationsEdit"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("Reply_notificationsEdit")).click();
        // Sleep
        // Sleep
        driver.findElement(By.id("notificationCommentsNever")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("In addition to notifications for when you're mentioned, select if you would like to receive notifications on reply threads.".equals(driver.findElement(By.cssSelector("div.setting-list__hint > span > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Do not trigger notifications on messages in reply threads unless I'm mentioned".equals(driver.findElement(By.cssSelector("#Reply_notificationsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // LOG OUT
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
