package com.mattermost.selenium.tests;

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ChannelSettingsPubHeaderIT extends DriverBase {

    @Test
    public void testChannelSettingsPubHeaderIT() throws Exception {        // LOG IN
        driver.get(baseUrl + "/login");
        // DisableAnimations
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.name("loginId"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.name("loginId")).clear();
        driver.findElement(By.name("loginId")).sendKeys("admin@test.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("passwd");
        driver.findElement(By.id("loginButton")).click();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Town Square".equals(driver.findElement(By.linkText("Town Square")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // PUBLIC CHANNEL
        // Add Public Channel from + icon, without header
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("+"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("+")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.modal-intro > a > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Create a private channel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.col-sm-9 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-9 > input.form-control")).sendKeys("");
        driver.findElement(By.cssSelector("div.col-sm-9 > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.col-sm-9 > input.form-control")).sendKeys("headertest");
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("URL: /headertest (Edit)".equals(driver.findElement(By.cssSelector("p.input__help.dark")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("form.form-horizontal > div.modal-footer > button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Beginning of headertest".equals(driver.findElement(By.cssSelector("h4.channel-intro__title > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("p.channel-intro__content > span > span")).getText().matches("^This is the start of the headertest channel, created by admin[\\s\\S]*$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Invite others to this channel"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("strong.heading")).click();
        // View channel info without header
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#channelViewInfo > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#channelViewInfo > span")).click();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("h4.modal-title > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        try {
            assertThat("Header:", is(not(driver.findElement(By.cssSelector("div.info__label > span")).getText())));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.navigate().refresh();
        // Add header using `Add a channel description` placeholder link
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Add a channel description".equals(driver.findElement(By.cssSelector("a.channel-header__description.light > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Add a channel description"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Add a channel description")).click();
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Edit the text appearing next to the channel name in the channel header.".equals(driver.findElement(By.cssSelector("div.edit-modal-body > p > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Verify header 1024 character limit
        driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).sendKeys("https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.htm&");
        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.html https://docs.mattermost.com/process/release-process.htm&".equals(driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).getAttribute("value"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Your message is too long. Character count: 1025/1024".equals(driver.findElement(By.cssSelector("label.control-label")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("(//button[@type='button'])[13]"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("(//button[@type='button'])[11]"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
        // Sleep
        // Sleep
        // Sleep
        driver.navigate().refresh();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("strong.heading")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Add header using `Set a Header` link
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Set a Header"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Set a Header")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).sendKeys("*Header");
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (driver.findElement(By.cssSelector("p.markdown__paragraph-inline")).getText().matches("^[\\s\\S]*Header$")) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        // Sleep
        // Sleep
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//a[@id='channelHeaderDropdown']/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='channelHeaderDropdown']/span")).click();
        // Verify channel info with header
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#channelViewInfo > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#channelViewInfo > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("h4.modal-title > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Header:".equals(driver.findElement(By.cssSelector("div.info__label > span")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        driver.navigate().refresh();
        // Edit header, use markdown
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//a[@id='channelHeaderDropdown']/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='channelHeaderDropdown']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#channelEditHeader > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#channelEditHeader > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).sendKeys("* " + Keys.SHIFT + Keys.ENTER);
        // Sleep
        driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).sendKeys("- Item 1 " + Keys.SHIFT + Keys.ENTER);
        // Sleep
        driver.findElement(By.cssSelector("div.modal-body > div.edit-modal-body > div.textarea-wrapper > div > div > #edit_textbox")).sendKeys("- [Item 2 is a link](http://google.com)");
        // Sleep
        driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
        // Sleep
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("em")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("div.popover-content > div > p > em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Item 1".equals(driver.findElement(By.cssSelector("div.popover-content > div > ul > li")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Item 2 is a link".equals(driver.findElement(By.xpath("(//a[contains(text(),'Item 2 is a link')])[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.linkText("Item 2 is a link"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("em")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.xpath("//a[@id='channelHeaderDropdown']/span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//a[@id='channelHeaderDropdown']/span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if (isElementPresent(By.cssSelector("#channelViewInfo > span"))) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("#channelViewInfo > span")).click();
        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("headertest".equals(driver.findElement(By.cssSelector("h4.modal-title > strong")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Header".equals(driver.findElement(By.cssSelector("div.info__value > p > em")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Item 1".equals(driver.findElement(By.cssSelector("div.info__value > ul > li")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
        	if (second >= 60) fail("timeout");
        	try { if ("Item 2 is a link".equals(driver.findElement(By.xpath("(//a[contains(text(),'Item 2 is a link')])[3]")).getText())) break; } catch (Exception e) {}
        	Thread.sleep(1000);
        }

        driver.findElement(By.cssSelector("div.about-modal.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        // LOG OUT
        driver.navigate().refresh();
        // Sleep
        // Sleep
        // Sleep
        driver.findElement(By.cssSelector("a.sidebar-header-dropdown__toggle")).click();
        driver.findElement(By.cssSelector("#logout > span")).click();
    }
}
