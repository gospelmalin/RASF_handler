package repository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import model.Category;


/**
 * The Class RESTClient handles the communication with the API.
 */
public class RESTClient {
	
	/** The client. */
	private Client client;
	
	// URLs as static strings for ease of use and more readable code.
	/** The  URL used to Search for categories in RASF. */
	private static String REST_SERVICE_URL = "http://localhost:8081/RASF/rest/CategoryService/categories"; 
	
	
	/**
	 * Instantiates a new API client.
	 */
	// constructor
	public RESTClient() {
		client = ClientBuilder.newClient();
	}
	
	
	/**
	 * Query API for all categories.
	 *
	 * @return the string
	 */
	protected String getAllCategories() {
		RESTClient rc = new RESTClient();
		GenericType<String> string = new GenericType<String>() {};
		String s = rc.client
				.target(REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.get(string); // get the XML representation
		//print the XML representation
		System.out.println(s); // Kept for reference only
		return s;
	}
	
	/**
	 * Query API for selected category.
	 *
	 * @param categoryKey the category key
	 * @return the string
	 */
	protected String getSelectedCategory(int categoryKey) {
		RESTClient rc = new RESTClient();
		GenericType<String> string = new GenericType<String>() {};
		String s = rc.client
				.target(REST_SERVICE_URL)
			    .path("/{categoryKey}")
		        .resolveTemplate("categoryKey", Integer.toString(categoryKey))
				.request(MediaType.APPLICATION_XML)
				.get(string); // get the XML representation
		//print the XML representation
		System.out.println(s); // Kept for reference only
		return s;
	}

	/**
	 * Call API to add category.
	 *
	 * @param category the Category
	 * @return the string
	 */
	protected String addCategory(Category category) {
		Form form = new Form();
	    form.param("categoryKey", Integer.toString(category.getCategoryKey()));
	    form.param("categoryName", category.getCategoryName());
	    RESTClient rc = new RESTClient();
	    String callResult = rc.client
	       .target(REST_SERVICE_URL)
	       .request(MediaType.APPLICATION_XML)
	       .post(Entity.entity(form,
	          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	          String.class);
	    String returnMessage = "Add category request returned: \n" + callResult;
		
	    System.out.println(returnMessage);
	    return returnMessage;
	}
	
	/**
	 * Call API to update category.
	 *
	 * @param category the Category
	 * @return the string
	 */
	protected String updateCategory(Category category) {
		Form form = new Form();
	    form.param("categoryKey", Integer.toString(category.getCategoryKey()));
	    form.param("categoryName", category.getCategoryName());
	    RESTClient rc = new RESTClient();
	    String callResult = rc.client
	       .target(REST_SERVICE_URL)
	       .request(MediaType.APPLICATION_XML)
	       .put(Entity.entity(form,
	          MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	          String.class);
	    String returnMessage = "Update category request returned: \n" + callResult;
	    System.out.println(returnMessage);	    
	return returnMessage;
	}
	
	/**
	 * Call API to delete category.
	 *
	 * @param category the Category
	 * @return the string returnMessage
	 */
	protected String deleteCategory(Category category) {
	 RESTClient rc = new RESTClient();
	 String callResult = rc.client
	         .target(REST_SERVICE_URL)
	         .path("/{categoryKey}")
	         .resolveTemplate("categoryKey", Integer.toString(category.getCategoryKey()))
	         .request(MediaType.APPLICATION_XML)
	         .delete(String.class);
	 String returnMessage = "Delete category request returned: \n" + callResult;
	 System.out.println(returnMessage);	
	return returnMessage;
	}

}
