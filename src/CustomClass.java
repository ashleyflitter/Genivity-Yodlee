

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.httpclient.HttpClient;

import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;




public class CustomClass {
	public static String HOST_URI = "https://developer.api.yodlee.com/ysl/restserver/v1/";
			//base
    public static String GET_USER_INFO= "jsonsdk/Login/getUserInfo";
	private static String COB_LOGIN_URL = "cobrand/login";
	private static String USER_LOGIN_URL = "user/login/";
	private static String REGISTER_URL ="user/register";
	private static String ACCESS_TOKEN_URL=	"user/accessTokens";
	private static String TRANSACTIONS_URL="transactions";
			
	
			
	

	private String cobrandName="private-sandboxnxt120";
	
	//Cobrand login API parametersc
	private String paramNameCobrandLogin = "cobrandLogin";
	private String paramNameCobrandPassword = "cobrandPassword";

	//User login API parameters
	private String paramNameUserLogin = "loginName";
	private String paramNameUserPassword = "password";
	
	private String cobrandUsername="sbCobpriyanka0309";
	private String cobrandPassword="98ef593a-8f33-4985-bea0-77f5cebde184";
	private String app="10003600";
	private String token;
	private String redirect="true";
    private JSONObject jsonObject;
	
	
private String cobrandSessionToken;
private String userSessionToken ;
private String message;

	public String loginCobrand() {
		DefaultHttpClient httpclient = new DefaultHttpClient();

		String url = HOST_URI + COB_LOGIN_URL;
		try {
			HttpsURLConnection
					.setDefaultHostnameVerifier(new NullHostnameVerifier());

			PostMethod pm = new PostMethod(url);
			pm.addParameter(paramNameCobrandLogin, cobrandUsername);
			pm.addParameter(paramNameCobrandPassword, cobrandPassword);

			HttpClient hc = new HttpClient();
			hc.executeMethod(pm);
			

			String source = pm.getResponseBodyAsString();

			JSONObject jsonObject = new JSONObject(source);
			JSONObject cobConvCreds = jsonObject
					.getJSONObject("session");
			cobrandSessionToken = (String) cobConvCreds.get("cobSession");
			return "SUCCESS";

		

			

		} catch (Exception e) {
			message=e.getMessage();
			return "FAIL";
		}
	}

	@SuppressWarnings("deprecation")
	public String loginUser(String usernameValue,
			String passwordValue)  {
		

		
		//DefaultHttpClient httpclient = new DefaultHttpClient();

		String url = HOST_URI + USER_LOGIN_URL;
		try {
			HttpsURLConnection
					.setDefaultHostnameVerifier(new NullHostnameVerifier());
			   String coAuthentication= loginCobrand();
			if(coAuthentication.equals("SUCCESS"))
            {
				PostMethod pm = new PostMethod(url);
				pm.addParameter(paramNameUserLogin, usernameValue);
				pm.addParameter(paramNameUserPassword, passwordValue);
				//pm.addParameter(paramNameCobSessionToken, cobrandSessionToken);
               pm.addRequestHeader("Authorization", "cobSession="+cobrandSessionToken);
               pm.addRequestHeader("Connection","keep-alive");
               pm.addRequestHeader("Accept","application/json");
               //System.out.println("CustomClass.loginUser()"+pm);
              // System.out.println("CustomClass.loginUser()"+pm.getAuthenticationRealm().toString());
				HttpClient hc = new HttpClient();
				hc.executeMethod(pm);
				//System.out.println("CustomClass.loginUser()"+pm.getAuthenticationRealm().toString());
				String source = pm.getResponseBodyAsString();
				//System.out.println("CustomClass.loginUser()"+source);
				JSONObject jsonObject = new JSONObject(source);
				JSONObject userContext = jsonObject.getJSONObject("user");
				JSONObject userConvCreds = userContext
						.getJSONObject("session");
				userSessionToken = (String) userConvCreds.get("userSession");
			return "SUCCESS";
        }
        else
        {
        	return "FAIL";
        }

	} catch (Exception e) {
		message=e.getMessage();
		return "FAIL";
	} 
	}
	
