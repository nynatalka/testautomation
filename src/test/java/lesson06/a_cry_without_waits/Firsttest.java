package lesson06.a_cry_without_waits;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class Firsttest {
    static WebDriver wd;

    @BeforeClass
    public static void setUp() {
        wd=new ChromeDriver();
//        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wd.get("http://automationpractice.com/index.php?id_category=8&controller=category");
         wd.manage().window();
    }

@AfterClass
public static void tearDown(){
    wd.quit();
}
@Test
public void verifyFirstSerchResult() {
    wd.findElement(By.id("search_query_top")).click();
    wd.findElement(By.id("search_query_top")).sendKeys("Dress");
    wd.findElement(By.id("search_query_top")).submit();
    Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"))
            .getText(), containsString("Dress"));

}
}
