package br.ce.imp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.ce.imp.core.DSL;
import br.ce.imp.page.SignUpPage;

@RunWith(Parameterized.class)
public class TestBusinessRule {

	private WebDriver driver;
	private DSL dsl;
	private SignUpPage page;
	
	@Parameter 
	public String signup;
	@Parameter(value=1)
	public String email;
	@Parameter(value=2)
	public String password;
	@Parameter(value=3)
	public String passwords;
	@Parameter(value=4)
	public String inputAge;
	@Parameter(value=5)
	public String terms;
	
	
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


@Parameters
public static Collection<Object[]> getCollection(){
	return Arrays.asList(new Object[][] {
		{"", "", "", Arrays.asList(), new String[]{},"Sign up"},
	});

}


@Test
public void ValidateBusinessRules () {
	page.setSignup(signup);
	page.setEmail(email);
	page.setPassword(password);
	page.setCPassword(passwords);
	page.setInputAge(inputAge);
	page.setAcceptTerm(terms);
	
	
	
	page.Submit();
	}
}