	public String registerUser(String newUsername,
			String newPassword,String newEmail) {
		// String userSessionToken=null;
		DefaultHttpClient httpclient = new DefaultHttpClient();

		String url = HOST_URI + REGISTER_URL;
		try {
			HttpsURLConnection
					.setDefaultHostnameVerifier(new NullHostnameVerifier());

			PostMethod pm = new PostMethod(url);
			//pm.setRequestHeader("cobSession", cobrandSessionToken);
			//pm.addParameter(paramNameCobSessionToken, cobrandSessionToken);
		String parameters = "{\"user\":" +"{"+ "\"loginName\":\""+newUsername+"\""+",\"password\":"+
		 "\""+newPassword+"\""+
				 ",\"email\":"+"\""+newEmail+"\""+"}}";
		/*  pm.addParameter(paramNameNewUserLogin, newUsername);
			pm.addParameter(paramNameNewUserPassword, newPassword);
			pm.addParameter(paramNameUserEmail, newEmail);*/
		 pm.addParameter("userParam",parameters);
		 
			   pm.addRequestHeader("Authorization", "cobSession="+cobrandSessionToken);
               pm.addRequestHeader("Connection","keep-alive");
               pm.addRequestHeader("Accept","application/json");
              //pm.addParameter("userParam", parameters);
			HttpClient hc = new HttpClient();
			hc.executeMethod(pm);
			/*String source = pm.getResponseBodyAsString();
			JSONObject jsonObject = new JSONObject(source);
			JSONObject userContext = jsonObject.getJSONObject("user");
			JSONObject userConvCreds = userContext
					.getJSONObject("session");
			userSessionToken = (String) userConvCreds.get("userSession");*/
			return "SUCCESS";
		} catch (Exception e) {
		message=e.getMessage();
		return "FAIL";
		} 
		
	}

	public String getProvidersToken() {
		
		String value = getAccessTokens();
		try
		{
		if(value.equals("SUCCESS"))
		{
			return "SUCCESS";
		}
		else
			return "FAIL";
	}
        catch (Exception e) {
		message=e.getMessage();
		return "FAIL";
		} 
		
	}
	
	public String getAccessTokens() {
		// String userSessionToken=null;
		DefaultHttpClient httpclient = new DefaultHttpClient();

		String url = HOST_URI + ACCESS_TOKEN_URL+"?appIds="+"10003600";
		//String url = HOST_URI + ACCESS_TOKEN_URL;
		try {
			
			//String url = "http://www.google.com/search?q=developer";

			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);

			// add request header
		 request.addHeader("User-Agent", "Mozilla/5.0");
		
		 request.addHeader("Authorization", "cobSession="+cobrandSessionToken+",userSession="+userSessionToken);
	// request.addHeader("appIds",app);
		request.addHeader("Host","developer.api.yodlee.com");
		request.addHeader("cobrandName",cobrandName);
		HttpResponse response = client.execute(request);

		

			BufferedReader rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				//systrace
				result.append(line);
			}

			
			JSONObject jsonObject = new JSONObject(result.toString());
	
			JSONObject userContext = jsonObject.getJSONObject("user");
		    JSONArray jsonArray = userContext.getJSONArray("accessTokens");
		  
		    for (int i = 0, size = jsonArray.length(); i < size; i++)
		    {
		      JSONObject objectInArray = jsonArray.getJSONObject(i);
		      String[] elementNames = JSONObject.getNames(objectInArray);
		
		      app = objectInArray.getString("appId");
		      token=objectInArray.getString("value");
		    }
	
           return "SUCCESS";
		

		} catch (Exception e) {
		message=e.getMessage();
		return "FAIL";
		} 
		
	}
	
	//https://yieapnode.stage.yodleeinteractive.com/authenticate/yieap/
	
		
	

	
	
		public  String getTransactions()
		{
			DefaultHttpClient httpclient = new DefaultHttpClient();

			String url = HOST_URI + TRANSACTIONS_URL;
			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(url);
			 request.addHeader("User-Agent", "Mozilla/5.0");
			 request.addHeader("Authorization", "cobSession="+cobrandSessionToken+",userSession="+userSessionToken);
			    request.addHeader("Host","developer.api.yodlee.com");
			    request.addHeader("cobrandName",cobrandName);
			    HttpResponse response = client.execute(request);
				BufferedReader rd = new BufferedReader(
		                       new InputStreamReader(response.getEntity().getContent()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					//systrace
					result.append(line);
				}

				
				 jsonObject = new JSONObject(result.toString());
				 httpclient.getConnectionManager().shutdown();
	           return "SUCCESS";
			

			} catch (Exception e) {
			message=e.getMessage();
			return "FAIL";
			} 
			finally {
				httpclient.getConnectionManager().shutdown();
			}
			
		}
	private static class NullHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

}