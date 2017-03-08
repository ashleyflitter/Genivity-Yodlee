import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class Register {
	
	private String username;
	private String password;
	private String confirmpassword;
	private String email;
	private AllFunctions allFunctions;


private String message;
private boolean renderMessage;

public Register()
{
	renderMessage=false;
	
}

	public String registerUser()
	{
		String value = allFunctions.registerUser(username, confirmpassword, email);
		if(value.equals("SUCCESS"))  
		  return "SUCCESS";
		else
		{
	    message=allFunctions.getMessage();
		renderMessage=true;
		return "FAIL";
		}
		 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRenderMessage() {
		return renderMessage;
	}

	public void setRenderMessage(boolean renderMessage) {
		this.renderMessage = renderMessage;
	}

	public AllFunctions getAllFunctions() {
		return allFunctions;
	}

	public void setAllFunctions(AllFunctions allFunctions) {
		this.allFunctions = allFunctions;
	}
	
}
	