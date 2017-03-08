import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.PieChartModel;

import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;
 

public class AllFunctions implements Serializable {
	
	private CustomClass customClass;
	private String message;
	private String app;
	private String token;
	private String rssesion;
	private JSONObject jsonObject;
	private Transactions transactions;
	private List<Transactions> tlist ;
	private Map<String ,Double> hmap;
	private PieChartModel pieModel1;
	private List<String> categories;


	public AllFunctions()
	{
		tlist= new ArrayList<Transactions>();
		hmap = new HashMap<String ,Double>();
		categories = new ArrayList<String>();
		categories.add("Organic Food");
		categories.add("Drugs");
		categories.add("Gym Membership");
		categories.add("Gym Membership");
		categories.add("Health related Talk");
		categories.add("Health related travel");
		categories.add("Deepends related spending");
		categories.add("Transfers");
		
	}
	public String registerUser(String username, String password,
			String email)
	{
	String value = customClass.loginCobrand();
		if(value.equals("SUCCESS"))  
		{
			
			String value2=customClass.registerUser(username, password, email);
			if(value2.equals("SUCCESS"))
			{
				return "SUCCESS";
			}
			else
			{
				message=customClass.getMessage()+"user fail";
				return "FAIL";
			}
		}
		else
			message=customClass.getMessage()+"cobrand fail";
			return "FAIL";
	
	}

	public String LoginUser(String username, String password)
	{
	String value2 = null;
	value2 = customClass.loginUser(username, password);
	if(value2.equals("SUCCESS"))
			{
				return "SUCCESS";
			}
			else
			{
				message=customClass.getMessage();
				return "FAIL";
			}
		}
/*	public String getProviders()
	{
	String value2 = null;
		value2 = customClass.getProviders();
	if(value2.equals("SUCCESS"))
			{
				return "SUCCESS";
			}
			else
			{
				message=customClass.getMessage()+"user fail";
				return "FAIL";
			}
		}

*/
	
	public String getProvidersToken()
	{
		
	String value2 = null;
		value2 = customClass.getProvidersToken();
	if(value2.equals("SUCCESS"))
			{
		       app=customClass.getApp();
		       token=customClass.getToken();
		       rssesion=customClass.getUserSessionToken();
				return "SUCCESS";
			}
			else
			{
				message=customClass.getMessage();
				return "FAIL";
			}
		}
	
	public String getTransactiondetails()
	{
	try{
		int transactionNumber=1;
	String value2 = customClass.getTransactions();
	if(value2.equals("SUCCESS"))
			{
	jsonObject=	customClass.getJsonObject();
	
    JSONArray jsonArray = jsonObject.getJSONArray("transaction");
 
	String[] elementNames=null;
    for (int i = 0, size = jsonArray.length(); i < size; i++)
    {
      JSONObject objectInArray = jsonArray.getJSONObject(i);
      // getting amoumt values;
     String amt = jsonArray.getJSONObject(i).get("amount").toString();
     String container =  jsonArray.getJSONObject(i).get("CONTAINER").toString();
     int transactionId = (int)jsonArray.getJSONObject(i).get("id");
     String categorySource = jsonArray.getJSONObject(i).get("categorySource").toString(); 
     String categoryId = jsonArray.getJSONObject(i).get("categoryId").toString(); 
     JSONObject amtObj = new JSONObject(amt);
     String amtValue;
     try{
	double d= (double) amtObj.get("amount");
	amtValue = "$"+String.valueOf(d);
     }
     catch (ClassCastException ce)
     {
    	 int a= (int)amtObj.get("amount");
    	 amtValue = "$"+String.valueOf(a);
     }
   // getting description
     String description = jsonArray.getJSONObject(i).get("description").toString();
     JSONObject descpObj = new JSONObject(description);
  
     String simpleDesription=null;
     try{
      simpleDesription = descpObj.get("simple").toString();
     }
     catch(Exception se)
     {
    	 simpleDesription = descpObj.get("original").toString();
     }
    
     Transactions trans = transactions.getTransactions(String.valueOf(transactionId),objectInArray.get("date").toString(),
    		   amtValue,
    		   objectInArray.get("category").toString(),simpleDesription,container,categorySource,categoryId);
       tlist.add(trans);
     
      }
    

			
    return "SUCCESS";
	
			}
			else
			{
				message=customClass.getMessage();
				return "FAIL";
			}
		}
	
	catch(Exception e)
	{
		message=e.getMessage();
		return "FAIL";
	}
	
	}
	   public void onCellEdit(CellEditEvent  event) {
		   
		  // Entity entity =(Entity)((DataTable)event.getComponent()).getRowData();
		   Transactions tran = (Transactions)((DataTable)event.getComponent()).getRowData();
		 //  updateTransaction(tran.getTransactionId(),tran.getCategoryId(),tran.getContainer(),tran.getCategorySource(),tran.getCategory());
	   }
	   
	   public void updateTransaction()
	   {
		   
		   
	   }
	/*public void onRowEdit(RowEditEvent event) 
	{
        FacesMessage msg = new FacesMessage("Transaction Edited - Category Changed to ", ((Transactions) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Transactions) event.getObject()).getDescription());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    */
  
	public boolean generateChart()
	{
		if(tlist.isEmpty())
		{
			 if(getTransactiondetails().equals("SUCCESS"))
			{
				if(calculationsForChart()==1)
				{
					if(generatePieChart().equals("SUCCESS"))
						return true;
					else
						return false;
				}
				else
				return false;
			
		}
			 else
				 return false;
		}
		else
		{
			if(calculationsForChart()==1)
			{
				if(generatePieChart().equals("SUCCESS"))
					return true;
				else return false;
					
			}
			else return false;
		}
	}

	public int calculationsForChart()
	{
		try
		{
		 for(int i=0;i<tlist.size();i++)
		 {
			double  amount = Double.parseDouble(tlist.get(i).getAmount().substring(tlist.get(i).getAmount().lastIndexOf('$') + 1));
		
			String category = tlist.get(i).getCategory();
			
			if (hmap.containsKey(category))
			{
			
				hmap.put(category, hmap.get(category) + amount);
			}
			else
			{
				hmap.put(category, amount);
			}
		 }
		 return 1;
		}
		catch(Exception e)
		{ message = e.getMessage(); return 0;}
	}
	

	public String generatePieChart()
	{
		try{
		 pieModel1 = new PieChartModel();
         
		Iterator it = hmap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        pieModel1.set(pair.getKey().toString(), (Number) pair.getValue());
	    }
	         
	        pieModel1.setTitle("Simple Pie");
	        pieModel1.setLegendPosition("e");
	        pieModel1.setLegendCols(4);
	        pieModel1.setLegendRows(5);
	        return "SUCCESS";
	    }
	catch(Exception e)
	{
		message=e.getMessage();
		return "FAIL";
	}
}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public CustomClass getCustomClass() {
		return customClass;
	}

	public void setCustomClass(CustomClass customClass) {
		this.customClass = customClass;
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

	public String getRssesion() {
		return rssesion;
	}

	public void setRssesion(String rssesion) {
		this.rssesion = rssesion;
	}
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public List<Transactions> getTlist() {
		return tlist;
	}
	public void setTlist(List<Transactions> tlist) {
		this.tlist = tlist;
	}
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	public Transactions getTransactions() {
		return transactions;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}
	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}