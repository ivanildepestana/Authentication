
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
	
		
	public void setEmail(String email) {
		dsl.write("username", email);
	}
	
	public void setPassword(String password) {
		dsl.write("password", password);
	}
	 
	public void setCPassword(String confirmpassword) {
		dsl.write("confirm-password", confirmpassword);
	}	 

	public void setAge(String age) {
		dsl.write("age", age);
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
	
	public boolean getResultTerm() {
		return dsl.checkBox("terms");
	}
	public void Submit(){
		dsl.clickButton("//button[@type='submit']");;
	}


	
	}
	
	
		
	