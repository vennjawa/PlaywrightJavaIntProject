package tests;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class HelloTest {

static Playwright playwright;
static Browser browser;
BrowserContext context;
Page page;

@BeforeAll
static void setup() {
playwright = Playwright.create();

browser = playwright.chromium().launch(
new BrowserType.LaunchOptions()
.setHeadless(true)
);
}

@BeforeEach
void createContext() {
context = browser.newContext();
page = context.newPage();
}

@Test
void verifyGoogle() {
page.navigate("https://www.google.com");

System.out.println(page.title());

Assertions.assertTrue(page.title().contains("Google"));
}

@AfterEach
void closeContext() {
context.close();
}

@AfterAll
static void teardown() {
browser.close();
playwright.close();
}
}