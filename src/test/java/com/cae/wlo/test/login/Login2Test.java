package com.cae.wlo.test.login;

import com.cae.common.Secret;
import com.cae.wlo.test.BasePlaywrightTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class Login2Test extends BasePlaywrightTest {

    @Test
    public void login() {
        page.navigate("https://amdm.eu-west-1.devflightservices.cae.com/ngwlo/");

        PlaywrightAssertions.assertThat(page).hasTitle("Community Portal");
        page.locator("input#username").fill("1caeasmdm1");
        page.locator("input#password").fill(decrypt("Xy3gl9FsSNjGeSAEfQoRiu9CpcizplBz4hpv+7dQ3ME="));
        page.locator("input#loginButton").click();

        page.getByTitle("Company Code").selectOption("Z4");
        page.getByRole(AriaRole.BUTTON).and(page.getByText("Launch")).click();

        page.getByRole(AriaRole.BUTTON).and(page.getByText("Calculate scenario")).click();
        page.getByRole(AriaRole.BUTTON).and(page.getByText("Publish")).click();

        System.out.println();
    }
}
