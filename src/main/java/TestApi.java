import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.ce.imp.core.DSL;

public class TestApi {
	
	private DSL dsl;
	private WebDriver driver;
	private SignUpPage page;
	
	@Before
	public void test() throws IOException {
		Properties envProperties = new Properties();
		FileInputStream in = (FileInputStream) this.getClass().getResourceAsStream("env.properties");
		envProperties.load(in);
		in.close();
		
		System.setProperty("webdriver.gecko.driver","/home/ivanilde/Desktop/Automation/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(envProperties.getProperty("host"));
		dsl = new DSL(driver);
		new SignUpPage(driver);
	}
		
	@After
	public void finaliza(){
		driver = null;
		driver.quit();
	}
	

	@Test
		public void SignUp () {
		page.setSignup("Signup");
		page.setEmail("teste8@test.com");
		page.setPassword("1234@Ii");
		page.setCPassword("1234@Ii");
		page.setAge("44");
		page.setAcceptTerm("terms");
		page.setSubmit("//button[@type='submit']");
		
		
		Assert.assertEquals("Signup", page.GetResultSignup());
		Assert.assertEquals("teste7@test.com", page.getResultEmail());
	    Assert.assertEquals("1234@Ii",page.getResultPassword());
		Assert.assertEquals("1234@Ii",page.getResultCPassword());
	    Assert.assertEquals("44",page.getResultAge());
	    Assert.assertEquals("terms", page.getResultTerm());
	    
		page.Submit();
		
		
	}
			
			
		}

