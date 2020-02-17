package ui;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.PrimeGenerator;

public class View extends Application{
	
	public static PrimeGenerator primeGenerator;
	
	public static void main(String[] args) {
		
		primeGenerator = new PrimeGenerator();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println(primeGenerator.getTop());
		GridPane pane = new GridPane();
		
		 TextField tf1 = new TextField("");
		 // this sets the number of spaces in the text fields

		 Label l1 = new Label("Write a natural number here ");

		 // these labels are set and used before the text fields as show below

		 pane.add(l1, 0, 0);
		 pane.add(tf1, 1, 0);
		 
		 
		 Button FirstAlgorithm = new Button("First Algorithm");
		 Button SecondAlgorithm = new Button("Second Algorithm");
		 Button ThirdAlgorithm = new Button("Third Algorithm");
		 
		 pane.add(FirstAlgorithm, 0, 1);
		 pane.add(SecondAlgorithm, 1, 1);
		 pane.add(ThirdAlgorithm, 2, 1);
		 
		 if(primeGenerator.getPrimes()!=null) {
			System.out.println("Entre");
			 boolean[] primes = primeGenerator.getPrimes();
			int columns = primeGenerator.getColumns();
			int rows = primeGenerator.getRows();
			int z=1;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					Label label = new Label((z+1)+"");
					if(primes[z]) {
						label.setTextFill(Color.web("#ff0000"));
					}
					pane.add(label, (j), (i+2));
					z++;
				}
			}
		 }
		 
		 BorderPane borderPane = new BorderPane();
		 borderPane.setCenter(pane);

		 Scene scene = new Scene(borderPane, 500, 500);
		 primaryStage.setTitle("Prime Generator");
		 primaryStage.setScene(scene);
		 primaryStage.show();

		 FirstAlgorithm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					
					int top = Integer.parseInt(tf1.getText());
					primeGenerator.setTop(top);
					primeGenerator.firstAlgorithm();
					primaryStage.close();
					View v = new View();
					v.start(new Stage());
					
					
				}catch(NumberFormatException e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
			        alert.setHeaderText("Results:");
			        alert.setContentText("Insert a correct natural number");
			        alert.showAndWait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		 
		 SecondAlgorithm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					
					int top = Integer.parseInt(tf1.getText());
					primeGenerator.setTop(top);
					primeGenerator.secondAlgorithm();
					primaryStage.close();
					View v = new View();
					v.start(new Stage());
					
				}catch(NumberFormatException e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
			        alert.setHeaderText("Results:");
			        alert.setContentText("Insert a correct natural number");
			        alert.showAndWait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		 
		 ThirdAlgorithm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					
					int top = Integer.parseInt(tf1.getText());
					primeGenerator.setTop(top);
					primeGenerator.thirdAlgorithm();
					primaryStage.close();
					View v = new View();
					v.start(new Stage());
				}catch(NumberFormatException e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
			        alert.setHeaderText("Results:");
			        alert.setContentText("Insert a correct natural number");
			        alert.showAndWait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	 	
	}
}
