package lesson05;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;


public class Firsttest {
    static WebDriver wd;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

    }

    @Before
    public void before() {
        wd = new ChromeDriver();//окно браузера
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wd.manage().window();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("natachak2007@gmail.com");
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).sendKeys("725656kar");
        wd.findElement(By.id("passwd")).submit();
        wd.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }


    @After
    public void after() {
        wd.quit();
    }


    @Test
    public void verifyMyorder() {
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]"))
                .getText(), containsString("Order history"));


    }

    @Test
    public void verifyMysleep() {
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).click();
        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]"))
                .getText(), containsString("Credit slips"));

    }
    @Test
    public void verifyMywishlist() {
        Firsttest.wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).click();
        Assert.assertThat( Firsttest.wd.findElement(By.xpath("//*[@id=\"mywishlist\"]/h1"))
                .getText(), containsString("MY WISHLISTS"));
    }
    @Test
    public void verifyMyaddres() {
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).click();
        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]"))
                .getText(), containsString("My addresses"));


    }
    @Test
    public void verifyMypersInfo() {
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).click();
        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]"))
                .getText(), containsString("Your personal information"));

    }}


