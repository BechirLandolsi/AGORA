package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.json.JSONObject;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;

@ManagedBean
@SessionScoped
public class ProfileBean {
	
	@EJB
	CompanyServiceRemote CompanyService ;
	
	@EJB 
	OrderServiceRemote orderService ;
	
	private String from ;
	private String to ;
	
	ContactBean contactBean ;
	
	public void fonction(Company c){
		
	}
	
	
	
	
	/*public Double convertCurrency() throws IOException{
		// Setting URL
					String url_str = "https://v3.exchangerate-api.com/bulk/31499df34d95d359397c9efd/";
					String pricee=from;
					// Making Request
					String urlNew =url_str+pricee;
					URL url = new URL(urlNew);
					HttpURLConnection request = (HttpURLConnection) url.openConnection();
					request.connect();

					// Convert to JSON
					JsonParser jp = new JsonParser();
					JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
					JsonObject jsonobj = root.getAsJsonObject();

					// Accessing object
					String req_result = jsonobj.get("result").getAsString();
					//String req_result2 = jsonobj.get("timestamp").getAsString();
					//String req_result3 = jsonobj.get("from").getAsString();
					JsonObject req_result4 = jsonobj.get("rates").getAsJsonObject();

					System.out.println(jsonobj);
					
					price=(req_result4.get(to)).getAsDouble()*soumLekher;
					System.out.println(price);
					JsonParser parser = new JsonParser(); 
					JsonElement mJson =  parser.parse(jsonobj.toString());
					System.out.println(price);
					System.out.println("behi ay");
					System.out.println(from);
					System.out.println(to);
					this.setPrice(price);
					return price;
					
		
	}*/
	
	/*public  float currencyConvertion(String from,String to , float price)
	{
		String response = HttpRequest
				.get("https://v3.exchangerate-api.com/bulk/4f46365f63635a74262a885c/"+from)
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		JSONObject status = jsonObject.getJSONObject("rates");
		Double eur = status.getDouble(to);
		return (float) (eur * price) ;
	}*/
	
	

}
