import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebsiteInfo {

	public Document doc;
	public String Price;
	public int webCode;
	public String CustomLink;
	public String ProductName;
	public String url;
	

	public void getDoc(String s) throws IOException {
		doc = Jsoup.connect(s).get();
	}
	
	public String getPrice() {
		Price = doc.getElementsByClass("amount").html();
		return Price;
	}
	
	public void setName(String s) {
		ProductName = s.replace(' ', '-');
		ProductName.toLowerCase();
	}
	
	public void setWebCode(int x) {
		webCode = x;
	}
	
	public void setURL(String s) {
		url = s;
	}
	
	public void getLink() {
		CustomLink = "https://www.bestbuy.ca/en-ca/product/" + ProductName + "/" + webCode + ".aspx";
	}

}
