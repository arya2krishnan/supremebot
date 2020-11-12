package com.botticus123;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;


public class PaymentAutomator {
    private static final String MYNAME = "Arya Krishnan";
    private static final String MYEMAIL = "arya2krishnan@gmail.com";
    private static final String MYTEL = "5103094693";
    private static final String HOMEADDRESS = "464 Miwok Ct";
    private static final String HOMEZIP = "94539";
    private static final String HOMECITY = "Fremont";
    private static final String HOMESTATE = "CA";
    private static final String CCNUMBER = "123456789";
    private static final String CCEXPIRATION1 = "07";
    private static final String CCEXPIRATION2 = "2024";
    private static final String CCCVV = "455";
    private static final String JAVASCRIPT = "const xhr = new XMLHttpRequest();\n" +
            "xhr.open(\"POST\", \"https://www.supremenewyork.com/shop/173113/add.json\", true);\n" +
            "xhr.setRequestHeader(\"content-type\", \"application/x-www-form-urlencoded\");\n" +
            "xhr.setRequestHeader(\"user-agent\", \"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1\");\n" +
            "const data = \"s=77261&st=26837&qty=1\";\n" +
            "xhr.send(data);";


    public static void main(String[] args) throws InterruptedException {
        String computerName = "admin";
        String chromeBinary = "src/main/resources/drivers/chrome/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeBinary);
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.addArguments("--user-data-dir=/Users/"+ computerName +"/Library/Application Support/Google/Chrome");
        chOptions.addArguments("--disable-extensions");
        chOptions.setExperimentalOption("useAutomationExtension", false);
        chOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        ChromeDriver browser = new ChromeDriver(chOptions);

        browser.get("https://www.google.com/recaptcha/api2/demo");
        Thread.sleep(60000);
        browser.get("https://www.supremenewyork.com/shop");
        browser.executeScript(JAVASCRIPT);

        Thread.sleep(1000);
        browser.get("https://www.supremenewyork.com/checkout");

        Thread.sleep(500);
        WebElement name = browser.findElementById("order_billing_name");
        name.sendKeys(MYNAME);

        Thread.sleep(500);
        WebElement email = browser.findElementById("order_email");
        email.sendKeys(MYEMAIL);

        Thread.sleep(500);
        WebElement tel = browser.findElementById("order_tel");
        tel.sendKeys(MYTEL);

        Thread.sleep(500);
        WebElement address = browser.findElementById("bo");
        address.sendKeys(HOMEADDRESS);

        Thread.sleep(500);
        WebElement zipCode = browser.findElementById("order_billing_zip");
        zipCode.sendKeys(HOMEZIP);

        //WebElement city = browser.findElementById("order_billing_city");
       // city.sendKeys(HOMECITY);

        Thread.sleep(500);
        Select state = new Select(browser.findElementById("order_billing_state"));
        state.selectByVisibleText(HOMESTATE);

        Thread.sleep(500);
        WebElement number = browser.findElementById("rnsnckrn");
        number.sendKeys(CCNUMBER);

        Thread.sleep(500);
        Select expiration1 = new Select(browser.findElementById("credit_card_month"));
        expiration1.selectByVisibleText(CCEXPIRATION1);

        Thread.sleep(500);
        Select expiration2 = new Select(browser.findElementById("credit_card_year"));
        expiration2.selectByVisibleText(CCEXPIRATION2);

        Thread.sleep(500);
        WebElement cvv = browser.findElementById("orcer");
        cvv.sendKeys(CCCVV);


    }
}
