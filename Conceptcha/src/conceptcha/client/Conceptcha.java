package conceptcha.client;

import conceptcha.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class Conceptcha implements EntryPoint {

	public String templateFileName="./template.html";

	public HTMLPanel htmlPanel;
	
	public void onModuleLoad() {
			
		try {
			new RequestBuilder(RequestBuilder.GET, templateFileName).sendRequest("", new RequestCallback() {
				  @Override
				  public void onResponseReceived(Request req, Response resp) {
						
					 String htmlText = resp.getText();
					 RootPanel.get("body").clear();
				     htmlPanel=new HTMLPanel(htmlText);
				     getDynamicContent();
				     RootPanel.get("body").add(htmlPanel);
					    
				    
				  }

				 

				@Override
				  public void onError(Request res, Throwable throwable) {
				    Window.alert(throwable.getMessage());
					throwable.printStackTrace();
				  }
				});
		} catch (RequestException e) {
			Window.alert("cannot read the html template file "+templateFileName);
			  
			e.printStackTrace();
		}
		
		
	}
	
	public void getDynamicContent(){
		
	}
}
