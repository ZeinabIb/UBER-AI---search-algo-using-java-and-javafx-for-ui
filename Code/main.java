package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;

import javafx.scene.image.*;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.*;






public class Main extends Application {
	
	public Boolean bfs = false;
	public int initialstate;
	public int goalstate;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			////FLOW PANE/////////
			FlowPane flow = new FlowPane();
			
			
			/////////MAP IMAGE//////////
			Image mapimg = new Image("C:\\Users\\Zeinab\\Desktop\\UberAI\\heromapimg.png");
			ImageView map_imgview = new ImageView(mapimg);
			
			
			//////INITIALIZE CITIES///////////
			Circle cA = new Circle(30);
			Circle cB = new Circle(30);
			Circle cC = new Circle(30);
			Circle cD = new Circle(50);
			Circle cE = new Circle(40);
			Circle cF = new Circle(40);
			Circle cG = new Circle(30);
			Circle cH = new Circle(50);
			Circle cI = new Circle(30);
			Circle cJ = new Circle(50);
			
			GridPane grid = new GridPane();
			
			grid.add(cA, 0, 0);
			grid.add(cB, 2, 1);
			grid.add(cC, 2, 5);
			grid.add(cD, 3, 4);
			grid.add(cE, 3, 8);
			grid.add(cF, 4, 1);
			grid.add(cG, 4,7 );
			grid.add(cH, 0, 8);
			grid.add(cI, 1, 1);
			grid.add(cJ, 0, 6);
			
			cA.setFill(Color.GRAY);
			cB.setFill(Color.GRAY);
			cC.setFill(Color.GRAY);
			cD.setFill(Color.GRAY);
			cE.setFill(Color.GRAY);
			cF.setFill(Color.GRAY);
			cJ.setFill(Color.GRAY);
			cH.setFill(Color.GRAY);
			cI.setFill(Color.GRAY);
			cG.setFill(Color.GRAY);
			
			grid.setPadding(new Insets(40));
			grid.setVgap(10);
			grid.setHgap(30);
			
			cA.setOnMouseClicked(e->{
				cA.setFill(Color.AQUAMARINE);
			});
			
			cB.setOnMouseClicked(e->{
				cB.setFill(Color.AQUAMARINE);
			});
			cC.setOnMouseClicked(e->{
				cC.setFill(Color.AQUAMARINE);
			});
			cD.setOnMouseClicked(e->{
				cD.setFill(Color.AQUAMARINE);
			});
			cE.setOnMouseClicked(e->{
				cE.setFill(Color.AQUAMARINE);
			});
			cF.setOnMouseClicked(e->{
				cF.setFill(Color.AQUAMARINE);
			});
			cJ.setOnMouseClicked(e->{
				cJ.setFill(Color.AQUAMARINE);
			});
			cH.setOnMouseClicked(e->{
				cH.setFill(Color.AQUAMARINE);
			});
			cI.setOnMouseClicked(e->{
				cI.setFill(Color.AQUAMARINE);
			});
			cG.setOnMouseClicked(e->{
				cG.setFill(Color.AQUAMARINE);
			});
			
			
			
			StackPane stack = new StackPane();
			stack.getChildren().add(map_imgview);
			stack.getChildren().add(grid);
			
			
			GridPane right_grid = new GridPane();
			Text title = new Text("UBER AI");
			title.setFont(Font.font("Arial Black", 50));
			
			right_grid.add(title, 0, 0);
			right_grid.setPadding(new Insets(20));
			
			
			Label initiallb = new Label ("Choose Initial State : ");
			initiallb.setFont(Font.font("Arial ",25));
			TextField initialtf = new TextField();
			right_grid.add(initiallb, 0, 2);
			
			
			
			ComboBox<String> comboBox = new ComboBox<>();
	        comboBox.getItems().addAll(
	            "Airport",
	            "Home",
	            "Pharmacy",
	            "Restaurant",
	            "SuperMarket",
	            "University",
	            "Library",
	            "Hospital",
	            "CoffeeShop",
	            "School"
	        );
	        
	        Button cbcheckbtn = new Button ("Check");
	        
	        cbcheckbtn.setOnMouseClicked(e->{
	        	String selectedValue = comboBox.getValue();
	            System.out.println("Selected Value: " + selectedValue);
	            if (selectedValue.equals("Home")) {
	            cA.setFill(Color.LIGHTGREEN);
	            initialstate = 0;
	            }
	            else if (selectedValue.equals("School")) {
		            cB.setFill(Color.LIGHTGREEN);
		            initialstate = 1;
		            }
	            
	            else if (selectedValue.equals("Pharmacy")) {
		            cC.setFill(Color.LIGHTGREEN);
		            initialstate = 2;
		            }
	            
	            else if (selectedValue.equals("SuperMarket")) {
		            cD.setFill(Color.LIGHTGREEN);
		            initialstate = 3;
		            }
	            
	            else if (selectedValue.equals("Hospital")) {
		            cE.setFill(Color.LIGHTGREEN);
		            initialstate = 4;
		            }
	            
	            else if (selectedValue.equals("Library")) {
		            cF.setFill(Color.LIGHTGREEN);
		            initialstate = 5;
		            }
	            
	            else if (selectedValue.equals("University")) {
		            cJ.setFill(Color.LIGHTGREEN);
		            initialstate = 6;
		            }
	            
	            else if (selectedValue.equals("Restaurant")) {
		            cH.setFill(Color.LIGHTGREEN);
		            initialstate = 7;
		            }
	            else if (selectedValue.equals("CoffeeShop")) {
		            cI.setFill(Color.LIGHTGREEN);
		            initialstate = 8;
		            }
	            else if (selectedValue.equals("Airport")) {
		            cG.setFill(Color.LIGHTGREEN);
		            initialstate = 9;
		            }
	        });
	       
		
	        
