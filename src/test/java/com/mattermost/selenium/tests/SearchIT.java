package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class SearchIT extends DriverBase {

    @Test
    public void testSearchIT() throws Exception {        // LOG IN
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Search: Basic, markdown
        driver.findElement(By.id("post_textbox")).sendKeys("/test url test-search.md" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Search Testing".equals(driver.findElement(By.cssSelector("h1.markdown__heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("hello" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("span.sidebar--right__title > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Switch channel in center to make sure verifying in search results in RHS
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("off");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Basic word search: Hello world![\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Hello".equals(driver.findElement(By.cssSelector("h5.markdown__heading > span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Hello".equals(driver.findElement(By.cssSelector("code > span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.cssSelector("code.hljs")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Switch channel back to post in Town Square
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("town");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Multiple terms (not exact phrase)
        driver.findElement(By.id("post_textbox")).sendKeys("one hello" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("world two" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("world hello" + Keys.ENTER);
        // Switch channel in center to make sure verifying in search results in RHS
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Off-Topic"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Off-Topic")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Verify search results
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("hello world" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Hello".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Basic word search: Hello world![\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("h5:contains('Hello')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("code.hljs:contains('Hello')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("code:contains('Hello')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("a:contains('#hello')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("a:contains('#world')"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*world hello[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertFalse(isElementPresent(By.cssSelector("span:contains('two')")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Accents, non-Latin characters
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("crème fraîche" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Crème".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("您好*" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("您好".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Wildcard
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("hell*" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("hell".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("\"hell\"*" + Keys.ENTER);
        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No results found\\.[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("hello" + Keys.ENTER);
        // Jump to permalink view
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("a.search-item__jump > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        String jumpmessage = driver.findElement(By.cssSelector("p")).getText();
        driver.findElement(By.cssSelector("a.search-item__jump > span")).click();
        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Click here to jump to recent messages."))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Click here to jump to recent messages.")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (!isElementPresent(By.linkText("Click here to jump to recent messages."))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // In:channel, from:user, autocomplete
        // Sleep
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("inchannel" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("li.active > a.sidebar-item > span.sidebar-item__name"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("li.active > a.sidebar-item > span.sidebar-item__name")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("inchannel #verify" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("in:town");
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.search-autocomplete__item.selected"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.search-autocomplete__item.selected")).click();
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("inchannel" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("div.search-channel__name")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertThat("Off-Topic", is(not(driver.findElement(By.cssSelector("div.search-channel__name")).getText())));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("inchannel".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.linkText("#verify")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // LOG OUT
        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test2@test.com");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("password"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("off");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("fromuser" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // LOG OUT
        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("fromuser #verify" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("off");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("from:tes");
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.search-autocomplete__item.selected"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.search-autocomplete__item.selected")).click();
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("fromuser" + Keys.ENTER);
        // Sleep
        try {
            assertThat("Off-Topic", is(not(driver.findElement(By.cssSelector("div.search-channel__name")).getText())));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("fromuser".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.linkText("#verify")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("from:test2");
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.search-autocomplete__item.selected"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.ENTER);
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("in:off-topic");
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.search-autocomplete__item.selected"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.TAB);
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("fromuser" + Keys.ENTER);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("fromuser".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.search-channel__name")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.navigate().refresh();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("from:");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.UP);
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys(Keys.DOWN);
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test2".equals(driver.findElement(By.cssSelector("div.search-autocomplete__item.selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        try {
            assertEquals("from:", driver.findElement(By.cssSelector("input.search-bar")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // At-mention search
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("town");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("post_textbox")).sendKeys("@test2 greetings");
        // Sleep
        driver.findElement(By.id("post_textbox")).sendKeys(Keys.ENTER);
        // Sleep
        driver.navigate().refresh();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("test2");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("@test2".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test2".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("post_textbox")).sendKeys("@test2 direct" + Keys.ENTER);
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Off-Topic"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Off-Topic")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).sendKeys("@channel" + Keys.ENTER + Keys.ENTER);
        // Sleep
        // Sleep
        // LOG OUT
        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("test2@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("span.icon.icon__mentions > svg"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.cssSelector("span.icon.icon__mentions > svg")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("@test2"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Direct Message (with test)".equals(driver.findElement(By.cssSelector("div.search-channel__name > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("@test2".equals(driver.findElement(By.cssSelector("span.search-highlight > span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*@test2 direct[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: verifyTextNotPresent may require manual changes
        try {
            assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*@channel[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("Off");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("Town");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: verifyTextNotPresent may require manual changes
        try {
            assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*@channel[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("post_textbox")).clear();
        driver.findElement(By.id("post_textbox")).sendKeys("");
        // Sleep
        driver.findElement(By.id("post_textbox")).sendKeys("test usernametownsquare" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("test");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("@test - This Is a Very Long Name That Should Truncate".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        driver.findElement(By.id("post_textbox")).sendKeys("test usernameDM" + Keys.ENTER);
        // Sleep
        // LOG OUT
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("sidebarHeaderDropdownButton"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-primary"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
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
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("post_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("span.icon.icon__mentions > svg"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.cssSelector("span.icon.icon__mentions > svg")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("off");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Off-Topic".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Direct Message (with test2)".equals(driver.findElement(By.cssSelector("div.search-channel__name > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test usernameDM".equals(driver.findElement(By.cssSelector("p")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("test".equals(driver.findElement(By.cssSelector("span.search-highlight > span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*test usernametownsquare[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("button.btn.btn-link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("button.btn.btn-link")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.form-control.focused"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.form-control.focused")).sendKeys("Town");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.mentions__name.suggestion--selected")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("@test2")).click();
        // Sleep
        // at-username link opens profile popover
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("@test2".equals(driver.findElement(By.cssSelector("h3.popover-title")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("img.user-popover__image"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("test2@test.com"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Send Message"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // DM search
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("direct" + Keys.ENTER);
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Direct Message (with test2)".equals(driver.findElement(By.cssSelector("div.search-channel__name > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("direct".equals(driver.findElement(By.cssSelector("span.search-highlight")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("input.search-bar"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("input.search-bar")).clear();
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("");
        // Sleep
        driver.findElement(By.cssSelector("input.search-bar")).sendKeys("test3" + Keys.ENTER);
        // Sleep
        // Warning: waitForTextPresent may require manual changes
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*No results found\\. Try again[\\s\\S][\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertThat("test3 has joined the channel", is(not(driver.findElement(By.cssSelector("p")).getText())));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // LOG OUT
        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.id("sidebarHeaderDropdownButton")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.id("logout"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.id("logout")).click();
    }
}
