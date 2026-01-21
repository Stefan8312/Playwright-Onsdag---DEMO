package Systementor.PlaywrightDemo;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class InputsTest extends BasePlaywrightTest{

    @Test
    void fillInputsAndVerifyValues() {
        page.navigate ("https://practice.expandtesting.com/inputs");

        var number = page.locator("input[type='number']");
        var text = page.locator("input[type='text']");
        var password = page.locator("input[type='password']");
        var date = page.locator("input[type='date']");

        number.fill("1337");
        text.fill("hello playwright");
        password.fill("SuperSecretPassword");
        date.fill("2026-01-21");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Display Inputs")).click();

        var numberOutput = page.locator("#output-number");
        var textOutput = page.locator("#output-text");
        var passwordOutput = page.locator("#output-password");
        var dateOutput = page.locator("#output-date");

        assertEquals("1337", numberOutput.textContent());
        assertEquals("hello playwright", textOutput.textContent());
        assertEquals("SuperSecretPassword", passwordOutput.textContent());
        assertEquals("2026-01-21", dateOutput.textContent());
    }
}
