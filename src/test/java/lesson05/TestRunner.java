package lesson05;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Firsttest.class,
        SecondTest.class
})
public class TestRunner{}

