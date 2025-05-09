package com.cae;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class Main {
    // Playwright example to take a screenshot of a webpage
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50)
            );
            Page page = browser.newPage();
            page.navigate("https://amdm.eu-west-1.devflightservices.cae.com/ngwlo/");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
        }
    }
}