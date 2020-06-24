package br.ce.imp.core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
	

	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}

/********* TextField ************/
	
	public void write(By string, String text){
		driver.findElement(string).clear();
		driver.findElement(string).sendKeys(text);
	}

		
	public void write(String id_campo, String text){
		write(By.id(id_campo), text);
	}
	
	
	
	public String GetFieldValue(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}


	/********* Radio and Check **************/

	
    public boolean checkBox(String id){
		driver.findElement(By.id(id)).click();
		return false;
		
		}
	
/********* Button ************/
	
	public void clickButton(String id) {
		driver.findElement(By.xpath(id)).click();
	}
	
		
/********* Link  ************/
	
	 public String ClickLink(String link){
		 driver.findElement(By.linkText(link )).click();
		 return link;
	}

/********* Text ************/
	
	public String getText(By by) {
		return driver.findElement(by).getText();
	}
	
	public String getText(String id) {
		return getText(By.id(id));
	}
	

	
}

