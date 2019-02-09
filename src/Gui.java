import java.io.IOException;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Gui extends Application {
	WebsiteInfo wi;
	
	public void start (Stage primaryStage) {
		wi = new WebsiteInfo();
		primaryStage.setTitle("BestBuy Price Finder");
		Pane pane = new Pane();
		Scene scene = new Scene(pane,525,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Label label = new Label("BestBuy Price Finder");
		label.setLabelFor(pane);
		label.setLayoutX(150);
		label.setLayoutY(0);
		label.setStyle("-fx-font-family: TRON; -fx-font-size: 25;");
		
		TextField ProductName = new TextField("Enter the name of the product");
		ProductName.setLayoutX(0);
		ProductName.setLayoutY(50);
		ProductName.setMinSize(250, 30);
		ProductName.setOnMouseClicked(e -> ProductName.clear());
		ProductName.setOnAction(e -> {wi.setName(ProductName.getText());
		ProductName.setText("Enter the name of the product");
	});
		
		
		TextField WebCode = new TextField("Enter the webcode");
		WebCode.setLayoutX(0);
		WebCode.setLayoutY(100);
		WebCode.setMinSize(250, 30);
		WebCode.setOnMouseClicked(e -> WebCode.clear());
		WebCode.setOnAction(e -> {wi.setWebCode(Integer.parseInt(WebCode.getText()));
		WebCode.setText("Enter the webcode");});
		
		TextField URLField = new TextField("Enter the url");
		URLField.setLayoutX(0);
		URLField.setLayoutY(150);
		URLField.setMinSize(250, 30);
		URLField.setOnMouseClicked(e -> URLField.clear());
		URLField.setOnAction(e -> {wi.setURL(URLField.getText());
		URLField.setText("Enter the url");});

		TextField Price = new TextField();
		Price.setLayoutX(175);
		Price.setLayoutY(200);
		Price.setMinSize(100, 50);
		
		Button getPriceURL = new Button("Get Price Using URL");
		getPriceURL.setLayoutX(300);
		getPriceURL.setLayoutY(125);
		getPriceURL.setOnAction(e ->{
				try {
					wi.getDoc(wi.url);
					Price.setText(wi.getPrice());
				} catch (IOException e1) {
					System.out.println("Invalid Link");
				}
			}
		);
		
		Button getPrice = new Button("Get Price Using Name and Webcode");
		getPrice.setLayoutX(300);
		getPrice.setLayoutY(75);
		getPrice.setOnAction(e ->{
				try {
					wi.getLink();
					wi.getDoc(wi.CustomLink);
					Price.setText(wi.getPrice());
				} catch (IOException e1) {
				System.out.println("Invalid Name &/ Webcode");
				}});
		pane.getChildren().addAll(WebCode,ProductName,getPrice,Price,URLField,getPriceURL,label);
	}

	public static void main(String [] args) {
		Application.launch(args);
	}
}