	        //////////////GOAL STATE////////////////////////////
	        Label goallb = new Label ("Choose Goal State : ");
			goallb.setFont(Font.font("Arial ",25));
			TextField goaltf = new TextField();
			right_grid.add(goallb, 0, 3);
			
			
			
			ComboBox<String> comboBox2 = new ComboBox<>();
	        comboBox2.getItems().addAll(
	            "Airport",
	            "Home",
	            "Pharmacy",
	            "Restaurant",
	            "SuperMarket",
	            "University",
	            "Library",
	            "Hospital",
	            "CoffeeShop",
	            "School"
	        );
	        
	        Button cb2checkbtn = new Button ("Check");
	        
	        cb2checkbtn.setOnMouseClicked(e->{
	        	String selectedValue = comboBox2.getValue();
	            System.out.println("Selected Value: " + selectedValue);
	            if (selectedValue.equals("Home")) {
	            cA.setFill(Color.FIREBRICK);
	            }
	            
	            else if (selectedValue.equals("School")) {
		            cB.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("Pharmacy")) {
		            cC.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("SuperMarket")) {
		            cD.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("Hospital")) {
		            cE.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("Library")) {
		            cF.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("University")) {
		            cJ.setFill(Color.RED);
		            }
	            
	            else if (selectedValue.equals("Restaurant")) {
		            cH.setFill(Color.RED);
		            }
	            else if (selectedValue.equals("CoffeeShop")) {
		            cI.setFill(Color.RED);
		            }
	            else if (selectedValue.equals("Airport")) {
		            cG.setFill(Color.RED);
		            }
	        });
	       
			
	        ImageView mapicon = new ImageView (new Image("C:\\Users\\Zeinab\\Desktop\\UberAI\\mapicon.png"));
			mapicon.setFitWidth(50);
			mapicon.setFitHeight(50);
			right_grid.add(mapicon, 0, 1);
			
			Button showmapbtn = new Button ("Show Map");
			right_grid.add(showmapbtn, 1, 1);
			
	        right_grid.add(comboBox, 1, 2);
	        right_grid.add(cbcheckbtn, 2, 2);
	        right_grid.add(comboBox2, 1,3);
	        right_grid.add(cb2checkbtn, 2, 3);
	        
	        right_grid.setVgap(5);
	        right_grid.setHgap(10);
	        
	        Button bfsbtn = new Button("Find Shortest Path BFS");
	        right_grid.add(bfsbtn, 0, 4);
	        
	       /* Button dfsbtn = new Button("DFS");
	        right_grid.add(dfsbtn, 1, 4);
	        
	        Button bsbtn = new Button("Best Search");
	        right_grid.add(bsbtn, 2, 4);
	        
	        Button abtn = new Button("A*");
	        right_grid.add(abtn, 3, 4);*/
	        
	        bfsbtn.setBackground(Background.fill(Color.BROWN));
	        bfsbtn.setFont(Font.font("Arial Black", 15));
	        bfsbtn.setTextFill(Color.WHITE);
	        
	        
	        bfsbtn.setOnMouseClicked(e->{
	        	bfs = true;
	        	System.out.println(bfs);
	        });
	        
	        
	      
	        Button donebtn = new Button("Done");
	        right_grid.add(donebtn, 0, 5);
	        
	        
	        ImageView binarytree = new ImageView(new Image("C:\\Users\\Zeinab\\Desktop\\UberAI\\bt1.png"));
			
	      
	        
	        Button bbtn = new Button("show binary tree");
	        Stage binarystage = new Stage();
	        Pane pane = new Pane();
	        
	        right_grid.add(bbtn, 0, 7);
	       
	        Scene scene2 = new Scene(pane, 700,700);
	        binarystage.setScene(scene2);
	        
	        bbtn.setOnMouseClicked(e->{
	        	 pane.getChildren().add(binarytree);
	        binarystage.show();
	        
	        binarytree.setFitHeight(700);
	        binarytree.setFitWidth(700);
	        });
	        
	        
			
	        donebtn.setOnMouseClicked(e->{
	        	if (bfs == true) {
	        		System.out.println("true");
	        		Graph g = new Graph(initialstate,4);
	        		
	        	}
	        });
	        
	        
	        
			
			
			
			
			
			
			
			
			flow.getChildren().add(stack);
			flow.getChildren().add(right_grid);
			
			
			
			
			
			
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(flow,1250,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}








