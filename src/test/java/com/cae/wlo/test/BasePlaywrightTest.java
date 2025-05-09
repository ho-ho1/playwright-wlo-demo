package com.cae.wlo.test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Paths;
import java.util.Arrays;

public abstract class BasePlaywrightTest extends BaseTest {

    private static final boolean HEADLESS = false;

    protected Browser browser;
    protected Page page;

    private Playwright playwright;

    @BeforeAll
    public void setupPlaywright() {
        playwright = Playwright.create();
        if (HEADLESS) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions());
        } else {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(50)
                .setArgs(Arrays.asList("--start-maximized"))
            );
        }
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = browserContext.newPage();

    }

    @AfterAll
    public void tearDownPlaywright() {
        if (playwright != null) {
            playwright.close();
        }
    }

    private void takeScreenshot() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot_" + System.currentTimeMillis() + ".png")));
    }
}
