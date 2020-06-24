package br.ce.imp.page;
import org.openqa.selenium.WebDriver;

import br.ce.imp.core.DSL;

	
	public class SignUpPage {
		
		private DSL dsl;
		public Object getCPassword;
		
		public SignUpPage(WebDriver driver) {
			dsl = new DSL(driver);
		}
		
	
	public void setSignup(String Signup) {
		dsl.ClickLink("Sign Up");
		
	}
			
	public void setEmail(String Email) {
		dsl.write("username", Email);
	}
	
	public void setPassword(String Password) {
		dsl.write("password", Password);
	}
	 
	public void setCPassword(String Confirmpassword) {
		dsl.write("confirm-password", Confirmpassword);
	}	 

	public void setInputAge(String inputAge) {
		dsl.write("age", inputAge);
	}

	public void setAcceptTerm(String Terms){
		dsl.checkBox("terms");
	}
	
		
	public void setSubmit(String Submit) {
		dsl.clickButton("//div[@id='signup']/div/form/div[7]/button");
	}


	public String GetResultSignup() {
        dsl.ClickLink("Sign Up");
		return null;		
	}
	
	
	public String getResultEmail() {
		return dsl.getText("username");
	
	}
	
	public String getResultPassword() {
		return dsl.getText("password");
	
	}
	
	public String getResultCPassword() {
		return dsl.getText("confirm-password");
	
	}
	
	public String getResultAge() {
		return dsl.getText("age");
	
	}
	
	public Object getResultTerm() {
		return dsl.checkBox("terms");
	}
	
	public void Submit(){
		dsl.clickButton("//button[@type='submit']");;
	}


	
	
	
	}
	
	
	