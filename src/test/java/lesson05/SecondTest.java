package lesson05;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;


public class SecondTest {
    static WebDriver wd;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void before() {
        wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wd.manage().window();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("natachak2007@gmail.com");
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).sendKeys("725656kar");
        wd.findElement(By.id("passwd")).submit();
        wd.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

    @AfterClass
    public static void tearDown() {
        wd.quit();
    }

    @After
    public void after() {
        wd.get("http://automationpractice.com/index.php?controller=my-account");
    }
    @Test
    public void verifyFirstSearchResultFail(){
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("printed summer dress");
        wd.findElement(By.id("search_query_top")).submit();
        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"))
                .getText()
                .contains("Printed Summer Dress"));





}
}

