package java_lambdas_8.chapter_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.DateFormatter;


public class Local {

    public static void main(String[] args) {
        ThreadLocal<DateFormatter> t = ThreadLocal.withInitial(DateFormatter::new);
        

    }

}
