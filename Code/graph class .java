package application;
//Java program to print BFS traversal from a given source
//vertex. BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
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

public class Graph extends VBox {
	private int V; 
	private LinkedList<Integer> adj[]; // Adjacency Lists
	public LinkedList<Integer> queue
	= new LinkedList<Integer>();
	
	
	
	public LinkedList<Integer> queuecontent
	= new LinkedList<Integer>();
	
	
	public Scene scene = new Scene(this,750,750);
	public Stage stage = new Stage();
	
	

	Graph(int startstate, int goalstate){
		System.out.println("I am in graph function");
		
		Graph g = new Graph(10);

		//home
		//g.addEdge(0, 6); //
		g.addEdge(0, 8); //
		
		//school
		g.addEdge(1, 2); //
		//g.addEdge(1, 2); //
		//g.addEdge(1, 0); // 
		
		//pharmacy
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		//g.addEdge(2, 6);
		//g.addEdge(2, 1);
		
		//supermarket
		g.addEdge(3, 5);
		g.addEdge(3, 9);
		
		
		
		//library
		g.addEdge(5, 9);
		
		
		//uni
		g.addEdge(6, 2);
		
		//resto
		//g.addEdge(7, 6);
		//g.addEdge(7, 4);
		
		//coffeeshop
		g.addEdge(8, 1);
		
		//airport
		//g.addEdge(9, 4);
		
		
		
		
	
		System.out.println(
			"Using Breadth First Search "
			);

		g.BFS(startstate, goalstate, startstate);
		
		
		
		
		
		
		
		
	}
	// Constructor
	Graph(int v)
	{
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) { 
		adj[v].add(w); 
		}


	void BFS(int s, int goalstate, int initialstate)
	{
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		/*LinkedList<Integer> queue
			= new LinkedList<Integer>();*/

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");
			queuecontent.add(s);
			
			

			// Get all adjacent vertices of the dequeued
			// vertex s If a adjacent has not been visited,
			// then mark it visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			int n = 0;
			while (i.hasNext()) {
				 n = i.next();
				if (n == goalstate) {
					visited[n] = true;
					queue.add(n);
					
					break;
				}
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					
				}
			}
			
			System.out.print('\n'+ "path n : "+n + " ");
		}
		
		System.out.println(goalstate);
		queuecontent.add(goalstate);
		
		
		
		
        System.out.println("queuecontent :"+ queuecontent);
		
		
		
		
		
		///GRAPICHS////////////////
		StackPane s1 = new StackPane();
		
		Circle cHome = new Circle(30);
		cHome.setFill(Color.DODGERBLUE);
		Label lHome = new Label("HOME");
		lHome.setFont(Font.font("Arial Black",8));
		lHome.setTextFill(Color.WHITE);
		s1.getChildren().addAll(cHome,lHome);
		
		StackPane s2 = new StackPane();
		Circle cLibrary = new Circle(30);
		cLibrary.setFill(Color.DODGERBLUE);
		Label lLibrary = new Label("COFFEE SHOP");
		lLibrary.setFont(Font.font("Arial Black",8));
		lLibrary.setTextFill(Color.WHITE);
		s2.getChildren().addAll(cLibrary,lLibrary);
		
		
		StackPane s3 = new StackPane();
		Circle cSchool = new Circle(30);
		cSchool.setFill(Color.DODGERBLUE);
		Label lschool = new Label("SCHOOL");
		lschool.setFont(Font.font("Arial Black",8));
		lschool.setTextFill(Color.WHITE);
		s3.getChildren().addAll(cSchool,lschool);
		
		StackPane s4 = new StackPane();
		Circle cph = new Circle(30);
		cph.setFill(Color.DODGERBLUE);
		Label lph = new Label("PHARMACY");
		lph.setFont(Font.font("Arial Black",8));
		lph.setTextFill(Color.WHITE);
		s4.getChildren().addAll(cph,lph);
		
		StackPane s5 = new StackPane();
		Circle chosp = new Circle(30);
		chosp.setFill(Color.DODGERBLUE);
		Label lhosp = new Label("HOSPITAL");
		lhosp.setFont(Font.font("Arial Black",8));
		lhosp.setTextFill(Color.WHITE);
		s5.getChildren().addAll(chosp,lhosp);
		
		
		GridPane thisg = new GridPane();
		this.setPadding(new Insets(50));
		
		
		Text pathtxt = new Text("PATH : ");
		pathtxt.setFont(Font.font("Arial Black", 15));
		thisg.add(pathtxt,0 , 0);
		
		thisg.setHgap(15);
		
		Text bfstxt = new Text("Best First Search");
		bfstxt.setFont(Font.font("Arial Black", 15));
		ImageView hhimg = new ImageView(new Image("C:\\Users\\Zeinab\\Desktop\\UberAI\\HH.png"));
		hhimg.setFitWidth(600);
		hhimg.setFitHeight(600);
		if(initialstate == 0 && goalstate == 4) {
			thisg.add(s1, 1, 0);
			thisg.add(s2, 2, 0);
			thisg.add(s3, 3, 0);
			thisg.add(s4, 4, 0);
			thisg.add(s5, 5, 0);
			
			this.getChildren().addAll(bfstxt,hhimg, thisg);
		}
		
		
		
		else {
			System.out.println("else");
		}
		
		stage.setScene(scene);
		stage.show();
		
		
		
		
		
		
		
		
		
		
	}

	

}

