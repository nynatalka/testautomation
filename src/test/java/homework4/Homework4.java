package homework4;

import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Homework4 {

    static WebDriver wd;

    String query1 = "natachak2007@gmail.com";
    String query2 = "725656kar";
    static AccountPage result;

    @BeforeClass
    public static void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(10, SECONDS);
        wd.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        wd.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterClass
    public static void tearDown() {
        wd.quit();
    }

    @Test
    public void veryfySignin() {
        LoginPage _login1 = new LoginPage();
        result = _login1.logIn_task_1("natachak2007@gmail.com", "725656kar");
    }


    @Ignore
    @Test
    public void veryfyLogin() {
        LoginPage _loginPage = new LoginPage();
        result =  _loginPage.logIn_task_1(query1, query2);
    }

    @Test
    public void loginLogout() {
        result.signOut();
    }

    class LoginPage {
        @FindBy(xpath = "//*[@id=\"email\"]")
        WebElement login;

        @FindBy(xpath = "//*[@id=\"passwd\"]")
        WebElement element_with_id_password;

        //wd.findElement(By.id("search_query_top"))
        @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
        WebElement signin;

        @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
        WebElement h1;

        public LoginPage() {
            PageFactory.initElements(wd, this);
        }

        private void enterUsername(String username) {
            login.click();
            login.clear();
            login.sendKeys(username);
        }

        private void enterPassword(String password) {
            element_with_id_password.click();
            element_with_id_password.clear();
            element_with_id_password.sendKeys(password);
        }

        void clickSignInBtn(){
            signin.click();
        }

        AccountPage logIn_task_1(String username, String password) {
            login.click();
            login.clear();
            login.sendKeys(username);
            element_with_id_password.click();
            element_with_id_password.clear();
            element_with_id_password.sendKeys(password);
            signin.click();
            (new WebDriverWait(wd,10))
                    .until(ExpectedConditions.textToBePresentInElement(h1, "MY ACCOUNT"));
            return new AccountPage();
        }

        AccountPage logIn_task_2(String username, String password) {
            enterUsername(username);
            enterPassword(password);
            clickSignInBtn();
            (new WebDriverWait(wd,10))
                    .until(ExpectedConditions.textToBePresentInElement(h1, "MY ACCOUNT"));
            return new AccountPage();
        }
    }

    class AccountPage {

        @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
        WebElement sigout;

        @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
        WebElement h1;

        public AccountPage() {

            PageFactory.initElements(wd, this);
        }

        public LoginPage signOut() {
            sigout.click();

            (new WebDriverWait(wd,10))
                    .until(ExpectedConditions.textToBePresentInElement(h1, "AUTHENTICATION"));
            return new LoginPage();
        }
    }
}
