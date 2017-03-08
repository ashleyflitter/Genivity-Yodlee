
public class Transactions {
	
	private String date;
	private String amount;
	private String category;
	private String description;

	private String container ;
	private String transactionId ;
	private String categorySource ;
	private String categoryId;
	

	
		public Transactions getTransactions(String id ,String date , String amount , String category, String description,
				String container , String categorySource ,String categoryId)
		{
			Transactions tran= new Transactions();
			tran.setTransactionId(id);
			tran.setDate(date);
			tran.setAmount(amount);
			tran.setCategory(category);
			tran.setDescription(description);
			tran.setContainer(container);
			tran.setCategorySource(categorySource);
			tran.setCategoryId(categoryId); 
		
	
		return tran;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getCategorySource() {
		return categorySource;
	}
	public void setCategorySource(String categorySource) {
		this.categorySource = categorySource;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDate() {
		return date;
	}


}
