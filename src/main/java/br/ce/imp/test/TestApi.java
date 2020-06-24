package br.ce.imp.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.ce.imp.core.DSL;
import br.ce.imp.page.SignUpPage;

public class TestApi {
	
	private WebDriver driver; 
	private DSL dsl;
	private SignUpPage page;
	
	@Before
	public void test() throws IOException {
		Properties envProperties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("env.properties");
		envProperties.load(in);
		in.close();
		
		System.setProperty("webdriver.gecko.driver","/home/ivanilde/Desktop/Automation/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get(envProperties.getProperty("host"));
		new DSL(driver);
		page = new SignUpPage(driver);
		
	}
		
	@After
	public void finaliza(){
		driver = null;
		driver.quit();
	}
	
		@Test
			public void Signup () {
			page.setSignup("Signup");
			page.setEmail("teste10@test.com");
			page.setPassword("1234@Ii");
			page.setCPassword("1234@Ii");
			page.setInputAge("44");
			page.setAcceptTerm("terms");
			page.Submit();
			
						
			Assert.assertEquals("Signup", page.GetResultSignup());
			Assert.assertEquals("teste10@test.com", page.getResultEmail());
		    Assert.assertEquals("1234@Ii",page.getResultPassword());
			Assert.assertEquals("1234@Ii",page.getResultCPassword());
		    Assert.assertEquals("44",page.getResultAge());
		    Assert.assertEquals("terms", page.getResultTerm());
		    			
			}

	}
