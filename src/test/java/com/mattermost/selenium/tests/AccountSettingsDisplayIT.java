package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class AccountSettingsDisplayIT extends DriverBase {

    @Test
    public void testAccountSettingsDisplayIT() throws Exception {        driver.get(baseUrl + "/login");
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#accountSettings > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Display"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Display")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Open to manage your theme".equals(driver.findElement(By.cssSelector("#ThemeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Open Sans".equals(driver.findElement(By.id("Display_FontDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Clock Display
        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        try {
            assertEquals("on", driver.findElement(By.id("clockFormat12h")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("clockFormat24h")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("clockFormat24h")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select how you prefer time displayed.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        try {
            assertEquals("on", driver.findElement(By.id("clockFormat12h")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("clockFormat24h")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("clockFormat24h")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("24-hour clock (example: 16:00)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Clock_DisplayEdit > span")).click();
        try {
            assertEquals("off", driver.findElement(By.id("clockFormat12h")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("clockFormat12h")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("clockFormat12h")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("12-hour clock (example: 4:00 PM)".equals(driver.findElement(By.cssSelector("#Clock_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Teammate Name Display
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Show username (default)".equals(driver.findElement(By.cssSelector("#Teammate_Name_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Teammate_Name_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("nameFormatNickname"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameFormatFullName")).click();
        driver.findElement(By.id("nameFormatNickname")).click();
        driver.findElement(By.id("nameFormatFullName")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#Teammate_Name_DisplayCancel > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#Teammate_Name_DisplayCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Show username (default)".equals(driver.findElement(By.cssSelector("#Teammate_Name_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#Teammate_Name_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("nameFormatUsername"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        assertEquals("on", driver.findElement(By.id("nameFormatUsername")).getAttribute("value"));
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("nameFormatNickname"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("nameFormatNickname")).click();
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Show nickname if one exists, otherwise show first and last name".equals(driver.findElement(By.cssSelector("#Teammate_Name_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Teammate_Name_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("nameFormatFullName"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        assertEquals("on", driver.findElement(By.id("nameFormatNickname")).getAttribute("value"));
        driver.findElement(By.id("nameFormatFullName")).click();
        assertEquals("on", driver.findElement(By.id("nameFormatFullName")).getAttribute("value"));
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Show first and last name".equals(driver.findElement(By.cssSelector("#Teammate_Name_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Teammate_Name_DisplayEdit > span")).click();
        assertEquals("on", driver.findElement(By.id("nameFormatFullName")).getAttribute("value"));
        driver.findElement(By.id("nameFormatUsername")).click();
        assertEquals("on", driver.findElement(By.id("nameFormatUsername")).getAttribute("value"));
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Show username (default)".equals(driver.findElement(By.cssSelector("#Teammate_Name_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Default appearance of image link previews
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Set whether previews of image links show as expanded or collapsed by default. This setting can also be controlled using the slash commands /expand and /collapse.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        assertEquals("on", driver.findElement(By.id("collapseFormat")).getAttribute("value"));
        driver.findElement(By.id("collapseFormatOff")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.id("collapseFormatOff")).isSelected()) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Collapsed".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsEdit > span")).click();
        assertEquals("off", driver.findElement(By.id("collapseFormat")).getAttribute("value"));
        driver.findElement(By.id("collapseFormat")).click();
        assertEquals("on", driver.findElement(By.id("collapseFormat")).getAttribute("value"));
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Message Display
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select how messages in a channel should be displayed.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        assertEquals("on", driver.findElement(By.id("messageFormatStandard")).getAttribute("value"));
        driver.findElement(By.id("messageFormatCompact")).click();
        assertEquals("on", driver.findElement(By.id("messageFormatCompact")).getAttribute("value"));
        driver.findElement(By.cssSelector("#Message_DisplayCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        assertEquals("on", driver.findElement(By.id("messageFormatStandard")).getAttribute("value"));
        driver.findElement(By.id("messageFormatCompact")).click();
        assertEquals("on", driver.findElement(By.id("messageFormatCompact")).getAttribute("value"));
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Expanded".equals(driver.findElement(By.cssSelector("#Default_appearance_of_image_link_previewsDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        Thread.sleep(1000);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Compact".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Message_DisplayEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("messageFormatCompact"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        assertEquals("on", driver.findElement(By.id("messageFormatCompact")).getAttribute("value"));
        driver.findElement(By.id("messageFormatStandard")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("messageFormatStandard")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Standard".equals(driver.findElement(By.cssSelector("#Message_DisplayDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Channel Display Mode
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        assertEquals("on", driver.findElement(By.id("channelDisplayFormatFullScreen")).getAttribute("value"));
        driver.findElement(By.id("channelDisplayFormatCentered")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("channelDisplayFormatCentered")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Select the width of the center channel.".equals(driver.findElement(By.xpath("//li/div/div[3]/span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeCancel > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        assertEquals("on", driver.findElement(By.id("channelDisplayFormatFullScreen")).getAttribute("value"));
        driver.findElement(By.id("channelDisplayFormatCentered")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("channelDisplayFormatCentered")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Fixed width, centered".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#Channel_Display_ModeEdit > span")).click();
        assertEquals("on", driver.findElement(By.id("channelDisplayFormatCentered")).getAttribute("value"));
        driver.findElement(By.id("channelDisplayFormatFullScreen")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("on".equals(driver.findElement(By.id("channelDisplayFormatFullScreen")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Full width".equals(driver.findElement(By.cssSelector("#Channel_Display_ModeDesc > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Language
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("English".equals(driver.findElement(By.id("LanguageDesc")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.xpath("//li/div/div[2]/span")).getText().matches("^[\\s\\S]*Select which language Mattermost displays in the user interface\\.[\\s\\S]*Would like to help with translations[\\s\\S] Join the Mattermost Translation Server to contribute\\.[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.linkText("Mattermost Translation Server")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Deutsch");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Willkommen zu Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("span.sidebar-header-dropdown__icon")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Anzeige"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Anzeige")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Español");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("¡Bienvenido a Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Visualización"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Visualización")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Français");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Bienvenue sur Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Affichage"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Affichage")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Nederlands (Alpha)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Welkom bij Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Weergave"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Weergave")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Português (Brasil)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Bem-vindo a Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Exibição"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Exibição")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("Pусский (Beta)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square - добро пожаловать!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Вид"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Вид")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("한국어 (Alpha)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square에 오신 것을 환영합니다!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("화면"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("화면")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("中文 (简体)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("欢迎进入Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("显示"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("显示")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("中文 (繁體)");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("歡迎來到Town Square！".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("顯示"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("顯示")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("日本語");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Squareへようこそ!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebar-header-dropdown")).click();
        driver.findElement(By.cssSelector("#accountSettings > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("表示"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("表示")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#LanguageEdit > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#LanguageEdit > span")).click();
        new Select(driver.findElement(By.id("displayLanguage"))).selectByVisibleText("English");
        driver.findElement(By.id("saveSetting")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Welcome to Town Square!".equals(driver.findElement(By.cssSelector("p.channel-intro__content > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

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

        // ERROR: Caught exception [unknown command []]
    }
}
