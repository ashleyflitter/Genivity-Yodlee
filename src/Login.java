import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class Login {
	

	private String username="sbMempriyanka03091";
	private String password="sbMempriyanka03091#123";
//	private CustomClass customClass;
	
private String cobrandSessionToken;
private String userSessionToken ;
private String message;
private boolean renderMessage;
private AllFunctions allFunctions;
private boolean renderDatatable;
private boolean renderChart;

public Login()
{
	renderMessage=false;
	renderDatatable=false;
	renderChart=false;
	
}

	public String connect()
	{
		String value = allFunctions.LoginUser(username, password);
		//String value = customClass.loginCobrand(cobrandUsername, cobrandPassword);
		if(value.equals("SUCCESS"))  
           return "SUCCESS";
			else
			{
				message=allFunctions.getMessage();
				renderMessage=true;
				return "FAIL";
			}
	}
	


	
	public String getProvidersToken()
	{
		String value = allFunctions.getProvidersToken();
		//String value = customClass.loginCobrand(cobrandUsername, cobrandPassword);
		if(value.equals("SUCCESS")) 
		{
			
	           return "SUCCESS";
			}
			
		
			else
			{
				message=allFunctions.getMessage();
				renderMessage=true;
				return "FAIL";
			}
	}
	
	public String getTransactions()
	{
		String value = allFunctions.getTransactiondetails();
		//String value = customClass.loginCobrand(cobrandUsername, cobrandPassword);
		if(value.equals("SUCCESS")) 
		{
			renderDatatable=true;
           return "1";
		}
			else
			{
				message=allFunctions.getMessage();
				renderMessage=true;
				return "0";
			}
	}
	public String generateChart()
	{
	renderDatatable=false;
		if(allFunctions.generateChart()) 
		{
			renderChart=true;
           return "2";
		}
			else
			{
				message=allFunctions.getMessage();
				renderMessage=true;
				return "3";
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

public String getCobrandSessionToken() {
	return cobrandSessionToken;
}

public void setCobrandSessionToken(String cobrandSessionToken) {
	this.cobrandSessionToken = cobrandSessionToken;
}

public String getUserSessionToken() {
	return userSessionToken;
}

public void setUserSessionToken(String userSessionToken) {
	this.userSessionToken = userSessionToken;
}

public AllFunctions getAllFunctions() {
	return allFunctions;
}



public void setAllFunctions(AllFunctions allFunctions) {
	this.allFunctions = allFunctions;
}

public boolean isRenderDatatable() {
	return renderDatatable;
}

public void setRenderDatatable(boolean renderDatatable) {
	this.renderDatatable = renderDatatable;
}

public boolean isRenderChart() {
	return renderChart;
}

public void setRenderChart(boolean renderChart) {
	this.renderChart = renderChart;
}


}
